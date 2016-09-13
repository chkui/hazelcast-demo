package org.palm.hazelcast.map.listener;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class ListenerDemo {
	public static void main(String[] args) {
		HazelcastInstance ins = Hazelcast.newHazelcastInstance();
		IMap<Integer, String> map = ins.getMap("");
		map.addEntryListener(new ListenerExample(), true);//添加自定义监听器
		System.out.println("EntryListener registered");
	}
}
