package com.redwood.core;

import java.util.ArrayList;

import com.redwood.element.KxVector3d;

public abstract class KxMesh extends KxObject3d {
	
	public KxMesh() {
		super();
		_name = "KxMesh";
	}
	
	//op
	public void buildPrimitive()	{
		return;
	}
}
