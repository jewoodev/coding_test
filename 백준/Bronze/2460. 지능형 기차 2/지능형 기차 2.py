max_people = 0
how_many = 0

for i in range(10):
    get_out, get_in = map(int, input().split())
    how_many -= get_out
    how_many += get_in
    if max_people < how_many:
        max_people = how_many
print(max_people)