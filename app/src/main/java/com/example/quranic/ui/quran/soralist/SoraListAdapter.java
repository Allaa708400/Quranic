package com.example.quranic.ui.quran.soralist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quranic.MainActivity;
import com.example.quranic.R;
import com.example.quranic.data.pojo.Sora;
import com.example.quranic.ui.quran.qurancontainer.QuranContainerFragment;
import java.util.List;


public class SoraListAdapter extends RecyclerView.Adapter<SoraListAdapter.ViewHolder> {
    private final int pageNumber= 0;
    List<Sora> index;
    Fragment fragment;

    public SoraListAdapter(List<Sora> index, Fragment fragment) {
        this.index = index;
        this.fragment = fragment;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return  new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sora, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(index.get(position));

    }

    @Override
    public int getItemCount() {
        return index.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView soraNumber, soraName, from, to;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            soraNumber = itemView.findViewById(R.id.sora_number);
            soraName = itemView.findViewById(R.id.sora_name);
            from = itemView.findViewById(R.id.sora_start);
            to = itemView.findViewById(R.id.sora_end);

        }

        public void bind(Sora sora) {

            soraNumber.setText(Integer.toString(sora.getSoraNumber()));
            soraName.setText(sora.getArabicName());
            from.setText(Integer.toString(sora.getStartPage()));
            to.setText(Integer.toString(sora.getEndPage()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   MainActivity activity = (MainActivity) itemView.getContext();

                    Fragment fr = new QuranContainerFragment();


                   Bundle args = new Bundle();

                    args.putInt("sora", sora.getStartPage());
                    fr.setArguments(args);
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragment_container, fr, "QURAN_CONTAINER").commit();
                }
            });


        }



    }

}
