package org.palm.hazelcast.map.getStart;

import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * 客户端节点
 * @author chkui
 */
public class ClientNode {
	public static void main(String[] args) {
		// 获取Hazelcast实例
		HazelcastInstance ins = Hazelcast.newHazelcastInstance();

		// 从集群中读取Map实例
		Map<Integer, String> map = ins.getMap("default map");

		// 输出map中数据
		map.forEach((k,v)->{
			System.out.println("Pos:" + k + ". name:" + v);
		});
	}
}
