"""找出列表中，名字字数最少的人"""

names = ["Smith", "Jack", "Mary", "Tom", "Black", "Green"]

short_name = ""  # 存储所要找的最短的名字
index = -1  # 存储所要找的名字所在的list中的位置
length = 20000  # 存储最短的名字的字符长度

# for idx in range(0, len(names)):  # 根据names的索引遍历， idx存储索引值
for idx, name in enumerate(names):
    # name = names[idx]   # 取出每一个元素（名字）
    name_length = len(name)   # 计算名字的长度
    if name_length <= length:
        short_name = name
        index = idx
        length = name_length

print("{}是最短的名字，长度为{}，在列表是是第{}个。".format(short_name, length, index+1))


