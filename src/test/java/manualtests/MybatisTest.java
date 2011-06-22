package manualtests;

import java.io.Reader;
import java.util.Date;
import java.util.List;

import com.ss.demo.model.entity.Message;
import com.ss.demo.model.mybatis.MessageMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MybatisTest {
    private SqlSession session = null;
    private Logger log = Logger.getLogger(getClass().getName());

    public MybatisTest() {
        super();
    }

    public static void main(String[] args) {
        new MybatisTest().run(args);
    }

    private void run(String[] args) {
        try {
            log.info("Program started");
            String aResource = "iBatisConfig.xml";
            Reader reader = Resources.getResourceAsReader(aResource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            log.info(sessionFactory.getConfiguration().getEnvironment().getDataSource().toString());
            session = sessionFactory.openSession();
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            List<Message> messages = mapper.selectAll();

            if (messages.size() == 2) {
                Message m = new Message();
                m.setDatePosted(new Date());
                m.setMessageContent("MsgText");
                log.info("Inserting: " + m);
                mapper.insert(m);
                messages = mapper.selectAll();
            }

            log.info("List<Message> size=" + messages.size());
            log.info("List<Message> content:");
            for (Message message : messages) {
                log.info(message);
            }
        } catch (Exception e) {
            log.error("Exception caught: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
