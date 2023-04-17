# [Bronze III] 이진수 - 3460 

[문제 링크](https://www.acmicpc.net/problem/3460) 

### 성능 요약

메모리: 30616 KB, 시간: 36 ms

### 분류

구현(implementation), 수학(math)

### 문제 설명

<p>양의 정수 n이 주어졌을 때, 이를 이진수로 나타냈을 때 1의 위치를 모두 찾는 프로그램을 작성하시오. 최하위 비트(least significant bit, lsb)의 위치는 0이다.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, n이 주어진다. (1 ≤ T ≤ 10, 1 ≤ n ≤ 10<sup>6</sup>)</p>

### 출력 

 <p>각 테스트 케이스에 대해서, 1의 위치를 공백으로 구분해서 줄 하나에 출력한다. 위치가 낮은 것부터 출력한다.</p>

## 몰랐던 것

#### enumerate
- enumerate는 반복문 사용 시 몇번째 반복문인지 확인할 때 사용됩니다.
- 인덱스 번호와 컬렉션의 원소를 tuple 형태로 반환합니다.
![image](https://user-images.githubusercontent.com/105477856/211295876-cf2fafad-19ac-4d14-b1e1-d62dc31fcd96.png)
- tuple 형태 반환을 이용해서 아래처럼 활용할 수 있습니다. 
![image](https://user-images.githubusercontent.com/105477856/211296060-581b1182-2c58-4f01-beaf-464eaa802b12.png)
