package com.example.quranic.ui.quran.quransearch;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quranic.R;
import com.example.quranic.data.pojo.Aya;

import java.util.ArrayList;

public class QuranSearchAdapter extends RecyclerView.Adapter<QuranSearchAdapter.ViewHolder> {

private ArrayList<Aya> ayat;

private Fragment fragment;

public QuranSearchAdapter(Fragment fragment) {
        this.fragment = fragment;


         }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item_quran_search,parent,false));
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(ayat.get(position));
        }

@Override
public int getItemCount() {
        return ayat==null ? 0 : ayat.size();
        }


    public void setAyat(ArrayList<Aya> ayat) {
        this.ayat = ayat;
        notifyDataSetChanged();
    }


public class ViewHolder extends RecyclerView.ViewHolder{

    TextView ayaNo,soraNo,soraName,ayaContent;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        soraNo = itemView.findViewById(R.id.sora_no);
        ayaNo = itemView.findViewById(R.id.aya_no);
        soraName = itemView.findViewById(R.id.sora_name);
        ayaContent = itemView.findViewById(R.id.aya_content);
    }

    public void bind(Aya aya) {

        soraNo.setText(String.valueOf(aya.getSora()));
        ayaNo.setText(String.valueOf(aya.getAya_no()));
        soraName.setText(aya.getSora_name_ar());
        ayaContent.setText(aya.getAya_text());

        }
    }
}
