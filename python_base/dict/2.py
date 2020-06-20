d = {"color":"red", "name":"wang", "gender":"男", (1,):1, 2:23, "hello":[]}

d1 = d.copy()
print("d1", d1)
print(d1==d)
print(id(d1), id(d))
d["x"] = 12

d["hello"].append("world")
print("d", d)
print("d1", d1)

d2 = dict.fromkeys(["one", "two", "three"])
print("d2", d2)

print("有" if "one" in d2 else "没有")



for t in d.items():
    print("{}:{}".format(t[0], t[1]))


keys = d.keys()
for key in keys:
    print(key)

values = d.values()
for v in values:
    print(v)
