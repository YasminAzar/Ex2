package Algorithms;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Point {

	private double latitude;
    private double longitude;
    
    @XmlElement 
    public double getLatitude() {
        return latitude;
    }
    
    public void setLatitude(double Latitude) {
        this.latitude = Latitude;
    }
    
    
    @XmlElement 
    public double getLongitude() {
        return longitude;
    }
    
    public void setLongitude(double Longitude) {
        this.longitude = Longitude;
    }
}
