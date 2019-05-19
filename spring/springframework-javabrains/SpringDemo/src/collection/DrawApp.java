package collection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawApp {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("autowiring/spring.xml");

        Triangle triangle = (Triangle) factory.getBean("triangle");
        System.out.println(triangle);
    }
}
