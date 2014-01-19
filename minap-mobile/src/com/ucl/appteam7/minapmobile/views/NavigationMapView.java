
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
        int padding = height/70;
        int radius;
        radius = height/8 - padding;
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#e5e5e5"));
        
        
        
        
        int lineWidth = height/140;
        
        
        Paint myPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        myPaint.setStyle(Paint.Style.STROKE); 
        myPaint.setStrokeWidth(lineWidth);
        myPaint.setColor(Color.parseColor("#999999"));   // grey
        
        myPaint.setTextAlign(Paint.Align.CENTER); // set text to align to centre to make calculation easier
        
        
//        // calculate 2 (horizontal) level origins to draw items from (assuming items take in a centre point as the origin)
//        int[] x3LevelArray = new int[3];
//        for (int i = 0; i < 3; i++) {
//        	x3LevelArray[i] = i * (width / 3) + radius + padding;
//        }
        
        // this array gives 2 spaces evenly distributed based on the screen width
//        int[] x2LevelArray = new int[2];
//        int extraPadding = 20;
//        x2LevelArray[0] = width/2 - (radius + (width/4 - radius)) ;
//        x2LevelArray[1] = width/2 + (radius + (width/4 - radius));
        
        int halfWidth = width/2;
        // introduce an x-offset
        halfWidth -= 30;
        
        //this array uses a fixed distance from the horizontal centre (used for the bottom-most items)
        int[] x2LevelArray = new int[2];
        int extraPadding = 20;
        x2LevelArray[0] = halfWidth - (radius + (padding + extraPadding)) ;
        x2LevelArray[1] = halfWidth + (radius + (padding + extraPadding));
        
        // x coordinates for y-middle right positioned items
        int xRightItem = halfWidth + 2 * (radius)  + padding;
        
        // calculate 4 (vertical) level origins to draw items from (assuming items take in a centre point as the origin)
        int[] y4LevelArray = new int[4];
        for (int i = 0; i < 4; i++) {
        	y4LevelArray[i] =  i * (height / 4) + radius + padding;
        }
        
        // draw connector lines (vertical) top -> down
        canvas.drawLine(halfWidth, y4LevelArray[0], halfWidth, y4LevelArray[1], myPaint);
        canvas.drawLine(halfWidth, y4LevelArray[1], halfWidth, y4LevelArray[2], myPaint);
        
        canvas.drawLine(halfWidth, y4LevelArray[2], halfWidth, y4LevelArray[3] + (y4LevelArray[2] - y4LevelArray[3])/2, myPaint);
        canvas.drawLine(x2LevelArray[0], y4LevelArray[3] + (y4LevelArray[2] - y4LevelArray[3])/2, x2LevelArray[0], y4LevelArray[3], myPaint);
        canvas.drawLine(x2LevelArray[1], y4LevelArray[3] + (y4LevelArray[2] - y4LevelArray[3])/2, x2LevelArray[1], y4LevelArray[3], myPaint);
        
        // draw connector lines (horizontal) top -> down
        canvas.drawLine(halfWidth, y4LevelArray[1], xRightItem, y4LevelArray[1], myPaint);
        canvas.drawLine(halfWidth, y4LevelArray[2], xRightItem, y4LevelArray[2], myPaint);
        canvas.drawLine(x2LevelArray[0] - lineWidth/2, y4LevelArray[3] + (y4LevelArray[2] - y4LevelArray[3])/2, x2LevelArray[1] + lineWidth/2, y4LevelArray[3] + (y4LevelArray[2] - y4LevelArray[3])/2, myPaint);
        
        // draw item boxes/circles
        canvas.drawCircle(halfWidth, y4LevelArray[0], radius, paint);
        
        canvas.drawCircle(halfWidth, y4LevelArray[1], radius, paint);
        canvas.drawCircle(xRightItem, y4LevelArray[1], radius, paint);
        
        canvas.drawCircle(halfWidth, y4LevelArray[2], radius, paint);
        canvas.drawCircle(xRightItem, y4LevelArray[2], radius, paint);
        
        canvas.drawCircle(x2LevelArray[0], y4LevelArray[3], radius, paint);
        canvas.drawCircle(x2LevelArray[1], y4LevelArray[3], radius, paint);
        
        // define the rects for item boxes
        
        // draw text
        myPaint.setStrokeWidth(lineWidth/7);
        myPaint.setTextSize(height/30); 
        canvas.drawText("Some", halfWidth, y4LevelArray[0], myPaint); 
        canvas.drawText("Text", halfWidth, y4LevelArray[0] + height/30, myPaint); 
        
//        canvas.drawCircle(width / 2, 2* (height / 4 - padding), radius, paint);
//        canvas.drawCircle(width / 2, 3* (height / 4 - padding), radius, paint);
//        canvas.drawCircle(width / 2, 4 *(height / 4 - padding), radius, paint);

  
	}

}
