package com.ss.demo.model.mybatis;

import com.ss.demo.model.entity.Message;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;
import java.util.List;

public class MessageDaoMybatisImpl implements MessageDaoMybatis {
    private SqlSession session = null;
    private MessageMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(MessageDaoMybatisImpl.class);

    /**
     * Singleton inmplementation
     */
    private static class SingletonHolder {
        public static MessageDaoMybatisImpl instance = new MessageDaoMybatisImpl();
    }

    /**
     * Returns inctance of MessageDaoMybatisImpl
     */
    public static MessageDaoMybatisImpl getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * Use getInstance() to get instance of this object
     */
    protected MessageDaoMybatisImpl() {
        try {
            String aResource = "iBatisConfig.xml";
            Reader reader = Resources.getResourceAsReader(aResource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
            mapper = session.getMapper(MessageMapper.class);
        } catch (Exception e) {
            logger.error("Exception caught: " + e.getMessage(), e);
        }
    }

    /**
     * Performs cleanup, when object unneeded. Resets state of this Dao
     */
    public void finalize() {
        if (session != null) {
            session.close();
        }
        SingletonHolder.instance = null;
    }

    public void save(Message persistent) {
        mapper.insert(persistent);
    }

    public void update(Message persistent) {
        mapper.update(persistent);
    }

    public boolean delete(Integer id) {
        mapper.delete(id);
        return true;
    }

    public boolean delete(Message persistent) {
        mapper.delete(persistent.getId());
        return true;
    }

    public Message get(Integer id) {
        return mapper.select(id);
    }

    public List<Message> getAll() {
        return mapper.selectAll();
    }

    public boolean isExist(Integer id) {
        Message m = mapper.select(id);
        if (m != null) {
            return true;
        } else {
            return false;
        }
    }

}
