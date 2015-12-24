import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.applet.*;

/**
 * 
 * @author Reynaldo Villarreal
 * Clase HelloWorldApplet que hereda de la clase Aṕplet e implementa Runnable y un escucha del mouse "MouseListener".
 * Este Applet es un minijuego sobre acertar una imagen que aparecera aleatoriamente en pantalla, dandole un click, luego 
 * de acertar 10 veces, serán 10 puntos y aumentara el nivel, haciendo que la imagen se mueva más rápido, por lo tanto 
 * mas dificil de acertar.
 *
 */
public class HelloWorldApplet1 extends Applet implements Runnable, MouseListener{

	int xpos,i,level;                //variables enteras: posición x del mouse, variable de conteo i y el nivel.
	int ypos,delay;                  //posición y del mouse y el delay
	int circX,circY,circHeight, circWidth;     //posición x del circulo, posición Y del círculo, altura del círculo y ancho del círculo
	boolean circClic=true;                    //booleano que indica si se cliqueo el círculo 
	public boolean frozen = false;
	public Random md=new Random();            //variable aleatoria md para la posición del circulo
	public Random col=new Random();           //varable aleatoria col para darle colores aleatorios al círculo
	public Color color;                      //variable color tipo Color
	Thread t;                                //hilo t
	public int fps=1;                         //frames por segundo=1
	
	public void init(){
		resize(400,400 );                //tamaño de la pantalla 400x400

		level = 1;                      //nivel comienza de 1

		
		circX = md.nextInt(350);        //posición X aleatoria del circulo que sea de 0 a 350 para no salir del ancho de la pantalla
		circY=md.nextInt(350);          //posición Y aleatoria del círculo que sea de 0 a 350 para no salir del ancho de la pantalla    
		circHeight=50;                  //Altura del circulo
		circWidth=50;                   //Anchura del circulo
		i=1;                   
		addMouseListener(this);         //agregamos el escucha

	} 
	
	public void start() { 
		if (frozen) {     //si aun no se inicia no hace nada
 
	        } else { 
		    if (t == null) {             //de lo contrario creara el hilo t
			t = new Thread(this); 
		    } 
		    t.start();                    //se inicia el hilo
		}
		}
	
	public void stop(){                   //metodo para detener
		t=null;
	}

	
   public void paint(Graphics g) {                            // metodo paint para que la imagen se dibuje constantemenete
	   delay = (fps > 0) ? (1000 / fps) : 100;                //variable delay que tomara el valor de (1000/fps) si fps es mayor que 0 de lo contario sera 100.

	   color = new Color(col.nextInt(255),col.nextInt(255),col.nextInt(255),col.nextInt(255));        //Colores aleatorios al dibujarse
	    circX=md.nextInt(350);               //nueva posición X del circulo
	    circY=md.nextInt(350);               //nueva posición y del circulo
	   g.setColor(Color.BLACK);              //color negro para las letras
	   if (circClic) g.drawString("Tu puntaje: "+i,10,390);      //si cirClic es true significa que fue clickeado entonces imprime en pantalla el puntaje
	   
	   if(i==10){                                                      //si i==10 significa que se ah cliqueado 10 veces el circulo 
		   g.drawString("Has subido al nivel "+level++, 200, 200);    //imprime que se ha subido de nivel
		   g.drawString("fps: "+fps, 205, 205);                       //imprime los fps
		   i=0;                                                      //reinicia el contador de puntos
		   fps++;                                                    //aumenta los fps es decir la velocidad
	   }
	    g.setColor(color);                      
		g.fillOval(circX,circY, circHeight, circWidth);               //se dibuja el circulo en las nuevas coordenadas
        //level(i);
	   
   }
  
 
public void mouseClicked(MouseEvent e) {              
	// TODO Auto-generated method stub
	xpos=e.getX();
	ypos=e.getY();
	
	if (xpos > circX && xpos < circX+circWidth && ypos >circY &&  ypos < circY+circHeight) {   //se calcula que se haya cliqueado el circulo
		circClic = true;
		i++;
	}
		  else  
		   circClic = false;
 
		  
	
}

public void run() {
	
	Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
	
	
	long startTime = System.currentTimeMillis();
	
	
	while (Thread.currentThread() == t) { 
	    

	    repaint();
	    
	    
	    try { 
		startTime +=delay;
		Thread.sleep(Math.max(0, startTime-System.currentTimeMillis())); 
	    } catch (InterruptedException e) { 
		break; 
	    }
	}
    }

public void level(int i){ 
	if(i==10){ 
		
	}
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

}  