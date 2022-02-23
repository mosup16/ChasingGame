/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.sbiuld.agame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author بلال جلال
 */
public class BasicEnemy extends GameObjects{
    Random r=new Random();
    Handeler ha;
    public BasicEnemy(float x, float y, ID id, Handeler ha) {
        super(x, y, id);
        this.ha=ha;
        
        velX=3;
        velY=3;
    }

    @Override
    public void tick() {

        
        x+=velX;
        y+=velY;
        if(x<=0||x>=Game.Width-32){velX*=-1;}
        if(y<=0||y>=Game.Hieght-32){velY*=-1;}
        ha.addObject(new Tail(x, y, ID.tail, ha, Color.red, 12, 12, 0.03f));
        //for(int i=0;1<100;i++){System.out.println("df");}
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 12, 12);
       //ImageIcon pic=new ImageIcon(getClass().getResource("Data//BasicEnemy1.png"));
       //g.drawImage(pic.getImage(), (int)x, (int)y, null);
    }

    @Override
    public Rectangle getbounds() {
       return new Rectangle((int)x, (int)y, 12, 12);
    }
    
}
