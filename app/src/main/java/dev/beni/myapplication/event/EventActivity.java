package dev.beni.myapplication.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import dev.beni.myapplication.APIService;
import dev.beni.myapplication.R;
import dev.beni.myapplication.adapter.RecyclerViewAdapter;
import dev.beni.myapplication.model.LearnModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventActivity extends AppCompatActivity {

    private LinearLayoutManager layoutManager;
    private List<LearnModel> learnList =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i("autolog", "onCreate");
        getUserList();
    }
    private void getUserList() {
        try {
            String url = "https://beninurhalim.000webhostapp.com/json.php";

            Retrofit retrofit = null;

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }


            APIService service = retrofit.create(APIService.class);


            Call<List<LearnModel>> call = service.getLearnData();

            call.enqueue(new Callback<List<LearnModel>>() {
                @Override
                public void onResponse(Call<List<LearnModel>> call, Response<List<LearnModel>> response) {

                    learnList = response.body();
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(EventActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    RecyclerViewAdapter recyclerViewAdapter =new RecyclerViewAdapter(getApplicationContext(), learnList);
                   recyclerView.setAdapter(recyclerViewAdapter);

//                    recyclerView = findViewById(R.id.recycler);
//                    LinearLayoutManager manager = new LinearLayoutManager(EventActivity.this);
//                    recyclerView.setLayoutManager(manager);
//                    recyclerView.setHasFixedSize(true);
//                    adapter = new MyAdapter();
//                    recyclerView.setAdapter(recyclerViewAdapter);
                }

                @Override
                public void onFailure(Call<List<LearnModel>> call, Throwable t) {
                    Log.i("autolog", t.getMessage());
                }
            });
        }catch (Exception e) {Log.i("autolog", "Exception");}
    }
}