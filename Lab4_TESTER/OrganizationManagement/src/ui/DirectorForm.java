package ui;

import model.Organization;
import javax.swing.*;
import java.awt.*;

public class DirectorForm extends JFrame {
    private Organization organization;

    public DirectorForm(Organization organization) {
        this.organization = organization;
        initComponents();
        setTitle("Director Management - " + organization.getOrgName());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitle = new JLabel("Director Management for: " + organization.getOrgName());
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblInfo = new JLabel("<html><center>Organization ID: " + organization.getOrgID() +
                "<br>This form will manage directors for this organization</center></html>");
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);

        mainPanel.add(lblTitle, BorderLayout.NORTH);
        mainPanel.add(lblInfo, BorderLayout.CENTER);

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnClose);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}