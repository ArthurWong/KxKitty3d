package com.redwood.core.base;

import java.util.ArrayList;

import com.redwood.materials.KxMaterial;

public class Segment extends Element {

	public Segment(KxVertex v0, KxVertex v1, KxMaterial mat) {
		if(_vers == null)
			_vers = new ArrayList<KxVertex>(2);
		_vers.add(v0);
		_vers.add(v1);
		
		_mat = mat;
	}

}
