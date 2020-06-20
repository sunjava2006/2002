li = []         # 创建列表
print(li)

li1 = list()    # 创建列表
print(li1)

li2 = ["赵明", "顾益", "张方", "李宁"]
print(li2)

li3 = list(["李明虎", "方方", "赵娜", "许宁"])
print(li3)

li4 = list(range(1, 10))
print(li4)

li5 = list("China")
print(li5)

li6 = list({"java", "python"})
print(li6)


#--------------------- 列表推导式(表达式) ----------------------
list1 = [i**2+1 for i in range(10)]
print(list1)

list2 = [i*j for i in range(1, 10) for j in range(2)]
print(list2)

