package com.example.mchristi.intents;

/**
 * Created by mchristi on 9/18/15.
 */
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondaryActivity extends Activity {

    String mdata;
    EditText mEditText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        mdata = getIntent().getExtras().getString("data");

        mEditText1 = (EditText)findViewById(R.id.editText1);
    }

    public void ok(View v) {
        Intent res = new Intent();
        res.putExtra("returnKey","Coucou");
        setResult(RESULT_OK, res);
        finish();
    }



}
