package flo.muslim.info.api;

import flo.muslim.info.model.JadwalSholatModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("jakarta.json")
    Call<JadwalSholatModel> getJadwal();
}
