package com.example.sistemas.datos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sistemas.datos.models.DatosRes;
import com.example.sistemas.datos.datos.DatosApiService;
import com.example.sistemas.datos.models.Datos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private DatosRes adaptador;
    private boolean aptoParaCargar;
    final String TAG = "TRANSPORTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit=new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recyclerView = (RecyclerView) findViewById(R.id.idrecyclerView);
        adaptador = new DatosRes(this);
        recyclerView.setAdapter(adaptador);
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy >0){
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if(aptoParaCargar) {
                        if ((visibleItemCount +pastVisibleItems ) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final");
                            aptoParaCargar = false;

                            procesarDatos();
                        }
                    }
                }
            }
        });


        aptoParaCargar = true;
        procesarDatos();
    }

    private void procesarDatos() {

        DatosApiService service= retrofit.create(DatosApiService.class);
        Call<ArrayList<Datos>> datosRespuestaCall=service.obtenerListaPokemon();
        datosRespuestaCall.enqueue(new Callback<ArrayList<Datos>>() {
            public static final String TAG = "DATOS";

            @Override
            public void onResponse(Call<ArrayList<Datos>> call, Response<ArrayList<Datos>> response) {
                if (response.isSuccessful())
                {
                    ArrayList<Datos> datosRespuesta = response.body();

                   adaptador.adicionarDato(datosRespuesta);
                }
                else {
                    Log.e(TAG, "onResponse:"+ response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Datos>> call, Throwable t) {

                Log.e(TAG,"onFailure:" + t.getMessage());
            }
        });
    }
}
