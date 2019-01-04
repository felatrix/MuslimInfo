package flo.muslim.info;

import android.app.ProgressDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import flo.muslim.info.api.ApiService;
import flo.muslim.info.api.ApiUrl;
import flo.muslim.info.model.JadwalSholatModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JadwalShalat extends AppCompatActivity {

    private TextView tv_lokasi_value,tv_shubuh_value,tv_shurooq_value,tv_dzuhur_value,tv_ashar_value,tv_maghrib_value,tv_isya_value;

    private FloatingActionButton tab_refresh;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_shalat);

        getSupportActionBar().setTitle("Jadwal Sholat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_lokasi_value = findViewById(R.id.tv_lokasi_value);
        tv_shubuh_value = findViewById(R.id.tv_shubuh_value);
        tv_shurooq_value = findViewById(R.id.tv_shurooq_value);
        tv_dzuhur_value = findViewById(R.id.tv_dzuhur_value);
        tv_ashar_value = findViewById(R.id.tv_ashar_value);
        tv_maghrib_value = findViewById(R.id.tv_maghrib_value);
        tv_isya_value = findViewById(R.id.tv_isya_value);
        tab_refresh = findViewById(R.id.tab_refresh);
        getJadwal();
        tab_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            getJadwal();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        };


        return super.onOptionsItemSelected(item);
    }
    private void getJadwal(){


        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiUrl.URL_ROOT_HTTP).addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<JadwalSholatModel> call = apiService.getJadwal();

        call.enqueue(new Callback<JadwalSholatModel>() {
            @Override
            public void onResponse(Call<JadwalSholatModel> call, Response<JadwalSholatModel> response) {

                if (response.isSuccessful()){
                    tv_lokasi_value.setText(response.body().getCity()+", "+response.body().getItems().get(0).getDateFor());
                    tv_shubuh_value.setText(response.body().getItems().get(0).getFajr());
                    tv_shurooq_value.setText(response.body().getItems().get(0).getShurooq());
                    tv_dzuhur_value.setText(response.body().getItems().get(0).getDhuhr());
                    tv_ashar_value.setText(response.body().getItems().get(0).getAsr());
                    tv_maghrib_value.setText(response.body().getItems().get(0).getMaghrib());
                    tv_isya_value.setText(response.body().getItems().get(0).getIsha());
                } else {

                }
            }

            @Override
            public void onFailure(Call<JadwalSholatModel> call, Throwable t) {
                Toast.makeText(JadwalShalat.this,"Sorry,trt again .... server down",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
