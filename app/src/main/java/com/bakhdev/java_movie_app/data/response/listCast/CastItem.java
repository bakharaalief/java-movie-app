package com.bakhdev.java_movie_app.data.response.listCast;

import com.google.gson.annotations.SerializedName;

public class CastItem{

	@SerializedName("cast_id")
	private int castId;

	@SerializedName("character")
	private String character;

	@SerializedName("gender")
	private int gender;

	@SerializedName("credit_id")
	private String creditId;

	@SerializedName("known_for_department")
	private String knownForDepartment;

	@SerializedName("original_name")
	private String originalName;

	@SerializedName("popularity")
	private Object popularity;

	@SerializedName("name")
	private String name;

	@SerializedName("profile_path")
	private String profilePath;

	@SerializedName("id")
	private int id;

	@SerializedName("adult")
	private boolean adult;

	@SerializedName("order")
	private int order;

	public int getCastId(){
		return castId;
	}

	public String getCharacter(){
		return character;
	}

	public int getGender(){
		return gender;
	}

	public String getCreditId(){
		return creditId;
	}

	public String getKnownForDepartment(){
		return knownForDepartment;
	}

	public String getOriginalName(){
		return originalName;
	}

	public Object getPopularity(){
		return popularity;
	}

	public String getName(){
		return name;
	}

	public String getProfilePath(){
		return profilePath;
	}

	public int getId(){
		return id;
	}

	public boolean isAdult(){
		return adult;
	}

	public int getOrder(){
		return order;
	}
}