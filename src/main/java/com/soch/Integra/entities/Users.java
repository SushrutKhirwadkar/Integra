package com.soch.Integra.entities;

import java.util.Date;
public class Users  implements java.io.Serializable {
 
 
     private String uname;
     private String pwd;
     private String email;
     private Date dor;
 
    public Users() {
    }
 
     
    public Users(String uname) {
        this.uname = uname;
    }
    public Users(String uname, String pwd, String email, Date dor) {
       this.uname = uname;
       this.pwd = pwd;
       this.email = email;
       this.dor = dor;
    }
    
    public String getUname() {
        return this.uname;
    }
     
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPwd() {
        return this.pwd;
    }
     
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getEmail() {
        return this.email;
    }
     
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDor() {
        return this.dor;
    }
     
    public void setDor(Date dor) {
        this.dor = dor;
    }
}
