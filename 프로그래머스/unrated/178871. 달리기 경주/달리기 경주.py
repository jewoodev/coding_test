def solution(players, callings):
   
    # 선수들의 초기 순위를 인덱스로 매핑한 딕셔너리 생성
    # {"mumu" : 0, "soe" : 1, "poe" : 2, "kai" : 3, "mine" : 4}
    players_ranking = {player: int(idx) for idx, player in enumerate(players)}

    for call in callings:
        current_rank = players_ranking[call]  # 호출된 선수의 현재 순위

        # {선수 : 순위} 딕셔너리에서 선수의 순위 바꿔주기
        players_ranking[call] -= 1
        players_ranking[players[current_rank - 1]] += 1

        # players 배열에서 선수들의 순위 바꿔주기
        players[current_rank - 1], players[current_rank] = call, players[current_rank - 1]

    return players