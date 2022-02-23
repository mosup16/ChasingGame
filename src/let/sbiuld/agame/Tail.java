/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.sbiuld.agame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author بلال جلال
 */
public class Tail extends GameObjects{
    Handeler ha;
    float alpha=1f;
    Color color;
    private int height,width;
    private float life;
    public Tail(float x, float y, ID id,Handeler ha,Color color,int width,int height,float life) {
        super(x, y, id);
        this.ha=ha;
        this.color=color;
        this.width=width;
        this.height=height;
        this.life=life;
        
    }
    
    @Override
    public void tick() {
        if(alpha>life)
        alpha-=life-0.001;
        else
        ha.removeObjects(this);

    }

    @Override
    public void render(Graphics g) {
    Graphics2D g2d=(Graphics2D)g;
    g2d.setComposite(maketail(alpha));
    g.setColor(color);
    g.fillRect((int)x, (int)y, width, height);
    g2d.setComposite(maketail(1f));
    }
    
    public AlphaComposite maketail(float alpha){
    int type= AlphaComposite.SRC_OVER;
    return AlphaComposite.getInstance(type,alpha);
    }
    
    @Override
    public Rectangle getbounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
