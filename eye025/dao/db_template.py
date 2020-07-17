import pymysql
from contextlib import closing
import os

prop = {}  # 存储配置信息的字典


def get_conn():
    """从配置文件读取信息，并创建connection对象"""
    global prop  # 一个全局的。只要配置之后 ，不为空，就不会再次从文件中读取。
    if 0 == len(prop):
        path = os.getcwd()
        print("path", path)
        with open('./dao/db.properties', 'r') as fin:
            for i in fin:     # 读取配置文件中每一行。
                key, value = i.split("=")    # 按“=”将字符串分割成列表，赋给两个变量
                prop[key] = value.strip()    # 以key，value变量为字典的key,value。添加到字典中。

    conn = pymysql.connect(host=prop.get("host"), user=prop.get("user"), password=prop.get("password"),
                           database=prop.get("database"), charset=prop.get("charset"))
    return conn


def select_one(sql, *args):
    data = None
    with closing(get_conn()) as conn:
        try:
            conn.autocommit(False)
            with conn.cursor(pymysql.cursors.DictCursor) as cur:
                cur.execute(sql, args)
                data = cur.fetchone()
            conn.commit()
            conn.autocommit(True)
        except Exception as err:
            print(err)
            if conn:
                conn.rollback()
    return data


def save_or_update(sql, *args):
    conn = None
    cur = None
    count = -1
    try:
        conn = get_conn()
        conn.autocommit(False)
        cur = conn.cursor()
        count = cur.execute(sql, args)
        conn.commit()
    except Exception as err:
        if conn:
            conn.rollback()
        print(err)
        raise err
    finally:
        if cur:
            cur.close()
        if conn:
            conn.autocommit(True)
            conn.close()
    return count


def select_list(sql, *args):
    conn = None
    cur = None
    data = None
    try:
        conn = get_conn()
        conn.autocommit(False)
        cur = conn.cursor(pymysql.cursors.DictCursor)
        cur.execute(sql, args)
        data = cur.fetchall()
        conn.commit()
    except Exception as err:
        print(err)
        if conn:
            conn.rollback()
        raise err
    finally:
        if cur:
            cur.close()
        if conn:
            conn.autocommit(True)
            conn.close()
    return data


if __name__ == "__main__":
    get_conn()