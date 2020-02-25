package com.example.mchristi.intents;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    protected EditText mEditText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText)findViewById(R.id.editText1);
        Log.i("OnCreate"," started");
    }


    public boolean openBrowser(View v) {
        Intent i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.fr/search?q=" + mEditText1.getText().toString()));
        startActivity(i);
        return true;
    }

    public boolean call(View v) {
        String url = "tel:3334444";
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
        startActivity(i);
        return true;
    }

    public boolean where(View v) {
        String url = "geo:32,25";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
        return true;
    }

    public boolean startSecondaryActivity(View v) {
        Intent i = new Intent(getApplicationContext(), SecondaryActivity.class);
        i.putExtra("data", "CALL OK!");
        startActivityForResult(i, 0); // 0 = requestcode de l'activity appelant
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        Bundle extras = intent.getExtras();
        mEditText1.setText(extras != null ? extras.getString("returnKey") : "nothing returned");
    }

    public void startTimer(String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}
