package Algorithms;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Placemark {
	
	private String name;
    private String description;
    private Point point;

	@XmlElement 
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    @XmlElement 
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @XmlElement 
    public Point getPoint() {
        return point;
    }
    
    public void setPoint(Point point) {
        this.point = point;
    }


}
