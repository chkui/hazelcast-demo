package org.palm.hazelcast.config;

import java.util.Map;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * 展示如何读取和引入配置
 * 
 * @author chkui
 */
public class HazelcastConfigSimple {
	// 配置文件存放路径
	final static String DEF_SIMPLE_CONFIG_FILE = "xmlconfig/simple-config.xml";

	public static void main(String[] args) {
		// 加载配置文件
		Config config = new ClasspathXmlConfig(DEF_SIMPLE_CONFIG_FILE);
		// 获取网络配置
		NetworkConfig netConfig = config.getNetworkConfig();
		// 获取用户定义的map配置
		MapConfig mapConfigXml = config.getMapConfig("demo.config");
		// 获取系统默认的map配置
		MapConfig mapConfigDefault = config.getMapConfig("default");
		// 输出集群监听的起始端口号
		System.out.println("Current port:" + netConfig.getPort());
		// 输出监听端口的累加号
		System.out.println("Current port count:" + netConfig.getPortCount());
		// 输出自定义map的备份副本个数
		System.out.println("Config map backup count:" + mapConfigXml.getBackupCount());
		// 输出默认map的备份副本个数
		System.out.println("Default map backup count:" + mapConfigDefault.getBackupCount());

		// 测试创建Hazelcast实例并读写测试数据
		HazelcastInstance instance1 = Hazelcast.newHazelcastInstance(config);
		HazelcastInstance instance2 = Hazelcast.newHazelcastInstance(config);

		Map<Integer, String> defaultMap1 = instance1.getMap("defaultMap");
		defaultMap1.put(1, "testMap");
		Map<Integer, String> configMap1 = instance1.getMap("configMap");
		configMap1.put(1, "configMap");

		Map<Integer, String> testMap2 = instance2.getMap("defaultMap");
		System.out.println("Default map value:" + testMap2.get(1));
		Map<Integer, String> configMap2 = instance2.getMap("configMap");
		System.out.println("Config map value:" + configMap2.get(1));
	}
}
