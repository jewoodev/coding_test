def solution(arr, queries):
    list_ = []
    
    for query in queries:
        first = 0
        smaller = 0
        for i in range(query[0], query[1]+1):
            if arr[i] > query[2]:
                if first == 0:
                    smaller = arr[i]
                    first += 1
                else:
                    if smaller > arr[i]:
                        smaller = arr[i]

        if smaller == first:
            list_.append(-1)
        else:
            list_.append(smaller)   
            
    return list_