package GIS;

import Geom.Point3D;

public class My_meta_data implements Meta_data{
	
	@Override
	public long getUTC() {
		return System.currentTimeMillis();
	}

	@Override
	public Point3D get_Orientation() {
		return null;
	}

}