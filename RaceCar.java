

public class RaceCar extends Thread {
private int finish,i;
//public String name;
Race r;


public RaceCar(int finish,int i,Race r) {
	this.finish=finish;
	this.i=i;
	this.r=r;
}
	
public void run() {
	for(int j=0;j<finish;j=j+10) {
		System.out.println("carro"+i+": "+j);
		
		try{
			Thread.sleep((long)((Math.random()*(5-1)+1)*1000));
			r.pintar(j,i);
		}catch(InterruptedException e){}
	}
	System.out.println("La carrera ha terminado el carro ganador es: carro"+i);
}
}
