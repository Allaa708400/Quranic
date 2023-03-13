package com.example.quranic.ui.azkar.azkarhome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranic.MainActivity;
import com.example.quranic.R;
import com.example.quranic.data.pojo.azkar.ZekrType;
import com.example.quranic.ui.quran.qurancontainer.QuranContainerFragment;

import java.util.ArrayList;


public class AzkarTypesAdapter extends RecyclerView.Adapter<AzkarTypesAdapter.ViewHolder> {

   ArrayList<ZekrType> azkarTypes;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_zekr, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(azkarTypes.get(position));


    }

    @Override
    public int getItemCount() {

        return azkarTypes == null ? 0 : azkarTypes.size();

    }

    public void setAzkarTypes(ArrayList<ZekrType> azkarTypes) {
        this.azkarTypes = azkarTypes;
        notifyDataSetChanged();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        TextView zekrName;
        ImageView zekrImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            zekrName = itemView.findViewById(R.id.zekr_name);
            zekrImage = itemView.findViewById(R.id.zeker_image);
        }

      //  public void bind(Zekr zekrType) {
      public void bind(ZekrType zekrType) {

            zekrName.setText(zekrType.getZekrName());
            if (zekrType.getZekrImageId() != -1) {
                zekrImage.setImageResource(zekrType.getZekrImageId());
            }
        //    itemView.setOnClickListener(v-> NavHostFragment
               //     .findNavController(fragment).
                //    navigate(AzkarHomeFragmentDirections.
               //             actionAzkarHomeFragmentToAzkarListFragment(zekrType.getZekrName())));




        }
    }

}

