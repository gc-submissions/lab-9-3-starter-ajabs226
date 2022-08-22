package co.grandcircus.trackerapi.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.grandcircus.trackerapi.model.CountPair;

@Service
public class TrackerServiceC implements TrackerService {

	LinkedList<CountPair> ll = new LinkedList<>();

	@Override
	public synchronized void add(String token) {
		if (ll.size() == 0) {
			ll.add(new CountPair(token, 1));
			return;
		}

		for (CountPair countPair : ll) {
			
			if (countPair.getToken().equals(token)) {
				
				countPair.setCount(countPair.getCount() + 1);

				CountPair temp = countPair;

				ll.remove(countPair);

				ll.addLast(temp);
				
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

	@Override
	public String getLatest() {
		if (ll.size() == 0) {
			return "";
		}
		CountPair cp = ll.get(ll.size() - 1);
		return cp.getToken();
	}

	@Override
	public CountPair getTop() {

		if (ll.size() == 0) {
			return new CountPair("", 0);
		}

		List<CountPair> sortedList = new ArrayList<>(ll);

		sortedList.sort(Comparator.comparing(CountPair::getCount));

		return sortedList.get(sortedList.size() - 1);
	}

	@Override // Amy
	public List<String> getLatest5() {

		List<String> latest5 = new ArrayList<String>();

		for (int i = ll.size() - 1; i > ll.size() - 6; i--) {
			latest5.add(ll.get(i).getToken());
		}

		return latest5;
	}

	@Override
	public List<CountPair> getTop5() {

		if (ll.size() == 0) {
			return null;
		}
		
		int listSizeOffset = 0;
		
		if (ll.size() < 5) {
			listSizeOffset = ll.size();
			
		} else {
			listSizeOffset = 5;
		}
		
		List<CountPair> returnList = new ArrayList<>();

		List<CountPair> sortedList = new ArrayList<>(ll);

		sortedList.sort(Comparator.comparing(CountPair::getCount));

		for (int i = sortedList.size() - 1; i >= sortedList.size() - listSizeOffset; i--) {
			returnList.add(sortedList.get(i));
		}

		return returnList;
	}

}
