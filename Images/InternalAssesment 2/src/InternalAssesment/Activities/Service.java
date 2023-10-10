package InternalAssesment.Activities;

import InternalAssesment.StudentOptions;
import InternalAssesment.UserDB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Service extends JFrame implements ActionListener {
    private JFrame frame = new JFrame("Choose user");
    private JLabel lblServiceOptions = new JLabel("Service options:");
    private JLabel plantingTrees = new JLabel("Planting trees");
    private JLabel bulgarianRedCross = new JLabel("Bulgarian Red Cross");
    private JLabel bulgarianPlatformFor = new JLabel("Bulgarian Platform For");
    private JLabel internationalDevelopment = new JLabel("International Development");
    private JButton back = new JButton("Back");
    private String[] userProgress = new String[] {"Done", "Doing", "To do", "Not selected"};
    private JComboBox treesComboBox = new JComboBox(userProgress);
    private JComboBox redCrossComboBox = new JComboBox(userProgress);
    private JComboBox bulgarianPlatformComboBox = new JComboBox(userProgress);

    public Service(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 350, 400,230 );
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);

        lblServiceOptions.setBounds(135, 10, 400, 30);
        frame.add(lblServiceOptions);

        plantingTrees.setBounds(20, 40, 400, 30);
        frame.add(plantingTrees);

        bulgarianRedCross.setBounds(20, 80, 400, 30);
        frame.add(bulgarianRedCross);

        bulgarianPlatformFor.setBounds(20, 120, 400, 30);
        frame.add(bulgarianPlatformFor);

        internationalDevelopment.setBounds(20, 140, 400, 30);
        frame.add(internationalDevelopment);

        back.setBounds(250, 170, 120, 30);
        back.setFocusable(false);
        back.addActionListener(this);
        frame.add(back);

        treesComboBox.setBounds(250, 40, 120, 30);
        treesComboBox.setFocusable(false);
        frame.add(treesComboBox);
        treesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDB.LoggedUser.progress[UserDB.LoggedUser.treesServiceIndex] = String.valueOf(treesComboBox.getSelectedItem());
            }
        });

        redCrossComboBox.setBounds(250, 80, 120, 30);
        redCrossComboBox.setFocusable(false);
        frame.add(redCrossComboBox);
        redCrossComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDB.LoggedUser.progress[UserDB.LoggedUser.redCrossServiceIndex] = String.valueOf(redCrossComboBox.getSelectedItem());
            }
        });

        bulgarianPlatformComboBox.setBounds(250, 120, 120, 30);
        bulgarianPlatformComboBox.setFocusable(false);
        frame.add(bulgarianPlatformComboBox);
        bulgarianPlatformComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDB.LoggedUser.progress[UserDB.LoggedUser.developmentServiceIndex] = String.valueOf(bulgarianPlatformComboBox.getSelectedItem());
            }
        });

        int index = UserDB.indexOf(userProgress, UserDB.LoggedUser.progress[UserDB.LoggedUser.treesServiceIndex]);

        if(index >= 0){
            treesComboBox.setSelectedIndex(index);
        }

        index = UserDB.indexOf(userProgress, UserDB.LoggedUser.progress[UserDB.LoggedUser.redCrossServiceIndex]);

        if(index >= 0){
            redCrossComboBox.setSelectedIndex(index);
        }

        index = UserDB.indexOf(userProgress, UserDB.LoggedUser.progress[UserDB.LoggedUser.developmentServiceIndex]);

        if(index >= 0){
            bulgarianPlatformComboBox.setSelectedIndex(index);
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


