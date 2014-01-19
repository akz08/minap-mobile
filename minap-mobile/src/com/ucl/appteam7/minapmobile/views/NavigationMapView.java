
package com.ucl.appteam7.minapmobile.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class NavigationMapView extends ImageView {

	
	private static final int X_OFFSET = -30; // offset from width/2
	
	// using American spelling for consistency
	private String bgColor = new String("#ffffff");
	private String lineColor = new String("#999999");
	private String textColor = new String("#666666");
	private String boxLightColor = new String("#eaeaea");
	private String boxDarkColor = new String("#c1c1c1");

	private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG); 
	
	private int width, halfWidth;
	private int height;
	private int padding, extraPadding; // extraPadding used for bottom-most items
	private int radius;
	private int lineWidth;
	private int textSize;
	private int yTextOffset;
	
    private Rect rectInitialDiagnosis = new Rect();
    private Rect rectDemographics = new Rect();
    private Rect rectPrehospital = new Rect();
    private Rect rectReperfusion = new Rect();
    private Rect rectAngiography  = new Rect();
    private Rect rectExaminations = new Rect();
    private Rect rectMedicalHistory = new Rect();
	
    
	public NavigationMapView(Context context) {
		super(context);

	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	
/*
 * COORDINATE CALCULATIONS
 */
		
		// all dimensions are relative to the parent dimensions to scale when zoomed
        width = getWidth();
        halfWidth = width/2 + X_OFFSET;
        height = getHeight();
        padding = height/70;
        extraPadding = 20;
        radius = height/8 - padding;
        textSize = height/33;
        lineWidth = height/140;
        
        //this array uses a fixed distance from the horizontal centre (used for the bottom-most items)
        int[] x2LevelArray = new int[2];
        
        x2LevelArray[0] = halfWidth - (radius + (padding + extraPadding)) ;
        x2LevelArray[1] = halfWidth + (radius + (padding + extraPadding));
        
        // x coordinates for y-middle right positioned items
        int xRightItem = halfWidth + 2 * (radius)  + padding;
        
        // calculate 4 (vertical) level origins to draw items from (assuming items take in a centre point as the origin)
        int[] y4LevelArray = new int[4];
        for (int i = 0; i < 4; i++) {
        	y4LevelArray[i] =  i * (height / 4) + radius + padding;
        }

/*
 * FILL BACKGROUND
 */
        
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor(bgColor));
        canvas.drawPaint(paint);
        
/*
 * DRAW CONNECTOR LINES
 */
        
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(lineWidth);
        paint.setColor(Color.parseColor(lineColor));
        
        // draw connector lines (vertical) top -> down
        canvas.drawLine(halfWidth, y4LevelArray[0], halfWidth, y4LevelArray[1], paint);
        canvas.drawLine(halfWidth, y4LevelArray[1], halfWidth, y4LevelArray[2], paint);
        
        canvas.drawLine(halfWidth, y4LevelArray[2], halfWidth, y4LevelArray[3] + (y4LevelArray[2] - y4LevelArray[3])/2, paint);
        canvas.drawLine(x2LevelArray[0], y4LevelArray[3] + (y4LevelArray[2] - y4LevelArray[3])/2, x2LevelArray[0], y4LevelArray[3], paint);
        canvas.drawLine(x2LevelArray[1], y4LevelArray[3] + (y4LevelArray[2] - y4LevelArray[3])/2, x2LevelArray[1], y4LevelArray[3], paint);
        
        // draw connector lines (horizontal) top -> down
        canvas.drawLine(halfWidth, y4LevelArray[1], xRightItem, y4LevelArray[1], paint);
        canvas.drawLine(halfWidth, y4LevelArray[2], xRightItem, y4LevelArray[2], paint);
        canvas.drawLine(x2LevelArray[0] - lineWidth/2, y4LevelArray[3] + (y4LevelArray[2] - y4LevelArray[3])/2, x2LevelArray[1] + lineWidth/2, y4LevelArray[3] + (y4LevelArray[2] - y4LevelArray[3])/2, paint);
        
/*
 * DRAW VALUE ITEMS
 */
        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.parseColor(boxColor));
        paint.setShader(new LinearGradient(0, 0, 0, height/4, Color.parseColor(boxLightColor), Color.parseColor(boxDarkColor), Shader.TileMode.REPEAT));
        
        // draw item circles
