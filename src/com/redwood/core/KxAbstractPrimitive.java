package com.redwood.core;

import com.redwood.core.base.Face;
import com.redwood.core.base.KxVertex;
import com.redwood.materials.KxMaterial;

public abstract class KxAbstractPrimitive extends KxMesh {
	protected boolean _isDirty;
	
	public KxAbstractPrimitive() {
		// TODO Auto-generated constructor stub
		super();
		_name = "KxAbstractPrimitive";
		setIsDirty(true);
		init();
	}
	
	protected void init()	{
		return;
	}
	
	protected Face createFace(KxVertex v0, KxVertex v1, KxVertex v2, KxMaterial mat)	{
		return new Face(v0, v1, v2, mat);
	}
	
	//gs
	public void setIsDirty(boolean value)	{
		_isDirty = value;
	}
	
	public boolean getIsDirty()	{
		return _isDirty;
	}
}
