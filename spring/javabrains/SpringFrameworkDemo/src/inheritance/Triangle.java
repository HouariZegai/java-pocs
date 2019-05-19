package inheritance;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

public class Triangle implements ApplicationContextAware, BeanNameAware {

    private List<Point> points;

    private ApplicationContext context;
    private String beanName;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + points +
                '}';
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
