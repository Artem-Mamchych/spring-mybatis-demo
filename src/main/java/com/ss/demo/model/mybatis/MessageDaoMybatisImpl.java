package com.ss.demo.model.mybatis;

import com.ss.demo.model.entity.Message;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

//FIXME not works!
public class MessageDaoMybatisImpl implements MessageDaoMybatis {
    private SqlSession session = null;
    private MessageMapper mapper;

    private static class SingletonHolder {
        public static MessageDaoMybatisImpl instance = new MessageDaoMybatisImpl();
    }

    public static MessageDaoMybatisImpl getInstance() {
        return SingletonHolder.instance;
    }

    protected MessageDaoMybatisImpl() {
        try {
            String aResource = "iBatisConfig.xml";
            Reader reader = Resources.getResourceAsReader(aResource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
            mapper = session.getMapper(MessageMapper.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            //log.error("Exception caught: " + e.getMessage(), e);
        }
    }

    public void finalize() {
        if (session != null) {
            session.close();
        }
        SingletonHolder.instance = null;
    }

    public void saveOrUpdate(Message persistent) {
        throw new RuntimeException("saveOrUpdate() not implemented yet");
    }

    @Override
    public void save(Message persistent) {
        mapper.insert(persistent);
    }

    @Override
    public void update(Message persistent) {
        mapper.update(persistent);
    }

    public void delete(Integer id) {
        mapper.delete(id);
    }

    public void delete(Message persistent) {
        mapper.delete(persistent.getId());
    }

    public Message get(Integer id) {
        return mapper.select(id);
    }

    public List<Message> getAll() {
        return mapper.selectAll();
    }

}
