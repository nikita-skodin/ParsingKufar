import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    MainWindow(){
        setTitle("Parsing");
        setSize(900,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setResizable(false);
        setLocationRelativeTo(null);
        MyJPanel myJPanel;
        add(myJPanel =  new MyJPanel());
        myJPanel.init();
        setVisible(true);

    }
}
