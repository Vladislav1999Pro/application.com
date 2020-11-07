public class Apples {
    MyRandom myRandom = new MyRandom();
    Matrix matrix;
    int time;

    public Apples(Matrix matrix) {
        this.matrix = matrix;
    }

    public void process() {
        if (++time > 0) {
            time =  0;
            Point point = matrix.getPoint(myRandom.nextInt(19), myRandom.nextInt(19));
            if (point.valueSnake == 0) {
                point.valueApple = 12;
            }
        }
    }
}
