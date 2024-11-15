package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Dialog extends JDialog {

    Dialog(String [] meal, JPanel panel) {
        JDialog dialog = new JDialog();

        dialog.setSize(300,370);
        dialog.getContentPane().setBackground(Color.decode("#DA7227"));
        dialog.setLocationRelativeTo(panel);
        dialog.setLayout(null);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            JLabel nameLabel = new JLabel(meal[0]);
            nameLabel.setBounds(20, 120, 300, 50);
            nameLabel.setForeground(Color.white);
            nameLabel.setFont(new Font("Arial", 1, 32));
            dialog.add(nameLabel);

//            JLabel id = new JLabel("Meal ID: " + meal[1]);
//            id.setBounds(150, 40, 300, 50);
//            id.setForeground(Color.white);
//            id.setFont(new Font("Arial", 1, 21));
//            dialog.add(id);
//
            JLabel descriptionLabel = new JLabel(meal[2]);
            descriptionLabel.setBounds(20, 175, 300, 50);
            descriptionLabel.setForeground(Color.white);
            descriptionLabel.setFont(new Font("Arial", 1, 20));
            dialog.add(descriptionLabel);

            JLabel nutValue = new JLabel(meal[3] + " calories");
            nutValue.setBounds(20, 200, 300, 50);
            nutValue.setForeground(Color.white);
            nutValue.setFont(new Font("Arial", 1, 20));
            dialog.add(nutValue);

            JLabel spiceLabel = new JLabel(meal[4]);
            spiceLabel.setBounds(20, 260, 300, 50);
            spiceLabel.setForeground(Color.white);
            spiceLabel.setFont(new Font("Arial", 1, 21));
            dialog.add(spiceLabel);

            JLabel servSize = new JLabel(meal[5]);
            servSize.setBounds(20, 220, 300, 50);
            servSize.setForeground(Color.white);
            servSize.setFont(new Font("Arial", 1, 21));
            dialog.add(servSize);

            JLabel dietLabel = new JLabel(meal[6]);
            dietLabel.setBounds(20, 240, 300, 50);
            dietLabel.setForeground(Color.white);
            dietLabel.setFont(new Font("Arial", 1, 21));
            dialog.add(dietLabel);

            JLabel ingredientsLabel = new JLabel(meal[7]);
            ingredientsLabel.setBounds(20, 150, 300, 50);
            ingredientsLabel.setForeground(Color.white);
            ingredientsLabel.setFont(new Font("Arial", 1, 16));
            dialog.add(ingredientsLabel);

        dialog.setVisible(true);
    }
}
