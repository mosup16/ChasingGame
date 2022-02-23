/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.sbiuld.agame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import letsbiuldagame.Game.State;

/**
 *
 * @author بلال جلال
 */
public class Manue extends MouseAdapter{
    private Game game;
    private Handeler ha;
    Random r;
    HealthPar hp;
    Spon s;
    public Manue(Game game,Handeler ha,Random r,HealthPar hp,Spon s){
    this.game=game;
    this.ha=ha;
    this.r=r;
    this.hp=hp;
    this.s=s;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int mx=e.getX();
        int my=e.getY();
    if(game.gamestate==State.Manue){
        if(mouseover(mx, my, Game.Width/2-150, Game.Hieght/2-150, 300, 100)){
        ha.Olist.clear();
        game.gamestate=State.Game;
        HealthPar.Health=200;
        hp.setLevel(1);
        hp.setScore(0);
        s.fackescore=0;
        ha.addObject(new Player(Game.Width/2, Game.Hieght/ 2, ID.Player,ha));
        ha.addObject(new BasicEnemy(r.nextInt(Game.Width-20), r.nextInt(Game.Hieght-20), ID.Basicenemy,ha));
        
        }
        if(mouseover(mx, my,Game.Width/2-150, Game.Hieght/2+150, 300, 100)){
            System.exit(33);
        }
        if(mouseover(mx, my,Game.Width/2-150, Game.Hieght/2, 300, 100)){
        game.gamestate=State.Help;
    }}
    if(game.gamestate==State.Help||game.gamestate==State.End){
        if(mouseover(mx, my,Game.Width/2-150, Game.Hieght/2+150, 300, 100)){
        game.gamestate=State.Manue;
    }}
    if(game.gamestate==State.Pusse){
        if(mouseover(mx, my,0, 0, Game.Width, Game.Hieght)){
        game.gamestate=State.Game;
    }}}
    @Override
    public void mouseReleased(MouseEvent e){
      
    }
    public boolean mouseover(int mx,int my,int x,int y,int width,int hieght){
    if(mx>x&&mx<x+width){
    if(my>y&&my<y+hieght){
    return true;
    }else return false;
    }else return false;
    }
    public void tick(){
    
    }
    public void render(Graphics g){
    if(game.gamestate==State.Manue){
    Font font=new Font("arial",1,50);
    
    g.setColor(Color.white);
    g.setFont(font);
    g.drawString("RunAway",Game.Width/2-100, Game.Hieght/2-250);
    
    g.draw3DRect(Game.Width/2-150, Game.Hieght/2-150, 300, 100, true);
    g.drawString(" Play",Game.Width/2-70, Game.Hieght/2-80);
    
    g.draw3DRect(Game.Width/2-150, Game.Hieght/2, 300, 100, true);
    g.drawString(" Help",Game.Width/2-70, Game.Hieght/2-80+150);
    
    g.draw3DRect(Game.Width/2-150, Game.Hieght/2+150, 300, 100, true);
    g.drawString(" Quit",Game.Width/2-70, Game.Hieght/2-80+300);
    }
    if(game.gamestate==State.Help){
    g.setColor(Color.white);
    Font font=new Font("arial",1,60);
    g.setFont(font);
    g.setColor(Color.white);
    g.drawString("Help ",Game.Width/2-100, Game.Hieght/2-250);
    g.setColor(Color.white);
    Font font2=new Font("arial",1,30);
    g.setFont(font2);
    g.drawString("Use The arrows to move the Player and RunAway .. ",Game.Width/2-350, Game.Hieght/2-100);
    g.draw3DRect(Game.Width/2-150, Game.Hieght/2+150, 300, 100, true);
    Font font3=new Font("arial",1,50);
    g.setFont(font3);
    g.drawString("<< Back",Game.Width/2-100, Game.Hieght/2-80+300);
    
    }
    if(game.gamestate==State.End){
    g.setColor(Color.white);
    Font font=new Font("arial",1,60);
    g.setFont(font);
    g.setColor(Color.red);
    g.drawString("Game Over ",Game.Width/2-100, Game.Hieght/2-250);
    g.setColor(Color.white);
    Font font2=new Font("arial",1,30);
    g.setFont(font2);
    g.drawString("your score is: "+hp.getScore(),Game.Width/2-350, Game.Hieght/2-100);
    g.drawString("your level is: "+hp.getLevel(),Game.Width/2-350, Game.Hieght/2-20);
    g.draw3DRect(Game.Width/2-200, Game.Hieght/2+150, 300, 100, true);
    Font font3=new Font("arial",1,50);
    g.setFont(font3);
    g.drawString("<< Back",Game.Width/2-150, Game.Hieght/2-80+300);}
    
    
    if(game.gamestate==State.Pusse){
    Font font4=new Font("arial",1,30);
    g.setFont(font4);
    g.drawString("Pusse ",Game.Width/2, Game.Hieght/2);
        }
/*    public void renderhelp(){
      BufferStrategy bs=game.getBufferStrategy();
      if(bs==null){
      game.createBufferStrategy(3);
      return;
      }
      Graphics g=bs.getDrawGraphics();
    Font font=new Font("arial",1,10);
    g.setColor(Color.black);
    g.fillRect(0, 0, Game.Width, Game.Hieght);
    g.setColor(Color.white);
    g.drawString("RunAway is agame that let you ",Game.Width/2-100, Game.Hieght/2-250);

    g.dispose();
    bs.show();
    }*/
}}
