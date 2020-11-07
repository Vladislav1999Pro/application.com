public class Matrix {

    public Point[] points;
    public  int w;
    public int h;
    public int length;

    public Matrix(int width, int height) {
        w = width;
        h = height;
        points = new Point[(length = w * h)];
        recursion(0, 0);
    }

    public Point getPoint(int x, int y) {
        return points[twoDoneD(x,y)];
    }

    private int twoDoneD(int x, int y) {
        return w * y + x;
    }

    public Point recursion(int x, int y) {
        if (points[twoDoneD(x, y)] == null) {
            Point p = new Point(x, y);
            points[twoDoneD(x, y)] = p;

            p.points[0] = recursion(border(x + 1, 0, w - 1), border(y, 0, h - 1));
            p.points[1] = recursion(border(x, 0, w - 1), border(y + 1, 0, h - 1));
            p.points[2] = recursion(border(x - 1, 0, w - 1), border(y, 0, h -1 ));
            p.points[3] = recursion(border(x, 0, w - 1), border(y - 1, 0, h - 1));

            return  p;
        } else {
            return points [twoDoneD(x, y)];
        }
    }

    public int border(int vel, int min, int max) {
        if(vel > max) {
            vel = max;
        }
        if (vel < min) {
            vel = min;
        }
        return vel;
    }

    public void process() {
        for (Point point : points) {
            if (point.valueSnake > 0) {
                point.valueSnake--;
            }
            if (point.valueApple > 0) {
                point.valueApple--;
            }
        }

    }
}
