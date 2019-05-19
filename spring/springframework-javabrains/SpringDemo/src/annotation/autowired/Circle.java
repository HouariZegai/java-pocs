package annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle {
    private Point center;

    public Point getCenter() {
        return center;
    }

    @Autowired
    @Qualifier("relatedCircle")
    public void setCenter(Point center) {
        this.center = center;
    }

    public void draw() {
        System.out.println("Circle{" +
                "center=" + center +
                '}');
    }
}
