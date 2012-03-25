package com.redwood.session;

import com.redwood.core.KxSence3d;
import com.redwood.core.base.Face;
import com.redwood.core.base.KxVertex;
import com.redwood.core.base.Segment;

public abstract class KxAbstractSession {
	
	//����
	public abstract void drawVertice(KxVertex v);
	
	//����
	public abstract void drawSegment(Segment s);
	
	//����
	public abstract void drawFace(Face f);
}
