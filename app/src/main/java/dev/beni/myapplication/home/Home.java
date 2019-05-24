package dev.beni.myapplication.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import java.util.Timer;
import java.util.TimerTask;

import dev.beni.myapplication.ActivitySouvenir;
import dev.beni.myapplication.MainActivity;
import dev.beni.myapplication.R;
import dev.beni.myapplication.adapter.ViewPagerAdapter;
import dev.beni.myapplication.event.EventActivity;


public class Home extends Fragment {

    public Home() {}

    GridLayout mainGrid;
    ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mainGrid = (GridLayout) view.findViewById(R.id.mainGrid);


        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        ViewPagerAdapter vpa = new ViewPagerAdapter(getContext());
        viewPager.setAdapter(vpa);

//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
        setSingleEvent(mainGrid);
        return  view;
//        return inflater.inflate(R.layout.fragment_home, container, false);

    }


    public class MyTimerTask extends TimerTask {

        @Override
        public void run(){
            //EROR getActivity
            getActivity().runOnUiThread(new Runnable() {

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

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (finalI ==0){
                        Intent intent = new Intent(view.getContext(), ActivitySouvenir.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }else if (finalI ==4){
                        Intent intent = new Intent(view.getContext(), EventActivity.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }

                }
            });
        }
    }
}