package org.palm.hazelcast.map.interceptor;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class InterceptorDemo {
	public static void main(String[] args) {
		HazelcastInstance ins = Hazelcast.newHazelcastInstance();
		IMap<Integer, String> imap = ins.getMap("");
		imap.addInterceptor(new InterceptorExample());// 添加拦截器
		imap.put(1, "Mei");
		imap.put(1, "Tracer");
		imap.put(1, "D.va");
		imap.put(1, "Mercy");
		
		imap.get(1);
		imap.remove(1);
		System.out.println(imap.get(1));
	}
}
