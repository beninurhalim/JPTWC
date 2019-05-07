package dev.beni.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActivitySouvenir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_souvenir);

        TextView txtInfo = (TextView)findViewById(R.id.txtInfo);
        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("info");
            txtInfo.setText(info);
        }
    }
}
