package com.redwood.session;

import com.redwood.core.KxSence3d;
import com.redwood.core.base.Face;
import com.redwood.core.base.KxVertex;
import com.redwood.core.base.Segment;

public abstract class KxAbstractSession {
	
	//»­µã
	public abstract void drawVertice(KxVertex v);
	
	//»­Ïß
	public abstract void drawSegment(Segment s);
	
	//»­Ãæ
	public abstract void drawFace(Face f);
}
