//Programa que emula una carrera de carritos

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Race extends JFrame implements ActionListener{    //Clase Race que se encarga principalmente de la parte grafica
	private JPanel contentPane;
	JLabel carro0,carro1,carro2,carro3,carro4;
	JButton iniciar;
	ImageIcon images;
	Icon icono0,icono1,icono2,icono3,icono4;
	public String a,b,c,d,e;
	
    int scale = 3;	

		public Race() {
			a="carro0";b="carro1";c="carro2";d="carro3";e="carro4";
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBackground(new java.awt.Color(204, 0, 0));
			contentPane.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 153), null));
			contentPane.setLayout(null);
			setContentPane(contentPane);
				images=new ImageIcon("src/carrito2.png");
			
			iniciar = new JButton("iniciar");
			iniciar.addActionListener(this);
			/*iniciar.addActionListener(new ActionListener() {   //boton que da inicio al creación de los 5 hilos que seran los carritos
				public void actionPerformed(ActionEvent e) {
					RaceCar[] cars=new RaceCar[5];

					for(int i=0;i<5;i++){
						cars[i]=new RaceCar(5,"carro"+i);
						cars[i].start();
					}
				}
			});*/
			iniciar.setBounds(166, 194, 117, 25);
			contentPane.add(iniciar);
			
			carro0 = new JLabel();     
			carro0.setBounds(0,0,50,23); 
			icono0=new ImageIcon(images.getImage().getScaledInstance(carro0.getWidth(), carro0.getHeight(), Image.SCALE_DEFAULT));
			carro0.setIcon(icono0);
			contentPane.add(carro0);
			
			carro1 = new JLabel();
			carro1.setBounds(0,35,50,23);
			icono1=new ImageIcon(images.getImage().getScaledInstance(carro1.getWidth(), carro1.getHeight(), Image.SCALE_DEFAULT));		
			carro1.setIcon(icono1);
			contentPane.add(carro1);
			
			carro2 = new JLabel();
			carro2.setBounds(0,70,50,23);
			icono2=new ImageIcon(images.getImage().getScaledInstance(carro2.getWidth(), carro2.getHeight(), Image.SCALE_DEFAULT));
			carro2.setIcon(icono2);
			contentPane.add(carro2);
			
			carro3 = new JLabel();
			carro3.setBounds(0,95,50,23);
			icono3=new ImageIcon(images.getImage().getScaledInstance(carro3.getWidth(), carro3.getHeight(), Image.SCALE_DEFAULT));			
			carro3.setIcon(icono3);
			contentPane.add(carro3);
			
			carro4 = new JLabel();
			carro4.setBounds(0,130,50,23);
			icono4=new ImageIcon(images.getImage().getScaledInstance(carro4.getWidth(), carro4.getHeight(), Image.SCALE_DEFAULT));			
			carro4.setIcon(icono4);
			contentPane.add(carro4);
			setVisible(true);
	}
		public void pintar(int x,int name){
			if(name==0){
				System.out.println("carro"+name+" pintar");
				carro0.setBounds(x,0,50,23);
			}else if(name==1){
				System.out.println(name+"pintar");
				carro1.setBounds(x,35,50,23);
			}else if(name==2){
				System.out.println(name+"pintar");
				carro2.setBounds(x,70,50,23);
			}else if(name==3){
				System.out.println(name+"pintar");
				carro3.setBounds(x,95,50,23);
			}else if(name==4){
				System.out.println(name+"pintar");
				carro4.setBounds(x,130,50,23);
			}
			
		}
		
	
	
	
	
public static void main (String[] args){
	 new Race();
}
public void actionPerformed(ActionEvent evt) {
	// TODO Auto-generated method stub
	Object fun=evt.getSource();
	if(fun==iniciar){
		RaceCar[] cars=new RaceCar[5];
		Race r=new Race();

		for(int i=0;i<5;i++){
			cars[i]=new RaceCar(250,i,r);
			cars[i].start();
		}
	}
	
}
}
