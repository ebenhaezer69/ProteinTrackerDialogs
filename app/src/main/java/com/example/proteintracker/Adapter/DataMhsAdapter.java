package com.example.proteintracker.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proteintracker.Model.DataMhs;
import com.example.proteintracker.R;
import java.util.ArrayList;

public class DataMhsAdapter extends RecyclerView.Adapter<DataMhsAdapter.ViewHolder> {
    ArrayList <DataMhs> dataMhsArrayList;

    public DataMhsAdapter (ArrayList<DataMhs> dataMhsArrayList){
        this.dataMhsArrayList = dataMhsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_data_mhs,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataMhsAdapter.ViewHolder holder, int position) {
        holder.txtNama.setText(dataMhsArrayList.get(position).getNama());
        holder.txtNim.setText(dataMhsArrayList.get(position).getNim());
        holder.txtcitacita.setText(dataMhsArrayList.get(position).getCitacita());
        holder.txtgender.setText(dataMhsArrayList.get(position).getGender());
        holder.txtmotohidup.setText(dataMhsArrayList.get(position).getMotohidup());
    }


    @Override
    public int getItemCount() {
        return (dataMhsArrayList != null) ? dataMhsArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtNim, txtcitacita, txtgender, txtmotohidup;

        public ViewHolder(View view) {
            super(view);
            txtNama = view.findViewById(R.id.txtNama);
            txtNim = view.findViewById(R.id.txtNim);
            txtgender = view.findViewById(R.id.txtGender);
            txtcitacita = view.findViewById(R.id.txtCitaCita);
            txtmotohidup = view.findViewById(R.id.txtMotoHidup);
        }
    }
}
