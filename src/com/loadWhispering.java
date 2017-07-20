package com;

/**
 * Created by Big_Boss on 2017/7/19.
 */
import com.opensymphony.xwork2.Action;

import java.util.ArrayList;
import java.util.List;

import Dao.whisperingDao;

public class loadWhispering {
    private int serialNumber;
    private List list=new ArrayList();

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List getList() {
        return list;
    }

    public String execute(){
        whisperingDao dao=new whisperingDao();
        list=dao.getpage(serialNumber);
        return Action.SUCCESS;
    }
}
