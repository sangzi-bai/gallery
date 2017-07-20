package com;

/**
 * Created by Big_Boss on 2017/7/18.
 */
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import Dao.ImgDAO;
import Dao.Dao;
import bases.ImgEntity;
public class load {
    private int page;
    private int homepage;
    private List list=new ArrayList();

    public int getPage() {
        return page;
    }

    public int getHomepage() {
        return homepage;
    }

    public List getList() {
        return list;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setHomepage(int homepage) {
        this.homepage = homepage;
    }

    public String execute(){
        Dao dao=new Dao();
        setHomepage(dao.getpagesum());
        if(page<1)this.page=1;
        list=dao.getpage(page);
        return Action.SUCCESS;
    }
}
