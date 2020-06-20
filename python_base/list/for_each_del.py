li = [100, 200, 300, 400, 500, 600]

# for i in li:
#     if i==300 or i==400:
#         li.remove(i)

# 当要从遍历中删除元素。优先使用下标从大到小的遍历法。
for i in range(len(li)-1, -1, -1):
    # print(i)
    if li[i]==300 or li[i]==400:
        li.pop(i)


# for i in range(0,len(li)):
#     print(i)
#     if li[i]==300 or li[i]==400:
#         li.pop(i)

i = 0
while i<len(li):
    if li[i]==300 or li[i]==400:
        li.pop(i)
        i-=1
    i += 1


print(li)