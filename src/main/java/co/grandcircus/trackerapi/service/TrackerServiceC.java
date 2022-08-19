package co.grandcircus.trackerapi.service;

import java.util.LinkedList;
import java.util.List;
import co.grandcircus.trackerapi.model.CountPair;

public class TrackerServiceC implements TrackerService{

	LinkedList<CountPair> ll = new LinkedList<>();

	@Override //Dustin
	public void add(String token) {
		for (CountPair countPair : ll) {
			if (countPair.getToken().equals(token)) {
				countPair.setCount(countPair.getCount()+1);
				ll.add(countPair);
				ll.remove(countPair);
			}
			ll.add(new CountPair(token, 1));
		}
	}

	@Override
	public void reset() {
		ll.clear();		
	}

	@Override
	public int getTotalCount() {
		int sum = 0;
		for (CountPair countPair : ll) {
			sum += countPair.getCount();
		}
		return sum;
	}

	@Override
	public boolean getTokenExists(String token) {
		for (CountPair countPair : ll) {
			if (countPair.getToken().equals(token)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getTokenCount(String token) {
		int sum = 0;
		for (CountPair countPair : ll) {
			if (countPair.getToken().equals(token)) {
				sum += countPair.getCount();
			}
		}
		return sum;
	}

	@Override // Amy
	public String getLatest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // Amy
	public CountPair getTop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // Amy
	public List<String> getLatest5() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override //Dustin
	public List<CountPair> getTop5() {
		// TODO Auto-generated method stub
		return null;
	}

}
