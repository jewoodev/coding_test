def solution(wallpaper):
    a, b = [], []
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == "#":
                a.append(i)
                b.append(j)
    return [min(a), min(b), max(a)+1, max(b)+1]

"""
def solution(wallpaper):
    answer = []
    idx1 = []
    idx2 = []
    for i in range(0, len(wallpaper), 1):
        if "#" in wallpaper[i]:
            answer.append(i)
            break
    for k in range(0, len(wallpaper), 1):
        if "#" in wallpaper[k]:
            idx = wallpaper[k].rfind("#")
            idx1.append(idx)
            idx = wallpaper[k].find("#")
            idx2.append(idx)     
    answer.append(min(idx2))
    for j in range(len(wallpaper)-1, 0, -1):
        if "#" in wallpaper[j]: 
            answer.append(j+1)
            break
    answer.append(max(idx1)+1)
    return answer
"""
"""
위의 코드는 두가지 샘플에서 오답처리가 되었는데 판단되어지기에 마지막 for 문에서 생긴 문제가 아닐까 싶다.
해당 반복문은 처음 파일이 발견된 row가 파일이 존재하는 유일한 row 인 경우, 그리고 그 row가 index 0의 위치라면 문제가 생길 것 같다.
"""