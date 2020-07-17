from flask import Flask, render_template, request, jsonify, g, current_app, session, redirect
from service import user_service, ad_service
import random
import os

# 创建一个Flask对象
app = Flask(__name__)

app.config["SECRET_KEY"] = b'1234'


@app.before_request
def check_login():
    curr_path = request.path
    print("curr_path:", curr_path)
    o = session.get("user_info")
    if not o:
        print('没登录 ------------------------------')
        if not (curr_path == '/'
                or curr_path == '/login'
                or curr_path== '/favicon.ico'
                or curr_path.startswith("/static")):
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
            return render_template("login.html", msg="用户名或密码错误")
        else:
            # return redirect("/index")
            session["user_info"] = user
            return ("", 302, {"location":"/index"})


@app.route("/index")
def index_page():

    return render_template("index.html")


@app.route(rule="/logout")
def logout():
    '''退出登录，将session中用户信息清除，并返回登录页面。'''
    del session['user_info']
    return redirect("/")

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




if __name__ == '__main__':
    app.run(debug=True)

