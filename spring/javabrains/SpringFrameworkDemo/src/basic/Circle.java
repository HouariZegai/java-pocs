package basic;

public class Circle {
    private int id;
    private String name;
    private int width;
    private int height;

    public Circle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void draw() {
        System.out.println("Circle:\nid: " + id + " name: " + name);
        System.out.println("Width: " + width + " Height: " + height);
    }
}
