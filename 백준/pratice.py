# m = int(input())
# n = int(input())
# prime_list = []

# if m <= 2:
#     if n != 1:
#         prime_list.append(2)

# for i in range(m, n+1):
#     if i <= 1:
#         continue
#     else:
#         for j in range(2, i):
#             if i % j == 0:
#                 break
#             else:
#                 if j == i-1:
#                     prime_list.append(i)

# if len(prime_list) == 0:
#     print(-1)
# else:
#     sum_prime = 0
#     for i in prime_list:
#         sum_prime += i
#     print(sum_prime)
#     print(prime_list[0])