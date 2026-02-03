package org.example.forms;

import org.example.util.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bai4UserForm extends JFrame {
    private JTextField txtUnitId;
    private JTextField txtName;
    private JTextArea txtDescription;

    public Bai4UserForm() {
        setTitle("Add Organization Unit");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        // Unit Id
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Unit Id"), gbc);
        gbc.gridy = 1;
        txtUnitId = new JTextField(30);
        panel.add(txtUnitId, gbc);

        // Name* (Required)
        gbc.gridy = 2;
        panel.add(new JLabel("Name*"), gbc);
        gbc.gridy = 3;
        txtName = new JTextField(30);
        panel.add(txtName, gbc);

        // Description
        gbc.gridy = 4;
        panel.add(new JLabel("Description"), gbc);
        gbc.gridy = 5;
        txtDescription = new JTextArea(6, 30);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JScrollPane scrollPane = new JScrollPane(txtDescription);
        panel.add(scrollPane, gbc);

        // Note text
        gbc.gridy = 6;
        JLabel lblNote = new JLabel("This unit will be added under Organization");
        lblNote.setForeground(Color.GRAY);
        panel.add(lblNote, gbc);

        // Required note
        gbc.gridy = 7;
        JLabel lblRequired = new JLabel("* Required");
        lblRequired.setForeground(Color.GRAY);
        lblRequired.setFont(new Font(lblRequired.getFont().getName(), Font.PLAIN, 11));
        panel.add(lblRequired, gbc);

        // Buttons panel
        gbc.gridy = 8;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setPreferredSize(new Dimension(100, 35));
        btnCancel.setBackground(Color.WHITE);
        btnCancel.addActionListener(e -> clearFields());

        JButton btnSave = new JButton("Save");
        btnSave.setPreferredSize(new Dimension(100, 35));
        btnSave.setBackground(new Color(102, 187, 106));
        btnSave.setForeground(Color.WHITE);
        btnSave.addActionListener(e -> saveData());

        buttonPanel.add(btnCancel);
        buttonPanel.add(btnSave);
        panel.add(buttonPanel, gbc);

        add(panel);
    }

    private void saveData() {
        // Validate Name is required
        String name = txtName.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Name is required!",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        String unitId = txtUnitId.getText().trim();
        String description = txtDescription.getText().trim();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO organization_units (unit_id, name, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, unitId.isEmpty() ? null : unitId);
            stmt.setString(2, name);
            stmt.setString(3, description.isEmpty() ? null : description);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this,
                "Organization unit saved successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
            clearFields();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Database error: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtUnitId.setText("");
        txtName.setText("");
        txtDescription.setText("");
    }
}
