from flask import Flask, render_template, request, jsonify, g, current_app, session, redirect, make_response
from service import user_service, ad_service
import random
import os

# 创建一个Flask对象
app = Flask(__name__)

app.config["SECRET_KEY"] = b'1234'


@app.before_request
def check_login():
    print(request.headers)
    print(request.headers.get("User-Agent"))
    curr_path = request.path
    print("curr_path:", curr_path)
    o = session.get("user_info")
    if not o:
        loginName = request.cookies.get("loginName") # 从request中取得cookie数据
        pwd = request.cookies.get('pwd')
        if loginName and pwd:
            user = user_service.login(loginName, pwd)
            if user:
                session['user_info'] = user
                return "", 302,{'location':'/index'}

        print('没登录 ------------------------------')
        if not (curr_path == '/'
                or curr_path == '/login'
                or curr_path== '/favicon.ico'
                or curr_path.startswith("/static")
                or curr_path.startswith("/app/")):
            return redirect('/')

    else:
        print("已登录===============================")


def create_code():
    ran = random.randint(10000, 100000)
    print("ran", ran, "----------------------------------------------------------")
    session["code"]=str(ran)
    # return session["code"]



# 路由视图函数
@app.route("/")
def login_page():
    create_code()
    print("code",session['code'])
    print("code", session['code'])
    d = session['code']
    print(d)
    return render_template("/login.html", code=session['code'])


@app.route(rule='/login', methods=['POST'])
def login():
    # loginName = request.args.get("loginName") # request.args 是在get 请求中获取参数的对象。
    # validate = request.args["validate"]
    loginName = request.form.get("loginName")  # request.form 是在post 请求中获取参数的对象。
    validate = request.form['validate']
    pwd = request.values.get("pwd")            # request.values 无论get post方法都有的对象。

    # 校验验证码
    if session.get("code") != validate:
        create_code()
        return render_template("login.html", msg="验证码不正确", code=session['code'])
    else:
        # 登录
        user = user_service.login(loginName, pwd)
        if not user:
            create_code()
            template =  render_template("login.html", msg="用户名或密码错误",code=session['code'])
            return make_response(template)
        else:
            # return redirect("/index")
            session["user_info"] = user
            # return ("", 302, {"location":"/index"})
            response = make_response("", 302, {"location":"/index"})
            if request.values.get("autoLogin"): # 是否10天免登录
                response.set_cookie("loginName", loginName, max_age=10*24*3600)
                response.set_cookie("pwd", pwd, max_age=10*24*3600)
            return response

@app.route("/index")
def index_page():

    return render_template("index.html")


@app.route(rule="/logout")
def logout():
    '''退出登录，将session中用户信息清除，并返回登录页面。'''
    del session['user_info']
    response = make_response("",302,{"location":"/"})
    response.set_cookie("loginName",'',0)
    response.set_cookie("pwd", '', 0)
    return response

@app.route('/ad')
def adpage():

    ad_lsit = ad_service.list_all()
    return render_template("ad.html", adList=ad_lsit)


@app.route(rule="/publishad", methods=["POST"])
def publishad():
    try:
        ad_list = None
        ad_name = request.values.get("ad_name")
        ad_desc = request.values.get("ad_desc")
        ad = request.files.get("ad")  # 文件对象
        adfile_name = ad.filename  # 取文件名

        cwd = os.getcwd()
        file_name = os.path.join(cwd, 'static', adfile_name)
        print(file_name)
        ad.save(file_name)     # 保存文件

        # 存储到数据库中
        if ad_service.publish_ad(ad_name, ad_desc, adfile_name) == 1:
           msg = "发布成功"
           ad_list = ad_service.list_all()
    except Exception as err:
        print(err)
        msg = "发布失败"
    return render_template("ad.html", msg=msg, adList=ad_list)

@app.route("/modify_pwd")
def modify_page():
    return render_template("modify_pwd.html")


@app.route("/oldPwdValidate", methods=["post"])
def validateOldPwd():
    old = request.values.get("oldpwd")
    id = session.get("user_info").get("id")
    u = user_service.validatePwd(old, id)
    result = {"result":"nook"}
    if u:
        result = {"result": "ok"}
    return jsonify(result)


#================================================================
@app.route("/app/getad")
def app_getad():
    data = ad_service.list_all()
    for i in data:
        i["ad_img"]="http://wangrui.free.idcfengye.com/static/"+i["ad_img"]
    return jsonify(data),{'Access-Control-Allow-Origin':'http://127.0.0.1:5500'}




#=================================================================


if __name__ == '__main__':
    app.run(debug=True)

