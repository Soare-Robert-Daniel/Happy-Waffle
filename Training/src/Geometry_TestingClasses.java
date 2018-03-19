import java.lang.Math;
/**
 * <h1>Rectangle Implementation</h1>
 * This is a simple class that implement a primitive rectangle
 */
class Rectangle{
    private float length;
    private float height;

    Rectangle(){
        length = 0;
        height = 0;
    }

    Rectangle(float height, float length)
    {
        this.length = length;
        this.height = height;
    }

    /**
     * This method is used to calculate the area of the rectangle.
     * @return float Area of the rectangle
     */

    public float GetArea()
    {
        return length * height;
    }

    /**
     * This method is used to modify the properties of the rectangle.
     * @param height  The height of the rectangle
     * @param length The length of the rectangle
     */

    public void Set(float height , float length )
    {
        this.length = length;
        this.height = height;
    }
}

/**
 * <h1>Circle Implementation</h1>
 * This is a simple class that implement a primitive circle
 */

class Circle{
    private float radius;

    Circle()
    {
        this.radius = 0;
    }

    Circle(float radius)
    {
        this.radius = radius;
    }

    /**
     * This method is used to calculate the area of the circle.
     * @return float Area of the circle
     */
    public float GetArea()
    {
        return (float)Math.PI * this.radius * this.radius;
    }

    /**
     * This method is used to modify the properties of the radius.
     * @param radius The radius of the circle
     */
    public void Set(float radius)
    {
        this.radius = radius;
    }
}

public class Geometry_TestingClasses {

    public Rectangle rect;
    public Circle circ;

    public void exe()
    {
        this.rect = new Rectangle(10, 10);
        System.out.println("The area of the rectangle is: " + String.valueOf(this.rect.GetArea()) );

        this.circ = new Circle(10);
        System.out.println("The area of the circle is: " + String.valueOf(this.circ.GetArea()) );
    }

    public static void main(String[] args)
    {
        Geometry_TestingClasses test = new Geometry_TestingClasses();
        test.exe();
    }
}
