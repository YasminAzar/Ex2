import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.*;

import Algorithms.CSVReader;
import Algorithms.Document;
import Algorithms.Placemark;
import Algorithms.Point;

public class Main {

	public static void main(String[] args) throws JAXBException {
		
		Point p1= new Point();
		p1.setLatitude(35.21138319);		
		p1.setLongitude(32.10423611);
		
		Point p2= new Point();
		p2.setLatitude(35.21138319);
		p1.setLongitude(32.10423611);
		
		
		Placemark placemark1=new Placemark();
		placemark1.setName("Ariel_University1");
		placemark1.setPoint(p1);
		placemark1.setDescription("bla");
		
		Placemark placemark2=new Placemark();
		placemark2.setName("Ariel_University2");
		placemark2.setPoint(p2);
		placemark2.setDescription("bla");
		
		Document doc=new Document();
		Document doc1=new Document();
		CSVReader readcsv=new CSVReader();

		LinkedList<Placemark> list =new LinkedList<Placemark>();
		CSVReader list1 =new CSVReader();
		

		list.add(placemark1);
		list.add(placemark2);
		
		doc.setPlacemarks(list);
		doc1.setPlacemarks(list1);


		JAXBContext context = JAXBContext.newInstance(Document.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		m.marshal(doc, System.out);
		m.marshal(doc, new File("doc.kml"));

	}

}
