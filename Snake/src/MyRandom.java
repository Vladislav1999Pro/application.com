public class MyRandom {
    public int value = 1, border = 7;

    public int nextInt(int value) {
        return nextInt() % (value + 1);
    }

    public int nextInt() {
        while (true) {
            value = value * 2;
            border = border +1;
            if (value > border) {
                value = value - border;
                return value;
            }
        }
    }
}
