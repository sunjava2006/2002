for i in range(100, 1000):
    # h = i // 100
    # m = i // 10%10
    # l = i % 10
    h = int(str(i)[0])
    m = int(str(i)[1])
    l = int(str(i)[2])
    # print(h,m,l)
    if i == h**3 + m**3 + l**3:
        print(i)