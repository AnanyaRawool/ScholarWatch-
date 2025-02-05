package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class options extends JFrame implements ActionListener {

    JButton attendance , marks , profile;
    options(){
        setSize(1000,300);

        profile = new JButton("Profile");
        profile.setBounds(180,100,200, 80);
        profile.addActionListener(this);
        add(profile);

        attendance = new JButton("Attendance");
        attendance.setBounds(400,100,200,80);
        attendance.addActionListener(this);
        add(attendance);

        marks = new JButton("Marks");
        marks.setBounds(620,100,200,80);
        marks.addActionListener(this);
        add(marks);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bgimg.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(1000,300,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);
        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0,0,1000,300);
        add(lb1);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==attendance){
            new viewAttendance();
            this.setVisible(false);
        }
        if(ae.getSource()==marks){
            new viewMarks();
            this.setVisible(false);
        }
        if(ae.getSource()==profile){
            new viewDetails();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new options();
    }
}