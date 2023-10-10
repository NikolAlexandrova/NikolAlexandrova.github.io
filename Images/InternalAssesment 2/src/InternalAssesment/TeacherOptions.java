package InternalAssesment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherOptions {
    private JFrame frame = new JFrame("Choose a student");
    private JLabel progress = new JLabel();
    private JTable table;
    private Object[] columns = {"Creativity", "Activity", "Services"};
    private JPanel topPanel = new JPanel();

    public TeacherOptions(){
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 350, 500,250 );
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBackground(Color.WHITE);

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
        topPanel.setVisible(true);

        progress.setBounds(200, 20, 350, 230);
        progress.setFocusable(false);

        System.out.println(UserDB.allUsers.size());
        String[] array = new String[UserDB.allUsers.size()];
        for(int i = 0; i < array.length; i++) {
            System.out.println(UserDB.allUsers.get(i).username);
            array[i] = UserDB.allUsers.get(i).username;
        }

        JComboBox comboBox = new JComboBox(array);
        comboBox.setBounds(30, 20, 100, 60);
        comboBox.setFocusable(false);
        Object[][] data = userOutput(0);

        table = new JTable(data, columns);
        table.setEnabled(false);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = comboBox.getSelectedIndex();
                Object[][] output = userOutput(index);

                for (int i = 0; i < output.length; i++){
                    for (int j = 0; j< output[i].length; j++){
                        table.setValueAt(output[i][j], i,j);
                    }
                }
            }
        });

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());

        tablePanel.add(table.getTableHeader(), BorderLayout.PAGE_START);
        tablePanel.add(table, BorderLayout.CENTER);
        frame.add(tablePanel, BorderLayout.CENTER);
        tablePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        topPanel.add(comboBox);
        frame.add(topPanel, BorderLayout.PAGE_START);
    }

    private Object[][] userOutput(int index){
        User user = UserDB.allUsers.get(index);

        Object[][] result = {{"Newspaper: " + user.progress[user.newspaperCreativityIndex], "Gym: " + user.progress[user.gymActivityIndex], "Tree service: " + user.progress[user.treesServiceIndex]},
                {"Debate: " + user.progress[user.debateCreativityIndex], "Dance: " + user.progress[user.danceActivityIndex], "Red cross: " + user.progress[user.redCrossServiceIndex]},
                {"Trip: " + user.progress[user.tripCreativityIndex], "Martial arts: " + user.progress[user.martialArtsActivityIndex], "Development: " + user.progress[user.developmentServiceIndex]}};

        return result;
    }
}