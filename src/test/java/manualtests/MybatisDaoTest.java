package manualtests;


import java.io.Reader;
import java.util.Date;
import java.util.List;

import com.ss.demo.model.entity.Message;
import com.ss.demo.model.mybatis.MessageDaoMybatisImpl;
import com.ss.demo.model.mybatis.MessageMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MybatisDaoTest {
    private SqlSession session = null;
    private Logger log = Logger.getLogger(getClass().getName());
    private MessageDaoMybatisImpl dao;

    public MybatisDaoTest() {
        super();
    }

    public static void main(String[] args) {
        new MybatisDaoTest().run(args);
    }

    private void run(String[] args) {
        try {
            log.info("Program started");
            dao = MessageDaoMybatisImpl.getInstance();
            List<Message> messages = dao.getAll();

            if (messages.size() == 2) {
                Message m = new Message();
                m.setDatePosted(new Date());
                m.setMessageContent("MsgText");
                log.info("Inserting: " + m);
                dao.save(m);
                messages = dao.getAll();
            }

            log.info("List<Message> size=" + messages.size());
            log.info("List<Message> content:");
            for (Message message : messages) {
                log.info(message);
            }
            dao.finalize();
        } catch (Exception e) {
            log.error("Exception caught: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
