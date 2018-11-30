package GIS;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;
import GIS.Meta_data;

public class My_GIS_element implements GIS_element {

	Point3D p=new Point3D();
	MyCoords coo=new MyCoords();
	Meta_data meta=new My_meta_data();
	
	/**
	 *@return the point 
	 */
	@Override
	public Geom_element getGeom() {
		return this.p;
	}
	
	/**
	 * the meta data returns the element creation time - The UTC
	 *@return the data from the meta data 
	 */
	@Override
	public Meta_data getData() {
		return meta ;
	}

	/**
	 *@return Returns the transition of this point to the next point by adding a vector 
	 */
	@Override
	public void translate(Point3D vec) {
		Point3D ans=coo.add(p, vec);		
		System.out.println(ans.toString());
	}

}
