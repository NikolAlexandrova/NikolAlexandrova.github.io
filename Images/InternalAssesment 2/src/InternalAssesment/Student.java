package InternalAssesment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student extends JFrame implements ActionListener {

    private JFrame frame = new JFrame("Student");
    private JButton btnSignUp = new JButton("Sign up");
    private JButton btnLogIn = new JButton("Log in");
    private JLabel lblQuestion = new JLabel("Please choose between the following: ");

    Student(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 350, 400, 200);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);

        lblQuestion.setBounds(80, 20, 350, 50);
        lblQuestion.setFocusable(false);
        lblQuestion.setVisible(true);
        frame.add(lblQuestion);

        btnSignUp.setBounds(80, 120, 120, 30);
        btnSignUp.setFocusable(false);
        btnSignUp.addActionListener(this);
        btnSignUp.setVisible(true);
        frame.add(btnSignUp);

        btnLogIn.setBounds(200, 120, 120, 30);
        btnLogIn.setFocusable(false);
        btnLogIn.addActionListener(this);
        btnLogIn.setVisible(true);
        frame.add(btnLogIn);

        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnSignUp){
            frame.dispose();
            SignUpStudent myWindow = new SignUpStudent();
        }
        if (e.getSource() == btnLogIn){
            frame.dispose();
            LogInStudent myWindow = new LogInStudent();
        }
    }

}
