package com.sarabkr.moviedb.Models;

import android.content.Context;
import android.widget.Toast;

import com.sarabkr.moviedb.Listeners.OnSearchApiListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class RequestManager {
    /*
    Fetches movie search results from the IMDB API using Retrofit.
    Uses headers for authentication (x-rapidapi-key).
    Notifies the caller of results/errors via listeners (OnSearchApiListener).
     */
    Context context;
    // retrofit setup
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://imdb188.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void searchMovies(OnSearchApiListener listener, String movie_name){
        //___ making the api call
        getMovies getMovies = retrofit.create(RequestManager.getMovies.class);
        Call<SearchApiResponse> call = getMovies.callMovies(movie_name);

        call.enqueue(new Callback<SearchApiResponse>() {
            @Override
            public void onResponse(Call<SearchApiResponse> call, Response<SearchApiResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Couldn't fetch data!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<SearchApiResponse> call, Throwable t) {
                listener.OnError(t.getMessage());
            }
        });
    }
    public interface getMovies {
    //____api interface
        @Headers({
                "Accept: application/json",
                "x-rapidapi-host: imdb188.p.rapidapi.com",
                "x-rapidapi-key: 52fcaa186fmsh17dca39adcbeea1p1d1f31jsn9d2392631046"
        })
        @GET("api/v1/searchIMDB?query={movie_name}")
        Call<SearchApiResponse> callMovies(
                @Path("movie_name") String movie_name
        );
    }
}
