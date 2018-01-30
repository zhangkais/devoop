package OperationDBUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Util {
    public static ComboPooledDataSource cpds=null;
    static {
        cpds=new ComboPooledDataSource();
    }
    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

    public static ComboPooledDataSource getDataSource() throws SQLException {
        return cpds;
    }
}
