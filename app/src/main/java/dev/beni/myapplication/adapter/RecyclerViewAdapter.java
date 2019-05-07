package dev.beni.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dev.beni.myapplication.R;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<User> item;
    private Context context ;

    public RecyclerViewAdapter(Context context, List<User> item ) {
        Log.i("autolog", "RecyclerViewAdapter");
        this.item = item;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("autolog", "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_row, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i("autolog", "onBindViewHolder");
        holder.judul.setText(item.get(position).getJudul());
        holder.deskripsi.setText(item.get(position).getDeskripsi());
    }

    @Override
    public int getItemCount() {
        Log.i("autolog", "getItemCount");
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView judul, deskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.i("autolog", "ViewHolder");

            judul = (TextView) itemView.findViewById(R.id.judul);
            deskripsi = (TextView) itemView.findViewById(R.id.deskripsi);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
        }
    }
}