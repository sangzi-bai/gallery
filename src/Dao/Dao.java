package Dao;

/**
 * Created by Big_Boss on 2017/7/18.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bases.ImgEntity;
import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Dao {
    private Configuration cfg =null;

    private SessionFactory sf = null;
    private Session se =null;
    private Transaction ts =null;

    public Dao(){
        cfg = new Configuration().configure();
        sf = cfg.buildSessionFactory();
        se = sf.openSession();
        ts = se.beginTransaction();
    }

    private void destory()
    {
        ts.commit();
        se.close();
        sf.close();
    }

    public ImgEntity insert(ImgEntity img)
    {
        se.save(img);
        destory();
        return img;
    }

    public List<ImgEntity> getpage(int pageNo)
    {
        List<ImgEntity> rtn = new ArrayList<>();
        Query query = se.createQuery("from ImgEntity");
        int pageSize = 2;
        rtn = query.setFirstResult((pageNo-1)*pageSize)
                .setMaxResults(pageSize)
                .list();
        destory();
        return rtn;
    }

    public int getpagesum(){
        String hql= "select count(*) from ImgEntity";
        Query query=se.createQuery(hql);
        int page = ((Long) query.iterate().next()).intValue();
        return page/2+page%2;
    }
}
