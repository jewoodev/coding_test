import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> belt = new Stack<>();
        Queue<Integer> seq = new LinkedList<>();

        for(int i = 0; i < order.length; i++) {
            seq.offer(order[i]);
        }
        int i = 0;
        while (!(seq.isEmpty())){
            if(i < order.length) {
                i++;
                belt.push(i);
                while (seq.peek().intValue() == belt.peek().intValue()) {
                    seq.poll();
                    belt.pop();
                    answer++;
                    if (belt.isEmpty()) {
                        break;
                    }
                }
            }
            else {
                break;
            }
        }
        return answer;
    }
}