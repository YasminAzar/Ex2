package Algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVWriter 
{
	public static void main(String[] args) throws IOException
	{
		CSVReader readCSV=new CSVReader();
		readCSV.getFiles();
		File f=new File("FileCsv");
		if(f.isDirectory())
		{
			
		}
		String csvFile="FileCsv";
		String line = "";
		String cvsSplitBy = ",";
		String fileName = "data1.kml"; //write to this file
		String kmlstart="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+ 
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n";
		PrintWriter pw =null;
		File kmlFile=new File(fileName);

		String kmlend="</kml>";
		String kmldoc="<Document>";
		String sb1 = new String();

		//try and catch for the writing part
		try 
		{
			pw = new PrintWriter(kmlFile);
			pw.write(kmlstart.toString());
			pw.write(kmldoc.toString());

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			br.readLine();
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] userInfo = line.split(cvsSplitBy);

				sb1="<Placemark>"+"<name>"+ userInfo[1] +"</name>"+"<description>" +" FirstSeen: "+userInfo[3] +"<br />"+
						" ,Channel: " + userInfo[4] + 
						" ,Type: "+userInfo[10]+"</description> "+"<Point>"+"<coordinates>"+userInfo[7]+" "+userInfo[6]+" "+userInfo[8]+
						"</coordinates>"+"</Point>"+"</Placemark>";


				pw.write(sb1.toString());
				pw.write("\n");

			} 
			pw.write("</Document>");
			pw.write("\n");

			pw.write(kmlend.toString());
			pw.close();
			System.out.println("done!");
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
	}
//		ArrayList<String> content = new ArrayList<String>();
//		String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n";
//		content.add(kmlstart);
//		
//		String fileName = "data1.kml";
//		PrintWriter pw = null;
//		String csvFile = "data1.csv";
//        String line = "";
//        String cvsSplitBy = ",";
//        String fileName1 = "data1.kml"; //write to this file
//		String kmlstart1="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+ 
//				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n";
//		PrintWriter pw1 =null;
//		File kmlFile=new File(fileName1);
//		
//
//		String kmlend="</kml>";
//		String kmldoc="<Document>";
//		String sb1 = new String();
//		try 
//		{
//			pw1 = new PrintWriter(kmlFile);
//			pw1.write(kmlstart1.toString());
//			pw1.write(kmldoc.toString());
//
//			@SuppressWarnings("resource")
//			BufferedReader br = new BufferedReader(new FileReader(csvFile));
//			br.readLine();
//			br.readLine();
//			while ((line = br.readLine()) != null) {
//
//				String[] userInfo = line.split(cvsSplitBy);
//
//				sb1="<Placemark>"+"<name>"+ userInfo[1] +"</name>"+"<description>" +" FirstSeen: "+userInfo[3] +"<br />"+
//						" ,Channel: " + userInfo[4] + 
//						" ,Type: "+userInfo[10]+"</description> "+"<Point>"+"<coordinates>"+userInfo[7]+" "+userInfo[6]+" "+userInfo[8]+
//						"</coordinates>"+"</Point>"+"</Placemark>";
//
//
//				pw1.write(sb1.toString());
//				pw1.write("\n");
//
//			} 
//			pw1.write("</Document>");
//			pw1.write("\n");
//
//			pw1.write(kmlend.toString());
//			pw1.close();
//			System.out.println("done!");
//		}
//		catch (FileNotFoundException e) 
//		{
//			e.printStackTrace();
//			return;
//		}
	}


