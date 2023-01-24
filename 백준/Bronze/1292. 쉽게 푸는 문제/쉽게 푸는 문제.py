a, b = map(int, input().split())
progression = []

for i in range(1, 100):
    for j in range(1, i+1):
        progression.append(i)

sum_result = 0
for i in range(a-1, b):
    sum_result += progression[i]
print(sum_result)