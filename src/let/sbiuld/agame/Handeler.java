/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.sbiuld.agame;
import java.awt.*;
import java.util.*;
/**
 *
 * @author بلال جلال
 */
public class Handeler {
    LinkedList<GameObjects> Olist=new LinkedList<GameObjects>();
    
    public void tick(){
    for (int i=0;i<Olist.size();i++){
    GameObjects TempO1=Olist.get(i);
    TempO1.tick();
    }
    }
    
    
    public void render(Graphics g){
    for(int i=0;i<Olist.size();i++){
    GameObjects tempO2=Olist.get(i);
    tempO2.render(g);
    }
    }
    
    
    public void addObject(GameObjects Obj){
    this.Olist.add(Obj);
    }
    public void removeObjects(GameObjects Obj){
    this.Olist.remove(Obj);
    }
    
    public void clear(){
    for (int i=0;i<Olist.size();i++){
    if(Olist.get(i).getID()!=ID.Player){
    this.removeObjects(Olist.get(i));
        
    }}
    }
}
