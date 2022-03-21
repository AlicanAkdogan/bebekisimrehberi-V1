package com.alican.bebeksimrehberi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.cardTasarimTutucu> {

    private Context mContext;
    private List<Names> namesList;

    public NamesAdapter(Context mContext, List<Names> namesList) {
        this.mContext = mContext;
        this.namesList = namesList;
    }

    public class cardTasarimTutucu extends RecyclerView.ViewHolder {

        private TextView namesText, namesExplanationText;

        public cardTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            namesText = itemView.findViewById(R.id.namesText);
            namesExplanationText = itemView.findViewById(R.id.namesExplanationText);
        }
    }

    @NonNull
    @Override
    public cardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design,parent,false);
        return new cardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cardTasarimTutucu holder, int position) {

        final Names names = namesList.get(position);
        holder.namesText.setText(names.getName());
        holder.namesExplanationText.setText(names.getNames_explanation());

    }

    @Override
    public int getItemCount() {
        return namesList.size();
    }

}






































