package callbacks;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

public class Triangle implements InitializingBean, DisposableBean {

    private List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + points +
                '}';
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean init method called from " + this.getClass().getName());
    }

    @Override
    public void destroy() {
        System.out.println("DisposableBean destroy method called from " + this.getClass().getName());
    }

    // Second method to call init using xml tag
    public void myInit() {
        System.out.println("myInit method called");
    }

    public void cleanUp() {
        System.out.println("cleanUp method called");
    }
}
