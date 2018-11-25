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
		System.out.println(New_Point.toString());
		System.out.println(New_Point_exepted.toString());

		assertEquals(New_Point.toString(),New_Point_exepted.toString());
	}
	
	@Test
	public void testDistance3d() {
		Point3D gps0=new Point3D(32.103315,35.209039,670.0);
		Point3D gps1=new Point3D(32.106352 ,35.205225 ,650.0);

		double dis=coo.distance3d(gps0, gps1);
		
		System.out.println("the dis in meter: "+dis);
		double exepted= 493.052331;
		assertEquals(dis,exepted,0.000001);
	}
	
	@Test
	public void testVector3D() {
		Point3D gps0=new Point3D(32.103315,35.209039,670.0);
		Point3D gps1=new Point3D(32.106352 ,35.205225 ,650.0);

		Point3D Vector3D=coo.vector3D(gps1, gps0);
		System.out.println("the Vector3D in meter: "+Vector3D.toString());
		Point3D expected_point= new Point3D(337.6989920612287,-359.237259725745,-20.0);
		assertEquals(Vector3D.toString(),expected_point.toString());
	}
	
	@Test
	public void azimuth_elevation_dist() {
		Point3D gps0=new Point3D(32.10332,35.20904,670.0);
		Point3D gps1=new Point3D(32.10635 ,35.20523 ,650.0);
		double [] azimuth_elevation_dist= coo.azimuth_elevation_dist(gps0, gps1);
		double [] expected_r= {313.2229,-2.3291,242304.92274834221};
		System.out.println("the azimuth_elevation_dist in polar coordinate: ["+azimuth_elevation_dist[0]+", "+azimuth_elevation_dist[1]+", "+azimuth_elevation_dist[2]+"]");

//		assertTrue(azimuth_elevation_dist.toString().equals(expected_r.toString()));
		assertEquals(azimuth_elevation_dist[0],expected_r[0],0.1);
		assertEquals(azimuth_elevation_dist[1],expected_r[1],0.1);
		assertEquals(azimuth_elevation_dist[2],expected_r[2],0.1);

//		assertEquals(azimuth_elevation_dist.toString().valueOf(1),expected_r.toString().valueOf(1));
//		assertEquals(azimuth_elevation_dist.toString().valueOf(2),expected_r.toString().valueOf(2));

	}
	

	@Test
	public void isValid_GPS_Point() {
		Point3D gps0=new Point3D(32.103315,35.209039,670.0);
		assertTrue(coo.isValid_GPS_Point(gps0));
		
	}

}
