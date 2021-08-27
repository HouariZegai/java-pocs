package annotation.jsr_250;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawApp {
    public static void main(String[] args) {
        AbstractApplicationContext factory = new ClassPathXmlApplicationContext("annotation/jsr_250/spring.xml");
        factory.registerShutdownHook();

        Circle circle = (Circle) factory.getBean("circle");
        circle.draw();
    }
}
