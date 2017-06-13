package com.example.sid.marwadishaadi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

    private GestureDetector gestureDetector;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener){
        gestureDetector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                //here get the view that has been touched
                View child = recyclerView.findChildViewUnder(e.getX(),e.getY());

                //now pass the item and its position to your click listener
                if(child!=null && clickListener!=null){
                    clickListener.onClick(child, recyclerView.getChildPosition(child));
                }

                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
            }
        });
    }

    public static interface ClickListener {
        public void onClick(View view, int position);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        //use the gesture detector to intercept singletap and longtouch events
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}