import random

ran  = random.randint(0, 10)

if 0 == ran%2:
    print("{}是偶数。".format(ran))
else:
    print("{}是奇数。".format(ran))