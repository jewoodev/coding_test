def solution():
    input_money = int(input("숫자를 입력하세요: "))

    first_coin_count = 0
    twice_coin_count = 0
    third_coin_count = 0
    fourth_coin_count = 0

    if input_money >= 500:
        first_coin_count += input_money // 500
        input_money = input_money - 500 * (input_money // 500)

    if input_money >= 100:
        twice_coin_count += input_money // 100
        input_money = input_money - 100 * (input_money // 100)

    if input_money >= 50:
        third_coin_count += input_money // 50
        input_money = input_money - 50 * (input_money // 50)

    if input_money >= 10:
        fourth_coin_count += input_money // 10
        input_money = input_money - 10 * (input_money // 10)



    return first_coin_count+twice_coin_count+third_coin_count+fourth_coin_count

if __name__ == "__main__":
    print(solution())