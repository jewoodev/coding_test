import itertools

def solution(babbling):
    global l1
    l1 = ["aya", "ye", "woo", "ma"]
    l2 = list(itertools.permutations(l1, 2))
    l3 = list(itertools.permutations(l1, 3))
    l4 = list(itertools.permutations(l1, 4))
    print(l2)
    l2_2 = []
    l3_2 = []
    l4_2 = []
    for i in range(len(l2)):
        l2_2.append("".join(l2[i]))
    for i in range(len(l3)):
        l3_2.append("".join(l3[i]))
    for i in range(len(l4)):
        l4_2.append("".join(l4[i]))
    l1.extend(l2_2)
    l1.extend(l3_2)
    l1.extend(l4_2)
    count = 0
    for i in babbling:
        if i in l1:
            count += 1
    return count