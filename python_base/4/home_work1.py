'''1、《射雕英雄传》中，黄蓉与瑛姑见面时曾出过这样一道题：
今有物不知其数，三三数之剩二，五五数之剩三，七七数之剩二，问几何？
试产生一个100-200之间的随机数。看是否满足这个数的条件。'''

import random
ran = random.randint(100, 200)
if ran%3==2 and ran%5==3 and ran%7==2:
    print("{},三三数之剩二，五五数之剩三，七七数之剩二.".format(ran))
else:
    print("{},不符合’三三数之剩二，五五数之剩三，七七数之剩二‘。".format(ran))



'''2、你的银行卡中有多少钱，你不记得了。今天你去取1000元钱，
根据余额是否足够，给出相应的操作。 '''

amount = random.randint(100, 10000)
want = int(input('输入取钱的金额：'))
if want <= amount:
    amount -= want
    print("取出{}元，余额还有{}元。".format(want, amount))
else:
    print("你想取{}元，但是余额只有{}元。余额不足。".format(want, amount))