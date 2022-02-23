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
public class SmartEnemy extends GameObjects{
    Random r=new Random();
    Handeler ha;
     
      private GameObjects Player;
    public SmartEnemy(float x, float y, ID id, Handeler ha) {
        super(x, y, id);
        this.ha=ha;
        for(int i=0;i<ha.Olist.size();i++){
        if(ha.Olist.get(i).getID()==ID.Player){
        Player=ha.Olist.get(i);
        }
        }

    }

    @Override
    public void tick() {

        x+=velX;
        y+=velY;

       float diffx=x-Player.getx();
       float diffy=y-Player.gety();
       float distance=(float) Math.sqrt((x-Player.getx())*(x-Player.getx())+(y-Player.gety())*(y-Player.gety()));
       velX= (-3.0f/distance)*diffx;
       velY=(-3.0f/distance)*diffy;

        x= Game.clamp((int)x, Game.Width-40, 0);
        y= Game.clamp((int)y, Game.Hieght-60, 0);
     
        ha.addObject(new Tail(x, y, ID.tail, ha, Color.orange, 22, 22, 0.03f));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect((int)x,(int) y, 22, 22);
    }

    @Override
    public Rectangle getbounds() {
       return new Rectangle((int)x,(int) y, 12, 12);
    }
    
}
