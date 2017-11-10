package ru.edhunter.independent_seatwork.gof_patterns.observer.weather_service;

public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
