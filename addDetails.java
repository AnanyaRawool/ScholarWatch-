package sms;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class addDetails extends JFrame implements ActionListener {

    int x = 80;
    int txtX = 250;
    int txtWidth = 200;
    int txtHeight = 40;

    Font font = new Font("Tahoma", Font.BOLD,20);
    Font fontTxt = new Font("Tahoma", Font.PLAIN,20);

    JRadioButton half,quarter;
    JDateChooser dop ;
    JButton add;
    JComboBox edition;
    JTextField name, address, publication, phoneNo;
    addDetails(){
        setSize(600,700);

        JLabel l1  = new JLabel("Name");
        l1.setBounds(x,70,150,40);
        l1.setFont(font);
        add(l1);

        JLabel l2  = new JLabel("publication");
        l2.setBounds(x,130,150,40);
        l2.setFont(font);
        add(l2);

        JLabel l3  = new JLabel("D.O.p");
        l3.setBounds(x,190,150,40);
        l3.setFont(font);
        add(l3);

        JLabel l4  = new JLabel("prize");
        l4.setBounds(x,250,150,40);
        l4.setFont(font);
        add(l4);

        JLabel l5  = new JLabel("Address");
        l5.setBounds(x,310,150,40);
        l5.setFont(font);
        add(l5);

        JLabel l6  = new JLabel("Phone No");
        l6.setBounds(x,370,150,40);
        l6.setFont(font);
        add(l6);

        JLabel l7  = new JLabel("edition");
        l7.setBounds(x,430,150,40);
        l7.setFont(font);
        add(l7);



        name = new JTextField();
        name.setBounds(txtX, 70,  txtWidth,txtHeight);
        name.setFont(fontTxt);
        add(name);

        publication = new JTextField();
        publication.setBounds(txtX, 130,  txtWidth,txtHeight);
        publication.setFont(fontTxt);
        add(publication);

        address = new JTextField();
        address.setBounds(txtX, 310,  txtWidth,txtHeight);
        address.setFont(fontTxt);
        add(address);

        phoneNo = new JTextField();
        phoneNo.setBounds(txtX, 370,  txtWidth,txtHeight);
        phoneNo.setFont(fontTxt);
        add(phoneNo);

//        dob calender

        dop = new JDateChooser();
        dop.setBounds(txtX, 190, txtWidth, txtHeight);
        dop.setFont(fontTxt);
        add(dop);

        ButtonGroup btn = new ButtonGroup();


        half  = new JRadioButton("half ");
        half .setBounds(txtX, 250, txtWidth/2, txtHeight);
        half .setFont(fontTxt);
        btn.add(half );
        add(half );

        quarter = new JRadioButton("quarter");
        quarter.setBounds(txtX+120, 250, txtWidth/2, txtHeight);
        quarter.setFont(fontTxt);
        btn.add(quarter);
        add(quarter);

        String [] arr = {"1", "2","3","4","5"};
        edition = new JComboBox(arr);
        edition.setBounds(txtX,430, txtWidth,txtHeight );
        edition.setFont(fontTxt);
        add(edition);


        add = new JButton("Add Details");
        add.setBounds(200,580,150,70);
        add.setFont(font);
        add.addActionListener(this);
        add(add);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/bgimg.jpg"));
        Image editedimg1 = i2.getImage().getScaledInstance(600,700,Image.SCALE_DEFAULT);
        i2 = new ImageIcon(editedimg1);
        JLabel lb1 = new JLabel(i2);
        lb1.setBounds(0,0,600,700);
        add(lb1);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==add){
            String name =  this.name.getText();
            String publication = this.publication.getText();
            String phoneNo = this.phoneNo.getText();
            String address = this.address.getText();

            String edition = (String)this.edition.getSelectedItem();

            String prize = null;
            if(half.isSelected()){
                prize = "half";
            }
            else if(quarter.isSelected()){
                prize = "quarter";
            }

            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String dob = df.format(this.dop.getDate());
            System.out.println(dob);

            conn c = new conn();

            String query = "insert into stud_details (name, address, contact, publication, dop, prize, edition) values ('"+name+"','"+address+"','"+phoneNo+"', '"+publication+"','"+dop+"','"+prize+"','"+edition+"');";

            try{
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Added Successfully!");
            }catch (Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Some error occured :(");
            }

        }

    }

    public static void main(String[] args) {
        new addDetails();
    }
}
