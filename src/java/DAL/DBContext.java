package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
 /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + ";databaseName=" + dbName;//+"; integratedSecurity=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
//        return DriverManager.getConnection(url);
    }
//    public static void main(String[] args) {
//        try {
//            System.out.println(new DBContext().getConnection());
//        } catch (Exception e) {
//        }
//    }
    
    public static void main(String[] args) {
    try {
        Connection connection = new DBContext().getConnection();
        if (connection != null) {
            System.out.println("Kết nối thành công đến database!");
        } else {
            System.out.println("Kết nối thất bại!");
        }
    } catch (Exception e) {
        System.err.println("Có lỗi xảy ra khi kết nối đến database:");
        e.printStackTrace();
    }
}

    
    
    public ResultSet getData(String sql){
        Connection conn = null;
        ResultSet rs = null;
        Statement state;
        try{
         state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        } catch (SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    /*Insert your other code right after this comment*/
 /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "PRJ301_FA23_SE1761";
//    private final String dbName = "account";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123456";
}


