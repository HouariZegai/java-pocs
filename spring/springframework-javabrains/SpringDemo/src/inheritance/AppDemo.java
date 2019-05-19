package inheritance;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDemo {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("inheritance/spring.xml");

        Triangle triangle = (Triangle) factory.getBean("triangle");
        System.out.println(triangle);
        System.out.println("Bean name: " + triangle.getBeanName());
    }
}
