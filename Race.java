//Programa que emula una carrera de carritos

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Race extends JFrame{    //Clase Race que se encarga principalmente de la parte grafica
	private JPanel contentPane;
	ImageIcon images=new ImageIcon();
	public String a,b,c,d,e;
	
    int scale = 3;	

		public Race() {
			a="carro1";b="carro2";c="carro3";d="carro4";e="carro5";
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBackground(new java.awt.Color(204, 0, 0));
			contentPane.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 153), null));
			contentPane.setLayout(null);
			setContentPane(contentPane);
				images=new ImageIcon("src/carrito2.png");
			
			JButton iniciar = new JButton("iniciar");
			iniciar.addActionListener(new ActionListener() {   //boton que da inicio al creación de los 5 hilos que seran los carritos
				public void actionPerformed(ActionEvent e) {
					RaceCar[] cars=new RaceCar[5];

					for(int i=0;i<5;i++){
						cars[i]=new RaceCar(5,"carro"+i);
						cars[i].start();
					}
				}
			});
			iniciar.setBounds(166, 194, 117, 25);
			contentPane.add(iniciar);
	}
		public void paint(int x, String name){     //metodo que aún no funciona para pintar los carritos y moverlos, recibira como argumentos un entero x y una cadena que es el nombre
			if(name == a){                         //se compara que el nombre del carro sea igual al nombre almacenado en la variable a
				JLabel carro1 = new JLabel();      //label que contendra una imagen y se movera dentro del container
				carro1.setIcon(images);            //se le incluye la imagen al label
				carro1.setBounds(x,0,50,23);       //se le asigna el tamaño y las coordenadas del carro el valor, de g hara que avanza a traves del frame
				contentPane.add(carro1);
				setVisible(true);
			}else if(name == b){
				JLabel carro2 = new JLabel();
				carro2.setIcon(images);
				carro2.setBounds(x,35,50,23);
				contentPane.add(carro2);
				setVisible(true);
			}else if(name == c){
				JLabel carro3 = new JLabel();
				carro3.setIcon(images);
				carro3.setBounds(x,70,50,23);
				contentPane.add(carro3);
				setVisible(true);
			}else if(name == d){
				JLabel carro4 = new JLabel();
				carro4.setIcon(images);
				carro4.setBounds(x,95,50,23);
				contentPane.add(carro4);
				setVisible(true);
			} else{
				JLabel carro5 = new JLabel();
				carro5.setIcon(images);
				carro5.setBounds(x,130,50,23);
				contentPane.add(carro5);
				setVisible(true);
			}
		}
	
	
	
	
public static void main (String[] args){
	SwingUtilities.invokeLater(new Runnable()
	 {
	 public void run()
	 {
	 new Race().setVisible(true);
	 }
	 });
	/**
*RaceCar[] cars=new RaceCar[5];
*cars[0]=new RaceCar(15,"Rey0");
*cars[1]=new RaceCar(15,"Rey1");
*cars[2]=new RaceCar(15,"Rey2");
*cars[3]=new RaceCar(15,"Rey3");
*cars[4]=new RaceCar(15,"Rey4");

*for(int i=0;i<5;i++){
	*cars[i].start();
*}
*/
}
}
