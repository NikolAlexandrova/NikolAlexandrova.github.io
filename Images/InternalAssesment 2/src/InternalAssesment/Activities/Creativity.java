package InternalAssesment.Activities;

import InternalAssesment.StudentOptions;
import InternalAssesment.UserDB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Creativity extends JFrame implements ActionListener{
    private JFrame frame = new JFrame("Choose user");
    private JLabel lblCreativityOptions = new JLabel("Creativity options:");
    private JLabel schoolNewspaper = new JLabel("School newspaper");
    private JLabel howToDebateBrochure = new JLabel("How to debate brochure");
    private JLabel organizeATrip = new JLabel("Organize a trip");
    private JButton back = new JButton("Back");
    private String[] userProgress = new String[] {"Done", "Doing", "To do", "Not selected"};
    private JComboBox newspaperComboBox = new JComboBox(userProgress);
    private JComboBox debateComboBox = new JComboBox(userProgress);
    private JComboBox tripComboBox = new JComboBox(userProgress);

public Creativity(){

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(500, 350, 400,230 );
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.getContentPane().setBackground(Color.WHITE);

    lblCreativityOptions.setBounds(135, 10, 400, 30);
    frame.add(lblCreativityOptions);

    schoolNewspaper.setBounds(20, 40, 400, 30);
    frame.add(schoolNewspaper);

    howToDebateBrochure.setBounds(20, 80, 400, 30);
    frame.add(howToDebateBrochure);

    organizeATrip.setBounds(20, 120, 400, 30);
    frame.add(organizeATrip);

    back.setBounds(250, 160, 120, 30);
    back.setFocusable(false);
    back.addActionListener(this);
    frame.add(back);

    newspaperComboBox.setBounds(250, 40, 120, 30);
    newspaperComboBox.setFocusable(false);
    frame.add(newspaperComboBox);
    newspaperComboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserDB.LoggedUser.progress[UserDB.LoggedUser.newspaperCreativityIndex] = String.valueOf(newspaperComboBox.getSelectedItem());
        }
    });

    debateComboBox.setBounds(250, 80, 120, 30);
    debateComboBox.setFocusable(false);
    frame.add(debateComboBox);
    debateComboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserDB.LoggedUser.progress[UserDB.LoggedUser.debateCreativityIndex] = String.valueOf(debateComboBox.getSelectedItem());
        }
    });

    tripComboBox.setBounds(250, 120, 120, 30);
    tripComboBox.setFocusable(false);
    frame.add(tripComboBox);
    tripComboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserDB.getLoggedUser().progress[UserDB.getLoggedUser().tripCreativityIndex] = String.valueOf(tripComboBox.getSelectedItem());
        }
    });

    int index = UserDB.indexOf(userProgress, UserDB.getLoggedUser().progress[UserDB.getLoggedUser().newspaperCreativityIndex]);

    if(index >= 0){
        newspaperComboBox.setSelectedIndex(index);
    }

    index = UserDB.indexOf(userProgress, UserDB.getLoggedUser().progress[UserDB.getLoggedUser().debateCreativityIndex]);

    if(index >= 0){
        debateComboBox.setSelectedIndex(index);
    }

    index = UserDB.indexOf(userProgress, UserDB.getLoggedUser().progress[UserDB.getLoggedUser().tripCreativityIndex]);

    if(index >= 0){
        tripComboBox.setSelectedIndex(index);
    }


}
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == back){
            UserDB.Save();
            frame.dispose();
            StudentOptions myWindow = new StudentOptions();
        }
    }
}
