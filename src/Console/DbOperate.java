package Console;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
/**
 * Created by CQZ on 2018/8/11.
 * desc:
 */
public class DbOperate {

    /**
     * 数据库表备份
     *
     * @throws Exception
     */
    public static void tableBackup(String dbUser,String dbPass,String dbHost,String dbPort,String dbName,String savePath, String tableName)
            throws Exception {

        Runtime runtime = Runtime.getRuntime();
        // -u后面是用户名，-p是密码-p后面最好不要有空格，-family是数据库的名字
        Process process = runtime.exec("mysqldump -h " + dbHost + " -P "
                + dbPort + " -u " + dbUser + " -p" + dbPass + " " + dbName
                + " " + tableName);
        InputStream inputStream = process.getInputStream();// 得到输入流，写成.sql文件
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(reader);
        String s = null;
        StringBuffer sb = new StringBuffer();
        while ((s = br.readLine()) != null) {
            sb.append(s + "\r\n");
        }
        s = sb.toString();
        File file = new File(savePath);
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();
        br.close();
        reader.close();
        inputStream.close();
    }

    /**
     * 备份数据库
     *
     * @param savePath
     * @throws Exception
     */
    public static void dbBackup(String dbUser, String dbPass, String dbHost,
                                String dbPort, String dbName, String savePath) throws Exception {

        Runtime runtime = Runtime.getRuntime();
        // -u后面是用户名，-p是密码-p后面最好不要有空格，-family是数据库的名字
        Process process = runtime.exec("mysqldump -h " + dbHost + " -P "
                + dbPort + " -u " + dbUser + " -p" + dbPass + " " + dbName);
        InputStream inputStream = process.getInputStream();// 得到输入流，写成.sql文件
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(reader);
        String s = null;
        StringBuffer sb = new StringBuffer();
        while ((s = br.readLine()) != null) {
            sb.append(s + "\r\n");
        }
        s = sb.toString();
        File file = new File(savePath);
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();
        br.close();
        reader.close();
        inputStream.close();
    }

    /**
     * 执行sql文件
     *
     * @param savePath
     * @throws Exception
     */
    public static void dbRecover(String dbUser, String dbPass, String dbHost,
                                 String dbPort, String dbName, String savePath) throws Exception {
        // 获取操作数据库的相关属性

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("mysql -h" + dbHost + " -P " + dbPort
                + " -u " + dbUser + " -p" + dbPass
                + " --default-character-set=utf8 " + dbName);
        OutputStream outputStream = process.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(savePath)));
        String str = null;
        StringBuffer sb = new StringBuffer();
        while ((str = br.readLine()) != null) {
            sb.append(str + "\r\n");
        }
        str = sb.toString();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream,
                "utf-8");
        writer.write(str);
        writer.flush();
        outputStream.close();
        br.close();
        writer.close();
    }

    public static void main(String[] args) {
        /*try {
            dbBackup("root", "ROOT", "localhost","3306", "EPDB", "D:/back.sql");
            System.out.println("完成！");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        try {
            //dbRecover("root", "root", "localhost","3306", "ssm", "D:/back.sql");
            dbBackup("root","root","localhost","3306","ssm","C:\\Users\\Saber\\Documents\\2018暑假学习笔记");
            System.out.println("完成！");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}