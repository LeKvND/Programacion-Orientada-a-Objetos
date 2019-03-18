import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;


public class DemoGridLayout implements ActionListener{
    JFrame frame;
    JPanel panelSuperior, panelInferior;
    JButton[] bt = new JButton[20];
    String res = new String("0");
    String resultado = new String("10");
    JLabel puntuacion,puntos,tiempo,segundos;
    int numerin=0,segundoasegundo=10;
    int estado;
    ImageIcon topo,nada;


    public DemoGridLayout(){
        construyePanelSuperior();
        construyePanelInferior();
        construyeVentana();

        }

    void construyePanelSuperior(){
        panelSuperior = new JPanel ();
        panelSuperior.setLayout(new FlowLayout());
        puntuacion = new JLabel("Tu puntuación es de: ");
        puntos = new JLabel("");
        tiempo = new JLabel("Tiempo: ");
        segundos = new JLabel("10");

        panelSuperior.add(puntuacion);
        panelSuperior.add(puntos);
        panelSuperior.add(tiempo);
        panelSuperior.add(segundos);

    }

    void construyePanelInferior(){
        Thread hilo = new Proceso("Cambiar tablero");
        panelInferior= new JPanel();
        panelInferior.setLayout(new GridLayout(5,4,10,10));

        topo = new ImageIcon("2.png");
        nada = new ImageIcon("1.png");
        for(int i = 0; i < 20; i++) {
              bt[i] = new JButton("");
              bt[i].setIcon(nada);
        }
        for(int i = 0; i < 20; i++) {
              panelInferior.add(bt[i]);
              bt[i].addActionListener(this);
      }
        hilo.start();
        aparecer();
      }




    public void actionPerformed (ActionEvent e){
        for(int indiceboton=0;indiceboton<20;indiceboton++){
          if(e.getSource()==bt[indiceboton]){
            if(bt[indiceboton].getIcon() == topo){
              numerin+=1;
              res=Integer.toString(numerin);
              bt[indiceboton].setIcon(nada);
              aparecer();
              puntos.setText(res);
            }
          }
        }

   }



    void construyeVentana(){
        frame =new JFrame("Wak-a-Mole!");
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        frame.add(panelSuperior);
        frame.add(panelInferior);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      }

    void aparecer(){
        int cantidad=1;
        if(Math.random()>0.5){
            cantidad = (int) (Math.random()*4);
            if (cantidad == 0){
              cantidad=1;
            }
        }
        for(int m=0;m<cantidad;m++){
            int indice = (int) (Math.random()*21);
            bt[indice].setIcon(topo);
        }
      }

public class Proceso extends Thread implements Runnable {
Thread hilo;
        public Proceso(String msg){
          super(msg);
        }

        public void setHilo(Thread hilo){
          this.hilo = hilo;
        }

        public void run(){
          while(true){
            segundoasegundo-=1;
            resultado=Integer.toString(segundoasegundo);
            segundos.setText(resultado);
            try{
             this.hilo.sleep(1000);}
             catch(InterrumpedException ex){
               Logger.getLogger(Proceso .class.getName())
               .log(Level.SEVERE, null, ex);
             }
          }
        }
}





    public static void main(String [] inforux){
        new DemoGridLayout();}
}
