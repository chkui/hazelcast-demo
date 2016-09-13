package org.palm.hazelcast.map.listener;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class ListenerDemo {
	public static void main(String[] args) {
		HazelcastInstance ins = Hazelcast.newHazelcastInstance();
		IMap<Integer, String> map = ins.getMap("");
		map.addEntryListener(new ListenerExample(), true);//添加自定义监听器
		map.put(1, "Grand Theft Auto");
		map.put(1, "Final Fantasy");
		map.put(2, "World Of Warcraft");
		
		HazelcastInstance insex = Hazelcast.newHazelcastInstance();
		IMap<Integer, String> mapex = insex.getMap("");
		
		System.out.println(mapex.get(1));
		System.out.println(mapex.get(2));
		mapex.remove(1);
		mapex.remove(2);
		System.exit(0);
	}
}
