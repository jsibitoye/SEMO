import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class NewBarTest {

    static JFrame frame = new JFrame();
    static JProgressBar bar = new JProgressBar(0, 100);

    public static void ProgressBarDemo() {

        bar.setValue(0);
        bar.setBounds(0, 0, 420, 50);
        bar.setStringPainted(true);
        // bar.setFont(new Font("MV Boli",Font.BOLD,25));
        // bar.setForeground(Color.red);
        // bar.setBackground(Color.black);

        frame.add(bar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 50);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setUndecorated(true);
        frame.setResizable(false);

        fill();
    }

    public static void fill() {
        int counter = 0;

        while (counter <= 100) {

            bar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            counter += 1;
        }
        bar.setString("Done! :)");
    }

    public static void main(String[] args) {
        ProgressBarDemo();
    }
}
