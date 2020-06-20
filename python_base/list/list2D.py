"""二维列表的定义"""

list1 = [["Tom", "Smith"], ["Peter", "Jack"], [], ["Black", "Will", "Brown"]]
print(list1[0][1])

list1[-1][-1] = "Green"
print(list1)

print("* " * 50)
"""遍历二维列表"""

for li in list1:
    for i in li:
        print(i, end=", ")
    print()


print(list([[10,20],[3,1],[]]))


