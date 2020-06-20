li = [100, -1, -200, 50, 2]

# 倒序
li.reverse()
print(li)


# li.sort()
li.sort(key=abs, reverse=False)
print(li)

# 内置sorted
li = sorted(li, key=abs, reverse=True)
print(li)

