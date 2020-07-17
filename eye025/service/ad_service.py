from dao import db_template


def publish_ad(ad_title, ad_desc, ad_img):
    sql = """insert into t_ad(ad_title, ad_desc, ad_img) values(%s,%s,%s)"""
    return db_template.save_or_update(sql, ad_title, ad_desc, ad_img)


def list_all():
    sql = "select * from t_ad"
    return db_template.select_list(sql)

