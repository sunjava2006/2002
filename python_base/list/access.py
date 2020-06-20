li = ["python", "java", "c++", "c", "oracle"]  # list索引（下标）从0开始的。最大下标是（长度-1）。

print(li[-2])
print(li[len(li)-1])

print("---------------遍历1 通过索引---------------")
for idx in range(len(li)):
    print("{}:{}".format(idx, li[idx]))

i = 0
while i<len(li):
    print(i, li[i])
    i += 1

print("----------------- 遍历2，List本身就是可迭代的 ------------------")
for i in li:
    print(i)
print("------------------ 遍历3，将List转化为枚举对象再遍历 ---------------------")
enu = enumerate(li)
print(enu)
for i, o in enu:
    print(i, o)


