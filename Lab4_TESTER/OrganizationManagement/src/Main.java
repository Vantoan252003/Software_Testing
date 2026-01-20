import ui.OrganizationForm;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Set look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Run application
        SwingUtilities.invokeLater(() -> {
            OrganizationForm form = new OrganizationForm();
            form.setVisible(true);
        });
    }
}