def solution(a, d, included):
    seq = a
    armseq = []
    
    for i in range(len(included)):
        armseq.append(seq)
        seq += d
    
    answer = 0
    for i in range(len(included)):
        if included[i]:
            answer += armseq[i]
    return answer