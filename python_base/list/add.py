li = ["java"]

# append 只能添加一个元素，添加的元素是做为一个整体添加进去的，成为list中的一个元素。
li.append("c")
print(li)

li.append(("c++", "c#"))
print(li)

# +  将两个列表中的元素进行了合并。
li += ["oracle", "mysql"]
print(li)

# extend 与+ 运算符相同，都是进行元素的合并。
li.extend(["china","python"])
print(li)

# * 运算符，将列表中元素翻n倍
li *= 3
print(li)
