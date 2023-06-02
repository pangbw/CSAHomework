import java.util.ArrayList;
import java.util.List;

public class FourthTime {
    public static void main(String[] args) {
        //1.整数反转
        System.out.println("<-------第一题------->");
        System.out.println("输入：x = 123");
        System.out.println("输出：" + IntegerReverse(123));
        System.out.println("输入：x = -123");
        System.out.println("输出：" + IntegerReverse(-123));
        System.out.println("输入：x = 120");
        System.out.println("输出：" + IntegerReverse(120));
        System.out.println("输入：x = 0");
        System.out.println("输出：" + IntegerReverse(0));
        System.out.println("输入：x = " + Math.pow(2, 31));
        System.out.println("输出：" + IntegerReverse((int) Math.pow(2, 31)));
        //2.爬楼梯
        System.out.println("<-------第二题------->");
        System.out.println(3+"阶楼梯，有"+GetOnStairs(3)+"种方法可以爬到楼顶。");
        System.out.println(4+"阶楼梯，有"+GetOnStairs(4)+"种方法可以爬到楼顶。");
        System.out.println(5+"阶楼梯，有"+GetOnStairs(5)+"种方法可以爬到楼顶。");
        //3.求子集
        System.out.println("<-------第三题------->");
        GetSubset(new int[]{1, 2, 3});
    }

    //1.整数反转
    public static int IntegerReverse(int n) {
        try {
            if (n < 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(-n));
                sb.reverse();
                n = -Integer.parseInt(sb.toString());
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(n));
                sb.reverse();
                n = Integer.parseInt(sb.toString());
            }
            if (n >= -Math.pow(2, 31) && n <= Math.pow(2, 31) - 1) {
                return n;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    //2.爬楼梯
    public static int GetOnStairs(int n) {
        int temp,a,b;
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n > 2) {
            a = 1;
            b = 2;
            temp = 0;
            for (int i = 3; i <= n; i++) {
                temp = a + b;
                a = b;
                b = temp;
            }
        }else {
            return 0;
        }
        return temp;
    }

    //3.求子集
    public static void GetSubset(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(list);
        for(int num : nums){
            int size = res.size();
            for(int i = 0; i < size; i++){
                List<Integer> temp = new ArrayList<>(res.get(i));
                temp.add(num);
                res.add(temp);
            }
        }
        System.out.println(res);
    }
}

