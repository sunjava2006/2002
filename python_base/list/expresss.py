"""语法1：[expression for var in range]"""
list1 = [i*2-1 for i in range(10)]
print(list1)

import random
list2 = [random.randint(0, 10) for i in range(10)]
print(list2)


"""语法2：[expression for var in list]"""
price = [7000, 100000, 10000000, 89]
list3 = [int(i*0.8) for i in price]
print(list3)


"""语法3：[expression for var in list if condition]"""
list4 = [int(i*0.5) for i in price if i>10000]
print(list4)


"""语法4：[expression for var1 in range1 for var2 in range2]"""
list5 = [i*j for i in range(1, 10) for j in range(1,10)]
print(list5)

list6 = [[i, j] for i in range(1,3) for j in [20, 30]]
print(list6)

list7 = [[i for i in range(1,3)] for j in [20, 30]]
print(list7)
