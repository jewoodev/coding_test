def solution(my_string, is_suffix):
    suffix_list = []
    
    for i in range(len(my_string)):
        suffix_list.append(my_string[i:])
    
    if is_suffix in suffix_list:
        return 1
    else:
        return 0