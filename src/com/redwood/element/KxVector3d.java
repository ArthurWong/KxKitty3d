package com.redwood.element;

public class KxVector3d {

	private float _x;
	private float _y;
	private float _z;
	
	public KxVector3d() {
		set_x(0f);
		set_y(0f);
		set_z(0f);
	}

	public KxVector3d(float x, float y, float z)	{
		set_x(x);
		set_y(y);
		set_z(z);
	}

	//gs
	public void set_x(float _x) {
		this._x = _x;
	}

	public float get_x() {
		return _x;
	}

	public void set_y(float _y) {
		this._y = _y;
	}

	public float get_y() {
		return _y;
	}

	public void set_z(float _z) {
		this._z = _z;
	}

	public float get_z() {
		return _z;
	}
}
