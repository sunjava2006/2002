t1 = ("Tom", "Jack", "Peter", "Marry", "Maria")
print(t1)

t2 = tuple(set(t1))
print(t2)

# del t1
# print(t1)

t3 = tuple(["c++"])
print(t3)

t4 = ("java",)
print(t4)

print("*" * 50)
print(t1[2])
print(t1[1::-1])
print(t1[-1:0:-1])

# t1[0] = "Smith"
print("Id", id(t1))
t1 = t1 + ("hello",)*2
print("id", id(t1))
print("---------------", t1)