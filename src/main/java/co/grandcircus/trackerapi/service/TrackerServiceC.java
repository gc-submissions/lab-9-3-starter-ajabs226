package co.grandcircus.trackerapi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import co.grandcircus.trackerapi.model.CountPair;

public class TrackerServiceC implements TrackerService {

	LinkedList<CountPair> ll = new LinkedList<>();

	@Override
	public void add(String token) {

		for (CountPair countPair : ll) {

			if (countPair.getToken().equals(token)) {

				countPair.setCount(countPair.getCount() + 1);

				CountPair temp = countPair;

				ll.remove(countPair);

				ll.add(temp);

				return;

			} else {

				continue;
			}
		}
		ll.add(new CountPair(token, 1));
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

	@Override
	public List<CountPair> getTop5() {
		
		List<CountPair> returnList = new ArrayList<>();
		
		List<CountPair> sortedList = new ArrayList<>(ll);
		
		sortedList.sort(Comparator.comparing(CountPair::getCount));
		
		for (int i = sortedList.size() - 1; i > sortedList.size() - 6; i--) {
			returnList.add(sortedList.get(i));
		}
					
		return returnList;
	}

}
