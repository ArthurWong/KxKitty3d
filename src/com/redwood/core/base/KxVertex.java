package com.redwood.core.base;

public class KxVertex extends KxValueObject {

	public KxVertex() {
		_coor[0] = _coor[1] = _coor[2] = 0;
	}
	
	public KxVertex(float x, float y, float z)	{
		_coor[0] = x;
		_coor[1] = y;
		_coor[2] = z;
	}

	//¼ÇÂ¼×ø±ê
	private float _coor[] = new float[3];

	//gs
	public void setX(float value)	{
		_coor[0] = value;
	}
	public void setY(float value)	{
		_coor[1] = value;
	}
	public void setZ(float value)	{
		_coor[2] = value;
	}
	
	public float x()	{	return _coor[0];	}
	public float y()	{	return _coor[1];	}
	public float z()	{	return _coor[2];	}
}