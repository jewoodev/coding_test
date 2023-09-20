def solution(code):
    answer = ''
    mode = 0
    
    while True:
        for idx, val in enumerate(code):
            if mode == 0:
                if val != "1":
                    if idx % 2 == 0:
                        answer += val
                else:
                    mode = 1
            else:
                if val != "1":
                    if idx % 2 != 0:
                        answer += val
                else:
                    mode = 0
        break
                    
    if answer == '': 
        answer = "EMPTY"
    
    return answer