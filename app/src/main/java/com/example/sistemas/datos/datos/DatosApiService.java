package com.example.sistemas.datos.datos;

import com.example.sistemas.datos.models.Datos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sistemas on 23/04/18.
 */

public interface DatosApiService {

    @GET("9j82-erkm")
    Call<ArrayList<Datos>> obtenerListaPokemon();
}
