package com.gdd.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.gdd.greendao.InfoBean;

import com.gdd.greendao.InfoBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig infoBeanDaoConfig;

    private final InfoBeanDao infoBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        infoBeanDaoConfig = daoConfigMap.get(InfoBeanDao.class).clone();
        infoBeanDaoConfig.initIdentityScope(type);

        infoBeanDao = new InfoBeanDao(infoBeanDaoConfig, this);

        registerDao(InfoBean.class, infoBeanDao);
    }
    
    public void clear() {
        infoBeanDaoConfig.clearIdentityScope();
    }

    public InfoBeanDao getInfoBeanDao() {
        return infoBeanDao;
    }

}
