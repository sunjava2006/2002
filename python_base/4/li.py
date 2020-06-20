# list index
li = ["python", "java", "c", "c++"]

print(li[0], li[1], li[2], li[3])
print(li[-1], li[-2], li[-3], li[-4])

li[3] = "C#"
print(li[3])

a = ("python", "java", "js", "c#")
print(a[0], a[1], a[2], a[3])
print(a[-1], a[-2], a[-3], a[-4])
# a[3] = "C++"
print(a[3])


s = "china"
print(s[0], s[1], s[2], s[3], s[4])
print(s[-1], s[-2], s[-3], s[-4], s[-5])
# s[0] = "C"
print(s)

# 切片
print(li[::2]) # [启始位置:结束位置:步长]
print(a[::2])
print(s[::2])

# +
print(id(li))
li += ["js"]
print(id(li))
print(li)

print(id(a))
a += ("c",)
print(id(a))
print(a)

print(id(s))
s += "!"
print(id(s))
print(s)
print("*" * 100)

print(id(li))
li *= 3
print(id(li))
print(li)

print(id(a))
a *= 3
print(id(a))
print(a)

# 成员运算符
print("c" in s)