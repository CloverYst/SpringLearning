package org.example;

import org.example.domain.SysUser;
import org.example.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        UserServiceImpl service = (UserServiceImpl) ctx.getBean("service");

        //实体类没有必要放在容器中 因为是动态的
        //1.用户提交 2.数据库查询
        SysUser user = new SysUser();
        user.setAge(12);
        user.setName("clovr");
        service.addUser(user);
    }
}
