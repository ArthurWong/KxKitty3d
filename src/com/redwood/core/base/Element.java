package com.redwood.core.base;

import java.util.ArrayList;

import com.redwood.materials.KxMaterial;

public class Element {
	protected ArrayList<KxVertex> _vers;
	protected KxMaterial _mat;
	
	//gs
	public KxMaterial mat()	{
		return _mat;
	}
	
	public ArrayList<KxVertex> vertices()	{
		return _vers;
	}
}
