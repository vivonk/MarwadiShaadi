package com.example.sid.marwadishaadi.Chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.sid.marwadishaadi.Blocked_Members.BlockModel;
import com.example.sid.marwadishaadi.Blocked_Members.BlockedActivity;
import com.example.sid.marwadishaadi.R;
import com.example.sid.marwadishaadi.User_Profile.UserProfileActivity;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class DefaultMessagesActivity extends DemoMessagesActivity
        implements MessageInput.InputListener,
        MessageInput.AttachmentsListener {



    public static void open(Context context) {
        context.startActivity(new Intent(context, DefaultMessagesActivity.class));
    }

    private MessagesList messagesList;
    private Toolbar toolbar;
    private Menu menu;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    RelativeLayout relative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_messages);
        relative = (RelativeLayout)findViewById(R.id.relative_chat);
        toolbar = (Toolbar) findViewById(R.id.chat_msg_toolbar);
        toolbar.setTitle("Siddhesh Rane");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), UserProfileActivity.class);
                startActivity(i);
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.messagesList = (MessagesList) findViewById(R.id.messagesList);
        initAdapter();

        MessageInput input = (MessageInput) findViewById(R.id.input);
        input.setInputListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.chat_toolbar_block,menu);
        this.menu =menu;
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();
        switch(id)
        {
            case R.id.blocked:
                 onBlockPressed(id);
                 Snackbar snackbar = Snackbar.make(relative, "Added to Blocked List", Snackbar.LENGTH_LONG).setAction("UNBLOCK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            onUnblockPressed(id);
                        }
                    });
                    snackbar.show();
                return true;

            case R.id.search:
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void onUnblockPressed(int id) {
        MenuItem menuItem = menu.findItem(id);
        menuItem.setTitle("Block");
    }

    private void onBlockPressed(int id) {
        MenuItem menuItem = menu.findItem(id);
        menuItem.setTitle("Unblock");
    }

    @Override
    public boolean onSubmit(CharSequence input) {
        super.messagesAdapter.addToStart(
                MessagesFixtures.getTextMessage(input.toString()), true);
        return true;
    }

    @Override
    public void onAddAttachments() {
        super.messagesAdapter.addToStart(
                MessagesFixtures.getImageMessage(), true);
    }

    private void initAdapter() {
        super.messagesAdapter = new MessagesListAdapter<>(super.senderId, super.imageLoader);
        super.messagesAdapter.enableSelectionMode(this);
        super.messagesAdapter.setLoadMoreListener(this);
        this.messagesList.setAdapter(super.messagesAdapter);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
