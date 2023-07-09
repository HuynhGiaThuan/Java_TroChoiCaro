/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import GUI.SQLServerDataProvider;
/**
 *
 * @author thuan
 */
public class DangKyDao {
   
     public void AddSV(String user,String Name , String Pass ,String Email ){
        String sql="insert into Account values('"+user+"',N'"+Name+"','"+Pass+"','icons8_morpheus_96px.png',0)";
        SQLServerDataProvider pro  = new SQLServerDataProvider();
          pro.open();
          int n= pro.executeUpdate(sql);
          pro.close();
    }
}
