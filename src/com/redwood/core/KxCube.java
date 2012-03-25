package com.redwood.core;

import java.util.ArrayList;
import com.redwood.core.base.Face;
import com.redwood.core.base.KxVertex;
import com.redwood.element.KxVector3d;
import com.redwood.materials.KxMaterial;
import com.redwood.session.KxAbstractSession;

public class KxCube extends KxAbstractPrimitive {

	private final int MAX_SEGMENTS = 10;
	private int _segmentsW;
	private int _segmentsH;
	private int _segmentsD;
	
	private float _width;
	private float _height;
	private float _depth;
	
	private boolean _edge;
	
	private ArrayList<KxVertex> _varr;
	private KxMaterial _mat;
	private ArrayList<Face> _farr;
	
	public KxCube() {
		super();
		init();
	}
	
	public KxCube(float w, float h, float d)	{
		super();
		init();
		_width = w;
		_height = h;
		_depth = d;
	}
	
	//op
	@Override
	protected void init() {
		super.init();
		_name = "KxCube";
		
		_segmentsW = 1;
		_segmentsH = 1;
		_segmentsD = 1;
		
		_width = 0;
		_height = 0;
		_depth = 0;
		
		_varr = new ArrayList<KxVertex>();
		_farr = new ArrayList<Face>();
	}

	@Override
	public void buildPrimitive() {
		super.buildPrimitive();
		
		if(_varr != null && _varr.size() > 0)
		{
			_varr.clear();
		}
		
		if(_farr != null && _farr.size() > 0)
		{
			_farr.clear();
		}
		
		int i = 0;
		int j = 0;
		
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int inc = 0;
		
		
		
		for (i = 0; i <= _segmentsW; i++) {
			for (j = 0; j <= _segmentsH; j++) {
				_edge = (i == 0 || i == _segmentsW || j == 0 || j == _segmentsH);
				
				//create front/back
				_varr.add( makeVertex(_width/2 - i*_width/_segmentsW, _height/2 - j*_height/_segmentsH, -_depth/2) );
				_varr.add( makeVertex(_width/2 - i*_width/_segmentsW, _height/2 - j*_height/_segmentsH, _depth/2) );
				
				if (i > 0 && j > 0) {
					a = 2*((_segmentsH+1)*i + j);
					b = 2*((_segmentsH+1)*i + j - 1);
					c = 2*((_segmentsH+1)*(i - 1) + j - 1);
					d = 2*((_segmentsH+1)*(i - 1) + j);

					buildFaces(a, b, c, d, _mat, false);
					buildFaces(a+1, b+1, c+1, d+1, _mat, true);
				}
			}
		}

		inc += 2*(_segmentsW + 1)*(_segmentsH + 1);
		
		for (i = 0; i <= _segmentsW; i++) {
			for (j = 0; j <= _segmentsD; j++) {
				_edge = (i == 0 || i == _segmentsW || j == 0 || j == _segmentsD);
				
				//create top/bottom
				_varr.add( makeVertex(_width/2 - i*_width/_segmentsW, -_height/2, -_depth/2 + j*_depth/_segmentsD) );
				_varr.add( makeVertex(_width/2 - i*_width/_segmentsW, _height/2, -_depth/2 + j*_depth/_segmentsD) );
				
				if (i > 0 && j > 0) {
					a = inc + 2*((_segmentsD + 1)*i + j);
					b = inc + 2*((_segmentsD + 1)*i + j - 1);
					c = inc + 2*((_segmentsD + 1)*(i - 1) + j - 1);
					d = inc + 2*((_segmentsD + 1)*(i - 1) + j);
					
					buildFaces(a, b, c, d, _mat, false);
					buildFaces(a+1, b+1, c+1, d+1, _mat, true);
				}
			}
		}
		
		inc += 2*(_segmentsW + 1)*(_segmentsD + 1);
		
		for (i = 0; i <= _segmentsH; i++) {
			for (j = 0; j <= _segmentsD; j++) {
				_edge = (i == 0 || i == _segmentsH || j == 0 || j == _segmentsD);
				
				//create left/right
				_varr.add( makeVertex(_width/2, _height/2 - i*_height/_segmentsH, -_depth/2 + j*_depth/_segmentsD) );
				_varr.add( makeVertex(-_width/2, _height/2 - i*_height/_segmentsH, -_depth/2 + j*_depth/_segmentsD) );
				
				if (i > 0 && j > 0) {
					a = inc + 2*((_segmentsD + 1)*i + j);
					b = inc + 2*((_segmentsD + 1)*i + j - 1);
					c = inc + 2*((_segmentsD + 1)*(i - 1) + j - 1);
					d = inc + 2*((_segmentsD + 1)*(i - 1) + j);
					
					buildFaces(a, b, c, d, _mat, false);
					buildFaces(a+1, b+1, c+1, d+1, _mat, true);
				}
			}
		}
	}
	
	private KxVertex makeVertex(float x, float y, float z)	{
		return new KxVertex(x + _pos.get_x(), y + _pos.get_y(), z + _pos.get_z());
	}
	
	private void buildFaces(int a, int b, int c, int d, KxMaterial mat, boolean back) {
		KxVertex va = _varr.get(a);
		KxVertex vb = _varr.get(b);
		KxVertex vc = _varr.get(c);
		KxVertex vd = _varr.get(d);
		
		if(back){
			addFace(createFace(va,vb,vc, mat));
			addFace(createFace(va,vc,vd, mat));
		}else{
			addFace(createFace(vb,va,vc, mat));
			addFace(createFace(vc,va,vd, mat));						
		}
	}
	
	protected void addFace(Face f)	{
		_farr.add(f);
	}
	
	public void renderMe(KxAbstractSession s)	{
		for(int i = 0; i < _farr.size(); i++)
		{
			s.drawFace(_farr.get(i));
			//throw new Error("##########");
		}
	}
	
	//gs
	public void setSegmentsW(int value)	{
		if(value > MAX_SEGMENTS)	{
			value = MAX_SEGMENTS;
		}
		_segmentsW = value;
		setIsDirty(true);
	}
	
	public void setSegmentsH(int value)	{
		if(value > MAX_SEGMENTS)	{
			value = MAX_SEGMENTS;
		}
		_segmentsH = value;
		setIsDirty(true);
	}
	
	public void setSegmentsD(int value)	{
		if(value > MAX_SEGMENTS)	{
			value = MAX_SEGMENTS;
		}
		_segmentsD = value;
		setIsDirty(true);
	}
	
	public void setWidth(float w)	{
		_width = w;
		setIsDirty(true);
	}
	
	public void setHeight(float h)	{
		_height = h;
		setIsDirty(true);
	}
	
	public void setDepth(float d)	{
		_depth = d;
		setIsDirty(true);
	}
	
	public void setMaterial(KxMaterial mat)	{
		_mat = mat;
	}
	
	public KxMaterial mat()	{	return _mat;	}
}
