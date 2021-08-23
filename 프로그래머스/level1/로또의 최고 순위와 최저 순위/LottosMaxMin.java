class LottosMaxMin {
    public int[] solution(int[] lottos, int[] win_nums) {
        int eqnum = 0, bonus =0;
        for(int lotto : lottos) {
            if(lotto == 0) {
                bonus++;
                continue;
            }
            for(int win : win_nums) {
                if(lotto == win) {
                    eqnum++;
                    break;
                }
            }
        }
        int[] answer = {7-Math.max(eqnum + bonus, 1), 7-Math.max(eqnum, 1)};
        return answer;
    }
}