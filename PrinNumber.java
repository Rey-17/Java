import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;


public class PrinNumber extends JFrame {

	private boolean Keepgoing;
	private JPanel contentPane;
	private JTextField numero;
	private JLabel resultado;
	private JLabel Titulo;
	private JLabel mainEnding;

	
	public PrinNumber() {
		Keepgoing=true;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("PrinNmbers");
		
		numero = new JTextField();
		numero.setBounds(9, 79, 123, 29);
		contentPane.add(numero);
		numero.setColumns(10);
		
		JButton Iniciar = new JButton("Iniciar");
		Iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		Iniciar.setBounds(10, 147, 122, 25);
		
	    contentPane.add(Iniciar);
		
		resultado = new JLabel("");
		resultado.setBackground(new Color(106, 90, 205));
		resultado.setFont(new Font("Norasi", Font.BOLD | Font.ITALIC, 76));
		resultado.setBounds(272, 33, 77, 139);
		contentPane.add(resultado);
		
		Titulo = new JLabel("Introduzca la duración del hilo");
		Titulo.setBounds(10, 33, 226, 15);
		contentPane.add(Titulo);
		
		mainEnding = new JLabel("");
		mainEnding.setFont(new Font("Norasi", Font.BOLD | Font.ITALIC, 14));
		mainEnding.setBounds(109, 201, 256, 29);
		contentPane.add(mainEnding);
	}
	
	private void start(){
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			  
			   protected Void doInBackground() throws Exception {
			  
			   int n=1;
			   int duracion=Integer.parseInt(numero.getText().toString());
			   while(Keepgoing){
				   if(n<=duracion){
						resultado.setText(""+n);
						n++;
						try{
							Thread.sleep(1000);
						}catch(InterruptedException e){}
						}else{
							long mili=duracion*1000;
							dormir2(mili, duracion);
						}
			   }
					
			   

			    return null;
			   }
			  };
			  
			  worker.execute();
	}
	
	public void dormir2(long m, int duracion){
       int i=0;
       int imp=duracion;
		while(i<=duracion){
				try{
					mainEnding.setText("Durmiendo por "+imp+" seg.");
					Thread.sleep(1000);
				}catch(InterruptedException e){}
				--imp;
				i++;
				}
		mainEnding.setText("main() is ending...");
				stopPrinting();
	   }
	
	public void stopPrinting(){
		Keepgoing=false;
	}
	
	
	public static void main(String[] args) {
					PrinNumber frame = new PrinNumber();
					frame.setVisible(true);
	}
}
