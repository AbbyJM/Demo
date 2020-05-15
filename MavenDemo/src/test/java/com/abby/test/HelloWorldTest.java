package com.abby.test;

import com.abby.MavenDemo.MavenDemoApplication;
import com.abby.MavenDemo.TestController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MavenDemoApplication.class)
public class HelloWorldTest {

    @Resource
    TestController testController;

    @Test
    public void helloWorldTest(){
        final String helloWorld = testController.test();
        Assert.assertEquals("hello world",helloWorld);
    }
}
