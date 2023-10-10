package InternalAssesment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LogInStudent extends JFrame implements ActionListener{
    private JFrame frame = new JFrame("Log in to your account");
    private JLabel email = new JLabel("Email: ");
    private JLabel pass = new JLabel("Password:");
    private JLabel lblTryAgain = new JLabel("Please try again ");
    private JButton Continue = new JButton("Continue");
    private JButton Back = new JButton("Back");
    private JTextField emailField = new JTextField("");
    private JPasswordField jPasswordField = new JPasswordField(6);

    public LogInStudent() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 350, 400,200 );
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        email.setBounds(60, 30, 120, 50);
        frame.add(email);

        lblTryAgain.setBounds(60, 110, 120, 50);
        lblTryAgain.setVisible(false);
        frame.add(lblTryAgain);

        Continue.setBounds(250, 120, 120, 30 );
        Continue.setFocusable(false);
        Continue.addActionListener(this);
        frame.add(Continue);

        Back.setBounds(100, 120, 120, 30 );
        Back.setFocusable(false);
        Back.addActionListener(this);
        frame.add(Back);

        emailField.setBounds(155, 40, 200, 30);
        frame.add(emailField);

        jPasswordField.setBounds(155, 80, 200, 30);
        frame.add(jPasswordField);

        pass.setBounds(50,80, 100, 30);
        frame.add(pass);

        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                UserDB.Save();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Continue) {
            String username = emailField.getText().toString();
            String password = new String (jPasswordField.getPassword());
            System.out.println(username + password);


            int UserID = UserDB.checkUser(username, password);
            if(UserID != -1){
                User currentUser = null;
                for(User user: UserDB.allUsers){
                    if(!user.username.equals(username)){
                        continue;
                    }
                    currentUser = user;
                }
                UserDB.LoggedUser = currentUser;
                frame.dispose();
                StudentOptions myWindow = new StudentOptions();
            } else{
                JOptionPane.showMessageDialog(this, "Wrong password or email");
            }
        }
        if (e.getSource()== Back){
            frame.dispose();
            Student myWindow = new Student();
        }
    }
}
