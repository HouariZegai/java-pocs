package annotation.component_stereotype;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawApp {
    public static void main(String[] args) {
        AbstractApplicationContext factory = new ClassPathXmlApplicationContext("annotation/component_stereotype/spring.xml");
        factory.registerShutdownHook();

        Circle circle = (Circle) factory.getBean("circle");
        circle.draw();
    }
}
