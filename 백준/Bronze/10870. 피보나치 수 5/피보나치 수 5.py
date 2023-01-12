nlist = [0, 1]
nbh = int(input())
for i in range(nbh):
    nlist.append(nlist[i] + nlist[i+1])
print(nlist[nbh])