import java.sql.*;

public class FifthTime {

    //JDBC驱动和数据库URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/csa_java?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    //用户名和密码
    static final String USER = "root";
    static final String PASSWORD = "mysql";

    public static void main (String[] args) {
        /*
        创建student表（SNO Varchar 20， Name Varchar 10， Age Integer， College Varchar 30）
        语句：use csa_java;
             create table student(
                SNO Varchar(20),
                Name Varchar(10),
                Age Integer,
                College Varchar(30)
               );
         */
        Connection conn;
        Statement stmt;
        try{
            //注册JDBC驱动
            Class.forName(JDBC_DRIVER);

            //打开链接
//            System.out.println("打开数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);

            //执行sql语句
//            System.out.println("实例化Statemen对象...");
            stmt = conn.createStatement();
            String sql;
            //默认查询"select * from student;"
            sql = "select * from student;";
            ResultSet rs = stmt.executeQuery(sql);
            //遍历输出
            System.out.printf("%4s%6s%4s%8s\n", "SNO", "Name", "Age", "College");
            while(rs.next()) {
                System.out.printf("%4s%4s%4d%8s\n",rs.getString("SNO"), rs.getString("name"), rs.getInt("Age"), rs.getString("College"));
            }
//            while(rs.next()) {
//                String sno = rs.getString("SNO");
//                String name = rs.getString("Name");
//                int age = rs.getInt("Age");
//                String college = rs.getString("College");
//
//                System.out.printf("%4s%4s%4d%8s\n",sno, name, age,college);
//            }

            /*
            1.插入数据
            insert into student (SNO, Name, Age, College) values ('s001', '老大', 20, '计算机学院');
            insert into student (SNO, Name, Age, College) values ('s002', '老二', 19, '计算机学院');
            insert into student (SNO, Name, Age, College) values ('s003', '老三', 18, '计算机学院');
            insert into student (SNO, Name, Age, College) values ('s004', '老四', 17, '计算机学院');
             */
            System.out.println("第1题的效果");
            System.out.println("------------------");

            sql = "insert into student (SNO, Name, Age, College) values ('s001', '老大', 20, '计算机学院');";
            stmt.executeUpdate(sql);
            sql = "insert into student (SNO, Name, Age, College) values ('s002', '老二', 19, '计算机学院');";
            stmt.executeUpdate(sql);
            sql = "insert into student (SNO, Name, Age, College) values ('s003', '老三', 18, '计算机学院');";
            stmt.executeUpdate(sql);
            sql = "insert into student (SNO, Name, Age, College) values ('s004', '老四', 17, '计算机学院');";
            stmt.executeUpdate(sql);

            printTable(stmt);

            System.out.println("------------------");
            /*
            2.查看表中所有信息，编历输出到控制台
            select * from student;
             */
            System.out.println("第2题的效果");
            System.out.println("------------------");

            printTable(stmt);

            System.out.println("------------------");
            /*
            3.把SNO为s004的记录删除
            delete from student where SNO = 's001';
             */
            System.out.println("第3题的效果");
            System.out.println("------------------");

            sql = "delete from student where SNO = 's004';";
            stmt.executeUpdate(sql);

            printTable(stmt);

            System.out.println("------------------");
            /*
            4.查询SNO为s003的记录
            select * from student where SNO = 's003';
             */
            System.out.println("第4题的效果");
            System.out.println("------------------");

            sql = "select * from student where SNO = 's003';";
            rs = stmt.executeQuery(sql);

            rs.next();
            System.out.println("Student{sno='"+rs.getString("SNO")+"', name='"+rs.getString("Name")+"', age="+rs.getInt("Age")+"', college='"+rs.getString("College")+"'}");

            printTable(stmt);

            System.out.println("------------------");
            /*
            5.把SNO为s001的记录修改为（‘s001’，‘老大’，20，‘通信学院’）
            update student set College = '通信学院';
             */
            System.out.println("第5题的效果");
            System.out.println("------------------");

            sql = "update student set College = '通信学院' where SNO = 's001';";
            stmt.executeUpdate(sql);

            printTable(stmt);

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void printTable(Statement stmt) throws SQLException {
        String sql = "select * from student;";
        ResultSet rs = stmt.executeQuery(sql);

        System.out.printf("%4s%6s%4s%8s\n", "SNO", "Name", "Age", "College");
        while(rs.next()) {
            System.out.printf("%4s%4s%4d%8s\n",rs.getString("SNO"), rs.getString("name"), rs.getInt("Age"), rs.getString("College"));
        }
//            while(rs.next()) {
//                String sno = rs.getString("SNO");
//                String name = rs.getString("Name");
//                int age = rs.getInt("Age");
//                String college = rs.getString("College");
//
//                System.out.printf("%4s%4s%4d%8s\n",sno, name, age,college);
//            }
    }
}
