package InternalAssesment.Activities;

import InternalAssesment.StudentOptions;
import InternalAssesment.UserDB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Activity extends JFrame implements ActionListener {
    private JFrame frame = new JFrame("Choose user");
    private JLabel lblActivityOptions = new JLabel("Activity options:");
    private JLabel gym = new JLabel("Gym");
    private JLabel dancingLessons = new JLabel("Dancing lessons");
    private JLabel martialArtsLessons = new JLabel("Martial arts lessons");
    private JButton back = new JButton("Back");
    private String[] userProgress = new String[] {"Done", "Doing", "To do", "Not selected"};
    private JComboBox gymComboBox = new JComboBox(userProgress);
    private JComboBox dancingComboBox = new JComboBox(userProgress);
    private JComboBox martialArtsComboBox = new JComboBox(userProgress);

    public Activity() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 350, 400,230 );
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);

        lblActivityOptions.setBounds(135, 10, 400, 30);
        frame.add(lblActivityOptions);

        gym.setBounds(20, 40, 400, 30);
        frame.add(gym);

        dancingLessons.setBounds(20, 80, 400, 30);
        frame.add(dancingLessons);

        martialArtsLessons.setBounds(20, 120, 400, 30);
        frame.add(martialArtsLessons);

        back.setBounds(250, 160, 120, 30);
        back.setFocusable(false);
        back.addActionListener(this);
        frame.add(back);

        gymComboBox.setBounds(250, 40, 120, 30);
        gymComboBox.setFocusable(false);
        frame.add(gymComboBox);
        gymComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDB.LoggedUser.progress[UserDB.LoggedUser.gymActivityIndex] = String.valueOf(gymComboBox.getSelectedItem());
            }
        });

        dancingComboBox.setBounds(250, 80, 120, 30);
        dancingComboBox.setFocusable(false);
        frame.add(dancingComboBox);
        dancingComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDB.LoggedUser.progress[UserDB.LoggedUser.danceActivityIndex] = String.valueOf(dancingComboBox.getSelectedItem());
            }
        });

        martialArtsComboBox.setBounds(250, 120, 120, 30);
        martialArtsComboBox.setFocusable(false);
        frame.add(martialArtsComboBox);
        martialArtsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDB.LoggedUser.progress[UserDB.LoggedUser.martialArtsActivityIndex] = String.valueOf(martialArtsComboBox.getSelectedItem());
            }
        });

        int index = UserDB.indexOf(userProgress, UserDB.LoggedUser.progress[UserDB.LoggedUser.gymActivityIndex]);

        if(index >= 0){
            gymComboBox.setSelectedIndex(index);
        }

        index = UserDB.indexOf(userProgress, UserDB.LoggedUser.progress[UserDB.LoggedUser.danceActivityIndex]);

        if(index >= 0){
            dancingComboBox.setSelectedIndex(index);
        }

        index = UserDB.indexOf(userProgress, UserDB.LoggedUser.progress[UserDB.LoggedUser.martialArtsActivityIndex]);

        if(index >= 0){
            martialArtsComboBox.setSelectedIndex(index);
        }

    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            UserDB.Save();
            frame.dispose();
            StudentOptions myWindow = new StudentOptions();
        }
    }
}

