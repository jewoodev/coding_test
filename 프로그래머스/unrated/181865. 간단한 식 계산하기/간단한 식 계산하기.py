def solution(binomial):
    s = binomial.split(" ")
    if s[1] == "+":
        answer = int(s[0]) + int(s[2])
    elif s[1] == "-":
        answer = int(s[0]) - int(s[2])
    elif s[1] == "*":
        answer = int(s[0]) * int(s[2])
    elif s[1] == "/":
        answer = int(s[0]) / int(s[2])
    return answer