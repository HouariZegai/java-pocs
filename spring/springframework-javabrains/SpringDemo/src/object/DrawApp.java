package object;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawApp {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("object/spring.xml");

        // for initialize: can use id, name or alias; but id is the best practise
        Triangle triangle = (Triangle) factory.getBean("triangle-name");
        System.out.println(triangle);
    }
}
