package com;

/**
 * Created by Big_Boss on 2017/7/21.
 */
import com.opensymphony.xwork2.Action;

import Dao.Dao;
public class deleteImg{
    private int serialNumber;

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String execute(){
        Dao dao=new Dao();
        if(dao.deleteimg(serialNumber))
            return Action.SUCCESS;
        else return Action.ERROR;
    }
}
