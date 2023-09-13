def solution(names):
    l1 = len(names) // 5
    r1 = len(names) % 5
    
    answer = []
    
    if l1 < 1:
        return names[1]
    else:
        for i in range(l1):
            answer.append(names[i*5])
            
        if r1 != 0:
            i += 1
            answer.append(names[i*5])
    
    return answer