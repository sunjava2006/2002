import random


score = random.randint(30, 100)

grad = ""

if score >= 90:
    grad = "优"
elif score >= 80:
    grad = "良"
elif score >= 70:
    grad = "中"
elif score >= 60:
    grad = "及格"
else:
    grad = "差"

print("{}:{}".format(score, grad))


if score >=90:
    pass
if score <90 and score>=80:
    pass
if score <80 and score>=70:
    pass
if score <70 and score>=60:
    pass
if score<69:
    pass