import ui.MainUI;

import javax.swing.*;
/**
 * @author Catherine Giovetti
 * @version 2021.11.21
 */
public class Main {

    public static void main(String[] args) {
        //using Swing to create the GUI
        SwingUtilities.invokeLater(new Runnable() {
            //run the method that creates the GUI
            @Override
            public void run() {
                createGui();
            }
        });
    }
    private static void createGui() {
        MainUI ui = new MainUI();
        //method to get root panel
        JPanel root = ui.getRootPanel();
        //frame to hold the panel
        JFrame frame = new JFrame();
        //closes the program when you click the X
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the pane to the new JPanel named root
        frame.setContentPane(root);
        //packs the
        frame.pack();
        //centers the ui
        frame.setLocationRelativeTo(null);
        //displays the ui as visible
        frame.setVisible(true);
    }
}
