package work6.work1;

// Прямоугольник
public class Rectangle extends Shape{

    public int getArea(){
        return super.height * super.width;
    }

    public int getPerimeter(){
        return (super.height * 2) + (super.width * 2);
    }

}
