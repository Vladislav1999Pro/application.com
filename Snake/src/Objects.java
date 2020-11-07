public class Objects {
    public Matrix matrix;
    public Snake snake;
    public Apples apples;

    public Objects(int width, int height) {
        matrix = new Matrix(width, height);
        snake = new Snake(matrix.getPoint(10,10));
        apples = new Apples(matrix);
    }

    public void process() {
        matrix.process();
        snake.process();
        apples.process();
    }
}
