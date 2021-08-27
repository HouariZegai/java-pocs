package callbacks;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDemo {
    public static void main(String[] args) {
        AbstractApplicationContext factory = new ClassPathXmlApplicationContext("callbacks/spring.xml");
        factory.registerShutdownHook(); // for call destroy method

        Triangle triangle = (Triangle) factory.getBean("triangle");
        System.out.println(triangle);
    }
}
