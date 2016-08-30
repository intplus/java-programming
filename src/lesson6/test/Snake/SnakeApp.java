package lesson6.test.Snake;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Main class.
 * The game window. The window contains the gameplay window, highscores window, listening  the keyboard and sends commands
 * @author Vlad
 */
public class SnakeApp {

    public static void main(String[] args) {
        new SnakeApp().startGraphicInterface();
    }

    /**
     * Open the main menu
     *  @link SnakeApp#startGame()
     * @see SnakeApp#startGame
     */
    public void startGraphicInterface() {
        JFrame myWindow = new JFrame("Snake menu");
        myWindow.setLayout(null);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setSize(270, 240);
        myWindow.setVisible(true);

        final JButton GO = new JButton("Start game");
        GO.setLocation(30, 30);
        GO.setSize(200, 40);
        myWindow.add(GO);

        GO.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {//Start the game
                startGame();//Zavolame SnakeDialog - START GAME!
            }
        });

        final JButton highscore = new JButton("Highscore");
        highscore.setLocation(30, 80);
        highscore.setSize(200, 40);
        myWindow.add(highscore);
        myWindow.setResizable(false);

        highscore.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                HighscoreManager hm = new HighscoreManager();
                JOptionPane.showMessageDialog(highscore, hm.getHighscoreString(), "Highscores", JOptionPane.WARNING_MESSAGE);//Show highscores from HighscoreManager as Warning Message
            }
        });

        final JButton exit = new JButton("Exit");
        exit.setLocation(30, 130);
        exit.setSize(200, 40);
        myWindow.add(exit);

        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(exit, "Goodbye!", "OK", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        });
    }

    /**
     * Opening of the game window. Saving score(if user want).
     * @link SnakeGame()
     * @see SnakeGame
     */
    public void startGame() {
        JDialog dlg = new JDialog((JFrame) null, "Snake v.over9000");//Game as Dialog
        dlg.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        final SnakeGame sn = new SnakeGame();//If you start the game,
        dlg.getContentPane().add(sn);
        sn.newGame();
        dlg.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent ev) {
                sn.processKey(ev);
            }
        });
        dlg.setVisible(true);
        dlg.pack();
        dlg.setResizable(true);
        dlg.setLocation(300, 200);
        dlg.addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {
            }

            public void windowClosed(WindowEvent event) {
            }

            public void windowClosing(WindowEvent event) {
                Object[] options = {"Yes", "No!"};
                int n = JOptionPane.showOptionDialog(event.getWindow(), "Save score?",//You can save the score
                        "Snake", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                if (n == 0) {
                    Object[] options1 = {"Yes", "No!"};
                    String name = "Anonymouse";
                    JOptionPane k = new JOptionPane();
                    JDialog dialog = k.createDialog(null, "Score");

                    name = k.showInputDialog(null, "Your name", "Score", 1);
                    HighscoreManager hm = new HighscoreManager();
                    if (name != null) {
                        name = name + " ";
                        hm.addScore(name, sn.getPoints()); //Set score for Highscore-table
                    }
                    event.getWindow().dispose();//Close the snake-game window

                } else {
                    event.getWindow().dispose();//Close the snake-game window
                }
            }

            public void windowDeactivated(WindowEvent event) {
            }

            public void windowDeiconified(WindowEvent event) {
            }

            public void windowIconified(WindowEvent event) {
            }

            public void windowOpened(WindowEvent event) {
            }
        });
    }
}