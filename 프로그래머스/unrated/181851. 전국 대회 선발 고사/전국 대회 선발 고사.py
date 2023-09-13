def solution(rank, attendance):
    poss_num = []
    
    for i in range(len(rank)):
        for j in range(len(rank)):
            if rank[j] == i+1:
                if attendance[j] == True:
                    poss_num.append(j)
    
    answer = poss_num[0] * 10000 + poss_num[1] * 100 + poss_num[2]
    return answer