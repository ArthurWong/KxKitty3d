package com.redwood;

import com.redwood.core.KxCube;
import com.redwood.core.KxSence3d;
import com.redwood.materials.KxWireColorMaterial;
import com.redwood.renderer.AbstractRenderer;
import com.redwood.renderer.AbstractRendererFor10;
import com.redwood.renderer.AbstractRendererFor20;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class KxKitty3dActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        createCube();
        createRenderer();
    }
    
    private KxSence3d _sence;
    private void createCube()	{
    	_sence = new KxSence3d();
    	KxCube cube = new KxCube();
    	cube.setMaterial(new KxWireColorMaterial());
    	cube.setPos(0f, 0f, 0f);
    	cube.setWidth(0.8f);
    	cube.setHeight(0.9f);
    	cube.setDepth(0.5f);
    	cube.setSegmentsW(2);
    	cube.setSegmentsH(3);
    	cube.setSegmentsD(3);
    	_sence.addChild(cube);
    }
    
    private GLSurfaceView _sv;
    private AbstractRenderer _renderer;
    private void createRenderer()	{
    	if(_sence == null)
    		return;
    	_renderer = new RendererFor10();
    	_renderer.setSence(_sence);
    	
    	//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        _sv = new GLSurfaceView(this);
        _sv.setEGLConfigChooser(false);
        if(_renderer instanceof AbstractRendererFor10)
        {
        	_sv.setRenderer((AbstractRendererFor10)_renderer);
        }
        else
        {
        	_sv.setRenderer((AbstractRendererFor20)_renderer);
        }
        _sv.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        setContentView(_sv);
    }
}