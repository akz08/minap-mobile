
package com.ucl.appteam7.minapmobile.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

public class NavigationMapView extends ImageView {
	
	
	public NavigationMapView(Context context) {
		super(context);

	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	
		// all dimensions are relative to the parent dimensions to scale when zoomed
		
        int width = getWidth();
        int height = getHeight();
        int padding = height/60;
        int radius;
        radius = height/8 - padding;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#CD5C5C"));
        
//        // calculate 2 (horizontal) level origins to draw items from (assuming items take in a centre point as the origin)
//        int[] x3LevelArray = new int[3];
//        for (int i = 0; i < 3; i++) {
//        	x3LevelArray[i] = i * (width / 3) + radius + padding;
//        }
        
        int[] x2LevelArray = new int[2];
        int extraPadding = 20;
        x2LevelArray[0] = width/2 - (radius + padding + extraPadding) ;
        x2LevelArray[1] = width/2 + (radius + padding + extraPadding);
        
        // calculate 4 (vertical) level origins to draw items from (assuming items take in a centre point as the origin)
        int[] y4LevelArray = new int[4];
        for (int i = 0; i < 4; i++) {
        	y4LevelArray[i] =  i * (height / 4) + radius + padding;
        }
        
        canvas.drawCircle(width / 2, y4LevelArray[0], radius, paint);
        canvas.drawCircle(width / 2, y4LevelArray[1], radius, paint);
        canvas.drawCircle(width / 2, y4LevelArray[2], radius, paint);
        canvas.drawCircle(x2LevelArray[0], y4LevelArray[3], radius, paint);
        canvas.drawCircle(x2LevelArray[1], y4LevelArray[3], radius, paint);
//        canvas.drawCircle(width / 2, 2* (height / 4 - padding), radius, paint);
//        canvas.drawCircle(width / 2, 3* (height / 4 - padding), radius, paint);
//        canvas.drawCircle(width / 2, 4 *(height / 4 - padding), radius, paint);

  
	}

}
