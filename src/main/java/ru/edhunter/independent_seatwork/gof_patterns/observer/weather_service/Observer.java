package ru.edhunter.independent_seatwork.gof_patterns.observer.weather_service;

public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
