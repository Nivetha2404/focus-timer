import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusTimerGUI {
    private JFrame frame;
    private JLabel timerLabel;
    private int seconds = 0;
    private Timer timer;
    private int focusTime = 0;
    private int breakTime = 0;
    private boolean isFocus = true;

    public FocusTimerGUI() {
        frame = new JFrame("Focus Timer");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timerLabel = new JLabel("00:00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JButton startBtn = new JButton("Start");
        JButton switchBtn = new JButton("Switch Mode");

        startBtn.addActionListener(e -> startTimer());
        switchBtn.addActionListener(e -> switchMode());

        frame.setLayout(new BorderLayout());
        frame.add(timerLabel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(startBtn);
        panel.add(switchBtn);

        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void startTimer() {
        timer = new Timer(1000, e -> {
            seconds++;
            if (isFocus) focusTime++;
            else breakTime++;
            updateLabel();
        });
        timer.start();
    }

    private void switchMode() {
        isFocus = !isFocus;
        seconds = 0;
    }

    private void updateLabel() {
        int mins = seconds / 60;
        int secs = seconds % 60;
        timerLabel.setText(String.format("%02d:%02d", mins, secs));
    }

    public double calculateProductivity() {
        if (focusTime + breakTime == 0) return 0;
        return (double) focusTime / (focusTime + breakTime);
    }
}