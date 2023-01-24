T = int(input())
for i in range(T):
    input_val = list(map(int, input().split()))
    input_val.sort()
    print(input_val[-3])
    

    
"""
import sys
input = sys.stdin.readline      # 이 모듈을 이용해서 메모리 사용을 효율적으로 할 수 있다.
"""