package com.mydrawingapp.paint.interfaces;

import android.graphics.Path;

import com.mydrawingapp.paint.painttools.FirstCurrentPosition;


public interface Shapable {
	Path getPath();

	FirstCurrentPosition getFirstLastPoint();

	void setShap(ShapesInterface shape);
}
