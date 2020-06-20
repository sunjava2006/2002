# 求5位数以内的质数

for i in range(2, 100):
    for d in range(2,i+1):
        if i%d==0:
            if d==i:
                print(i)
            else:
                break

