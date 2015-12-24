import java.io.*;
/**
 * Clase Polygon que recibe los lados
 *
 */
public class Polygon implements Serializable
{
	
	public int sides;
	public double area;
/**
 * Constructor Polygon que le asigna el lado recibido del cliente
 * @param sides que inicializa los lados
 */
	public Polygon(int sides)
	{
		this.sides = sides;  //inicializa los lados
		System.out.println("Inside Polygon constructor");
	}
/**
 * Metodo getNumberOfSides
 * @return devuelve el número de lados
 */
	public int getNumberOfSides()
	{
		return sides;   //devuelve el numero de lados
	}
/**
 * @return devuelve una cadena declarando los lados
 */
	public String toString()
	{
		return "Polygono que devuelve: " + sides + " sides ";
	}	
}