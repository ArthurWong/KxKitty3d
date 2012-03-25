package com.redwood.core;

import java.util.ArrayList;

import com.redwood.session.KxAbstractSession;

public class KxObjectContainer3d extends KxMesh {

	protected ArrayList<KxObject3d> _children;
	
	public KxObjectContainer3d() {
		super();
		_name = "KxObjectContainer";
		_children = new ArrayList<KxObject3d>();
	}
	
	//op
	public void addChild(KxObject3d child)	{
		KxAbstractPrimitive prim;
		if(child instanceof KxAbstractPrimitive)
		{
			prim = (KxAbstractPrimitive)child;
			prim.buildPrimitive();
		}
		
		_children.add(child);
	}
	
	public void renderMe(KxAbstractSession s)	{
		if(_children != null)
		{
			KxObject3d o;
			for(int i = 0; i < _children.size(); i++)
			{
				o = _children.get(i);
				o.renderMe(s);
			}
		}
	}

	//g
	public KxObject3d getChildAt(int index)	{
		return _children.get(index);
	}
	
	public ArrayList<KxObject3d> getChildren()	{
		return _children;
	}
}
