package com.group2022103.flightkiosk.view;

import com.group2022103.flightkiosk.vo.*;

public class CreditView {
    private String ID,PWD,id,pwd;

    public CreditView(CreditBack creditBack){
    }

    public CreditView(CreditFront creditFront){
        this.ID = creditFront.getID();
        this.PWD = creditFront.getPWD();
    }

    public void setID(String id){
        this.id = id;
    }

    public void setPWD(String pwd){
        this.pwd = pwd;
    }

    public boolean check(){
        if(ID.equals(id) && PWD.equals(pwd)){
            return true;
        }
        else{
            return false;
        }
    }
}
