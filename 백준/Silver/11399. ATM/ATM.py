n = int(input())
list1 = [i for i in range(n)]
list2 = list(map(int, input().split()))

sorted_list = sorted(list2)
result = 0
list3 = []

for i in range(len(list2)):
    result += sorted_list[i] 
    list3.append(result)

result2 = 0
for i in list3:
    result2 += i
print(result2)