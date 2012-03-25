package com.redwood.renderer;

import com.redwood.core.KxSence3d;
import com.redwood.session.KxAbstractSession;

public abstract class AbstractRenderer {
	protected KxAbstractSession _session;
	protected KxSence3d _sence;
	
	public void setSence(KxSence3d s)	{
		_sence = s;
	}
}
