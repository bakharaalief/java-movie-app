package com.bakhdev.java_movie_app.data.response.list;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ListMovieResponse{

	@SerializedName("page")
	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("results")
	private List<ResultsItem> results;

	@SerializedName("total_results")
	private int totalResults;

	public int getPage(){
		return page;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public int getTotalResults(){
		return totalResults;
	}
}