/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import GUI.SQLServerDataProvider;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author thuan
 */
public class DangNhapDAO {
    public static String getPass(String user){
        String password="";
        try{
              String sql = "select PassWord from Account where UserName  = '"+user.trim()+"'";
            SQLServerDataProvider pro  = new SQLServerDataProvider();
          
            pro.open();
            ResultSet rs = pro.executeQuery(sql);
            while(rs.next()){
                 password=rs.getString(1);
            }
             pro.close();
        }catch(Exception ex){
            System.out.print("Lỗi không thấy dữ liệu1111");
        }
        return password;
    }
    
     public static String getUsername(String user){
         String userName="";
        try{
          String sql = "select UserName from Account where UserName = '"+user.trim()+"'";
           SQLServerDataProvider pro  = new SQLServerDataProvider();
          
            pro.open();
            ResultSet rs = pro.executeQuery(sql);
            while(rs.next()){
                 userName=rs.getString(1);
            }
             pro.close();
        }catch(Exception ex){
            System.out.print("Lỗi không thấy dữ liệu");
        }
        return userName;
       
    }
     
     public static String getName(String user ){
         String Name="";
            try{
                String sql="select TenUser from Account where UserName ='"+user.trim()+"' ";
                  SQLServerDataProvider pro  = new SQLServerDataProvider();
                pro.open();
                ResultSet rs = pro.executeQuery(sql);
                while(rs.next()){
                     Name=rs.getString(1);
            }
             pro.close();
            }catch(Exception ex){
                System.out.print("Lỗi không thấy dữ liệu");
            }
         
         
         return Name;
     
     }
     public static String getAvatar(String user ){
         String Hinh="";
            try{
                String sql="select Hinh from Account where UserName ='"+user.trim()+"' ";
                  SQLServerDataProvider pro  = new SQLServerDataProvider();
                pro.open();
                ResultSet rs = pro.executeQuery(sql);
                while(rs.next()){
                     Hinh=rs.getString(1);
            }
             pro.close();
            }catch(Exception ex){
                System.out.print("Lỗi không thấy dữ liệu");
            }
         
         
         return Hinh;
     
     }
     
     public void updateUser(String Name, String PassWrd,String Account){
         String Sql="update  Account set TenUser=N'"+Name+"' , PassWord='"+PassWrd+"' where UserName= '"+Account+"'";
         SQLServerDataProvider pro  = new SQLServerDataProvider();
         pro.open();
         int n= pro.executeUpdate(Sql);
         pro.close();
     }
     
//     public void getAvatar(String Name){
//         String sql="select Hinh from Account where TenUser =N'"+Name+"'";
//          SQLServerDataProvider pro  = new SQLServerDataProvider();
//          pro.open();
//         
//          pro.close();
//     }
    
     
     
     
     
     
}
