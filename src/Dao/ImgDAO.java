package Dao;

/**
 * Created by Big_Boss on 2017/7/18.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import bases.ImgEntity;
public class ImgDAO {
    private Configuration cfg =null;
    private ServiceRegistry sr =null;

    private SessionFactory sf = null;
    private Session se =null;
    private Transaction ts =null;

    public ImgDAO()
    {
        //初始化Hibernate
        cfg = new Configuration().configure();

        sr = new StandardServiceRegistryBuilder().
                applySettings(cfg.getProperties()).build();

    }
    private void init()
    {
        sf= cfg.buildSessionFactory(sr);

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
        init();
        se.save(img);
        destory();
        return img;
    }

    //查询列表
    public List<ImgEntity>getAll()
    {
        List<ImgEntity> rtn = new ArrayList<>();
        init();
        rtn=se.createQuery("from ImgEntity").list();
        destory();
        return rtn;
    }

}
