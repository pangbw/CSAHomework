public class FirstTime {
    public static void main(String[] args) {
        //选择题答案
        System.out.println("选择题答案：");
        System.out.println("\t1.B 2.B 3.D 4.B 5.B");
        //编程题答案
        System.out.println("编程题结果：");
        System.out.println("\t1.打印三⻆：");
        showTriangle(4);
        System.out.println("\t2.颠倒字符串：");
        reverseString("123456789");
        System.out.println("\t3.回⽂数判断：(测试用例：1，121，123)");
        isPalindrome(1);
        isPalindrome(121);
        isPalindrome(123);
        System.out.println("\t4.水仙花数:");
        ShuiXianHua();
        System.out.println("\t5.数组最值和:");
        int[] a = {9,4,6,7,3,1,10,25,0};
        arraysDemo(a);
    }
    public static void showTriangle(int n){
    //n为行数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n-1; j++) {
                //以中轴作为输出判定依据
                if (j >= (2*n-1)/2-i && j <= (2*n-1)/2+i)
                    System.out.print('*');
                else
                    System.out.print(' ');
            }
            System.out.print('\n');
        }
    }

    public static void reverseString(String s) {
        char[] chars = s.toCharArray();
        char temp;
        for (int i = 0; i < chars.length/2; i++) {
            temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        String s1 = String.valueOf(chars);
        s = s1;
        System.out.println(s);
    }

    public static void isPalindrome(int num) {
        boolean flag = false;
        String s = String.valueOf(num);
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                break;
            flag = true;
        }
        if (s.length() == 1)
            flag = true;

        if (flag)
            System.out.println("是的") ;
        else
            System.out.println("不是") ;
    }

    public static void ShuiXianHua() {
        for (int i = 100; i < 1000; i++) {
            int sum = 0,temp = i;
            for (int j = 0; j < 3; j++) {
                sum += Math.pow(temp%10,3);
                temp = temp/10;
            }
            if (sum == i)   System.out.print(i+" ");
        }
        System.out.print("\n");

    }

    public static void arraysDemo(int[] a) {
        int max = a[0],min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i])
                max = a[i];
            else if (min > a[i])
                min = a[i];
        }
        System.out.println("max:"+max+"\tmin:"+min);
    }
}