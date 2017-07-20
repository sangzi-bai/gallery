package Dao;

/**
 * Created by Big_Boss on 2017/7/19.
 */
import bases.WhisperingEntity;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class whisperingDao {
    private Configuration cfg =null;

    private SessionFactory sf = null;
    private Session se =null;
    private Transaction ts =null;

    public whisperingDao(){
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

    public WhisperingEntity insert(WhisperingEntity Whispering)
    {
        se.save(Whispering);
        destory();
        return Whispering;
    }
    public List<WhisperingEntity> getpage(int serialNumber)
    {
        List<WhisperingEntity> rtn = new ArrayList<>();
        Query query = se.createQuery("from WhisperingEntity where serialNumber="+serialNumber);
        rtn = query.list();
        destory();
        return rtn;
    }
}
