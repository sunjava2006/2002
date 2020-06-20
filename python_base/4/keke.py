#九章算术：鸡翁一值钱5，鸡母一值钱3，鸡雏3值钱1。今有百钱，欲买百鸡，各几何？
for w in range(1, 20):
    for m in range(1, 33):
        c = 100-w-m
        if c%3==0:
            if w*5+m*3+c/3==100:
                print("w:{}, m:{}, c:{}".format(w, m ,c))



#100多个人排队，3人一组多1人，4人一组多两人，5人一组多3人。问有多少人？
for p in range(100, 200):
    if p%3==1 and p%4==2 and p%5==3:
        print("{}人".format(p))
        # break;