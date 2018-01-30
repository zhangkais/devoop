package OperationDBUtils;

import org.junit.Test;

public class Testrun {
    @Test
    public  void  connection() throws Exception {
         System.out.println(C3p0Util.getConnection());
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection= DriverManager.getConnection("jdbc:mysql:///test","root","root");
//        Statement stmt = connection.createStatement();
//         QueryRunner runner=new QueryRunner();
//
//        ResultSet rs = stmt.executeQuery("select name from user");//选择import java.sql.ResultSet;
//        while(rs.next()){//如果对象中有数据，就会循环打印出来
//            System.out.println(rs.getString("name"));
//        }

    }
}
