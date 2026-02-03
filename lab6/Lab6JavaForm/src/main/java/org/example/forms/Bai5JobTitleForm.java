package org.example.forms;

import org.example.util.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bai5JobTitleForm extends JFrame {
    private JTextField txtJobTitle;
    private JTextArea txtDescription;
    private JTextField txtJobSpecFile;
    private JTextArea txtNote;

    public Bai5JobTitleForm() {
        setTitle("Bài 5 - Add Job Title Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        // Job Title
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Job Title*:"), gbc);
        gbc.gridy = 1;
        txtJobTitle = new JTextField(30);
        panel.add(txtJobTitle, gbc);

        // Description
        gbc.gridy = 2;
        panel.add(new JLabel("Description:"), gbc);
        gbc.gridy = 3;
        txtDescription = new JTextArea(4, 30);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JScrollPane descScroll = new JScrollPane(txtDescription);
        panel.add(descScroll, gbc);

        // Job Spec File
        gbc.gridy = 4;
        panel.add(new JLabel("Job Spec File:"), gbc);
        gbc.gridy = 5;
        txtJobSpecFile = new JTextField(30);
        panel.add(txtJobSpecFile, gbc);

        // Note
        gbc.gridy = 6;
        panel.add(new JLabel("Note:"), gbc);
        gbc.gridy = 7;
        txtNote = new JTextArea(4, 30);
        txtNote.setLineWrap(true);
        txtNote.setWrapStyleWord(true);
        txtNote.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JScrollPane noteScroll = new JScrollPane(txtNote);
        panel.add(noteScroll, gbc);

        // Buttons
        gbc.gridy = 8;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setPreferredSize(new Dimension(100, 35));
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
        String jobTitle = txtJobTitle.getText().trim();
        String description = txtDescription.getText().trim();
        String jobSpecFile = txtJobSpecFile.getText().trim();
        String note = txtNote.getText().trim();

        // Validate required field
        if (jobTitle.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Job title is required!",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate lengths
        if (jobTitle.length() > 100) {
            JOptionPane.showMessageDialog(this,
                "Job title must not exceed 100 characters!",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (description.length() > 400) {
            JOptionPane.showMessageDialog(this,
                "Description must not exceed 400 characters!",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (note.length() > 400) {
            JOptionPane.showMessageDialog(this,
                "Note must not exceed 400 characters!",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Save to database
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO job_titles (job_title, description, job_spec_file, note) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, jobTitle);
            stmt.setString(2, description.isEmpty() ? null : description);
            stmt.setString(3, jobSpecFile.isEmpty() ? null : jobSpecFile);
            stmt.setString(4, note.isEmpty() ? null : note);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this,
                "Job title saved successfully!",
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
        txtJobTitle.setText("");
        txtDescription.setText("");
        txtJobSpecFile.setText("");
        txtNote.setText("");
    }
}
