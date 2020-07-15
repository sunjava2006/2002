from flask import Flask, render_template, request

# 创建一个Flask对象
app = Flask(__name__)


# 路由视图函数
@app.route("/")
def hello():
    return render_template("login.html")


@app.route(rule='/login', methods=['POST'])
def login():
    # loginName = request.args.get("loginName") # request.args 是在get 请求中获取参数的对象。
    # validate = request.args["validate"]
    loginName = request.form.get("loginName")  # request.form 是在post 请求中获取参数的对象。
    validate = request.form['validate']
    pwd = request.values.get("pwd")            # request.values 无论get post方法都有的对象。

    # 调用查询方法
    return {"name":loginName, "password":pwd}







if __name__ == '__main__':
    app.run(debug=True)

