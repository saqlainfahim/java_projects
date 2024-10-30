import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClock extends JFrame {

    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(" hh:mm:ss a ");
    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEEE");
    SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MMMMM dd, yyyy");
    JLabel jLabelTime = new JLabel();
    JLabel jLabelDay = new JLabel();
    JLabel jLabelDate = new JLabel();
    String time;
    String day;
    String date;

    DigitalClock() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setTitle("Digital Clock");
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        jLabelTime.setFont(new Font("Sherif", Font.BOLD, 40));
        jLabelTime.setBackground(new Color(192, 235, 166));
        jLabelTime.setForeground(new Color(26, 26, 25));
        jLabelTime.setOpaque(true);

        jLabelDay.setFont(new Font("Sherif", Font.PLAIN, 30));

        jLabelDate.setFont(new Font("Sherif", Font.PLAIN, 30));

        this.add(jLabelTime);
        this.add(jLabelDay);
        this.add(jLabelDate);
        this.setVisible(true);

        updateTime();
    }

    public void updateTime() {
        while (true) {
            time = simpleDateFormat1.format(Calendar.getInstance().getTime());
            jLabelTime.setText(time);

            day = simpleDateFormat2.format(Calendar.getInstance().getTime());
            jLabelDay.setText(day);

            date = simpleDateFormat3.format(Calendar.getInstance().getTime());
            jLabelDate.setText(date);

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
