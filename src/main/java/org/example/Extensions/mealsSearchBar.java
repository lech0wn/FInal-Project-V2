package org.example.Extensions;

import org.example.Databases.mealsDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mealsSearchBar {

    JLabel errorLabel = new JLabel("Meal not found");

    public mealsSearchBar(JFrame frame, JPanel mealPanelContainer) {
        RoundedTextfield searchbar = new RoundedTextfield();

        searchbar.setBounds(370, 20, 550, 45);
        searchbar.setBackground(Color.decode("#FACD97"));
        searchbar.setForeground(Color.black);
        searchbar.setFont(new Font("Arial", Font.PLAIN, 14));
        //searchbar.setText("            ");
        frame.add(searchbar);

        ImageIcon img = new ImageIcon("src/main/java/org/example/img/Search.png");
        JButton search = new JButton(img);
        search.setBorder(BorderFactory.createEmptyBorder());
        search.setFocusable(false);
        search.setBackground(Color.decode("#FACD97"));
        search.setBounds(9, 2, 30, 40);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchName = searchbar.getText().trim();
                if(mealsDatabase.authenticateMealName(searchName)){
                    mealPanelContainer.removeAll();
                    System.out.println("success");
                    searchbar.setText("");
                    mealPanelContainer.revalidate();
                    mealPanelContainer.repaint();
                } else {
                    errorLabel.setBounds(370, 65, 500, 20);
                    errorLabel.setForeground(Color.red);
                    errorLabel.setFont(new Font("Bitstream Vera Sans Mono", Font.BOLD, 14));
                }
            }
        });

        frame.add(errorLabel);
        searchbar.add(search);
    }
}

