def solution(my_string, is_prefix):
    prefix_list = []
    
    for i in range(len(my_string)):
        prefix_list.append(my_string[:i])
    
    if is_prefix in prefix_list:
        return 1
    else:
        return 0