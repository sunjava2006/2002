import random

# 使用随机数，产生0-100之间的成绩
score = random.randint(30, 100)

# 根据成功，确定等级
grad = ""

if score<60:
    grad = "差"
else:
    if score <70:
        grad = "及格"
    else:
        if score<80:
            grad = "中"
        else:
            if score<90:
                grad = "良"
            else:
                grad = "优"

print("{}:{}".format(score, grad))
