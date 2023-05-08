package com.example.quranic.ui.quran.soralist;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quranic.MainActivity;
import com.example.quranic.R;
import com.example.quranic.data.pojo.quran.Jozz;
import com.example.quranic.data.pojo.quran.Sora;
import com.example.quranic.ui.quran.qurancontainer.QuranContainerFragment;



import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class SoraListAdapter extends RecyclerView.Adapter<SoraListAdapter.ViewHolder> {


   List<?> index;

    Fragment fragment;





    public SoraListAdapter(List<?> index, Fragment fragment) {



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






        if (index.get(position) instanceof Sora) {
            holder.bind((Sora) index.get(position));
        } else if (index.get(position) instanceof Jozz) {
            holder.bind((Jozz) index.get(position));




        } else if (index.get(position) instanceof Integer) {
            holder.bind((Integer) index.get(position));
        }


    }

    @Override
    public int getItemCount() {
        return index.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView soraNumber, soraName, from, to, wordTo,wordFrom;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            soraNumber = itemView.findViewById(R.id.sora_number);
            soraName = itemView.findViewById(R.id.sora_name);
            from = itemView.findViewById(R.id.sora_start);
            to = itemView.findViewById(R.id.sora_end);
            wordFrom = itemView.findViewById(R.id.word_from);
            wordTo = itemView.findViewById(R.id.word_to);

        }



        public void bind(Sora sora) {

            NumberFormat nf= NumberFormat.getInstance(new Locale("ar","EG"));

            wordTo.setVisibility(View.VISIBLE);

            soraNumber.setText((nf.format(sora.getSoraNumber())+"-"));
            soraName.setText(sora.getArabicName());
            from.setText(nf.format(sora.getStartPage()));
            to.setText(nf.format(sora.getEndPage()));






            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    MainActivity activity = (MainActivity) itemView.getContext();


                 //   Fragment fr = new QuranContainerFragment(sora.getStartPage());

                    Fragment fr = new QuranContainerFragment(sora.getStartPage());


                    Bundle args = new Bundle();

                    args.putInt("sora",sora.getStartPage());
                    fr.setArguments(args);
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragment_container, fr, "QURAN_CONTAINER").commit();


                }
            });




        }


        public void bind(Jozz jozz) {

            NumberFormat nf = NumberFormat.getInstance(new Locale("ar", "EG"));

            soraName.setText((fragment.getString(R.string.jozz) + " " + (nf.format(jozz.getJozzNumber()) + " : ")));

            soraNumber.setText("");
            from.setText(nf.format(jozz.getStartPage()));
            to.setText(nf.format(jozz.getEndPage()));






            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    MainActivity activity = (MainActivity) itemView.getContext();


                    Fragment fr = new QuranContainerFragment(jozz.getStartPage());

                    Bundle args = new Bundle();

                    args.putInt("sora", jozz.getStartPage());
                    fr.setArguments(args);
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragment_container, fr, "QURAN_CONTAINER").commit();
                }
            });







        }




        public void bind(Integer page) {

            NumberFormat nf = NumberFormat.getInstance(new Locale("ar", "EG"));

            soraName.setText((fragment.getString(R.string.page) + " : " + (nf.format(page))));
            from.setVisibility(View.GONE);
            to.setVisibility(View.GONE);
            wordTo.setVisibility(View.GONE);
            wordFrom.setVisibility(View.GONE);
            soraNumber.setText("");






            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    MainActivity activity = (MainActivity) itemView.getContext();


                    Fragment fr = new QuranContainerFragment(page);

                    Bundle args = new Bundle();

                    args.putInt("sora",page);
                    fr.setArguments(args);
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragment_container, fr, "QURAN_CONTAINER").commit();


                }
            });




        }

    }
}




