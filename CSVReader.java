package Algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 
 * base on https://github.com/mustafarasit/readFromFolder.git
 * @author Yasmin
 *
 */
public class CSVReader {
	public static void main(String[] args) {

		getFiles();

	}
	static LinkedList<Placemark> list =new LinkedList<Placemark>();

	static LinkedList<Placemark> getFiles() {

		String line = "";
		String cvsSplitBy = ",";
		String dirPath = "C:\\Users\\Yasmin\\eclipse-workspace\\Ex2\\FileCsv";
		//folder
		File dir = new File(dirPath);
		//Create file name array in folder
		String[] files = dir.list();
		if (files.length == 0) {
			System.out.println("The directory is empty");
		} else {
			//Writing file name
			for (String aFile : files) {
				System.out.println(aFile);
				try {
					FileInputStream fstream = new FileInputStream(dirPath + "/" + aFile);
					BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
					br.readLine();
					br.readLine();

					/* read log line by line */
					while ((line = br.readLine()) != null) {


						String[] userInfo = line.split(cvsSplitBy); //userInfo is an array of all the information in a row

						System.out.println("MAC: " + userInfo[0] + " , SSID: " + userInfo[1] +
								" ,AuthMode: " + userInfo[2] + " ,FirstSeen: " + " ,Channel: "+ userInfo[4]+
								" ,RSSI: "+userInfo[5]+" ,CurrentLatitude: "+userInfo[6]+" ,CurrentLongitude: "+userInfo[7]+
								" ,AltitudeMeters: "+userInfo[8]+" ,AccuracyMeters: "+userInfo[9]+" ,Type: "+userInfo[10]);

						String description= "MAC: " + userInfo[0] + " , SSID: " + userInfo[1] +
								" ,AuthMode: " + userInfo[2] + " ,FirstSeen: " + " ,Channel: "+ userInfo[4]+
								" ,RSSI: "+userInfo[5];
						String name="Name: "+ userInfo[1];
						Point point=new Point();
						double latitude=Double.parseDouble(userInfo[6]);
						double longitude=Double.parseDouble(userInfo[7]);

						point.setLatitude(latitude);
						point.setLongitude(longitude);
						Placemark placemark =new Placemark();
						placemark.setDescription(description);
						placemark.setName(name);
						placemark.setPoint(point);

						list.add(placemark);

						fstream.close();

					} 
				}
				catch (Exception e) {
					System.err.println("Error: " + e.getMessage());
				}
			}
		}
		return list;
	}
}
