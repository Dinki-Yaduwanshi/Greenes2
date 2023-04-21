package com.example.pap;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ItemViewHolder> {
    String str;
    Context context;
    ArrayList<dataUser> dataUserArrayList;
    Locale id=new Locale("in","ID");
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMMM-yyyy",id);
    public AdapterItem(Context context,ArrayList<dataUser> dataUserArrayList) {
        this.context = context;
        this.dataUserArrayList = dataUserArrayList;
    }



    @NonNull
    @Override
    public AdapterItem.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItem.ItemViewHolder holder, int position) {
        holder.viewBind(dataUserArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView name,warranty,desc,site,tgl;
        Button se1;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            warranty=itemView.findViewById(R.id.warranty);
            desc=itemView.findViewById(R.id.desc);
            site=itemView.findViewById(R.id.site);
            tgl=itemView.findViewById(R.id.tgl);
            se1=itemView.findViewById(R.id.se1);
        }

        public void viewBind(dataUser dataUser) {
           name.setText(dataUser.getName());

            warranty.setText(dataUser.getWarranty());
            tgl.setText(simpleDateFormat.format(dataUser.getTgl()));
            desc.setText(dataUser.getDesc());


        }
    }
}
