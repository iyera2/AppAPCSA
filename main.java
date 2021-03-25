import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.util.Scanner;


public class main extends JFrame {

    public main() {

        UI();
    }

    private void UI(){
        createLayout();
        setTitle("Welcome to Password Storer");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void createLayout(){
        var menuBar = new JMenuBar();
        var iconNewPassword = new ImageIcon("src/resources/newPassword.png");
        var exitIcon = new ImageIcon("src/resources/exit.png");

        var fileMenu = new JMenu("File");

        var newMenuItem = new JMenuItem("New Password", iconNewPassword);
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
    // public class Login
    // {
    //     String username, password;
    //     Scanner s = new Scanner(System.in);
    //     System.out.print("Enter username:");
    //     username = s.nextLine();
    //     System.out.print("Enter password:");
    //     password = s.nextLine();
    //     if(username.equals(usernamex) && password.equals(passwordx))
    //     {
    //         System.out.println("Welcome");
    //     }
    //     else
    //     {
    //         System.out.println("Incorrect username/password");
    //     }
    // }
}
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            var ex = new main();
            ex.setVisible(true);
        });
    }
}   