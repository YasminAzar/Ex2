package Test;

import static org.junit.Assert.*;
import org.junit.Test;

import Coords.MyCoords;
import Geom.Point3D;

public class MyCoordsTest {
	
	MyCoords coo= new MyCoords();

	@Test
	public void testAdd(){
		
		Point3D gps=new Point3D(32.103315,35.209039,670.0);
		Point3D local_vector_in_meter=new Point3D(337.698992061288,-359.249206938819,-20.0);
		
		
		Point3D New_Point=new Point3D (coo.add(gps, local_vector_in_meter));
		Point3D New_Point_exepted=new Point3D(32.106352 ,35.205808194261195 ,650.0);
		//System.out.println(New_Point.toString());
		//System.out.println(New_Point_exepted.toString());

		assertEquals(New_Point.toString(),New_Point_exepted.toString());
	
	}
	
	@Test
	public void testDistance3d() {
		Point3D gps0=new Point3D(32.103315,35.209039,670.0);
		Point3D gps1=new Point3D(32.106352 ,35.205808194261195 ,650.0);

		double dis=coo.distance3d(gps0, gps1);
		System.out.println("the dis in meter: "+dis);
		assertEquals(dis,"493.0523318");

	}
	
//	int a,b;
//	a=1;
//	b=1;
//	assertEquals(a,b);
	
	

}
