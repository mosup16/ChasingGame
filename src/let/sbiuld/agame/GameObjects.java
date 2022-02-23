/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.sbiuld.agame;

import java.awt.Graphics;
import java.awt.Rectangle;


/**
 *
 * @author بلال جلال
 */
public abstract class GameObjects {
    protected float x,y,fx,fy;
    protected ID id;
    protected float velX,velY;
    protected Rectangle r; 
    
    public GameObjects(float x,float y,ID id){
    this.x=x;
    this.y=y;
    this.id=id;
    }
    
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    public abstract Rectangle getbounds ();
    
    public void setx(float x){
    this.x=x;
    }
    public float getx(){
    return x;
    }
    
    
    public void sety(float y){
    this.y=y;
    }
    public float gety(){
    return y;
    }
    
    
    public void setID(ID id){
    this.id=id;
    }
    public ID getID(){
    return id;
    }
    
    
    public void setvelX(int velX){
    this.velX=velX;
    }
    public float getvelX(){
    return velX;
}
    
    
    public void setvelY(int velY){
    this.velY=velY;
    }
    public float getvelY(){
    return velY;
}
}
