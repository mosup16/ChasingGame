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

/**
 *
 * @author بلال جلال
 */
public class Pullets extends GameObjects{
    Random r=new Random();
    Handeler ha;
public Pullets(float x, float y, ID id, Handeler ha) {
        super(x, y, id);
        this.ha=ha;
        
        velX=(r.nextInt((5 - -5))+ -5);
        velY=5;
    }

    @Override
    public void tick() {
       
        x+=velX;
        y+=velY;
        //if(x<=0||x>=Game.Width-32){velX*=-1;}
        //if(y<=0||y>=Game.Hieght-32){velY*=-1;}
        if(y >=Game.Hieght&&x >=Game.Width||y >=Game.Hieght&&x <=Game.Width){ha.removeObjects(this);}
        ha.addObject(new Tail(x, y, ID.tail, ha, Color.YELLOW, 10, 10, 0.03f));
        //for(int i=0;1<100;i++){System.out.println("df");}
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int)x, (int)y, 10, 10);
    }

    @Override
    public Rectangle getbounds() {
       return new Rectangle((int)x, (int)y, 10, 10);
    }
    
}
