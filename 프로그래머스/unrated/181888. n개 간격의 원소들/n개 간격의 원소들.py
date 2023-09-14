def solution(num_list, n):
    val_1 = len(num_list) // n
    val_2 = len(num_list) % n
    answer = []
    
    for i in range(val_1):
        i *= n
        answer.append(num_list[i])
        
            
    if val_2 != 0:
        answer.append(num_list[-val_2])
    return answer