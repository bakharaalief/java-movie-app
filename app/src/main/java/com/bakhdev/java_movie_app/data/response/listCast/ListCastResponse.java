package com.bakhdev.java_movie_app.data.response.listCast;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ListCastResponse{

	@SerializedName("cast")
	private List<CastItem> cast;

	@SerializedName("id")
	private int id;

	@SerializedName("crew")
	private List<CrewItem> crew;

	public List<CastItem> getCast(){
		return cast;
	}

	public int getId(){
		return id;
	}

	public List<CrewItem> getCrew(){
		return crew;
	}
}