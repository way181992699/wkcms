package org.wkidt.wkcms;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wkidt.wkcms.user.mapper.UserMapper;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-mybatis.xml"})
public class AppTest {
    Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
    /*    logger.info("selectByUserName =================== " + userMapper.selectAllUser());
    }
*/

}
}
