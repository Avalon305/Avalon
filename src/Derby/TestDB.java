
//database.properties文件
//#jdbc.drivers=org.apache.derby.jdbc.ClientDriver 因为derby驱动程序将自动注册驱动类
//jdbc.url=jdbc:derby://localhost:1527/COREJAVA
//#jdbc.username=dbuser4  可以不使用用户名和密码，默认是APP用户，因为如果使用了如此的设置在第二次创建时（第一次中途失败）会出现 #org.apache.derby.client.am.SqlException: Schema“DBUSER4”中已经存在Table/View“GREETINGS”的异常，便于方便，所以在此注释掉了。
//#jdbc.password=secret4

//需要注意的是在通过Derby交互式脚本执行工具删除表时，在不同的用户创建了相同的表时（当你如上设置了用户和密码，derby将自动为你创建用户），应按 DROP TABLE 用户名.表名 执行删除表操作

package Derby;
import java.io.IOException;
import java.io.InputStream;
//java文件
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/*
*This program tests that the database and the JDBC driver are correctly configured.
*/

public class TestDB{
    public static void main(String[] args) throws IOException{
        try{
            runTest();
        }catch(SQLException ex){
            for(Throwable t:ex)
                t.printStackTrace();
        }

    }
    /**
    *Runs a test by creating a table,adding a value,showing the table contents,and removing the table.
    */
    public static void runTest() throws SQLException,IOException{
        try(Connection conn = getConnection())
        {
            Statement stat = conn.createStatement();
            stat.executeUpdate("CREATE TABLE Greeting (Message CHAR(40))");

            // Using ' not "
            stat.executeUpdate("INSERT INTO Greeting VALUES('hello')");
            stat.executeUpdate("INSERT INTO Greeting VALUES('你好，世界')");

            try(ResultSet result = stat.executeQuery("SELECT * FROM Greeting")){
                //将光标移动到下一行，初始在第一行之前
                while(result.next()) 
                    System.out.println(result.getString("Message"));
            }
            //stat.executeUpdate("DROP TABLE Greeting");

        }
    }
    /**
    *Gets a connection from the properties specified in the file database.properties.
    *@return the database connection
    */
    public static Connection getConnection() throws SQLException,IOException{
        Properties props = new Properties();
        
        try(InputStream in = Files.newInputStream(Paths.get("D:\\eclipse ee\\workspace\\ThreadPoolDemo\\src\\Derby","database.properties"))){
            props.load(in);
        }
        String drivers = props.getProperty("jdbc.drivers");
        //为了适应那些不能自动注册的数据库驱动程序
        if(drivers != null)
            //这种方式可以提供多个驱动器，使用冒号分割
            System.setProperty("jdbc.drivers",drivers);
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url,username,password);
    }




}