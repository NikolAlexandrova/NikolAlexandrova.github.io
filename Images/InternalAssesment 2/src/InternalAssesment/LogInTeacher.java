package InternalAssesment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInTeacher extends JFrame implements ActionListener {
    private JFrame frame = new JFrame("Log in to your account");
    private JLabel Email = new JLabel("Email: ");
    private JLabel Pass = new JLabel("Password:");
    private JLabel tryAgain = new JLabel("Try again ");
    private JButton Continue = new JButton("Continue");
    private JTextField emailField = new JTextField("");
    private JPasswordField jPasswordField = new JPasswordField(6);

    boolean checkUser(String name, String password){
        if(UserDB.TeacherName.compareTo(name)==0){
            if(UserDB.TeacherPassword.compareTo(password)==0){
                System.out.println("OK!");
                return true;
            }
            else{
                System.out.println("Wrong password");
                return false;
            }
        }else{
            System.out.println("Wrong email");
            return false;
        }

    }

    public LogInTeacher() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 350, 400,200 );
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        Email.setBounds(60, 30, 120, 50);
        frame.add(Email);

        tryAgain.setBounds(60, 110, 120, 50);
        tryAgain.setVisible(false);
        frame.add(tryAgain);

        Continue.setBounds(250, 120, 120, 30 );
        Continue.setFocusable(false);
        Continue.addActionListener(this);
        frame.add(Continue);

        emailField.setBounds(155, 40, 200, 30);
        frame.add(emailField);

        jPasswordField.setBounds(155, 80, 200, 30);
        frame.add(jPasswordField);

        Pass.setBounds(50,80, 100, 30);
        frame.add(Pass);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Continue) {
            String password = new String(jPasswordField.getPassword());
            if(checkUser(emailField.getText().toString(), password)) {
                frame.dispose();
                TeacherOptions myWindow = new TeacherOptions();
            }else{
                tryAgain.setVisible(true);
            }
        }
    }
}



