from dao import db_template
from hashlib import md5

def login(login_name, pwd):
    sql = "select * from t_users where login_name=%s and passwd=md5(%s)"
    return db_template.select_one(sql, login_name, pwd)


def validatePwd(pwd, id):
    sql = "select * from t_users where passwd=md5(%s) and id=%s"
    return db_template.select_one(sql, pwd, id)


if __name__ == '__main__':
    d = login('000001', '123456')
    print(d)

