package ui;

import dao.OrganizationDAO;
import model.Organization;
import validator.OrganizationValidator;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class OrganizationForm extends JFrame {
    private JTextField txtOrgName;
    private JTextField txtAddress;
    private JTextField txtPhone;
    private JTextField txtEmail;

    private JButton btnSave;
    private JButton btnBack;
    private JButton btnDirector;

    private OrganizationDAO orgDAO;
    private Organization savedOrganization;

    public OrganizationForm() {
        orgDAO = new OrganizationDAO();
        initComponents();
        setTitle("Organization Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Organization Name (Required)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        JLabel lblOrgName = new JLabel("Organization Name *:");
        formPanel.add(lblOrgName, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtOrgName = new JTextField(30);
        formPanel.add(txtOrgName, gbc);

        // Address
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        formPanel.add(new JLabel("Address:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtAddress = new JTextField(30);
        formPanel.add(txtAddress, gbc);

        // Phone
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        formPanel.add(new JLabel("Phone:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtPhone = new JTextField(30);
        formPanel.add(txtPhone, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.3;
        formPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtEmail = new JTextField(30);
        formPanel.add(txtEmail, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnSave = new JButton("Save");
        btnBack = new JButton("Back");
        btnDirector = new JButton("Director");
        btnDirector.setEnabled(false);

        btnSave.addActionListener(e -> handleSave());
        btnBack.addActionListener(e -> handleBack());
        btnDirector.addActionListener(e -> handleDirector());

        buttonPanel.add(btnSave);
        buttonPanel.add(btnBack);
        buttonPanel.add(btnDirector);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void handleSave() {
        String orgName = txtOrgName.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();

        // Validate input
        OrganizationValidator.ValidationResult validationResult =
                OrganizationValidator.validate(orgName, address, phone, email);

        if (!validationResult.isValid()) {
            JOptionPane.showMessageDialog(this,
                    validationResult.getErrorMessage(),
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if organization name already exists
        if (orgDAO.isOrgNameExists(orgName)) {
            JOptionPane.showMessageDialog(this,
                    "Organization Name already exists",
                    "Duplicate Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Save to database
        try {
            Organization org = new Organization(
                    orgName.trim(),
                    address.trim().isEmpty() ? null : address.trim(),
                    phone.trim().isEmpty() ? null : phone.trim(),
                    email.trim().isEmpty() ? null : email.trim()
            );

            savedOrganization = orgDAO.save(org);

            JOptionPane.showMessageDialog(this,
                    "Save successfully",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            // Enable Director button
            btnDirector.setEnabled(true);

            // Disable Save button to prevent duplicate save
            btnSave.setEnabled(false);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error saving organization: " + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void handleBack() {
        int choice = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to go back?\nUnsaved changes will be lost.",
                "Confirm",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    private void handleDirector() {
        if (savedOrganization != null) {
            DirectorForm directorForm = new DirectorForm(savedOrganization);
            directorForm.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OrganizationForm form = new OrganizationForm();
            form.setVisible(true);
        });
    }
}