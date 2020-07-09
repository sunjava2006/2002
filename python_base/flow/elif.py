import random

score = int(random.random()*100)

grade = ""

if score >= 90:
    grade = "优"
elif score >= 80:
    grade = "良"
elif score >= 70:
    grade = "中"
elif score >= 60:
    grade = "及格"
else:
    grade = "差"
print("成绩是{}分，等级为{}。".format(score, grade))