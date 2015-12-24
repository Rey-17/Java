import java.net.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
/**
 * 
 * @author Reynaldo Villarreal
 * <p>Clase CLienteTriangulo que  hereda de la clase JFrame e implementa un ActioListener<br>
 *    recibira dos valores, la base y la altura, del usuario el cual los enviara como los parámetros 
 *    del objeto de la clase RightTriangle que devolvera el area y la hipotenusa calculados.</p>
 * 
 *
 */

public class ClienteTriangulo extends JFrame implements ActionListener
{
	
	private JPanel contentPane;
	private JPanel panel;
	private JPanel PanelDerechoI;
	private JTextField textAltura;
	private JTextField textBase;
	//private JTextArea res;
	private JLabel lblresHipo;
	private JLabel lblresArea;
	private JButton btnEnvi;
	private JLabel Base;
	private JLabel Altura;
	private ImageIcon images;
	private Icon icono0;
	private JLabel lblresultado;
	private ObjectInputStream in;
	private InputStream inFromServer;
	private OutputStream outToServer;
	private ObjectOutputStream out;
	private Socket client;
	String serverName;
	int port;

    public 	RightTriangle rightOutTri;
    public  RightTriangle rightInTri;   
    
    /**
     * Constructor de la clase, inicializara la interfaz grafica, así como también se especifica el numero de puerto 
     * y el nombre del server.
     */
    public ClienteTriangulo(){
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 675, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		setTitle("Calculo del area de un triangulo");
		images=new ImageIcon("src/triangulo.png");
		
		
		JLabel lblimage = new JLabel();
		lblimage.setBounds(57,50,150,150);
		icono0 = new ImageIcon(images.getImage().getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_DEFAULT));
		lblimage.setIcon(icono0);
		contentPane.add(lblimage, BorderLayout.WEST);
		
	
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		Altura = new JLabel("Altura: ");
		Altura.setBounds(57, 114, 70, 15);
		panel.add(Altura);
		
		textAltura = new JTextField();
		textAltura.setBounds(145, 112, 114, 19);
		panel.add(textAltura);
		textAltura.setColumns(10);
		
		Base = new JLabel("Base: ");
		Base.setBounds(57, 145, 70, 15);
		panel.add(Base);
		
		textBase = new JTextField();
		textBase.setBounds(145, 143, 114, 19);
		panel.add(textBase);
		textBase.setColumns(10);
		
		btnEnvi = new JButton("Enviar");
		btnEnvi.setBounds(116, 203, 117, 25);
		btnEnvi.addActionListener(this);
		panel.add(btnEnvi);
		
		lblresultado = new JLabel("");
		lblresultado.setBounds(5, 10, 500, 100);
		lblresultado.setForeground(Color.black);
		lblresultado.setFont(new Font("FreeMono", Font.PLAIN, 13));
		panel.add(lblresultado);
		
		lblresArea = new JLabel();
		lblresArea.setBounds(68, 248, 190, 15);
		panel.add(lblresArea);
		
		lblresHipo = new JLabel();
		lblresHipo.setBounds(68, 275, 220, 15);
		panel.add(lblresHipo);
		
		setVisible(true);
		
		serverName = "localhost";
		port = 5001;                
		lblresultado.setText("Conectando al servidor: "+serverName+" en el puerto: "+port);

		try
		{
		/**
		 * @var client que sera un el cual se conectara al puerto especificado como parametro 	
		 */
		client = new Socket(serverName, port);                   
		System.out.println("Puerto Local : " + client.getLocalPort()); 
		lblresultado.setText("Conectado al Puerto Local: "+client.getLocalPort());//imprimira en pantalla el puerto local
		System.out.println("Puerto: " + client.getPort());            
		System.out.println("Just connected to " + client.getRemoteSocketAddress());

		}catch(IOException e)
		{
			e.printStackTrace();
		} 
              
		
	}
    
    /**
     * Metodo actionPerformed que sera el escucha a la hora de realizarse un evento, en este caso que el boton sea presionado 
     */
    public void actionPerformed(ActionEvent e){
		Object fun=e.getSource();               //se le asigna a la variable  fun el origen del evento
		if(fun == btnEnvi){                    //si el origen es igual al boton btnEnvi
			try{
			double baseenviar = Double.parseDouble(textBase.getText().trim());       //se le asigna a las variables baseenviar y alturaenviar lo introducido en el textefield
			double alturaenviar = Double.parseDouble(textAltura.getText().trim());  
			rightOutTri  = new RightTriangle(baseenviar,alturaenviar);
			
			outToServer = client.getOutputStream();            
			out = new ObjectOutputStream(outToServer);        //variable out que servira  para enviar el objeto al servidor
			
	        out.writeObject(rightOutTri);                  //envia al servidor el objeto rightOutTri
	        out.flush();
	            
		    inFromServer = client.getInputStream();        
			in = new ObjectInputStream(inFromServer);    //variable in que recibira desde  el servidor lo calculado en las otras clases
	            
	        rightInTri = (RightTriangle) in.readObject();    //el objeto ahora se almacenara en rightInTri
			 System.out.println("Base: " + rightInTri.getBase());
			 System.out.println(rightInTri.getAltura());
			 lblresArea.setText("El area es: "+rightInTri.getArea());
			 lblresHipo.setText("La hipotenusa: "+rightInTri.getHipotenusa());
			 System.out.println(rightInTri.getHipotenusa()+"\n");
			 System.out.println(rightInTri.area);
		}catch(IOException ex){
			
			} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
	}
    

	
	public static void main(String [] args)
	{
		ClienteTriangulo f=new ClienteTriangulo();
		f.setVisible(true);
		
		
}
}
