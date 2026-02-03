package org.example.forms;

import org.example.util.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Bai6EmployeeForm extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JTextField txtFullname;
    private JTextField txtEmail;
    private JTable userTable;
    private DefaultTableModel tableModel;
    private int selectedUserId = -1;

    public Bai6EmployeeForm() {
        setTitle("User Edition");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Tab 1: USER EDITION
        JPanel editionPanel = createEditionPanel();
        tabbedPane.addTab("USER EDITION", editionPanel);

        // Tab 2: USER LIST
        JPanel listPanel = createListPanel();
        tabbedPane.addTab("USER LIST", listPanel);

        add(tabbedPane);
    }

    private JPanel createEditionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(30, 41, 59));

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(30, 41, 59));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setForeground(new Color(148, 163, 184));
        formPanel.add(lblUsername, gbc);

        gbc.gridx = 1;
        txtUsername = new JTextField(15);
        txtUsername.setPreferredSize(new Dimension(200, 35));
        txtUsername.setBackground(new Color(30, 41, 59));
        txtUsername.setForeground(Color.WHITE);
        txtUsername.setCaretColor(Color.WHITE);
        txtUsername.setBorder(BorderFactory.createLineBorder(new Color(71, 85, 105)));
        formPanel.add(txtUsername, gbc);

        // Password
        gbc.gridx = 2;
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(148, 163, 184));
        formPanel.add(lblPassword, gbc);

        gbc.gridx = 3;
        txtPassword = new JPasswordField(15);
        txtPassword.setPreferredSize(new Dimension(200, 35));
        txtPassword.setBackground(new Color(30, 41, 59));
        txtPassword.setForeground(Color.WHITE);
        txtPassword.setCaretColor(Color.WHITE);
        txtPassword.setBorder(BorderFactory.createLineBorder(new Color(71, 85, 105)));
        formPanel.add(txtPassword, gbc);

        // Fullname
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel lblFullname = new JLabel("Fullname");
        lblFullname.setForeground(new Color(148, 163, 184));
        formPanel.add(lblFullname, gbc);

        gbc.gridx = 1;
        txtFullname = new JTextField(15);
        txtFullname.setPreferredSize(new Dimension(200, 35));
        txtFullname.setBackground(new Color(30, 41, 59));
        txtFullname.setForeground(Color.WHITE);
        txtFullname.setCaretColor(Color.WHITE);
        txtFullname.setBorder(BorderFactory.createLineBorder(new Color(71, 85, 105)));
        formPanel.add(txtFullname, gbc);

        // Email
        gbc.gridx = 2;
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(new Color(148, 163, 184));
        formPanel.add(lblEmail, gbc);

        gbc.gridx = 3;
        txtEmail = new JTextField(15);
        txtEmail.setPreferredSize(new Dimension(200, 35));
        txtEmail.setBackground(new Color(30, 41, 59));
        txtEmail.setForeground(Color.WHITE);
        txtEmail.setCaretColor(Color.WHITE);
        txtEmail.setBorder(BorderFactory.createLineBorder(new Color(71, 85, 105)));
        formPanel.add(txtEmail, gbc);

        // Buttons
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 4;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        buttonPanel.setBackground(new Color(30, 41, 59));

        JButton btnCreate = new JButton("Create");
        btnCreate.setPreferredSize(new Dimension(100, 35));
        btnCreate.setBackground(new Color(30, 41, 59));
        btnCreate.setForeground(new Color(59, 130, 246));
        btnCreate.setBorder(BorderFactory.createLineBorder(new Color(59, 130, 246)));
        btnCreate.setFocusPainted(false);
        btnCreate.addActionListener(e -> createUser());

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setPreferredSize(new Dimension(100, 35));
        btnUpdate.setBackground(new Color(30, 41, 59));
        btnUpdate.setForeground(new Color(34, 197, 94));
        btnUpdate.setBorder(BorderFactory.createLineBorder(new Color(34, 197, 94)));
        btnUpdate.setFocusPainted(false);
        btnUpdate.addActionListener(e -> updateUser());

        JButton btnDelete = new JButton("Delete");
        btnDelete.setPreferredSize(new Dimension(100, 35));
        btnDelete.setBackground(new Color(30, 41, 59));
        btnDelete.setForeground(new Color(239, 68, 68));
        btnDelete.setBorder(BorderFactory.createLineBorder(new Color(239, 68, 68)));
        btnDelete.setFocusPainted(false);
        btnDelete.addActionListener(e -> deleteUser());

        JButton btnReset = new JButton("Reset");
        btnReset.setPreferredSize(new Dimension(100, 35));
        btnReset.setBackground(new Color(30, 41, 59));
        btnReset.setForeground(new Color(234, 179, 8));
        btnReset.setBorder(BorderFactory.createLineBorder(new Color(234, 179, 8)));
        btnReset.setFocusPainted(false);
        btnReset.addActionListener(e -> resetFields());

        buttonPanel.add(btnCreate);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnReset);

        formPanel.add(buttonPanel, gbc);

        panel.add(formPanel, BorderLayout.NORTH);
        return panel;
    }

    private JPanel createListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Table
        String[] columns = {"ID", "Username", "Fullname", "Email"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        userTable = new JTable(tableModel);
        userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && userTable.getSelectedRow() != -1) {
                loadSelectedUser();
            }
        });

        JScrollPane scrollPane = new JScrollPane(userTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Refresh button
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(e -> loadUserList());
        panel.add(btnRefresh, BorderLayout.SOUTH);

        // Load initial data
        loadUserList();

        return panel;
    }

    private void createUser() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        String fullname = txtFullname.getText().trim();
        String email = txtEmail.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username and Password are required!");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, fullname.isEmpty() ? null : fullname);
            stmt.setString(4, email.isEmpty() ? null : email);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "User created successfully!");
            resetFields();
            loadUserList();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void updateUser() {
        if (selectedUserId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user from the list first!");
            return;
        }

        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        String fullname = txtFullname.getText().trim();
        String email = txtEmail.getText().trim();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE users SET username=?, password=?, fullname=?, email=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, fullname.isEmpty() ? null : fullname);
            stmt.setString(4, email.isEmpty() ? null : email);
            stmt.setInt(5, selectedUserId);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "User updated successfully!");
            resetFields();
            loadUserList();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void deleteUser() {
        if (selectedUserId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user from the list first!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?");
        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = DBConnection.getConnection()) {
                String sql = "DELETE FROM users WHERE id=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, selectedUserId);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "User deleted successfully!");
                resetFields();
                loadUserList();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    private void resetFields() {
        txtUsername.setText("");
        txtPassword.setText("");
        txtFullname.setText("");
        txtEmail.setText("");
        selectedUserId = -1;
    }

    private void loadUserList() {
        tableModel.setRowCount(0);
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT id, username, fullname, email FROM users ORDER BY id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("fullname"),
                    rs.getString("email")
                };
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading users: " + e.getMessage());
        }
    }

    private void loadSelectedUser() {
        int row = userTable.getSelectedRow();
        if (row != -1) {
            selectedUserId = (int) tableModel.getValueAt(row, 0);
            txtUsername.setText((String) tableModel.getValueAt(row, 1));
            txtFullname.setText((String) tableModel.getValueAt(row, 2));
            txtEmail.setText((String) tableModel.getValueAt(row, 3));
            txtPassword.setText(""); // Don't show password
        }
    }
}
