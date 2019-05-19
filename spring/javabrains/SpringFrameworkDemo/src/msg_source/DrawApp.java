package msg_source;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("msg_source/spring.xml");
        Circle circle = (Circle) context.getBean("circle");
        circle.draw();
    }
}
