# a = 1==1 and 3>2
# print(a)
#
# a = 1>4 and 3>2
# print(a)
#
# a = 1>0 and 3<2
# print(a)

print(False and False)  # and 表示“并且”，要求计算的两个“元”都为True的情况下，返回True。否则返回False。
print(True and True)
print(False and True)

gender = "male"
gender1 = "female"
age = 18
age1 = 20

print(gender=="male" and age1==20)

print("*" * 100)
"""
or 表示 “或者”。两个条件，有一个成立，则返回True，
只有在,都不成立的情况下，返回False。
"""
print(age==18 or gender1=="male")
print(age==40 or gender=="male")
print(age==18 or gender1=="female")

print("=" * 100)
"""not 表示 “非” ，非真即假，非假即真。"""
print(not False)
print(not True)
print(not 1>4)
a = 3==0
print(not a)




