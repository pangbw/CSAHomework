import java.util.Date;
import java.util.Scanner;

public class ThirdTime {
    public static void main(String[] args) {
        System.out.println("<-------第一题------->");
        UseCompute uc = new UseCompute();
        Compute add = new Addition();
        Compute ubt = new Ubtraction();
        Compute mul = new Multiplication();
        Compute div = new Division();
        uc.useCom(add, 1, 2);
        uc.useCom(ubt, 1, 2);
        uc.useCom(mul, 1, 2);
        uc.useCom(div, 1, 2);
        System.out.println("<-------第二题------->");
        System.out.println("测试用例分别为：-5，106，50。");
        gradeInput(-5);
        gradeInput(106);
        gradeInput(50);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("<-------第三题------->");
        getAverge();
        System.out.println("<-------第四题------->");
        System.out.println("详见源码");
        System.out.println("<-------第五题------->");
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println("字典中有"+SubStringCheck(s, words)+"个字符串S的子序列。");
    }

    public static void gradeInput(int grade) {
        try {
            if (grade >= 0 && grade <= 100)
                System.out.println("分数为：" + grade);
            else
                throw new OutOfGradeAreaException();
        } catch (OutOfGradeAreaException e) {
            e.printStackTrace();
        }
    }

    public static void getAverge() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数个数：");
        int n = sc.nextInt();
        int temp;
        double result = 0;

        for (int i = 0; i < n; i++) {
            try {
                temp = sc.nextInt();
                if (temp >= 0)
                    result += temp;
                else
                    throw new NegativeIntException();
            } catch (NegativeIntException e) {
                i--;
                e.printStackTrace();
            }
        }
        result /= n;
        System.out.println("这"+n+"个整数的平均数为："+result);

    }

    public static int SubStringCheck(String s, String[] words) {
        int n = 0;
        for (String word : words) {
            if (s.contains(word))
                n++;
        }
        return n;
    }
}

/*
        1.计算器
 */
interface Compute {
    //Compute接口
    int computer(int n, int m);
}

class Addition implements Compute {
    //Addition类:实现加法 n+m
    @Override
    public int computer(int n, int m) {
        return m + n;
    }
}

class Ubtraction implements Compute {
    //ubtraction类:实现减法 n-m
    @Override
    public int computer(int n, int m) {
        return n - m;
    }
}

class Multiplication implements Compute {
    //Multiplication类:实现乘法 n*m
    @Override
    public int computer(int n, int m) {
        return n * m;
    }
}

class Division implements Compute {
    //Division类:实现除法 n/m
    @Override
    public int computer(int n, int m) {
        if (m == 0) System.out.println("除数不能为零。");
        return n / m;
    }
}

class UseCompute {
    //UseCompute类：完成运算
    public void useCom(Compute com, int one, int two) {
        //用传递过来的对象调用 computer 方法完成运算，并输出运算的结果
        System.out.println("运算结果为：" + com.computer(one, two));
    }
}

/*
        2.异常机制练习：分数录入
 */
//见主类中gradeInput方法
class OutOfGradeAreaException extends Exception {
    //OutOfGradeAreaException类：自定义异常类,实际使用时，若无自定义必要，可用RunTimeException替代
    public OutOfGradeAreaException() {
        super("分数必须在0——100之间。");
    }
}

/*
        3.求N个整数的平均值
 */
//见主类中getIntAverage方法
class NegativeIntException extends Exception {
    //NegativeIntException类：自定义异常类,实际使用时，若无自定义必要，可用RunTimeException替代
    public NegativeIntException() {
        super("必须是正数或者0，请重新输入正确的数");
    }
}

/*
        4.雇员类
 */
class MyDate extends Date {
    //MyDate类
}

abstract class Empoyee {
    //Empoyee类
    private String name;
    private int number;
    private MyDate birthday;

    abstract void earnings();

    public String toString() {
        return "name:" + name + "number:" + number + "birthday" + birthday;
    }
}
/*
        5.字符串子序列
 */
//见主方法中的SubStringCheck