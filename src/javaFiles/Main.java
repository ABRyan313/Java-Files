package javaFiles;
import java.util.*;
import java.io.*;

public class Main {
	
	private static Random rand = new Random();

	public static void main(String[] args) {
		
		test1();
		test2();

	}
	
	private static String createLine() {
		String line = " " + rand.nextInt(100);
		for(int i = 0, n = rand.nextInt(10); i < n; ++i)
			line += ";" + rand.nextInt(100);
		return line;
	}
	
	private static void test1() {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Number"));
			for(int i = 0; i < 10; ++i) {
				writer.write(createLine());
				writer.newLine();
			}
			
			writer.close();
				
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static int parseLine(String line) {
		int sum = 0;
		String [] elements = line.split(";");
		for(String elems : elements )
			sum += Integer.parseInt(elems);
		return sum;
	}
	
	private static void test2() {
		try {
			int sum = 0;
			BufferedReader reader = new BufferedReader(new FileReader("Number"));
			for(String line = reader.readLine(); line != null; reader.readLine())
				sum += parseLine(line);
			
			reader.close();
			System.out.println(sum);
		}
		catch(Exception Ex) {
			System.out.println(Ex);
		}
	}

}
