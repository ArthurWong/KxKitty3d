package com.redwood.session;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES10;
import android.util.Log;

import com.redwood.core.base.Face;
import com.redwood.core.base.KxVertex;
import com.redwood.core.base.Segment;

public class KxSessionFor10 extends KxAbstractSession {

	public KxSessionFor10() {
		
	}

	public void drawVertice(KxVertex v)
	{
		
	}
	
	public void drawSegment(Segment s)
	{
		
	}
	
	public void drawFace(Face f)
	{
		if(f.mat() != null)
		{
			FloatBuffer fb = f.vbuf();
			ShortBuffer sb = f.ibuf();
			//Log.d("test", Integer.toString(fb.capacity()));
			//Log.d("test", Integer.toString(sb.capacity()));
			GLES10.glColor4f(1.0f, 0f, 0f, 0.5f);
			GLES10.glVertexPointer(3, GL10.GL_FLOAT, 0, fb);
			GLES10.glDrawElements(GL10.GL_TRIANGLES, 3, GL10.GL_UNSIGNED_SHORT, sb);
			GLES10.glColor4f(0f, 1.0f, 0f, 0.5f);
			GLES10.glDrawArrays(GL10.GL_LINE_LOOP, 0, 3);
		}
	}
}
