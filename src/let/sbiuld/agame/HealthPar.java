/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.sbiuld.agame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author بلال جلال
 */
public class HealthPar {
    Handeler ha;
    private int score=0;
    private int level=1;
    public static int Health=200;

    Game game;
    public HealthPar(Game game, Handeler ha){
    this.game=game;
    this.ha=ha;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static int getHealth() {
        return Health;
    }

    public static void setHealth(int Health) {
        HealthPar.Health = Health;
    }
    
    public void tick(){
    //Health--;
    score++;
    if(Health<=0){
    game.gamestate=Game.State.End;
    ha.Olist.clear();
    }
    }
    
    public void render(Graphics g){
    g.setColor(Color.gray);
    g.fillRect(15, 15, 200, 25);
    g.setColor(Color.green);
    g.fillRect(15, 15, Health, 25);
    g.setColor(Color.white);
    g.drawRect(15, 15, 200, 25);
    
    
    if(Health<=150){
    g.setColor(Color.yellow);
    g.fillRect(15, 15, Health, 25);
    
    }    
    if(Health<=50){
    g.setColor(Color.red);
    g.fillRect(15, 15, Health, 25);
    g.setColor(Color.red);
    g.drawRect(15, 15, 200, 25);
    }
    
    g.setColor(Color.WHITE);
    g.drawString("Score: "+score, 15, 60);
    g.setColor(Color.WHITE);
    g.drawString("Leavel: "+level, 15, 80);
    
    }
}
