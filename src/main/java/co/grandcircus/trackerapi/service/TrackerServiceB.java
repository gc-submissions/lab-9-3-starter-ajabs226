package co.grandcircus.trackerapi.service;

import java.util.List;

import co.grandcircus.trackerapi.model.CountPair;

public class TrackerServiceB implements TrackerService{
	// data structure must be able to retrieve latest 5
	// data structure should hold Object of type CountPair
	// LinkedList <CountPair (tomato, 1), (Bacon, 5), (Unicorn, 5)> remove, increment, add to end
	

	@Override
	public void add(String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getTokenExists(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTokenCount(String token) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLatest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountPair getTop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getLatest5() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountPair> getTop5() {
		// TODO Auto-generated method stub
		return null;
	}

}
