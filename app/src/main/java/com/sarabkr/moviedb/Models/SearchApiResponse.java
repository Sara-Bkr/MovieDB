package com.sarabkr.moviedb.Models;

import java.util.List;

public class SearchApiResponse {
   List<SearchArrayObject> titles= null;

    public List<SearchArrayObject> getTitles() {
        return titles;
    }

    public void setTitles(List<SearchArrayObject> titles) {
        this.titles = titles;
    }
}
