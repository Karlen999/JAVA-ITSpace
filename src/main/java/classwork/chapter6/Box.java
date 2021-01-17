package classwork.chapter6;

public class Box {

    double width;
    double height;
    double depth;

    Box () {
        width = 10;
        height = 10;
        depth = 10;
    }

    Box (double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    double volume(){
        return width * height * depth;
    }
}
