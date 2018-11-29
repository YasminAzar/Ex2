package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Csv2kml {

	public static void main(String[] args) throws IOException
	{

		String csvFile = "data1.csv";
		String line = "";
		String cvsSplitBy = ",";
		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+ 
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n");

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
		{
			br.readLine();
			br.readLine();

			while ((line = br.readLine()) != null) 
			{
				String[] userInfo = line.split(cvsSplitBy);

				System.out.println("MAC: " + userInfo[0] + " , SSID: " + userInfo[1] +
						" ,AuthMode: " + userInfo[2] + " ,FirstSeen: " + " ,Channel: "+ userInfo[4]+
						" ,RSSI: "+userInfo[5]+" ,CurrentLatitude: "+userInfo[6]+" ,CurrentLongitude: "+userInfo[7]+
						" ,AltitudeMeters: "+userInfo[8]+" ,AccuracyMeters: "+userInfo[9]+" ,Type: "+userInfo[10]);
			}

		} catch (IOException e) 
		{
			e.printStackTrace();
		}

		String fileName = "data1.kml";
		String kmlstart="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+ 
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n";
		PrintWriter pw =null;
		File kmlFile=new File(fileName);

		String kmlend="</kml>";
		String kmldoc="<Document>";
		String sb1 = new String();
		

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
}
