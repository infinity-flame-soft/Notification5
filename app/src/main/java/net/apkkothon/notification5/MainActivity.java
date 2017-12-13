package net.apkkothon.notification5;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--init----------------------
        button=findViewById(R.id.btn);
        editText=findViewById(R.id.et);


        //-onClick-----------------------
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"write some text plz",Toast.LENGTH_SHORT).show();
                }
                else {
                    sendNotify();
                }
            }
        });

    }

    private void sendNotify(){

        Random random=new Random();

        int id=random.nextInt();

        Intent intent=new Intent(MainActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent=PendingIntent.getActivity(this,id,intent,0);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setContentTitle("Notify")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(editText.getText().toString()).setAutoCancel(true).setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(id,builder.build());

    }

}
