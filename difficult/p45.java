package leetcode.difficult;
/*
下面的解题思路是反向寻找，即倒着找，避免了直接解题时需要预测下一步
倒着找即先找离终点最远能到终点的位置（这里的能到不一定需要完全相等，可以超出终点范围），
然后以此位置为终点继续重复此步骤，每次重复则step++即可。
 */
public class p45 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
    public static int jump(int[] nums) {
        int step=0;
        int pos=nums.length-1;//开始把最后一个房间作为终点。
        while(pos>0){//pos为0则表示线路通了。
           for(int i=0;i<pos;i++){    //这个for循环的思想是：从左边开始找第一个能跳到终点的，
                                      //这样即找到了相当于反方向能跳到终点却又离终点最远的位置。
               if(i+nums[i]>=pos){
                   pos=i;       //找到离终点最远的能到达终点的房间，则把此房间作为新终点。
                   step++;      //步数加一
                   break;       //结束本次查找离终点最远的能到终点房间的位置的for循环，进行新终点的新查询。
               }
           }
        }
        return step;
    }

}
/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明:

假设你总是可以到达数组的最后一个位置。

 */