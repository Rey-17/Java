import java.io.*;

/**
 * 
 * Clase Triangulo que hereda de la clase Poligono, en el cual se calcula el area y el poligono
 *
 */
public class Triangle extends Polygon implements Serializable
{
	/**
	 *  base: variable tipo double que sera la base
	 *  altura: variable tipo double que sera la altura
	 */
	public double base;   
	public double altura;
/**
 * Constructor de la clase Triangle que inicializa las variables base y altura
 * @param b parametro que recibe la base
 * @param h parametro que recibe la altura
 */
	public Triangle(double b, double h)
	{
		super(3);         //se le envia a poligono el numero de lados que es 3, ya que es un triangulo
		base = b;
		altura = h;
		System.out.println("Inside Triangle constructor");
	}

	public String toString()
	{
		return "Triangulo con  " + base + " and height " + altura;
	}

	public double getArea()            
	{
		
		return area;                 //devuelve el area
	}
	
	public double getBase()
	{
		
		return base;                 //devuelve la base
	}
	
	public double getAltura()
	{
		
		return altura;
	}
		
	public void calArea()
	{
		area = 0.5 * base * altura;              //se calcula el area
	}
	
	
}