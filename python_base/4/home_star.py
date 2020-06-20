row = int(input("输入三角形行数："))
col = row*2-1
for i in range(1,row+1):
    star = i*2-1
    print(" " * ((col-star)//2), end="")
    print("*" * star)

