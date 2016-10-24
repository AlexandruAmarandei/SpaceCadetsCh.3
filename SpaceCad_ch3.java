/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacecad_ch3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
/**
 *
 * @author alexa
 */
public class SpaceCad_ch3 extends JPanel implements ActionListener{

    public  static TextField text;
    private int x[] = new int [100];
    private int y[] = new int [100];
    private int o[] = new int [100];
    private int cnt = 0;
    private static JFrame frame;
    Hypocycloid s[] =new Hypocycloid [100];
    public static void main(String[] args) {
        SpaceCad_ch3 line = new SpaceCad_ch3();
        frame = new JFrame ("Challange 3");
        Button bt = new Button();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        text = new TextField ();
        frame.add(bt);  
        text.setBounds (1, 640, 650, 20);
        bt.setBounds(655, 640, 20, 20);
        
        frame.add(text);
        frame.add(bt); 
        bt.addActionListener(line);
        frame.add(line);
        frame.setBackground(Color.white);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }

    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d  = (Graphics2D) g;
        g2d.setColor(Color.black);
        Random rand = new Random();
        int maxXNeg = 0;
        int maxYNeg = 0;
        for(int i=1; i<=cnt; i++){
            s[i] = new Hypocycloid( x[i], y[i], o[i]);
            s[i].drawCircle();
            if(maxXNeg > s[i].getNegX()) maxXNeg = s[i].getNegX();
            if(maxYNeg > s[i].getNegY()) maxYNeg = s[i].getNegY();
        }
        for(int j=1; j<=cnt; j++){
        Color color = new Color(rand.nextInt(0xFFFFFF));
        g2d.setColor(color);
        int finish = s[j].getFinish();
        
        //maxXNeg = s[j].getNegX();
       // maxYNeg = s[j].getNegY();
        for(int i=1; i< finish ;i++){
            int auxx= s[j].getX(i) - maxXNeg;
            int auxy= s[j].getY(i) - maxYNeg;
            int auxxpred = s[j].getX(i-1) - maxXNeg;
            int auxypred = s[j].getY(i-1) - maxYNeg;
            g2d.drawLine(auxxpred, auxypred,auxx, auxy);
        }
        
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = text.getText();
        int first = input.indexOf(' ');
        int second = input.indexOf(' ', first + 1);
        cnt++;
        x[cnt] = Integer.parseInt (input.substring(0, first));
        y[cnt] = Integer.parseInt(input.substring(first + 1, second));
        o[cnt] = Integer.parseInt(input.substring(second+1));
        frame.repaint();
        
        
    }
    
}
