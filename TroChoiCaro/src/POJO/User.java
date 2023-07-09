/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Administrator
 */
public class User {
    
    String nameId;
    String avatar;

//    public User( String nameId, String avatar) {
//       
//        this.nameId = nameId;
//        this.avatar = avatar;
//    }

    @Override
    public String toString() {
        return nameId;
    }
    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    
}