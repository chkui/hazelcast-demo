package org.palm.hazelcast.config;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;

public class HazelcastConfigVariable {
	// XML配置文件存放路径
	final static String DEF_CONFIG_FILE = "xmlconfig/variable-config.xml";
	// properties文件路径
	final static String DEF_PROPERTIES_FILE = "properties/variable-config.properties";
	public static void main(String[] args) {
		try {
			// 获取配置文件磁盘路径
			final String path = Thread.currentThread().getContextClassLoader().getResource("").toString() + DEF_CONFIG_FILE;
			// 构建XML配置
			XmlConfigBuilder builder = new XmlConfigBuilder(path);
			// 配置对应的properties解析参数
			builder.setProperties(getProperties());
			// 创建Config
			Config config = builder.build();
			// 输出Config参数
			System.out.println(config.getGroupConfig().getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// get Properties
	private static Properties getProperties() {
		Properties p = null;
		try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(DEF_PROPERTIES_FILE)) {
			if (null != in) {
				p = new Properties();
				p.load(in);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return p;
	}
}
