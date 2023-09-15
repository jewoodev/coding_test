def solution(name, yearning, photo):
    answer = []
    yearning_answer = {} # 이름마다 그리움 점수를 갖는 딕셔너리

    for idx, val in enumerate(name):
        yearning_answer[val] = yearning[idx]

    for p in photo: # p는 사진 하나, 하나의 사진 당 인물의 이름들의 배열로 이루어져 있다.
        yearning_grade = 0

        for element in p: # element는 하나의 사진 당 인물 한 명의 이름을 담는 변수
            if element in name:
                yearning_grade += yearning_answer[element]

        answer.append(yearning_grade)
    
    return answer