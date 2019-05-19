package annotation.component_stereotype;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Circle {
    private Point center;

    public Point getCenter() {
        return center;
    }

    @Resource // if i don't specify the name it's take the name of object by default (center)
    public void setCenter(Point center) {
        this.center = center;
    }

    public void draw() {
        System.out.println("Circle{" +
                "center=" + center +
                '}');
    }
}
