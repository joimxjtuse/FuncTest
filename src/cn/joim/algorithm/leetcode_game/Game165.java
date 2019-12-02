package cn.joim.algorithm.leetcode_game;

/**
 * *https://leetcode-cn.com/contest/weekly-contest-165/
 * <p>
 * 这个题目是参考了某位奉献者的思路写出来的，没有想到这个好的方案，惭愧啊！
 */
public class Game165 {

    public static void main(String[] args) {
        int moves[][] = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        String result = new Game165().tictactoe(moves);
    }


    /**
     * 1275. 找出井字棋的获胜者
     * <p>
     * A 和 B 在一个 3 x 3 的网格上玩井字棋。
     * <p>
     * 井字棋游戏的规则如下：
     * <p>
     * 玩家轮流将棋子放在空方格 (" ") 上。
     * 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
     * "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
     * 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
     * 如果所有方块都放满棋子（不为空），游戏也会结束。
     * 游戏结束后，棋子无法再进行任何移动。
     * 给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
     * <p>
     * 如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；
     * 如果游戏以平局结束，则返回 "Draw"；
     * 如果仍会有行动（游戏未结束），则返回 "Pending"。
     * <p>
     * 你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-winner-on-a-tic-tac-toe-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * <p>
     * 输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
     * 输出："A"
     * 解释："A" 获胜，他总是先走。
     */
    public String tictactoe(int[][] moves) {
        String result = "Draw";

        boolean hasWiner = false;
        //最后一步是谁走的:如果是偶数，则最后一步是A走的，否则最后一步是B走的.
        int[] lastItem = moves[moves.length - 1];
        int size = moves.length;
        int lastOne = (size - 1) % 2;

        int sameRowCnt = 0, sameColumnCnt = 0, sameZhuDuiJiaoCnt = 0, sameFuDuiJiao = 0;

        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == lastOne) {
                //同一行
                if (lastItem[0] == moves[i][0]) {
                    sameRowCnt++;
                }
                //同一列
                if (lastItem[1] == moves[i][1]) {
                    sameColumnCnt++;
                }

                /**
                 * (0,0) (0,1) (0,2)
                 * (1,0) (1,1) (1,2)
                 * (2,0) (2,1) (2,2)
                 * */
                //主对角线上相等. x - y  = 0
                if (lastItem[0] == lastItem[1] && moves[i][0] == moves[i][1]) {
                    sameZhuDuiJiaoCnt++;
                }
                //副对角线上相等.
                if (lastItem[0] + lastItem[1] == 2 && moves[i][0] + moves[i][1] == 2) {
                    sameFuDuiJiao++;
                }
            }
        }

        if (sameRowCnt == 3 || sameColumnCnt == 3 || sameZhuDuiJiaoCnt == 3 || sameFuDuiJiao == 3) {
            hasWiner = true;
            result = lastOne == 0 ? "A" : "B";
        }

        if (!hasWiner) {
            //数组长度如果>=9,比完了;否则平局.
            if (moves.length >= 9) {
                result = "Draw";
            } else {
                result = "Pending";
            }
        }
        return result;
    }
}
