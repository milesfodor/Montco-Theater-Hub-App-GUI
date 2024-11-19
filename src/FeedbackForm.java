import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FeedbackForm extends JFrame {
    private JPanel panel1;
    private JTextPane textPane1;
    private JButton submitButton;

    public FeedbackForm() {
        setTitle("Feedback Form");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String feedback = textPane1.getText();
                File file = new File("feedback.txt");
                if (!feedback.isEmpty()) {
                    JOptionPane.showMessageDialog(FeedbackForm.this, "Thanks for your feedback!");
                    try {
                        FileWriter writer = new FileWriter(file);
                        writer.write(feedback);
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(FeedbackForm.this, "Please enter your feedback.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new FeedbackForm();
    }
}
