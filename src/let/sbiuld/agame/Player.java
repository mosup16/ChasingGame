/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.sbiuld.agame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author بلال جلال
 */
public class Player extends GameObjects {
    Random r=new Random();
    Handeler ha;
    private BufferedImage ima;
    
    public Player(float x, float y, ID id,Handeler ha) {
        super(x, y, id);
        this.ha=ha;
       // Images ss=new Images(ima);
       // ss.imageGeter(1, 1, 32, 32); 
}

    @Override
    public void tick() {
    /*if(getID()!=ID.Player)
    {for(int i=0;i<1000;i++)
    {    
    velX=r.nextInt(5)+1;
    velY=r.nextInt(5);        //for random movmentfor(int f=0;f<10;f++)
                             //System.out.println(velX);System.out.println(velY);
    {
    x+=velX;
    y+=velY;  
    if(x>=640&&y>=640/12*9){x=0;y=0;}      //reset the positoin
    for(int g=0;g<4000000;g++){}            //slow the motion
    }}}*/
    x+=velX;
    y+=velY;
    x= Game.clamp((int) x, Game.Width-40, 0);
    y= Game.clamp((int) y, Game.Hieght-60, 0);
    collision();
        ha.addObject(new Tail(x, y, ID.tail, ha, Color.BLUE, 32, 32, 0.05f));
    }
    
    public void collision(){
    for (int i=0;i<ha.Olist.size();i++){
    GameObjects tempObj=ha.Olist.get(i);
   if(tempObj.getID()==ID.Basicenemy||(tempObj.getID()==ID.SmartEnemy)||(tempObj.getID()==ID.ShoatEnemy)){
       if (getbounds().intersects(tempObj.getbounds())){
    HealthPar.Health-=2;
    }}
    }
    }
    
    @Override
    public void render(Graphics g) {
      
/*      Graphics2D g2d= (Graphics2D)g;
      g.setColor(Color.gray);
      g2d.draw(getbounds());*/ 
      g.setColor(Color.BLUE);
      g.fillRect((int)x,(int)y, 32, 32);
      g.drawImage(ima, (int)x, (int)y, null);
      //ImageIcon pic=new ImageIcon(getClass().getResource("Data//Player1.png"));
      // g.drawImage(pic.getImage(), (int)x, (int)y, null);
 }

    @Override
    public Rectangle getbounds() {
       return new Rectangle((int)x, (int)y, 32, 32);
    }
}
