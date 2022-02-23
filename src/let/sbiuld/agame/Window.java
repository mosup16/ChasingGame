/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.sbiuld.agame;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author بلال جلال
 */
public class Window extends Canvas {
public Window(int width, int height, String titel,Game game){

    JFrame d=new JFrame(titel);
    d.setPreferredSize(new Dimension(width, height));
    d.setMaximumSize(new Dimension(width, height));
    d.setMinimumSize(new Dimension(width, height));
    d.setIconImage(new ImageIcon(getClass().getResource("Data/ball icon.png")).getImage());
    
    d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    d.setResizable(false);
    d.setLocationRelativeTo(null);
    d.add(game);
    d.setVisible(true);
    game.start();
    
}    
}
