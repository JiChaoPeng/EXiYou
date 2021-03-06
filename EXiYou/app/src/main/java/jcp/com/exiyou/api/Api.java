package jcp.com.exiyou.api;

import android.util.Log;

import jcp.com.exiyou.constants.HttpParams;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static final String TAG = Api.class.getSimpleName();
    private static ApiService apiService;

    public static String HOST_NAME = null;


    public static void setApiService(String hostUrl) {
        HOST_NAME = hostUrl;
    }

    public static ApiService getApiService() {
        if (apiService == null) {
            initApiService();
        }
        return apiService;
    }

    private static void initApiService() {

        if (HOST_NAME != null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(HOST_NAME)
                    .build();

            apiService = retrofit.create(ApiService.class);
        } else {
            Log.e(TAG, "-----initApiService: 请在初始化Api的时候传入接口的 host Url");
        }

    }

    public static ApiService getHostService() {
        if (apiService == null) {
            initGetHostService();
        }
        return apiService;
    }

    private static void initGetHostService() {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(HttpParams.SHOP_HOSTNAME)
                    .build();
            apiService = retrofit.create(ApiService.class);
    }

}
