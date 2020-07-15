import pymysql as mysql
import os

def get_conn():

    try:
        conn = None
        with open("./db.info", "r") as fin:
            param = {}
            for i in fin:
                k,v = i.split("=")
                param[k] = v.strip()
            print(param)
            conn = mysql.connect(host=param.get("host"), user=param.get("user"), password=param.get("password"),
                                 database=param.get("database"), charset=param.get("charset"))
    except Exception as err:
        print(err)
    finally:
        return conn


def add(userName, pwd, gender, birthdate):
    try:
        conn = None
        cursor = None
        conn = get_conn()
        print(conn)
        sql = """insert into t_users(user_name, pwd, gender, birthdate) values (%s, %s, %s, %s)"""
        cursor = conn.cursor(mysql.cursors.DictCursor)
        cursor.execute(sql, (userName, pwd, gender, birthdate));

        conn.commit()

    except Exception as err:
        print(err)
        if conn:
            conn.rollback()
    finally:
        if cursor:
            cursor.close()
        if conn:
            conn.close()


if __name__ == "__main__":
    add("谢飞", "123456", "男", "2009-6-6")
