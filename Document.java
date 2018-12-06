package Algorithms;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Document
{
	private Collection<Placemark> placemarks;

	@XmlElement 
	public Collection<Placemark> getPlacemarks() {
		return placemarks;
	}

	public void setPlacemarks(Collection<Placemark> placemarks) {
		this.placemarks = placemarks;
	}

//	@XmlElement 
//	public Collection<Placemark> getPlacemarks() {
//		return placemarks;
//	}
//
//	public void setPlacemarks(Collection<Placemark> placemarks) {
//		this.placemarks = placemarks;
//	}
}
