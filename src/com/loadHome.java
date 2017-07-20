package com;

/**
 * Created by Big_Boss on 2017/7/19.
 */
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import Dao.ImgDAO;
import Dao.Dao;
import bases.ImgEntity;
public class loadHome {
    private int homepage;
    private int page;
    private List list=new ArrayList();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setHomepage(int homepage) {
        this.homepage = homepage;
    }

    public List getList() {
        return list;
    }

    public int getHomepage() {
        return homepage;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String execute(){
        Dao dao=new Dao();
        int page=dao.getpagesum();
        setHomepage(page);
        setPage(page);
        list=dao.getpage(page);
        return Action.SUCCESS;
    }
}
