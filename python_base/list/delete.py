li = ["java", "python", "javascript", "sql"]
print(li)

# python 中内建方法del
del li[-1]
print(li)

# 列表对象中定义的remove(element)
li.remove("javascript")
print(li)

li.extend(("g", "r"))
print("添加了g,r:",li)

# 列表对象的pop方法，可以通过指定下标的方式，删除元素。
# 不指定索引，是最后一个。但可以通过指定索引，删除任意位置上的元素。
print(li.pop(1))
print(li)
print(li.pop())
print(li)

