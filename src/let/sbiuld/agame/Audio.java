/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.sbiuld.agame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Player;
import javax.media.Manager;
import javax.media.RealizeCompleteEvent;


/**
 *
 * @author بلال جلال
 */
public class Audio extends javax.swing.JFrame implements ActionListener,ControllerListener {
    String path;
    Player p;
    File f=null;
    Game game;
    public Audio(String path){
    this.path=path;  
    try{
    getfile(path);
    creatfile();
   // System.out.println(path);
    }
    catch(Exception e){
    System.err.println(Arrays.toString(e.getStackTrace())+"\nex2 constractor");
    }
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void controllerUpdate(ControllerEvent ce) {
        try{
        Container co=getContentPane();
        if(ce instanceof RealizeCompleteEvent){
        Component vc=p.getVisualComponent();
        if(vc==null){
        co.add(vc, BorderLayout.CENTER);
        }
        Component comp=p.getControlPanelComponent();
        if(comp==null){
        co.add(comp, BorderLayout.SOUTH);
        }
        co.doLayout();
        }        

        }catch(Exception e){
        System.err.println(Arrays.toString(e.getStackTrace())+"\nex1 update controller");
        }    
    }
        private void creatfile() {
    try{
        //URL x=getClass().getResource("Data\\Katy_Perry_-_Swish_Swish_(Audio)_ft._Nicki_Minaj.mp3.wav");
       System.err.println(getClass().getResource("Data")+"\nex path"+"بلال جلال");
       p=Manager.createRealizedPlayer(getClass().getResource("Data/Music.mp3"));
      // p=Manager.createRealizedPlayer(getfile(path).toURL());
       System.err.println("\nex353 update controller");
       p.addControllerListener((ControllerListener) this);
       p.start();
       p.realize();
       }
       catch(Exception e){
           System.err.println(Arrays.toString(e.getStackTrace())+"\nex creat file\n"+e.getCause());
       }            
    }    

    private File getfile(String path) {
    try
    {
        f=new File(this.path);
        
    }
    catch(Exception e)
    {
    System.err.println(Arrays.toString(e.getStackTrace())+"\nex get file");
    }
        return f;
    }

}
