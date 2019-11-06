package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private EditText txtMobile;
    private EditText txtMessage;
    private Button btnSms;
     int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMobile = (EditText)findViewById(R.id.mblTxt);
        txtMessage = (EditText)findViewById(R.id.msgTxt);
        btnSms = (Button)findViewById(R.id.btnSend);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                    //SmsManager smgr = SmsManager.getDefault();
                   // smgr.sendTextMessage(txtMobile.getText().toString(),null,txtMessage.getText().toString(),null,null);
                    SmsManager sms=SmsManager.getDefault();
                    sms.sendTextMessage("9971146637", null, "Call back ASAP", pi,null);
                    Toast.makeText(MainActivity.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action, keycode;
        action = event.getAction();
        keycode = event.getKeyCode();

        switch(keycode){
            case KeyEvent.KEYCODE_VOLUME_UP:
            {
                if(KeyEvent.ACTION_UP==action){
                    count++;
                    //Toast.makeText(this,count, Toast.LENGTH_SHORT).show();
                    if (count > 0) {

                                try{
                                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                    PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                                    //SmsManager smgr = SmsManager.getDefault();
                                    // smgr.sendTextMessage(txtMobile.getText().toString(),null,txtMessage.getText().toString(),null,null);
                                    SmsManager sms=SmsManager.getDefault();
                                    sms.sendTextMessage("9971146637", null, "Call back ASAP", pi,null);
                                    Toast.makeText(MainActivity.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
                                }
                                catch (Exception e){
                                    Toast.makeText(MainActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                                }

                    }
                }
                break;
            }

            case KeyEvent.KEYCODE_VOLUME_DOWN:
            {
                if(KeyEvent.ACTION_DOWN==action){
                    count=0;
                    Toast.makeText(this, count, Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}

//9971146637