package th.forge.simpleweatherapp.data.retrofit;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import th.forge.simpleweatherapp.BuildConfig;

public class ApiKeyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url()
                .newBuilder()
                .addQueryParameter("appid", BuildConfig.API_KEY)
                .build();
        request = request.newBuilder()
                .url(url)
                .build();
        return chain.proceed(request);
    }
}
