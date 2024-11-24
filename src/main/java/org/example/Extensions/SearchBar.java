package org.example.Extensions;

import org.example.Databases.mealsDatabase;
import org.example.SidePanels.MealSidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBar {

    public SearchBar(JFrame frame) {
        RoundedTextfield searchbar = new RoundedTextfield();

        searchbar.setBounds(370, 20, 550, 45);
        searchbar.setBackground(Color.decode("#FACD97"));
        searchbar.setForeground(Color.black);
        searchbar.setFont(new Font("Arial", Font.PLAIN, 14));
        searchbar.setText("            ");
        frame.add(searchbar);

        ImageIcon img = new ImageIcon("src/main/java/org/example/img/Search.png");
        JButton search = new JButton(img);
        search.setBorder(BorderFactory.createEmptyBorder());
        search.setFocusable(false);
        search.setBackground(Color.decode("#FACD97"));
        search.setBounds(9, 2, 30, 40);

        searchbar.add(search);
    }
}
