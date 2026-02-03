package org.example;

import org.example.forms.Bai4UserForm;
import org.example.forms.Bai5JobTitleForm;
import org.example.forms.Bai6EmployeeForm;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        setTitle("Lab 6 - Software Testing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnBai4 = new JButton("Bài 4 – Add Organization Unit");
        JButton btnBai5 = new JButton("Bài 5 – Add Job Title Form");
        JButton btnBai6 = new JButton("Bài 6 – User Edition");

        btnBai4.setFont(new Font("Arial", Font.PLAIN, 14));
        btnBai5.setFont(new Font("Arial", Font.PLAIN, 14));
        btnBai6.setFont(new Font("Arial", Font.PLAIN, 14));

        btnBai4.addActionListener(e -> new Bai4UserForm().setVisible(true));
        btnBai5.addActionListener(e -> new Bai5JobTitleForm().setVisible(true));
        btnBai6.addActionListener(e -> new Bai6EmployeeForm().setVisible(true));

        panel.add(btnBai4);
        panel.add(btnBai5);
        panel.add(btnBai6);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
