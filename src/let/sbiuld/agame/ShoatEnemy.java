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
public class ShoatEnemy extends GameObjects{
    Random r=new Random();
    Handeler ha;
    private int timer=15;
    private int timer2=70;
    public ShoatEnemy(float x, float y, ID id, Handeler ha) {
        super(x, y, id);
        this.ha=ha;
        
        velX=0;
        velY=3;
    }

    @Override
    public void tick() {
       
        x+=velX;
        y+=velY;
        
        if(timer<=0){velY=0;}
        else{timer--;}
        if(timer<=0){
            timer2--;
        if(timer2<=0){
            if(velX==0){
        velX=3;
       
            }}}
                if(velX>0){
        velX+=0.05f;
        }
        else if(velX<0){
        velX-=0.05f;
        }
        velX=Game.clamp(velX, 10, -10);
        int spon= r.nextInt(10);
        if(spon==0){
        ha.addObject(new Pullets((int)x+48,(int) y+48, ID.Basicenemy, ha));
            }
        if(x<=0||x>=Game.Width-90){velX*=-1;}
        
       // if(y<=0||y>=Game.Hieght-32){velY*=-1;}
        //ha.addObject(new Tail(x, y, ID.tail, ha, Color.red, 64, 64, 0.03f));
        //for(int i=0;1<100;i++){System.out.println("df");}
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 94, 64);
    }

    @Override
    public Rectangle getbounds() {
       return new Rectangle((int)x, (int)y, 94, 64);
    }
    
}
