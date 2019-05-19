package useinterfaces;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawApp {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("useinterfaces/spring.xml");

        Shape shape = (Shape) factory.getBean("triangle");
        shape.draw();
    }
}
