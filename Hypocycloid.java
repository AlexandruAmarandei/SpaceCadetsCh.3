
package spacecad_ch3;

/*
 *
 * @author alexa
 */


public class Hypocycloid {
    private double x[] = new double[100100];
    private double y[] = new double[100100];
    double R, r, o, t;
    private int finish;
    int startx,starty, maxY=0, maxX=0;
    int size = 1;
    public Hypocycloid(double argR, double argr, double argo){
        R = argR;
        r = argr;
        o = argo;
        t = 0.01;
        if(argR < argr) size = -1;
        x[0] = (R+r) * Math.cos(t) + ((r+o) * Math.cos(((R+r)/r)*t))*size;
        y[0] = (R+r) * Math.sin(t) - (r+o) * Math.sin(((R+r)/r)*t);
        System.out.println(x[0] + " " + y[0]);
    }
    
    public void drawCircle(){
        int i;
        
        boolean v = false;
        int compXO = (int) (x[0] * 10);
        int compYO = (int) (y[0] * 10);
        int compX=0;
        int compY=0;
        for ( i = 1; i < 100000 && v==false; i++) {
            t +=0.01;
            x[i] = (R+r) * Math.cos(t) + (r+o) * (Math.cos(((R+r)/r)*t)*size);
            y[i] = (R+r) * Math.sin(t) - (r+o) * Math.sin(((R+r)/r)*t);
             compX = (int) (x[i] * 10);
             compY = (int) (y[i] * 10);
            if((int)x[i] < maxX) maxX = (int)x[i];
            if((int)y[i] < maxY) maxY = (int)y[i];
            //System.out.println(x[i] + " " + y[i]);
           
            if( (compX == compXO && compY == compYO)) v =true;
        }
        System.out.println(compX + " " + compY +" " + compXO + " " + compYO);
        finish = i;
        System.out.println(finish);
        
        
    }
    
    public int getFinish(){
        return finish;
    }
    
    public int getX(int i){
        return (int) x[i];
    }
    public int getY(int i){
        return (int) y[i];
    }
    public int getNegX(){
        return maxX;
    }
    public int getNegY(){
        return maxY;
    }
}
