/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class SQLServerDataProvider {
    private Connection con;
    public void open(){
        try{
            String user="sa",pass="123";
            String url="jdbc:sqlserver://localhost:1433;databaseName=Caro;encrypt=false";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con =DriverManager.getConnection(url,user,pass);
        }catch(Exception ex ){
            ex.printStackTrace();
        }
    }
    public void close(){
        try{
            this.con.close();
        }catch(Exception ex){
                    ex.printStackTrace();
        }
    }
    public ResultSet executeQuery(String sql){
        ResultSet rs= null;
        try{
            Statement st = con.createStatement();
            rs=st.executeQuery(sql);
        }catch(Exception ex ){
            
        }
        return rs; 
    }
    
    public int executeUpdate(String sql){
        int n =-1;
        try{
            Statement st =con.createStatement();
            n=st.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return n ;
    }
}