//        canvas.drawCircle(halfWidth, y4LevelArray[0], radius, paint);
//        
//        canvas.drawCircle(halfWidth, y4LevelArray[1], radius, paint);
//        canvas.drawCircle(xRightItem, y4LevelArray[1], radius, paint);
//        
//        canvas.drawCircle(halfWidth, y4LevelArray[2], radius, paint);
//        canvas.drawCircle(xRightItem, y4LevelArray[2], radius, paint);
//        
//        canvas.drawCircle(x2LevelArray[0], y4LevelArray[3], radius, paint);
//        canvas.drawCircle(x2LevelArray[1], y4LevelArray[3], radius, paint);
        
        // set the rects for item boxes (left, top, right, bottom)
        rectInitialDiagnosis.set(halfWidth - radius, y4LevelArray[0] - radius, halfWidth + radius,  y4LevelArray[0] + radius);
        
        rectDemographics.set(halfWidth - radius, y4LevelArray[1] - radius, halfWidth + radius,  y4LevelArray[1] + radius);
        rectPrehospital.set(xRightItem - radius, y4LevelArray[1] - radius, xRightItem + radius,  y4LevelArray[1] + radius);
        
        rectReperfusion.set(halfWidth - radius, y4LevelArray[2] - radius, halfWidth + radius,  y4LevelArray[2] + radius);
        rectAngiography.set(xRightItem - radius, y4LevelArray[2] - radius, xRightItem + radius,  y4LevelArray[2] + radius);
        
        rectExaminations.set(x2LevelArray[0] - radius, y4LevelArray[3] - radius, x2LevelArray[0] + radius, y4LevelArray[3] + radius);
        rectMedicalHistory.set(x2LevelArray[1] - radius, y4LevelArray[3] - radius, x2LevelArray[1] + radius, y4LevelArray[3] + radius);
        
        // draw the item boxes
        canvas.drawRect(rectInitialDiagnosis, paint);
        
        canvas.drawRect(rectDemographics, paint);
        canvas.drawRect(rectPrehospital, paint);
        
        canvas.drawRect(rectReperfusion, paint);
        canvas.drawRect(rectAngiography, paint);
        
        canvas.drawRect(rectExaminations, paint);
        canvas.drawRect(rectMedicalHistory, paint);
        
        // reset shader
        paint.setShader(null);
/*
 * DRAW VALUE TEXT
 */
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor(textColor));
        paint.setTextSize(textSize); 
        paint.setTextAlign(Paint.Align.CENTER); // set text to align to centre to make calculation easier
         
        yTextOffset = - textSize/3;
        // draw text
        canvas.drawText("Initial", halfWidth, y4LevelArray[0] + yTextOffset, paint); 
        canvas.drawText("Diagnosis", halfWidth, y4LevelArray[0] + textSize + yTextOffset, paint); 

        canvas.drawText("Demographics", halfWidth, y4LevelArray[1] - textSize + textSize/4, paint); 
        canvas.drawText("and", halfWidth, y4LevelArray[1] + textSize/4, paint); 
        canvas.drawText("Admission", halfWidth, y4LevelArray[1] + textSize + textSize/4, paint); 
        
        canvas.drawText("Prehospital", xRightItem, y4LevelArray[1] + yTextOffset, paint); 
        canvas.drawText("Events", xRightItem, y4LevelArray[1] + textSize + yTextOffset, paint); 
        
        canvas.drawText("Initial", halfWidth, y4LevelArray[2] + yTextOffset, paint); 
        canvas.drawText("Reperfusion", halfWidth, y4LevelArray[2] + textSize + yTextOffset, paint); 
        
        canvas.drawText("Angiography", xRightItem, y4LevelArray[2] + yTextOffset + textSize/2, paint); 
        
        canvas.drawText("Examinations", x2LevelArray[0], y4LevelArray[3] + yTextOffset + textSize/2, paint); 
        
        canvas.drawText("Medical", x2LevelArray[1], y4LevelArray[3] + yTextOffset, paint); 
        canvas.drawText("History", x2LevelArray[1], y4LevelArray[3] + textSize + yTextOffset, paint); 
  
	}

//	@Override 
//	public boolean onTouchEvent(MotionEvent event) {
//		float x = event.getX();
//		float y = event.getY();
//		
//		switch (event.getAction()) {
//		case MotionEvent.ACTION_DOWN:
//			Log.d("touch", "one finger down");
//			break;
//		case MotionEvent.ACTION_POINTER_UP:
//			if (event.getPointerCount() == 1) {
//				Log.d("touch", "one finger up");
//			}
//			break;
//		}
//		
//		return true;
//	}
	
}
