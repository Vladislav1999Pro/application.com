import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class MyFrame extends JFrame implements ActionListener {
    public JPanel panel;

    public int width = 20, height = 20;
    public Objects objects = new Objects(width, height);

    public MyFrame(){
        super("Snake");
        this.setVisible(true);
        this.setSize(510, 530);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(panel = new Panel());
        this.addKeyListener(new MyKeyAdapter());
        new Timer(200,this).start();

    }



    public static void main(String[] args) {
        new MyFrame();
    }

    public void window (String text){
        int i = JOptionPane.showConfirmDialog(null, text + " Хотите сыграть еще раз ???", "Программа",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (i == 1) {
            System.exit(0);
        }
        if (i == 0) {
            objects = new Objects(width, height);
        }

    }

    public  void notification() {
        if (!objects.snake.life) {
            window("Вы проиграли.");
        }
        if (objects.snake.length == 1000) {
            window("Вы выиграли.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        notification();
        objects.process();
        panel.repaint();

    }

    private class Panel extends JPanel {

        @Override
        public void paint(Graphics g) {
            Point[] points = objects.matrix.points;

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            for (Point point : points) {
                if (point.valueSnake > 0 && point.valueApple == 0) {
                    image.setRGB(point.x, point.y, new Color(0, 255, 0).getRGB());
                }
                if (point.valueSnake == 0 && point.valueApple > 0) {
                    image.setRGB(point.x, point.y, new Color(point.valueApple * 17, 0, 0).getRGB());
                }
                if (point.valueSnake > 0 && point.valueApple > 0) {
                    image.setRGB(point.x, point.y, new Color(255, 255, 0).getRGB());
                }
                if (point.valueSnake == 0 && point.valueApple == 0) {
                    image.setRGB(point.x, point.y, new Color(0, 0, 255).getRGB());
                }
                g.drawImage(image, 0,0, width * 25, height * 25, null);
            }
        }

    }

    private class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                objects.snake.direction = 0;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                objects.snake.direction = 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                objects.snake.direction = 2;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                objects.snake.direction = 3;
            }

        }

    }
}
