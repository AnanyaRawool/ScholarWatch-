package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewAttendance extends JFrame implements ActionListener {

    JScrollPane sp1 ;
    JTable attendanceDetails ;
    JLabel l1 , abc;
    JButton addUpdate , defaulters , refresh;

    Font font = new Font("Tahoma", Font.PLAIN, 20);
    viewAttendance(){
        setSize(1000,700);

        l1  = new JLabel("Attendance Section");
        l1.setBounds(280,50,400,100);
        l1.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 38));
        add(l1);

        abc = new JLabel("Defaulter List");
        abc.setBounds(400,150,150,50);
        abc.setFont(new Font("Tahoma", Font.ITALIC, 24));
        add(abc);
        abc.setVisible(false);

        sp1 = new JScrollPane();
        sp1.setBounds(400, 200,500,400);
        add(sp1);

        attendanceDetails = new JTable();
        sp1.setViewportView(attendanceDetails);
        attendanceDetails.setFont(font);
        attendanceDetails.setRowHeight(40);

        JTableHeader th1 = attendanceDetails.getTableHeader();
        th1.setFont(font);
        th1.setBackground(Color.decode("#96e37b"));

        getDetails();

        addUpdate = new JButton("Add / Update");
        addUpdate.setBounds(60,200, 200,50);
        addUpdate.setFont(font);
        addUpdate.addActionListener(this);
        add(addUpdate);

        defaulters = new JButton("Defaulters");
        defaulters.setBounds(60,350,200,50);
        defaulters.setFont(font);
        defaulters.addActionListener(this);
        add(defaulters);

        refresh = new JButton("Refresh");
        refresh.setBounds(60,500,200,50);
        refresh.setFont(font);
        refresh.addActionListener(this);
        add(refresh);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bgimg.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);
        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0,0,1000,700);
        add(lb1);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==defaulters){
            String cutoff =  JOptionPane.showInputDialog("Enter Defaulter CutOff");
            conn c = new conn();
            String query2 = "select gr, name , attendance from stud_details where attendance < '"+cutoff+"';";
            try {
                ResultSet defaultersRs = c.s.executeQuery(query2);
                attendanceDetails.setModel(DbUtils.resultSetToTableModel(defaultersRs));
                abc.setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }

        }

        if(ae.getSource()==refresh){
            getDetails();
            abc.setVisible(false);
        }

        if(ae.getSource()==addUpdate){
            new addAttendance();
            this.setVisible(false);
        }
    }

    void getDetails(){
        conn c = new conn();
        String query = "select gr , name , attendance from stud_details;";
        try{
            ResultSet rs = c.s.executeQuery(query) ;
            attendanceDetails.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new viewAttendance();
    }
}
