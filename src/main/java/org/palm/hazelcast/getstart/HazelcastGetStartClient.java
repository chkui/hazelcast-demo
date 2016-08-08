package org.palm.hazelcast.getstart;

import java.util.Map;
import java.util.Queue;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

/**
 * 启动客户端，从集群服务中读取数据。
 * @author chkui
 */
public class HazelcastGetStartClient {
	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		HazelcastInstance instance = HazelcastClient.newHazelcastClient(clientConfig);
		Map<Integer, String> clusterMap = instance.getMap("MyMap");
		Queue<String> clusterQueue = instance.getQueue("MyQueue");
		
		System.out.println("Map Value:" + clusterMap.get(1));
		System.out.println("Queue Size :" + clusterQueue.size());
		System.out.println("Queue Value 1:" + clusterQueue.poll());
		System.out.println("Queue Value 2:" + clusterQueue.poll());
		System.out.println("Queue Size :" + clusterQueue.size());
	}
}
