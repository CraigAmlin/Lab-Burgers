import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spike extends JFrame {
    private JButton button1;
    private JTextField txt;
    private JPanel Main;
    private JLabel pic1;

    public Spike(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(button1, txt.getText() + "Hello");
            }
        });
    }

    public static void main(String[] args) {
        Spike s = new Spike();
        s.setContentPane(s.Main);
        s.setTitle("Test Title");
        s.setSize(500,500);
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        pic1 = new JLabel(new ImageIcon("TestFrog.jpg"));
    }
}
