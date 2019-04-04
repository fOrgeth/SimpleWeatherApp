package th.forge.simpleweatherapp.app;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import th.forge.simpleweatherapp.BuildConfig;
import th.forge.simpleweatherapp.data.retrofit.ApiKeyInterceptor;
import th.forge.simpleweatherapp.data.retrofit.ApiService;

public class App extends Application {
    private static ApiService apiService;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Application", "oncreate");
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new ApiKeyInterceptor())
                .build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .client(client)
                    .build();
        }
        if (apiService == null) {
            apiService = retrofit.create(ApiService.class);
        }
    }

    private Gson getGson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    public static ApiService getApiService() {
        return apiService;
    }
}
