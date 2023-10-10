package InternalAssesment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpStudent extends JFrame implements ActionListener{
            private JFrame frame = new JFrame("Create a new account");
            private JLabel reg = new JLabel("Register");
            private JLabel email = new JLabel("Email:");
            private JLabel pass = new JLabel("Password:");
            private JLabel confirmPass = new JLabel("Confirm password:");
            private JTextField emailField = new JTextField("");
            private JPasswordField firstPass = new JPasswordField("");
            private JPasswordField secondPass = new JPasswordField("");
            private JButton logIn = new JButton("Log in");
            private JButton cancel = new JButton("Cancel");

            public SignUpStudent(){

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(500, 350, 500,250 );
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setResizable(false);

                reg.setBounds(200, 10, 120, 50);
                frame.add(reg);

                email.setBounds(50, 60, 100, 30);
                frame.add(email);

                emailField.setBounds(250, 60, 200, 30);
                frame.add(emailField);

                pass.setBounds(50,80, 100, 30);
                frame.add(pass);

                firstPass.setBounds(250, 80, 200, 30);
                frame.add(firstPass);

                confirmPass.setBounds(50, 100, 200, 30);
                frame.add(confirmPass);

                secondPass.setBounds(250, 100, 200, 30);
                frame.add(secondPass);

                logIn.setBounds(100, 150, 120, 30 );
                logIn.setFocusable(false);
                logIn.addActionListener(this);
                frame.add(logIn);

                cancel.setBounds(265, 150, 120, 30);
                cancel.setFocusable(false);
                cancel.addActionListener(this);
                frame.add(cancel);
            }

            public void actionPerformed(ActionEvent e){
                if (e.getSource() == logIn){
                    frame.dispose();
                    String name = emailField.getText();
                    String password = new String (firstPass.getPassword());
                    UserDB.addUser(name, password);
                    UserDB.Save();
                    LogInStudent myWindow = new LogInStudent();
                }
                if (e.getSource() == cancel){
                    frame.dispose();
                    Student myWindow = new Student();
                }
            }

        }