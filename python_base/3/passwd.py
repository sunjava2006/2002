passwd = int(input("输入数字密码："))
key = int(input("输入1位数字的加密Key："))

passwd = passwd << key  # 加密过以后的密码。


password = int(input("输入登录密码："))
key1 = int(input("输入解密key:"))

password = password << key1

ok = "成功" if passwd==password else "失败"
print("登录%s." % ok)


