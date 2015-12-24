import java.io.*;

/**
 * Clase RightTriangle que hereda de Triangle el cual calcula la hipotenusa
 *
 */
public class RightTriangle extends Triangle implements Serializable   //la clase RightTriangle hereda de la clase Triangle
{
	/**
	 *  variable hipotenusa que tendra el valor del calculo de la hipotenusa 
	 */
	public double hipotenusa;                   

	/**
	 * Constructor RightTriangle que recibe la base y altura y la envia por medio de super a la clase padre Polygon
	 * @param base recibe la base enviada por el cliente
	 * @param height recibe la altura enviada del cliente  
	 */
	public RightTriangle(double base, double height)              //el constructor el cual recibe la base y la altura
	{
		super(base, height);
		
		System.out.println("Inside RightTriangle constructor");
	}

	public String toString()
	{
		return super.toString() + " and hypotenuse " + hipotenusa;
	}
	
	public void calHipotenusa()	
	{
	hipotenusa = Math.sqrt((base * base) + (altura * altura));	 //Se calcula la hipotenusa
	}
	
	public double getHipotenusa()	
	{
    return 	hipotenusa;	                 //devuelve la hipotenusa
	}
	
}