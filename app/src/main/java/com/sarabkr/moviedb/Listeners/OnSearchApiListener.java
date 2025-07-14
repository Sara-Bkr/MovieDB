package com.sarabkr.moviedb.Listeners;

import com.sarabkr.moviedb.Models.SearchApiResponse;

public interface OnSearchApiListener {
    void onResponse(SearchApiResponse response);
     void OnError(String message);
}
