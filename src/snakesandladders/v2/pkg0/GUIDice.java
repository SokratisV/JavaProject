/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders.v2.pkg0;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Zac
 */
public class GUIDice extends JPanel {

    //Variables
    public JLabel die;
    private ImageIcon[] dieImg;
    private Random random;
    private GridBagConstraints gbc;
    private Border border;
    private Timer timer;
    
    private Assets assets = new Assets();

    //Constructors
    public GUIDice() {
        
        //Init
        border = BorderFactory.createLineBorder(Color.BLACK);
        die = new JLabel();
        dieImg = new ImageIcon[7];
        dieImg[0] = null;
        random = new Random();
        gbc = new GridBagConstraints();
        for (int i = 1; i <= 6; i++) {
            dieImg[i] = assets.getResizedIcon("dice"+i, 128, 128);
//            dieImg[i] = new ImageIcon("D:\\Zac\\Desktop\\snakeIcons\\dice" + i
//                    + ".png");
//            dieImg[i].setImage(dieImg[i].getImage().getScaledInstance(128, 128,
//                    Image.SCALE_SMOOTH));
        }
        die.setIcon(dieImg[1]);
        
        //GUIDice
        setBackground(Color.WHITE);
        setBorder(border);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(128, 128));
        
        //Adds
        add(die);
        
        
    }

    //Methods
    public void playAnimation(int result) {
        timer = new Timer(100, new ActionListener() {
            private int randomNumber = random.nextInt(6)+1;
            private int i;
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(i < 9){
                    while(randomNumber == getVisible())
                        randomNumber = random.nextInt(6)+1;
                    die.setIcon(dieImg[randomNumber]);
                    i++;
                }
                else if (i == 9){
                    while(randomNumber == getVisible() || randomNumber == result)
                        randomNumber = random.nextInt(6)+1;
                    die.setIcon(dieImg[randomNumber]);
                    i++;
                    repaint();
                }
                else {
                    die.setIcon(dieImg[result]);
                    timer.stop();
                }
                
                repaint();
            }
        });
        timer.start();
        
    }
    
    public void reset() {
        die.setIcon(dieImg[1]);
        repaint();
    }

    private int getVisible() {
        int i;
        for (i = 1; i <= 6; i++) {
            if (die.getIcon() == dieImg[i]) {
                break;
            }
        }
        return i;
    }

    //Getter Setters
}
