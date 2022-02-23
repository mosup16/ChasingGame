/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.sbiuld.agame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author بلال جلال
 */
public class Game extends Canvas implements Runnable,KeyListener {
    private static final long serialVersionUID = 1550691097823471818L;
    Manue m;
    public static int Width=920;
    public static int Hieght=920/12*9;
    
    private Thread thread;
     boolean running;
    private Handeler h;
    private Random r;
    private HealthPar hp;
    private Spon spon;
    Window s;
    File f;
    Audio sound;
    //private BufferedImage Imgs;
    ImageIcon pic;
    public Game() {
        h = new Handeler();
        r=new Random();
        hp =new HealthPar(this,h);
        spon=new Spon(h,hp,r);
        m=new Manue(this,h,r,hp,spon);
        Handeler ha = new Handeler();
        //ImageLoader loader=new ImageLoader();
       //Imgs= loader.imageLoader("Capture897.png");//kj
        this.addKeyListener(new KeyInput(h,this));
        this.addMouseListener(m);
         s = new Window(Width, Hieght, "RunAway", this);
        sound=new Audio(getClass().getResource("Data/Music.mp3").toString());
        if(gamestate==State.Game){
        h.addObject(new Player(Width/2, Hieght/ 2, ID.Player,h));
        h.addObject(new BasicEnemy(r.nextInt(Width-20), r.nextInt(Hieght-20), ID.Basicenemy,h));
        }/*else{
        for(int i=0;i<10;i++){
        h.addObject(new Particules(r.nextInt(Width-20), r.nextInt(Hieght-20), ID.particules, h));
        }}*/

    }

    public enum State{
    Manue(),
    Game(),
    Help()
    ,Pusse(),End;
    };
    public State gamestate=State.Manue;
    
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread = new Thread(this);
            thread.join();
            running = false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        /*long LastTime = System.nanoTime();
        double amountOfTicks = 1.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;*/

        while (running) {
            for(int i=0;i<20;i++){
                tick();
            for(int g=0;g<1;g++){if(running){render();}
            }}
            /*long now = System.nanoTime();
            delta += (now - LastTime) / ns;
            while (delta >= 1) {
                tick();
                delta-=100;
            for (int ii=0;ii<1000;ii++){}
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 10000;
                 System.out.println("FPS : "+frames);
                frames = 0;
            }*/
        }
        stop();
    }

    private void tick() {
        if(gamestate!=State.Pusse){
            h.tick();
        }
        if(gamestate==State.Game){
        hp.tick();
        spon.tick();        
        if(gamestate==State.Game||gamestate==State.End){
        m.tick();
        }
        //System.out.println(h.Olist.size());
    }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(2);
            return;
        }
        Graphics gd = bs.getDrawGraphics();
       // gd.setColor(Color.black);
       // gd.fillRect(0, 0, Width, Hieght);
      //BufferedImage imic= new BufferedImage(Width, Hieght,new Image(getClass().getResource("modern-figure-oil-paintings-flamenco-dancer.jpg")));
       //gd.drawImage(imic, WIDTH, WIDTH, this);
        pic=new ImageIcon(getClass().getResource("Data/nightfall.jpg"));
       gd.drawImage(pic.getImage(), 0, 0, null);
        h.render(gd);
        if(gamestate==State.Game){
        hp.render(gd);
        }else{
        System.gc();
        m.render(gd);
        }
        gd.dispose();
        bs.show();
    }
    
    public static float clamp(float var,float max,float min){
    if( var>=max)
        return max;
    else if(var<=min)return min;
    else return var;
    }

    public static void main(String[] args) {
        Game game = new Game();
       
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
           

}
