package annotation.jsr_250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Circle {
    private Point center;

    public Point getCenter() {
        return center;
    }

    @Resource(name = "c2")
    public void setCenter(Point center) {
        this.center = center;
    }

    public void draw() {
        System.out.println("Circle{" +
                "center=" + center +
                '}');
    }

    @PostConstruct
    public void initCircle() {
        System.out.println("Init circle called !");
    }

    @PreDestroy
    public void destroyCircle() {
        System.out.println("Destroy circle called !");
    }

}
