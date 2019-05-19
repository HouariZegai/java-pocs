package annotation.autowired;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawApp {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("annotation/autowired/spring.xml");

        Circle circle = (Circle) factory.getBean("circle");
        circle.draw();
    }
}
