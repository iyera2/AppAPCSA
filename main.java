import javax.swing.*;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;


public class main extends JFrame {

    public main() {

        UI();
    }

    private void UI(){

        SubmitAction act = new SubmitAction();
        createLayout();
        setTitle("Welcome to Password Storer");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class SubmitAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

            doSubmitAction();
        }

        private void doSubmitAction() {
            System.out.println("Hello");
        }
    }

    public void createLayout(){
        var menuBar = new JMenuBar();
        var iconNewPassword = new ImageIcon("src/resources/newPassword.png");
        var exitIcon = new ImageIcon("src/resources/exit.png");

        var fileMenu = new JMenu("File");

        var newMenuItem = new JMenuItem("New Password", iconNewPassword);
        newMenuItem.addActionListener(new SubmitAction());
        var exitMenuItem = new JMenuItem("Exit", exitIcon);
        var helpMenuItem = new JMenuItem("Help");

        exitMenuItem.setToolTipText("Exit application");
        exitMenuItem.addActionListener((event) -> System.exit(0));

        fileMenu.add(newMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenuItem);

        setJMenuBar(menuBar);
    }

    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            var ex = new main();
            ex.setVisible(true);
        });
    }
}   