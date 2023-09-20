def solution(n, control):
    
    for val in control:
        if val == "w":
            n += 1
        elif val == "s":
            n -= 1
        elif val == "d":
            n += 10
        else:
            n -= 10
    
    return n