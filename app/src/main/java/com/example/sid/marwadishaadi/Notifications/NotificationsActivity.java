package com.example.sid.marwadishaadi.Notifications;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sid.marwadishaadi.Dashboard_Interest.InterestModel;
import com.example.sid.marwadishaadi.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

    private List<NotificationsModel> notificationsModelList =new ArrayList<>();
    private RecyclerView recyclerView;
    private NotificationsAdapter notificationsAdapter;
    private Paint p = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        Toolbar toolbar = (Toolbar) findViewById(R.id.notify_toolbar);
        toolbar.setTitle("Notifications");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        notificationsAdapter =  new NotificationsAdapter(this, notificationsModelList);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(notificationsAdapter);
        prepareBlockData();

        Button clear = (Button) findViewById(R.id.clearnotifications);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationsModelList.clear();
                notificationsAdapter.notifyDataSetChanged();
            }
        });

        ItemTouchHelper.SimpleCallback touchevents = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                int position = viewHolder.getAdapterPosition();

                if(direction == ItemTouchHelper.RIGHT) {
                    notificationsModelList.remove(position);
                    notificationsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                Bitmap icon;
                if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){

                    View itemView = viewHolder.itemView;
                    float height = (float) itemView.getBottom() - (float) itemView.getTop();
                    float width = height / 3;
                    if(dX < 0){
                        p.setColor(Color.parseColor("#D32F2F"));
                        RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(),(float) itemView.getRight(), (float) itemView.getBottom());
                        c.drawRect(background,p);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.rejected);
                        RectF icon_dest = new RectF((float) itemView.getRight() - 2*width ,(float) itemView.getTop() + width,(float) itemView.getRight() - width,(float)itemView.getBottom() - width);
                        c.drawBitmap(icon,null,icon_dest,p);
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchevents);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    public void prepareBlockData()
    {
        NotificationsModel ne;

        ne= new NotificationsModel("Mervin",3,true,false,false,false,false,false,false,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,true,false,false,false,false,false,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,true,false,false,false,false,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,false,true,false,false,false,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,false,false,true,false,false,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,false,false,false,true,false,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,false,false,false,false,true,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,false,false,false,false,false,true,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,false,false,false,false,false,false,true);
        notificationsModelList.add(ne);

        notificationsAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
