package autowiring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawApp {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("autowiring/spring.xml");

        Triangle triangle = (Triangle) factory.getBean("triangle");
        Triangle t2 = (Triangle) factory.getBean("triangle");
        t2.setPointC(new Point(1, 2));
        System.out.println(triangle);
    }
}
