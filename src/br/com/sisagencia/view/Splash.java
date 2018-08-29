package br.com.sisagencia.view;


import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jhonatan Nobre
 */
public class Splash extends JWindow {

    AbsoluteLayout absoluto;
    AbsoluteConstraints absimage, absbarra;
    ImageIcon image;
    JProgressBar barra;
    JLabel jlabel;

    public Splash() {
        absoluto = new AbsoluteLayout();
        absimage = new AbsoluteConstraints(0,0);
        absbarra = new AbsoluteConstraints(0, 0);
        jlabel = new JLabel();
        
        image = new ImageIcon(this.getClass().getResource("/br/com/sisagencia/imagens/fundoSplash.png"));
        jlabel.setIcon(image);
        barra = new JProgressBar();
        barra.setPreferredSize(new Dimension(487, 5));
        this.getContentPane().setLayout(absoluto);
        this.getContentPane().add(jlabel,absimage);
        this.getContentPane().add(barra,absbarra);
        new Thread(){
            public void run(){
                int i=0;
                while(i<101){
                    barra.setValue(i);
                    i++;
                    try {
                        sleep(30);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //new Splash().setVisible(true);
                dispose();
                LoginView login = new LoginView();
                login.setVisible(true);
            }
        }.start();
        
        
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }

    public static void main(String[] args) {
        
        new Splash();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
