class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        // tmperatures[i] : i번째 날의 기온

        int[] result = new int[temperatures.length];

        // 현재 넣으려는 요소와 stack 에 있는 요소 비교
        // stack 에 있는 요소가 작으면, 그건 다 pop 하고 result 에 기록

        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                int[] cur = stack.pop();
                result[cur[1]] = i - cur[1];
            }

            stack.push(new int[]{temperatures[i], i});
        }

        return result;
        
    }
}
