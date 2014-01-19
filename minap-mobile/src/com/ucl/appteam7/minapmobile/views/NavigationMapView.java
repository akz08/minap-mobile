/**
 * Pinch to zoom functionality closely (nearly identical) based on a blog post series:
 * http://vivin.net/2011/12/04/implementing-pinch-zoom-and-pandrag-in-an-android-view-on-the-canvas/
 */

package com.ucl.appteam7.minapmobile.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.WindowManager;

public class NavigationMapView extends View {
	
	private static float MIN_ZOOM = 1f;
	private static float MAX_ZOOM = 5f;
	
	private static int NONE = 0;
	private static int DRAG = 1;
	private static int ZOOM = 2;
	
	private int mode;
	
	private boolean dragged = true;
	
	int displayWidth;
	int displayHeight;
	
	// track x,y coordinates of finger on first screen touch
	private float startX = 0f;
	private float startY = 0f;
	
	// track amount needed to translate the canvas along x,y
	private float translateX = 0f;
	private float translateY = 0f;

	// track amount translated along x,y on last pan
	private float previousTranslateX = 0f;
	private float previousTranslateY = 0f;
	
	private float scaleFactor = 1.f;
	private ScaleGestureDetector detector;
	
	public NavigationMapView(Context context) {
		super(context);
		detector = new ScaleGestureDetector(getContext(), new ScaleListener());
		
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		displayWidth = size.x;
		displayHeight = size.y;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		switch(event.getAction() & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN:
				// first finger pressed
				mode = DRAG; 
				
				// zeroing x, y
				startX = event.getX() - previousTranslateX;
				startY = event.getY() - previousTranslateY;
				
				
				break;
				
			case MotionEvent.ACTION_MOVE:
				
				// calculating delta x, y
				translateX = event.getX() - startX;
				translateY = event.getY() - startY;
				
				double distance = Math.sqrt(Math.pow(event.getX() - 
						(startX + previousTranslateX), 2) + Math.pow(event.getY() - 
								(startY + previousTranslateY), 2));

				if (distance > 0) {
					dragged = true;
				}      
				break;
				
			case MotionEvent.ACTION_POINTER_DOWN:
				// second finger pressed
				mode = ZOOM; 
				
				break;
				
			case MotionEvent.ACTION_UP:
				// all fingers off screen
				mode = NONE;
				dragged = false;
				// record translate x, y into previous translate x, y
				previousTranslateX = translateX;
				previousTranslateY = translateY;
				
				break;
				
			case MotionEvent.ACTION_POINTER_UP:
				// second finger off screen
				mode = DRAG;
				 
				previousTranslateX = translateX;
				previousTranslateY = translateY;
				break;
		}
		
		// this will set the value of scaleFactor
		detector.onTouchEvent(event);
		
		// only want to redraw the canvas if panning
		if ((mode == DRAG && scaleFactor != 1f && dragged) || mode == ZOOM) {
			invalidate();
		}
		
		return true;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.save();
		canvas.scale(scaleFactor, scaleFactor);
		
		// handling left bound
		if((translateX * -1) < 0) {
			translateX = 0;
		}
		
		// handling right bound
		else if((translateX * -1) > (scaleFactor - 1) * displayWidth) {
			translateX = (1 - scaleFactor) * displayWidth;
		}
			 
		if(translateY * -1 < 0) {
			translateY = 0;
		}
		
		// handling bottom bound
		else if((translateY * -1) > (scaleFactor - 1) * displayHeight) {
			translateY = (1 - scaleFactor) * displayHeight;
		}
		
		// dividing by scale factor, otherwise excessive panning will occur based on zoom level
		canvas.translate(translateX / scaleFactor, translateY / scaleFactor);
		
        int x = getWidth();
        int y = getHeight();
        int radius;
        radius = 100;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.drawCircle(x / 4, y / 4, radius, paint);
        canvas.drawCircle(x / 2, y / 2, radius, paint);
        canvas.drawCircle(x - (x / 4), y - (y / 4), radius, paint);
  
        canvas.restore();
	}
	
	private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
		@Override
		public boolean onScale(ScaleGestureDetector detector) {
			scaleFactor *= detector.getScaleFactor();
			scaleFactor = Math.max(MIN_ZOOM, Math.min(scaleFactor, MAX_ZOOM)); // keeping within bounds of maximum zoom
			return true;
		}
	}
}
