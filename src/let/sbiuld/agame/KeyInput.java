/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.sbiuld.agame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author بلال جلال
 */
public class KeyInput extends KeyAdapter{
   private Handeler ha;
   private Game game;
   private boolean keyDown[]=new boolean[4];
    public KeyInput(Handeler h,Game game){
    this.ha=h;
    this.game=game;
    }
    
   @Override
    public void keyPressed(KeyEvent e){
    int key=e.getKeyCode();
           //System.out.println(key);

    for(int i=0;i<ha.Olist.size();i++){
           //System.out.println("key"+key);
    GameObjects tempObj=ha.Olist.get(i);
           //System.out.println(ID.Player+"key"+tempObj.getID());
    if(tempObj.getID()==ID.Player){
    //the Player key events
      if(key==KeyEvent.VK_UP){tempObj.setvelY(-8);keyDown[0]=true;}
       if(key==KeyEvent.VK_DOWN){tempObj.setvelY(8);keyDown[1]=true;}
       if(key==KeyEvent.VK_RIGHT){tempObj.setvelX(8);keyDown[2]=true;}       
       if(key==KeyEvent.VK_LEFT){tempObj.setvelX(-8);keyDown[3]=true;}
    }
    }
    if(key==KeyEvent.VK_ESCAPE){
        if(game.gamestate==Game.State.Manue){
            System.exit(key);
        }        
        if(game.gamestate==Game.State.Game){
            game.gamestate=Game.State.Pusse;
            System.gc();
        }        
        if(game.gamestate==Game.State.Help){
            game.gamestate=Game.State.Manue;
        }}
    if(key==KeyEvent.VK_P){
        game.gamestate=Game.State.Pusse;
            System.gc();
        }
    if(key==KeyEvent.VK_SPACE){
        game.gamestate=Game.State.Game;
    }
    }
    
   @Override
    public void keyReleased(KeyEvent e){
        int key=e.getKeyCode();
    for(int i=0;i<ha.Olist.size();i++){
    GameObjects tempObj=ha.Olist.get(i);
    if(tempObj.getID()==ID.Player){
    //the Player key events
       if(key==KeyEvent.VK_UP){/*tempObj.setvelY(0);*/keyDown[0]=false;}
       if(key==KeyEvent.VK_DOWN){/*tempObj.setvelY(0);*/keyDown[1]=false;}
       if(key==KeyEvent.VK_RIGHT){/*tempObj.setvelX(0);*/keyDown[2]=false;}       
       if(key==KeyEvent.VK_LEFT){/*tempObj.setvelX(0);*/keyDown[3]=false;}
       
       if(keyDown[0]==false&&keyDown[1]==false){tempObj.setvelY(0);}
       if(keyDown[2]==false&&keyDown[3]==false){tempObj.setvelX(0);}
    }
    }
    }
    
    
    
}
