public class Snake {
    public int direction = 3;
    public Point point;
    public int length = 4;
    public boolean life = true;

    public Snake(Point point) {
        this.point = point;
        point.valueSnake = length;

    }

    private void move() {
        point = point.points[direction];
        if (point.valueSnake > 0) {
            life = false;
            point.valueSnake = 0;
        } else {
            point.valueSnake = length;
        }
    }

    private void ingestion() {
        if (point.valueApple > 0) {
            length++;
            point.valueApple = length - 1;
        }
    }

    public void process() {
        if (life) {
            move();
            ingestion();
        }
    }
}
