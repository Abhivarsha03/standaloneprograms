import java.text.NumberFormat;
import java.util.Scanner;

class NegativeNumException extends Exception
{
	public NegativeNumException(String message)
	{
		super(message);
	}
}

public class Converter
{

public static String[] units = { "Zero", "One", "Two", "Three", "Four",
"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
"Eighteen", "Nineteen" };

public static String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety" };

public static String convert(int n)
{
	if (n < 20) 
	{
		return units[n];
	}

	if (n < 100) 
	{
		return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
	}

	if (n < 1000) 
	{
		return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
	}

	if (n < 100000) 
	{
		return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
	}

	if (n < 10000000) 
	{
		return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
	}	
	return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
}

public static void main(String[] args)throws Exception
{
	int n;
	Scanner s=new Scanner(System.in);
    System.out.println("Enter a number:");
	n =s.nextInt();
	try 
	{	
		if(n<0)
		{
			throw new NegativeNumException("Enter positive numbers only:");
		}
	}
	catch(NegativeNumException e)
	{
		System.out.println(e.getMessage());
	}
	System.out.println(convert(n) + " ");
	
}
}