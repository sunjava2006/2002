d = {"one":1 , "two":2 , "three":3}

print(d.setdefault("one", "one!"))
print(d)

print(d.setdefault("four"))
print(d)

d.update({"one":"one!"})
print(d)