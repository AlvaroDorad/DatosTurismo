package com.example.sistemas.datos.models;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.sistemas.datos.R;

import java.util.ArrayList;

public class DatosRes extends RecyclerView.Adapter<DatosRes.RecicleViewHolder>{

    ArrayList<Datos> datos;

    private Datos datos1;
    private Context context;


    public DatosRes(Context context){

        this.context = context;
        datos = new ArrayList<>();
    }


    DatosRes(ArrayList<Datos> datos){
        this.datos = datos;
    }


    public class RecicleViewHolder extends RecyclerView.ViewHolder {

        private TextView text1;
        private TextView text2;
        private TextView text3;
        private TextView text4;

        CardView cv;
        TextView direccion;

        RecicleViewHolder(View itemView)
        {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            direccion = (TextView)itemView.findViewById(R.id.txt1);

            text1 = (TextView) itemView.findViewById(R.id.txt1);
            text2 = (TextView) itemView.findViewById(R.id.txt2);
            text3 = (TextView) itemView.findViewById(R.id.txt3);
            text4 = (TextView) itemView.findViewById(R.id.txt4);

        }
    }
    @Override
    public int getItemCount() {
        return datos.size();
    }

    @Override
    public RecicleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false); //item
        RecicleViewHolder pvh = new RecicleViewHolder(v);
        return pvh;
    }
    @Override
    public void onBindViewHolder(RecicleViewHolder direccionViewHolder, int i) {
        datos1 = datos.get(i);
        direccionViewHolder.direccion.setText(datos1.getNombreDelOperador());
        direccionViewHolder.text1.setText("Direccion: "+ datos1.getDirecciN());
        direccionViewHolder.text2.setText("Correo Electronico: "+datos1.getCorreoElectronico());
        direccionViewHolder.text3.setText("Prestador del servicio: "+datos1.getPrestadorDelServicioTuristico());
        direccionViewHolder.text4.setText("Servicio Prestado: "+datos1.getServicioQuePresta());

        Glide.with(context);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void adicionarDato(ArrayList <Datos> listaDatos){
        datos.addAll(listaDatos);
        notifyDataSetChanged();
    }
}
