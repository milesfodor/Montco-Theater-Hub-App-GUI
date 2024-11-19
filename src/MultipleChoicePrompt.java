import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MultipleChoicePrompt extends JFrame {
    private JButton selectButton;
    private JPanel MainPanel;
    private JPanel questionPanel;
    private JPanel answerPanel;
    private final ButtonGroup group = new ButtonGroup();
    private int numAnswers;

    public MultipleChoicePrompt(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.startsWith("Question: ")) {
                    JLabel label = new JLabel(line.substring("Question: ".length()));
                    questionPanel.add(label);
                } else if (line.startsWith("Number of answers: ")) {
                    numAnswers = Integer.parseInt(line.substring("Number of answers: ".length()));
                } else if (line.startsWith("Answer")) {
                    answerPanel.setLayout(new GridLayout(numAnswers, 1));
                    for (int i = 0; i < numAnswers; i++) {
                        JRadioButton radioButton = new JRadioButton(line.substring(line.indexOf(":") + 2));
                        group.add(radioButton);
                        answerPanel.add(radioButton);
                        line = reader.readLine();
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        setContentPane(MainPanel);
        setTitle("Multiple Choice Prompt");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(group.getSelection() != null) {
                    JOptionPane.showMessageDialog(MultipleChoicePrompt.this, "Thanks for your selection!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(MultipleChoicePrompt.this, "Please select an option.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new MultipleChoicePrompt("question.txt");
    }
}