package org.palm.hazelcast.getstart;

import java.util.Map;
import java.util.Queue;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * 创建Hazelcast主服务
 * @author chkui
 */
public class HazelcastGetStartServerMaster {
	public static void main(String[] args) {
		// 创建一个 hazelcastInstance实例
		HazelcastInstance instance = Hazelcast.newHazelcastInstance();
		// 创建集群Map
		Map<Integer, String> clusterMap = instance.getMap("MyMap");
		clusterMap.put(1, "Hello hazelcast map!");

		// 创建集群Queue
		Queue<String> clusterQueue = instance.getQueue("MyQueue");
		clusterQueue.offer("Hello hazelcast!");
		clusterQueue.offer("Hello hazelcast queue!");
	}
}
