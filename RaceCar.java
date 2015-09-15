import java.util.*;
import java.awt.*;
import javax.swing.*;

public class RaceCar extends Thread {
private int finish;
private String name;
private JPanel contentPane;


public RaceCar(int finish,String name) {
	this.finish=finish;
	this.name=name;
}
	
public void run() {
	Race r=new Race();
	for(int i=0;i<finish;i++) {
		System.out.println(name+": "+i);
		r.paint(i,name);
		try{
			Thread.sleep((long)((Math.random()*(5-1)+1)*1000));
		}catch(InterruptedException e){}
	}
	System.out.println("La carrera ha terminado el carro ganador es: "+name);
}
}
