import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {

    JFrame jFrame = new JFrame();
    JButton jButtonStart = new JButton("START");
    JButton jButtonReset = new JButton("RESET");
    JLabel jLabelTime = new JLabel();

    int timePassed = 0;
    int second = 0;
    int minute = 0;
    int hour = 0;
    boolean isStarted = false;

    String secondStr = String.format("%02d", second);
    String minuteStr = String.format("%02d", minute);
    String hourStr = String.format("%02d", hour);

    Timer timer = new Timer(
            1000,
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    timePassed += 1000;
                    hour = (timePassed / 3600000);
                    minute = (timePassed / 60000) % 60;
                    second = (timePassed / 1000) % 60;

                    secondStr = String.format("%02d", second);
                    minuteStr = String.format("%02d", minute);
                    hourStr = String.format("%02d", hour);

                    jLabelTime.setText(hourStr + ":" + minuteStr + ":" + secondStr);
                }
            }
    );

    Stopwatch() {
        jLabelTime.setText(hourStr + ":" + minuteStr + ":" + secondStr);
        jLabelTime.setBounds(43, 49, 200, 100);
        jLabelTime.setFont(new Font("SansSerif", Font.PLAIN, 30));
        jLabelTime.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabelTime.setHorizontalAlignment(JTextField.CENTER);
        jLabelTime.setOpaque(true);

        jButtonStart.setBounds(43, 152, 99, 50);
        jButtonStart.setFont(new Font("Serif", Font.PLAIN, 20));
        jButtonStart.setFocusable(false);
        jButtonStart.addActionListener(this);

        jButtonReset.setBounds(144, 152, 99, 50);
        jButtonReset.setFont(new Font("Serif", Font.PLAIN, 20));
        jButtonReset.setFocusable(false);
        jButtonReset.addActionListener(this);

        jFrame.add(jLabelTime);
        jFrame.add(jButtonStart);
        jFrame.add(jButtonReset);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 300);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonStart) {
            if (!isStarted) {
                isStarted = true;
                jButtonStart.setText("STOP");
                start();
            }
            else {
                isStarted = false;
                jButtonStart.setText("START");
                stop();
            }
        }

        if (e.getSource() == jButtonReset) {
            isStarted = false;
            jButtonStart.setText("START");
            reset();
        }
    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();

        timePassed = 0;
        second = 0;
        minute = 0;
        hour = 0;

        secondStr = String.format("%02d", second);
        minuteStr = String.format("%02d", minute);
        hourStr = String.format("%02d", hour);

        jLabelTime.setText(hourStr + ":" + minuteStr + ":" + secondStr);
    }
}