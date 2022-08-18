package co.grandcircus.trackerapi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.grandcircus.trackerapi.model.CountPair;

@Service
public class TrackerServiceA implements TrackerService {

	ArrayList<String> al = new ArrayList<>();
	HashMap<String, Integer> tokenMap = new HashMap<>();

	@Override
	public void add(String token) {
		// trim 'er up!
		tokenMap.merge(token, 1, Integer::sum);
		if (al.size() > 10) {
			al.remove(al.get(0));
			al.remove(al.get(0));
			al.remove(al.get(0));
			al.remove(al.get(0));
			al.remove(al.get(0));
		}
		al.add(token);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		tokenMap.clear();
		al.clear();
	}

	@Override
	public int getTotalCount() {
		int sum = 0;

		for (Integer i : tokenMap.values()) {
			sum += i;
		}
		return sum;
	}

	@Override
	public boolean getTokenExists(String token) {
		if (tokenMap.containsKey(token)) {
			return true;
		}
		return false;
	}

	@Override
	public int getTokenCount(String token) {
		if (tokenMap.get(token) != null) {
			return tokenMap.get(token);
		}
		return 0;
	}

	@Override
	public String getLatest() {
		if (al.size() == 0) {
			return "";
		}
		return al.get(al.size() - 1);
	}

	@Override
	public CountPair getTop() {
		CountPair cp = new CountPair();

		if (tokenMap.isEmpty()) {
			cp.setCount(0);
			cp.setToken("");
			return cp;
		}

		Integer maxValueInMap = (Collections.max(tokenMap.values()));

		for (String key : tokenMap.keySet()) {
			if (maxValueInMap.equals(tokenMap.get(key))) {
				cp.setToken(key);
				cp.setCount(tokenMap.get(key));
			}

		}
		return cp;
	}

	@Override
	public List<String> getLatest5() {

		List<String> returnList = new ArrayList<String>();

		for (int i = al.size() - 1; i > al.size() - 6; i--) {
			returnList.add(al.get(i));
		}
		return returnList;
	}

	@Override
	public List<CountPair> getTop5() {
		
		List<CountPair> cpList = new ArrayList<>();

		ArrayList<Integer> listOfValues = tokenMap.values().stream().collect(Collectors.toCollection(ArrayList::new));
//		System.out.println("Original" + listOfValues);
		
		Collections.sort(listOfValues);
//		System.out.println("sorted" + listOfValues);

		for (int i = listOfValues.size() - 1; i > listOfValues.size() - 6; i--) {
			for (Entry<String, Integer> entry : tokenMap.entrySet()) {
//				System.out.println("key" + entry.getKey());
//				System.out.println("value" + entry.getValue());
				if (entry.getValue().equals(listOfValues.get(i))) {
					cpList.add(new CountPair(entry.getKey(), entry.getValue()));
				}
			}

		}
		return cpList;
	}
}
