def solution(myStr):
    mystr = myStr.replace('a', ' ')
    mystr = mystr.replace('b', ' ')
    mystr = mystr.replace('c', ' ')
    mylist = mystr.split(' ')
    answer = [l for l in mylist if l]
    if answer == []:
        answer = ["EMPTY"]
    return answer