import random

ran = random.randint(1, 20)


if ran%2 == 0:
    print("--------------")
    print("%d:是偶数" % ran)
    print("--------------")
else:
    print("==============")
    print("{}:是奇数".format(ran))
    print("==============")

print("随机数是%d" % ran)