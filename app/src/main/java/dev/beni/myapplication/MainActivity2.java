package dev.beni.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Timer;
import java.util.TimerTask;
import dev.beni.myapplication.adapter.ViewPagerAdapter;


public class MainActivity2 extends AppCompatActivity {



    ViewPager viewPager;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);


        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);



        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

    }



    public class MyTimerTask extends TimerTask{

        @Override

        public void run() {

            MainActivity2.this.runOnUiThread(new Runnable() {

                @Override

                public void run() {

                    if (viewPager.getCurrentItem() == 0) {

                        viewPager.setCurrentItem(1);

                    }else if (viewPager.getCurrentItem() == 1) {

                        viewPager.setCurrentItem(2);

                    }else {

                        viewPager.setCurrentItem(0);

                    }

                }

            });

        }

    }

}