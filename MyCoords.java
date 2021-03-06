package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter {

	public MyCoords(){}

	/**
	 * @param point in degrees and points in meters
	 * @return the new point created by adding the point in meters
	 */
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {

		double a,b,c,d;

		a=Math.asin(local_vector_in_meter.x()/6371000);
		b=Math.asin(local_vector_in_meter.y()/6371000);

		//		System.out.println(a);
		//		System.out.println(b);

		c=Math.toDegrees(a);
		d=Math.toDegrees(b);
		//		System.out.println(c);
		//		System.out.println(d);

		Point3D local_vector_in_degrees= new Point3D(c,d,local_vector_in_meter.z());
		gps.add(local_vector_in_degrees);
		Point3D New_Point= new Point3D(gps.x(),gps.y(),gps.z());
		return New_Point;	
	}

	/**
	 * @param two points in degrees
	 * @return the distance between the two points
	 */
	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {

		double R=6371000; //Radios of earth in meter
		double Lon_Norm=Math.cos(Math.toRadians(gps0.x()));
		;
		double disLat=(gps0.x()*Math.PI/180)-(gps1.x()*Math.PI/180);
		double disLon=(gps0.y()*Math.PI/180)-(gps1.y()*Math.PI/180);
		//		System.out.println("The disLat is: "+disLat);
		//		System.out.println("The disLon is: "+disLon);
		double disLat_in_meter=Math.sin(disLat)*R;
		double disLon_in_meter=Math.sin(disLon)*R*Lon_Norm;
		//		System.out.println("The disLat_in_meter is: "+disLat_in_meter);
		//		System.out.println("The disLon_in_meter is: "+disLon_in_meter);
		double dis=Math.sqrt(disLat_in_meter*disLat_in_meter+disLon_in_meter*disLon_in_meter);
		return dis;
	}

	/**
	 * @param two points in degrees
	 * @return the vector between the two points
	 */
	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		float R=6371000; //Radios of earth in meter
		double Lon_Norm=Math.cos(Math.toRadians(gps0.x()));
		double disLat=(gps0.x()*Math.PI/180)-(gps1.x()*Math.PI/180);
		double disLon=(gps0.y()*Math.PI/180)-(gps1.y()*Math.PI/180);
		//		System.out.println("The disLat is: "+disLat);
		//		System.out.println("The disLon is: "+disLon);
		double disLat_in_meter=Math.sin(disLat)*R;
		double disLon_in_meter=Math.sin(disLon)*R*Lon_Norm;
		double disAlt_in_meter=gps0.z()-gps1.z();
		System.out.println("The disLat_in_meter is: "+disLat_in_meter);
		System.out.println("The disLon_in_meter is: "+disLon_in_meter);

		Point3D vector3D=new Point3D(disLat_in_meter,disLon_in_meter,disAlt_in_meter);
		return vector3D;
	}

	/**
	 * @param two points in degrees
	 * @return the azimuth,elevation and distance between the two points 
	 */
	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {

		float R=6371000; //Radios of earth in meter
		double Lon_Norm=Math.cos(Math.toRadians(gps0.x()));
		double disLat=(gps1.x()*Math.PI/180)-(gps0.x()*Math.PI/180);
		double disLon=(gps1.y()*Math.PI/180)-(gps0.y()*Math.PI/180);
		//		System.out.println("The disLat is: "+disLat);
		//		System.out.println("The disLon is: "+disLon);
		double disLat_in_meter=Math.sin(disLat)*R;
		double disLon_in_meter=Math.sin(disLon)*R*Lon_Norm;
		double azimuth=0;

		azimuth=Math.atan(disLon_in_meter/disLat_in_meter);
		azimuth=Math.toDegrees(azimuth);
		if(disLat_in_meter<0) azimuth=180-azimuth;
		if(disLat_in_meter<0 && disLon_in_meter<0) azimuth=180+azimuth;
		if(disLon_in_meter<0) azimuth=360+azimuth;
		System.out.println("The azimuth angel is: "+azimuth);

		double dz=gps1.z()-gps0.z();
		double elevation_in_rad=Math.atan(dz/distance3d(gps0,gps1));
		double elevation_in_deg=Math.toDegrees(elevation_in_rad);
		System.out.println("The elevation angel is: "+elevation_in_deg);

		double dxy=distance3d(gps0,gps1)*distance3d(gps0,gps1);
		double dist=Math.sqrt(dxy*dxy+dz*dz);
		System.out.println("The distance is: "+dist);

		double [] azimuth_elevation_dist= {azimuth,elevation_in_deg,dist};

		return azimuth_elevation_dist;
	}

	/**
	 * @param one point in degrees
	 * @return true if the point is valid
	 */
	@Override
	public boolean isValid_GPS_Point(Point3D p) {

		boolean isValid=true;
		double inf = Double.POSITIVE_INFINITY;

		if(p.x()<-180||p.x()>180)
			isValid=false;
		if(p.y()<-90||p.y()>90)
			isValid=false;
		if(p.y()<-450||p.y()>inf)
			isValid=false;

		return isValid;
	}


}
