li = ["python", "java", "oracle", "mysql"]

a = input("输入一个编程语言：")

# have = False
# idx = -1

# for i, e in enumerate(li):
#     if e==a:
#         have = True
#         idx = i

idx = -1
have = a in li
if have:
    idx = li.index(a)




print("{}这个语言,索引为{}".format("有" if have else "没有", idx))


