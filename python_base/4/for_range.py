'''1、《射雕英雄传》中，黄蓉与瑛姑见面时曾出过这样一道题：
今有物不知其数，三三数之剩二，五五数之剩三，七七数之剩二，问几何？
找出满足这个条件的100以内的数.
'''
for i in range(1, 800):
    if i%3==2 and i%5==3 and i%7==2:
        print(i)