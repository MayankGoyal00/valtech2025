package com.valtech.training.streamingservice.entities;

public class WebSeries extends Content{

	private int noOfEpisode;
	private long durationPerEpisode;
	
	public WebSeries() {
		// TODO Auto-generated constructor stub
	}

	public WebSeries(String name, String genre, String language, int noOfEpisode, long durationPerEpisode) {
		super(name, genre, language);
		this.noOfEpisode = noOfEpisode;
		this.durationPerEpisode = durationPerEpisode;
	}

	public int getNoOfEpisode() {
		return noOfEpisode;
	}

	public void setNoOfEpisode(int noOfEpisode) {
		this.noOfEpisode = noOfEpisode;
	}

	public long getDurationPerEpisode() {
		return durationPerEpisode;
	}

	public void setDurationPerEpisode(long durationPerEpisode) {
		this.durationPerEpisode = durationPerEpisode;
	}
	
	
}
