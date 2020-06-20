# l = [i for i in range(10000000)]
# print(l)

t = (i for i in range(10000000))  # 生成器推导式
print(t)

for i in t:
    print(i)

