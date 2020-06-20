d = {"color":"red", "name":"wang", "gender":"男", (1,):1, 2:23}
print(d)

# 字典通过键来取出，该键对应的值.dict[key]当key不存在时，抛出异常。
print(d["color"], d["name"], d["gender"])

# 使用dict.get(key)方法取值。
print(d.get("name"), d.get("gender"), d.get("height"))


d2 = dict()
print(d2)

d3 = dict(name="Wang", gender="男", age=20, t=90)
print(d3)

d2["name"] = "赵明"   # 添加元素
d2["age"] = 30       # 添加元素
d2["gender"] = "male"
d2["age"] = 20       # 修改元素
print("d2: {}".format(d2))

d2["age"] = None
print(d2)
del(d2["age"])   # 删除字典中的元素
print("删除age之后：", d2)


d2.clear()    #  删除所有元素
print("after clear:", d2)

print("*********************************************************")
print(d.popitem())
print(d)
print(d.popitem())
print(d)
print(d.popitem())
print(d)
print("--------------------------------------------------------")
print(d.pop("name"))
print(d)

