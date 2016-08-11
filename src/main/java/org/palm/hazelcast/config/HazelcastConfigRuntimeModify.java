package org.palm.hazelcast.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;

/**
 * 展示在代码执行时修改配置初始化方法
 * 
 * @author chkui
 */
public class HazelcastConfigRuntimeModify {
	public static void main(String[] args) {
		// 创建默认config对象
		Config config = new Config();
		// 获取NetworkConfig
		NetworkConfig netConfig = config.getNetworkConfig();
		System.out.println("Default port:" + netConfig.getPort());

		// 设置NetworkConfig
		netConfig.setPort(9701);
		System.out.println("Customer port:" + netConfig.getPort());
		
		// 初始化Hazelcast
		Hazelcast.newHazelcastInstance(config);
	}
}
