//import java.io.File;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class CheckEmail 
//{
//	//must have @
//	//must have .com 
//	//
//
//
//	//global variabales
//	public String number;
//	public void checkHeader()
//	{
//		System.out.println("What is the name of the file that has Card# header list you would like to check?");
//		Scanner scanner = new Scanner(System.in);
//		String file = scanner.nextLine();
//		scanner = new Scanner(new File(file));
//
//	}
//
//
//	public void readFile() throws IOException
//	{
//		System.out.println("What is the name of the file that has Card# header list you would like to check?");
//		Scanner scanner = new Scanner(System.in);
//		String file = scanner.nextLine();
//		scanner = new Scanner(new File(file));
//		//scanner = new Scanner(new File("CardNumbers.txt"));
//
//
//		if(scanner.next()== "Card Number")
//		{
//			//String [] tall = new String [100];
//			int i = 1;
//			while(scanner.hasNext())
//			{
//				//scanner.next();
//				//tall[i++] = scanner.next();
//				number= scanner.next();
//				checkCard(number);
//				// return number;
//			}
//			//return number;
//		}
//	}
//
//
//
//	//get this card from opening the file and getting the first input 
//	public void checkCard(String card ) 
//	{
//		//String returnedNumber= readFile();
//		int length= number.length();
//
//		//check length of card number 
//		if(length > 5 && length <20)
//		{
//			if(isNumeric(number))
//			{
//				//System.out.println("card: " + number + "is valid " );
//				return;
//
//			}
//			else
//			{
//				System.out.println("Card: " + number + " is not a number ");
//				return;
//			}
//		}
//		else 
//		{
//			System.out.println("Card: " + number + " is the incorrect length ");
//			return;
//		}
//	}
//
//	public static boolean isNumeric(String str)
//	{
//		for (char c : str.toCharArray())
//		{
//			if (!Character.isDigit(c)) return false;
//		}
//		return true;
//	}
//
//
//
//
//}
//
//
//
//
//
