//package SimpleClock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class SimpleClock extends JFrame implements Runnable {
        private SimpleDateFormat timeFormat12;
        private SimpleDateFormat timeFormat24;
        private  SimpleDateFormat dayFormat;
        private SimpleDateFormat dateFormat;

    
        Calendar calendar;
        SimpleDateFormat timeFormat;
//        SimpleDateFormat dayFormat;
//        SimpleDateFormat dateFormat;
    
        JLabel timeLabel;
        JLabel dayLabel;
        JLabel dateLabel;
        String time;
        String day;
        String date;

        private JButton formatButton;
        private JButton timezoneButton;

        private boolean is24HourFormat;
        private boolean isLocalTime;

        //TimeFormats
//        timeFormat12 = new SimpleDateFormat(""hh:mm:ss a");
//        timeFormat24 = new SimpleDateFormat("HH:mm:ss");


        SimpleClock() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Digital Clock");
            this.setLayout(new FlowLayout());
            this.setSize(350, 220);
            this.setResizable(false);
    
            timeFormat = new SimpleDateFormat("hh:mm:ss a");
            dayFormat=new SimpleDateFormat("EEEE");
            dateFormat=new SimpleDateFormat("dd MMMMM, yyyy");
            timeLabel = new JLabel();
            timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
            timeLabel.setBackground(Color.BLACK);
            timeLabel.setForeground(Color.WHITE);
            timeLabel.setOpaque(true);
            dayLabel=new JLabel();
            dayLabel.setFont(new Font("Ink Free",Font.BOLD,34));
    
            dateLabel=new JLabel();
            dateLabel.setFont(new Font("Ink Free",Font.BOLD,30));
    
    
            this.add(timeLabel);
            this.add(dayLabel);
            this.add(dateLabel);
            this.setVisible(true);


            Thread clockThread = new Thread(this);
            clockThread.start();
//            setTimer();
        }


    @Override
    public void run() {
        while (true) {
            String time = timeFormat.format(Calendar.getInstance().getTime());
            String day = dayFormat.format(Calendar.getInstance().getTime());
            String date = dateFormat.format(Calendar.getInstance().getTime());

            //Update UI

            SwingUtilities.invokeLater(() -> {
                timeLabel.setText(time);
                dayLabel.setText(day);
                dateLabel.setText(date);
            });
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
//        public void setTimer() {
//
//
//            while (true) {
//                time = timeFormat.format(Calendar.getInstance().getTime());
//                timeLabel.setText(time);
//
//                day = dayFormat.format(Calendar.getInstance().getTime());
//                dayLabel.setText(day);
//
//                date = dateFormat.format(Calendar.getInstance().getTime());
//                dateLabel.setText(date);
//
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                    e.getStackTrace();
//                }
//            }
//        }
        public static void main(String[] args) {

            SwingUtilities.invokeLater(()-> new SimpleClock());
        }



        }