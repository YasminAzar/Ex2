package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter {
	
	public MyCoords(){}
	

	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		
		double a,b,c,d;
		
		a=Math.asin(local_vector_in_meter.x()/6371000);
		b=Math.asin(local_vector_in_meter.y()/6371000);

		System.out.println(a);
		System.out.println(b);

		c=Math.toDegrees(a);
		d=Math.toDegrees(b);
		System.out.println(c);
		System.out.println(d);

		Point3D local_vector_in_degrees= new Point3D(c,d,local_vector_in_meter.z());
		gps.add(local_vector_in_degrees);
		Point3D New_Point= new Point3D(gps.x(),gps.y(),gps.z());
		return New_Point;	
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		Point3D gps0_in_radian= new Point3D(Math.toRadians(gps0.x()),Math.toRadians(gps0.y()),0);
		Point3D gps1_in_radian= new Point3D(Math.toRadians(gps1.x()),Math.toRadians(gps1.y()),0);
		System.out.println(gps0_in_radian.toString());
		System.out.println(gps1_in_radian.toString());

		
		Point3D gps0_in_meter= new Point3D(Math.sin(gps0.x()*6371000),Math.sin(gps0.y()*6371000*0.847091174),0);
		Point3D gps1_in_meter= new Point3D(Math.sin(gps1.x()*6371000),Math.sin(gps1.y()*6371000*0.847091174),0);
		System.out.println(gps0_in_meter.toString());
		System.out.println(gps1_in_meter.toString());
		
		double dis=gps0_in_meter.distance3D(gps1_in_meter);
		
	
		return dis;
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
