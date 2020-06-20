# 加 +
a = 1+1
print(a)

# 减 -
a = 1-2
print(a)

# 乘 *
a = 3*3
print(a)

# 除 /
a = 3/2
print(a)

# 整除 //
a = 3//2
print(a)

# 求余数 %
a = 3%2
print(a)

# 乘方 **
a = 3**2  # 3的2次方
print(a)


print("*" * 50)

'''练习，有课程:
Python:96分
English:96分
C:88
求:1）Python与English和C之间差多少分？差值可以是正数或负数。
   2）求三门课的平均分
   3) 比较English成绩是否高于另外两门课？将输出比较结果。
   4）输入一门新的课程“数学”的成绩。比较数学的成绩，是否与之前的三门课有成绩相同的？输出比较结果。
   注：输出时，采用不同的格式化输出方式。
'''
python = 95
english = 92
c = 89

minux1 = python - english
msg = "python与English之间相差" + str(minux1) + "分."
print(msg)  # python 在字符串拼接时，所有元素都要是字符串类型

minux2 = python - c
print("pyton与c语言之间相差", minux2, "分.", sep='')

avg = (python + english + c) / 3
print("{2}、{1}、{0}三门课的平均成绩是{3}.".format("python", "english", "c语言", avg))


