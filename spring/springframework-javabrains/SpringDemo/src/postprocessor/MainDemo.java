package postprocessor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDemo {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("postprocessor/spring.xml");
        Triangle t = (Triangle) factory.getBean("triangle");
        System.out.println(t);
    }
}
