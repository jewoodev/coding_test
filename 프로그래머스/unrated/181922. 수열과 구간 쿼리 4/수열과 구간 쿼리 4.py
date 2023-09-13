def solution(arr, queries):
    def veri_multi(seq, num):
        bool_arr = []
        for i in seq:
            if i % num == 0:
                bool_arr.append(True)
            else:
                bool_arr.append(False)
        return bool_arr
    
    for i in queries:
            for idx, val in enumerate(veri_multi(range(i[0], i[1]+1), i[2])):
                if val:
                    arr[idx] += 1
    return arr