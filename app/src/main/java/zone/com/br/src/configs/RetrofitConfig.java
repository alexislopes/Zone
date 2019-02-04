package zone.com.br.src.configs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import zone.com.br.src.controler.servico.UsuarioService;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        Gson gson = new GsonBuilder().setLenient().create();
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.15.11:8080/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public UsuarioService getUsuarioService(){
        return this.retrofit.create(UsuarioService.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
