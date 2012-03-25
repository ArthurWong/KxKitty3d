package com.redwood.core.base;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;

import android.util.Log;

import com.redwood.materials.KxMaterial;

public class Face extends Element {

	public Face(KxVertex v0, KxVertex v1, KxVertex v2, KxMaterial mat) {
		if(_vers == null)
			_vers = new ArrayList<KxVertex>(3);
		_vers.add(v0);
		_vers.add(v1);
		_vers.add(v2);
		
		_mat = mat;
	}

	private FloatBuffer _vbuf;
	private ShortBuffer _ibuf;
	private final int VERTS = 3;
	
	public FloatBuffer vbuf()	{
		if(_vers == null || _vers.size() < 3)
			return null;
		
		KxVertex v;
		
		ByteBuffer vbb = ByteBuffer.allocateDirect(VERTS * 3 * 4);
		vbb.order(ByteOrder.nativeOrder());
		_vbuf = vbb.asFloatBuffer();
		Log.d("*************", Integer.toString(_vers.size()));
		for(int i = 0; i < _vers.size(); i++)
		{
			v = _vers.get(i);
			//Log.d("@@@@@@@@@@@@", Float.toString(v.x()));
			//Log.d("@@@@@@@@@@@@", Float.toString(v.y()));
			//Log.d("@@@@@@@@@@@@", Float.toString(v.z()));
			_vbuf.put(v.x());
			_vbuf.put(v.y());
			_vbuf.put(v.z());
		}
		_vbuf.position(0);
		
		return _vbuf;
	}
	
	public ShortBuffer ibuf()	{
		ByteBuffer ibb = ByteBuffer.allocateDirect(VERTS * 2);
		ibb.order(ByteOrder.nativeOrder());
		_ibuf = ibb.asShortBuffer();
		short[] indexs = {0, 1, 2};
		for(int i = 0; i < VERTS; i++)
			_ibuf.put(indexs[i]);
		_ibuf.position(0);
		
		return _ibuf;
	}
}
