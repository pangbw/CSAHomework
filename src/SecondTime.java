import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondTime {
    public static void main(String[] args) {
        //第一题——人猿进化
        System.out.println("<-------第一题------->");
        Monkey m = new Monkey();
        People p = new People();
        m.speak();
        p.speak();
        p.think();

        //第二题——汽车卡车都是车
        System.out.println("<-------第二题------->");
        Car c1 = new Car();
        Truck t1 = new Truck();
        System.out.print("示例一:\n");
        c1.capabilityCheck(3);
        System.out.print("---------------------------\n");
        t1.capabilityCheck(1, 3000);
        System.out.print("示例二:\n");
        c1.capabilityCheck(6);
        System.out.print("---------------------------\n");
        t1.capabilityCheck(1, 7000);

        //第三题——大数运算
        System.out.println("<-------第三题------->");
        System.out.println("a=\"88888888888888888\",b=\"25461213124533465\"");
        System.out.println("C=\""+getSum("88888888888888888", "25461213124533465")+"\"");
        System.out.println("a=\"13829579081298345918257\",b=\"438823897418920918472193\"");
        System.out.println("C=\""+getSum("13829579081298345918257", "438823897418920918472193")+"\"");
        System.out.println("a=\"438823897418920918472193\",b=\"13829579081298345918257\"");
        System.out.println("C=\""+getSum("438823897418920918472193", "13829579081298345918257")+"\"");

        //第四题——机器人跑图
        System.out.println("<-------第四题------->");
        System.out.println("m = 5, n = 4: "+uniquePaths(5,4));
        System.out.println("m = 5, n = 5: "+uniquePaths(5,5));
        System.out.println("m = 6, n = 7: "+uniquePaths(6,6));

        //第五题——最长公共前缀
        System.out.println("<-------第五题------->");
        String[] strs = {"f1owner","f1ow","f1eight"};
        System.out.println("\"f1owner\",\"f1ow\",\"f1eight\":");
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{"apple","banana","pear"};
        System.out.println("\"apple\",\"banana\",\"pear\":");
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{"different", "difference","differ"};
        System.out.println("\"different\", \"difference\",\"differ\":");
        System.out.println(longestCommonPrefix(strs));
    }

    //大数求和方法
    public static String getSum(String a, String b) {
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c = "";
        for (int i = a.length() - 1; i >= 0; --i) {
            la.add(a.charAt(i) - '0');
        }
        for (int i = b.length() - 1; i >= 0; --i) {
            lb.add(b.charAt(i) - '0');
        }

        //算法：按位相加
        //创建一个缓存数列表
        List<Integer> lc = new ArrayList<Integer>();
        //基于长度 更长的那个列表 进行按位加法，但是将计算结果 直接存在当前位，先 不考虑 是否进位
        if (la.size() > lb.size()) {
            lc.addAll(la);
            for (int i = 0; i < la.size(); i++) {
                if (i < lb.size())
                    lc.set(i, la.get(i) + lb.get(i));
            }
        } else {
            lc.addAll(lb);
            for (int i = 0; i < lb.size(); i++) {
                if (i < la.size())
                    lc.set(i, la.get(i) + lb.get(i));
            }
        }
        //进位判断算法
        for (int i = 0; i < lc.size(); i++) {
            //判断当前位所存数值是否大于10
            if (lc.get(i) >= 10) {
                lc.set(i, lc.get(i) % 10);
                //判断是否到了列表末尾，及添位操作
                if (i + 1 == lc.size())
                    lc.add(1);
                else
                    lc.set(i + 1, lc.get(i + 1) + 1);
            }
        }
        //将列表转化为数字字符串
        StringBuilder sb = new StringBuilder();
        for (int i = lc.size() - 1; i >= 0; i--) {
            sb.append(lc.get(i).toString());
        }
        c = sb.toString();

        return c;
    }

    //机器人跑图方法
    public static int uniquePaths(int m, int n) {
        int[] l = new int[m - 1]; //lines
        int[] c = new int[n - 1]; //column
        int temp = 0;
        Arrays.fill(l, 1);
        Arrays.fill(c, 1);
        if (m <= 1 || n <= 1)
            temp = 1;
        else {
            for (int i = 2; i <= n; i++) {
                for (int j = 2; j <= m; j++) {
                    temp = c[i - 2] + l[j - 2];
                    l[j - 2] = temp;
                    c[i - 2] = temp;
                }
            }
        }
        return temp;
    }

    //最长公共前缀方法
    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        StringBuilder sb = new StringBuilder();
        int min = strs[0].length();
        boolean flag = true;
        for (String i : strs) {
            if (i.length() < min) {
                min = i.length();
            }
        }
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                sb.append(strs[0].charAt(i));
            flag = true;
        }
        ans = sb.toString();

        return ans;
    }
}

//Monkey类
class Monkey {
    //成员变量
    String name = "";

    //无参构造方法
    Monkey() {
    }

    //构造方法——初始化名字
    Monkey(String s) {
        name = s;
    }

    //成员方法
    public void speak() {
        System.out.println("咿咿呀呀 ...... ");
    }
}

//People类 继承自Monkey
class People extends Monkey {
    //成员方法
    void think() {
        System.out.println("别说话！认真思考！");
    }

    //成员方法
    public void speak() {
        System.out.println("小样儿，不错嘛！会说话了！");
    }
}

//Vehicle类
class Vehicle {
    //成员变量
    int wheels;
    float weight;

    //构造方法
    Vehicle(int wheels, float weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    //成员方法——信息展示
    public void showInfo() {
        System.out.printf("车轮的个数是：%d 车重：%.1f\n", wheels, weight);
    }
}

//Car类
class Car extends Vehicle {
    //成员变量
    int loader = 6;

    //构造方法
    Car() {
        super(4, 1150);
    }

    //成员方法——载客检查
    public void capabilityCheck(int people) {
        this.showInfo();
        System.out.printf("这是一辆小车，能载%d人，实载%d人", loader, people);
        if (people < loader)
            System.out.print("\n");
        else
            System.out.print("，你超员了\n");
    }
}

//Truck类
class Truck extends Vehicle {
    //成员变量
    int loader = 3;
    float payload = 5000;

    //构造方法
    Truck() {
        super(6, 15000);
    }

    //成员方法——载客检查
    public void capabilityCheck(int people, float nowload) {
        this.showInfo();
        System.out.printf("这是一辆卡车，能载%d人，实载%d人", loader, people);
        if (people < loader)
            System.out.print("\n");
        else
            System.out.print("，你超员了\n");
        System.out.printf("这是一辆卡车，核载%.0fkg，你已装载%.1fkg", payload, nowload);
        if (nowload <= payload)
            System.out.print("\n");
        else
            System.out.print("，你超载了\n");
    }

}