package com.redwood.core;

import com.redwood.element.KxVector3d;
import com.redwood.session.KxAbstractSession;

public abstract class KxObject3d {
	private static int _idCount = 0;
	protected int _id;
	protected String _name;
	protected KxVector3d _pos;
	
	public KxObject3d()	{
		_idCount += 1;
		_id = _idCount;
		_name = "KxObject3d";
		_pos = new KxVector3d();
	}
	
	public void renderMe(KxAbstractSession s)	{	}
	
	//gs
	public void setPos(float x, float y, float z)	{
		_pos.set_x(x);
		_pos.set_y(y);
		_pos.set_z(z);
	}
	
	public int getId()	{
		return _id;
	}
	
	public String getName()	{
		return _name;
	}
}
