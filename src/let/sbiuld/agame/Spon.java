/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.sbiuld.agame;

import java.util.Random;

/**
 *
 * @author بلال جلال
 */
public class Spon {
    private Handeler h;
    private HealthPar hp;
    Random r;
    boolean winning;
    int fackescore=0;
    public Spon(Handeler h,HealthPar hp,Random r){
    this.h=h;
    this.hp=hp;
     this.r=r;
     
    }
    public void tick(){
    fackescore++;
    if(fackescore>=1000){
        fackescore=0;
        hp.setLevel(hp.getLevel()+1);
        h.addObject(new BasicEnemy(r.nextInt(620), r.nextInt((640 / 12 * 9)-20), ID.Basicenemy,h));
        
        if(hp.getLevel()>=4){
        h.addObject(new FastEnemy(r.nextInt(620), r.nextInt((640 / 12 * 9)-20), ID.Basicenemy,h));
}       if(hp.getLevel()==4){
             h.addObject(new SmartEnemy(r.nextInt(Game.Width-20), r.nextInt(Game.Hieght-20), ID.SmartEnemy,h));
        }
        if(hp.getLevel()==10){
            h.Olist.clear();
            for(int i=0;i<300;i++)
            System.gc();
        h.addObject(new Player(Game.Width/2, Game.Hieght/ 2+400, ID.Player,h));
        h.addObject(new ShoatEnemy(Game.Width/2, Game.Hieght-670, ID.ShoatEnemy,h));
        }
        if(hp.getLevel()==11){
           h.Olist.clear();
            for(int i=0;i<300;i++){}
            System.gc();
        h.addObject(new Player(Game.Width/2, Game.Hieght/ 2+400, ID.Player,h));
        h.addObject(new SmartEnemy(r.nextInt(Game.Width-20), r.nextInt(Game.Hieght-20), ID.SmartEnemy,h));
        if(fackescore>=1000){
        fackescore=0;
        hp.setLevel(hp.getLevel()+1);
        h.addObject(new FastEnemy(r.nextInt(620), r.nextInt((640 / 12 * 9)-20), ID.Basicenemy,h));    }
        }/*int lv=1;
    
    winning=true;
    //hp.setLevel(hp.getLevel()+1);
   
    lv=1;
    if(hp.getScore()==s||hp.getScore()==200){
    
    hp.setLevel(hp.getLevel()+1);
    h.addObject(new BasicEnemy(r.nextInt(620), r.nextInt((640 / 12 * 9)-20), ID.Basicenemy,h));

    }*/
 
   /*if(hp.getScore()==100){
    hp.setLevel(2);
    for(int i=0;i<1;i++){
        h.addObject(new BasicEnemy(r.nextInt(620), r.nextInt((640 / 12 * 9)-20), ID.Basicenemy,h));
    }
    }
    if(hp.getScore()==1000){
    hp.setLevel(3);
    for(int i=0;i<2;i++){
        h.addObject(new BasicEnemy(r.nextInt(620), r.nextInt((640 / 12 * 9)-20), ID.Basicenemy,h));
    }
    }
    if(hp.getScore()==2000){
    hp.setLevel(4);
    for(int i=0;i<3;i++){
        h.addObject(new BasicEnemy(r.nextInt(620), r.nextInt((640 / 12 * 9)-20), ID.Basicenemy,h));
    }
    }if(hp.getScore()==3500){
    hp.setLevel(5);
    for(int i=0;i<2;i++){
        h.addObject(new BasicEnemy(r.nextInt(620), r.nextInt((640 / 12 * 9)-20), ID.Basicenemy,h));
    }*/
    }
    }}

