package msg_source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

@Controller
public class Circle {

    private Point center;

    @Autowired
    private MessageSource messageSource;

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void draw() {
        System.out.println(this.messageSource.getMessage("drawing.cirle", null, "default drawing msg", null));
        System.out.println(this.messageSource.getMessage("drawing.point", new Object[]{center.getX(), center.getY()}, "default drawing msg", null));
        //System.out.println("Circle{center=" + center.getX() + center.getY() + '}');
        System.out.println(this.messageSource.getMessage("greeting", null, "default msg!", null));
    }
}
