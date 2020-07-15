import pymysql
from contextlib import closing
def get_conn():
    conn = pymysql.connect(host='127.0.0.1', user='eyeadmin', password='123456',
                    database='eye025', charset='utf8')
    return conn

def add(login_name, passwd):
    try:
        '''1、连接到数据库'''
        conn = get_conn()
        cur = conn.cursor()  # 获取游标对象
        sql = "insert into t_users(login_name, passwd) values (%s, %s)"
        print("sql:", sql)
        '''2、游标'''
        cur.execute(sql, (login_name, passwd))  # 执行SQL语句。
        conn.commit()
    except Exception as err:
        print(err)
        conn.rollback()
    finally:
        cur.close()
        conn.close()


def list_all():
    sql = """select * from t_users"""
    conn = None
    cur = None
    data = []
    try:
        '''1、获取数据库连接'''
        conn = get_conn()

        '''2、获取游标对象'''
        cur = conn.cursor(pymysql.cursors.DictCursor)  # __________
        cur.execute(sql)

        '''3、获取查询的结果'''
        data = cur.fetchall()  # 所有的
        # while True:
        #     i = cur.fetchone() # 获取1条记录，当游标获取不到数据时，返回None。
        #     if i:
        #         data.append(i)
        #     else:
        #         break

        # for i in cur:
        #     data.append(i)

        # while True:
        #     i = cur.fetchmany(2)    # 指定获取最多n个数据，不指定时，是1个。返回的是列表。没有数据时，返回空列表。
        #     if len(i):
        #         # data.append(i)
        #         data.extend(i)
        #     else:
        #         break

        conn.commit()
    except Exception as err:
        print(err)
        conn.rollback()
    finally:
        if cur:
            cur.close()
        if conn:
            conn.close()
        return data


def login(login_name, pwd):
    sql = """select * from t_users where login_name=%s and passwd=%s"""
    conn = None
    cur = None
    data = None
    try:
        conn = get_conn()
        cur = conn.cursor(pymysql.cursors.DictCursor)
        cur.execute(sql, (login_name, pwd))
        data = cur.fetchone()

        conn.commit()
    except Exception as err:
        print(err)
        conn.rollback()
    finally:
        if cur:
            cur.close()
        if conn:
            conn.close()
        return data


def update_pwd(new_pwd, id):
    sql = """update t_users set passwd=%s where id=%s"""
    with closing(get_conn())as conn:
        with conn.cursor() as cur:
            count = cur.execute(sql, (new_pwd, id))
            return count


def find_one(id):
    sql = """select * from t_users where id=%s"""
    with closing(get_conn()) as conn:
        with conn.cursor(pymysql.cursors.DictCursor) as cur:
            cur.execute(sql, id)
        return cur.fetchone()


def delete(id):
    sql = "delete from t_users where id=%s"
    count = -1
    with closing(get_conn()) as conn:
        try:
            conn.autocommit(False)
            with conn.cursor() as cur:
                count = cur.execute(sql, id)
            conn.commit()
        except Exception as err:
            print(err)
            conn.rollback()

    return count



if __name__ == '__main__':
    # add("00002", "123456")

    # data = list_all()
    # print(data)

    # p = login("000002", '123456')
    # print(p)
    # update_pwd("123abc", 12)

    # data = find_one(1)
    # print(data)
    print(delete(3))