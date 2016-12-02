package com.mydrawingapp.paint.interfaces;


import android.graphics.Canvas;

public interface ToolInterface {
	void draw(Canvas canvas);

	void touchDown(float x, float y);

	void touchMove(float x, float y);

	void touchUp(float x, float y);

	boolean hasDraw();
}
