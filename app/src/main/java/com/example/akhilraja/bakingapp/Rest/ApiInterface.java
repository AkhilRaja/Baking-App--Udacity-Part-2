package com.example.akhilraja.bakingapp.Rest;

import com.example.akhilraja.bakingapp.Model.BakingModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by AkhilRaja on 04/06/17.
 */

public interface ApiInterface {
    @GET("baking.json")
    Call<List<BakingModel>> getBaking();

}