def solution(num_list):
    sum_result = 0
    mul_result = 1
    
    for num in num_list:
        sum_result += num
        mul_result *= num
        
    if sum_result**2 > mul_result:
        return 1
    else:
        return 0