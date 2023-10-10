package InternalAssesment;

import InternalAssesment.Activities.Activity;
import InternalAssesment.Activities.Creativity;
import InternalAssesment.Activities.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentOptions extends JFrame implements ActionListener{
    private JFrame frame = new JFrame("Choose an option");
    private JButton creativity = new JButton("Creativity");
    private JButton activity = new JButton("Activity");
    private JButton service = new JButton("Service");
    private String creativityPath = "/Users/n1kol1vay/Downloads/rsz_1creativity.png";
    private ImageIcon creativityImgIcon = new ImageIcon(creativityPath);
    private JLabel creativityImgLbl = new JLabel(creativityImgIcon);
    private String activityPath = "/Users/n1kol1vay/Downloads/rsz_acrivity.png";
    private ImageIcon activityImgIcon = new ImageIcon(activityPath);
    private JLabel activityImgLbl = new JLabel(activityImgIcon);
    private String servicePath = "/Users/n1kol1vay/Downloads/rsz_service.jpg";
    private ImageIcon serviceImgIcon = new ImageIcon(servicePath);
    private JLabel serviceImgLbl = new JLabel(serviceImgIcon);

    public StudentOptions(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 350, 500,250 );
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);

        creativityImgLbl.setBounds(80, 20, 100, 85);
        frame.add(creativityImgLbl);

        activityImgLbl.setBounds(190, 20, 112, 112);
        frame.add(activityImgLbl);

        serviceImgLbl.setBounds(310, 40, 120, 57);
        frame.add(serviceImgLbl);

        creativity.setBounds(60, 150, 120, 30 );
        creativity.setFocusable(false);
        creativity.addActionListener(this);
        frame.add(creativity);

        activity.setBounds(180, 150, 120, 30 );
        activity.setFocusable(false);
        activity.addActionListener(this);
        frame.add(activity);

        service.setBounds(310, 150, 120, 30 );
        service.setFocusable(false);
        service.addActionListener(this);
        frame.add(service);

        }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == creativity){
            frame.dispose();
            Creativity myWindow = new Creativity();
        }
        if (e.getSource() == activity){
            frame.dispose();
            Activity myWindow = new Activity();
        }
        if (e.getSource() == service){
            frame.dispose();
            Service myWindow = new Service();
        }
    }
}
