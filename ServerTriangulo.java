import java.net.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.*;
/**
 * 
 * @author Reynaldo Villarreal
 * @author Eusebio Atencio
 * Clase ServerTriangulo que como su nombre lo indica sera el servidor el cúal recibirá el objeto para realizar las conexiones con las 
 * clases y realizara los calculos respectivos. Hereda de la clase Thread
 *
 */

public class ServerTriangulo extends Thread{
	private ServerSocket serverSocket;   //se crea el socket del servidor
	private ObjectInputStream in;         //se crea la entrada del objeto
    private RightTriangle triRect;         //se crea un valor tipo RightTriangle que hereda todos sus metodos
    
    private JTextArea textConex, textResu;
    public JFrame api;
    
   
	public ServerTriangulo(int port) throws IOException       
	{
		serverSocket = new ServerSocket(port);
		api = new JFrame("Servidor que realiza el calculo");
		api.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		api.setLayout(new GridLayout(1, 0, 0, 0));
		textConex=new JTextArea();
		textConex.setFont(new Font("FreeMono", Font.BOLD, 15));
		textConex.setBackground(Color.BLACK);
		textConex.setForeground(Color.green); 
		api.getContentPane().add(new JScrollPane(textConex));
		textResu = new JTextArea();
		textResu.setFont(new Font("FreeMono", Font.PLAIN, 16));
		api.getContentPane().add(new JScrollPane(textResu));
		api.setMinimumSize(new Dimension(800,300));
        api.setVisible(true);
	}

	public void run()
	{
		 System.out.println("Waiting for client on port: " + serverSocket.getLocalPort() + " ...");
		 textConex.append("Esperando por cliente en el puerto "+serverSocket.getLocalPort()+"...\n"); //se imprime en el textarea 
		 System.out.println("Dame el Objeto Triangulo Rectangulo...");
		 while(true){
		 try
			{
		 Socket server = serverSocket.accept();                  //se acepta la conexión del cliente
		 InetAddress clientAddress = server.getInetAddress();    //para acceder los datos del cliente
		 textConex.append(" \nNombre del host es: "+clientAddress.getHostName()+"\n"); //se imprimen el nombre del host
		 textConex.append(" \nDireccion IP: "+clientAddress.getHostAddress()+'\n');   //se imprime la dirección IP
		 
		 textConex.append("Esperando objeto para realizar el calculo\nde el area y la hipotenusa"); 
		// System.out.println("Si lo envias te calculo:");
		 //System.out.println("El area y la hipotenusa");
		 		

		 System.out.println("Puerto: " + server.getLocalPort());        
		 System.out.println("Puerto: " + server.getPort());
         System.out.println("Just connected to " + server.getRemoteSocketAddress());
		 in = new ObjectInputStream(server.getInputStream());  //se crea la variable in para los objetos de entrada desde el cliente        
		 
		 
		try
		{
          triRect = (RightTriangle)in.readObject();            //se crea la variable triRect donde se le asignara el objeto de entrada
          double base=triRect.base;                           //se le asigna a la variable base el valor de base desde el objeto
          double altura=triRect.altura;                      // se le asigna a altura el valor de la altura desde el objeto
          triRect.calArea();                                //se calcula el area
          triRect.calHipotenusa();                         //se calcula la hipotenusa
          double area=triRect.getArea();                  //se le asigna a area el valor calculado desde el area
          double hipo = triRect.getHipotenusa();         //se le asigna a hipo la hipotenusa calculada en el objeto
          textResu.append("Base Introducida: "+base); 
          textResu.append("\naltura: "+altura);
          textResu.append("\nEl area calculado es:\n"+area);
          textResu.append("\nLa hipotenusa es: \n"+hipo);
       
          }catch(IOException ex) 
           {
             	System.err.println(ex);
           } catch(ClassNotFoundException e) 
             {
             	System.err.println(e);
             } 
              
         
		ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());   
			
	    out.writeObject(triRect);     //se le envia al cliente el objeto
		out.flush();
			    
		out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");

		}catch(SocketTimeoutException s)
		{
		System.out.println("Socket timed out!");
		break;
	    }catch(IOException e)
		{
		 e.printStackTrace();
		 break;
		}
	}
	
  }

	public static void main(String [] args)
	{


      int port= 5001;    //se crea el puerto                                    
		try 
		{
			Thread t = new ServerTriangulo(port);     
			t.start();                            
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}