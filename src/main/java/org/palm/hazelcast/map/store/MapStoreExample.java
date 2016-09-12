package org.palm.hazelcast.map.store;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hazelcast.core.MapStore;

/**
 * Map持久数据读写
 * @author chkui
 */
public class MapStoreExample implements MapStore<Integer, String> {
	
	Map<Integer, String> store;
	
	public MapStoreExample(){
		store = new HashMap<Integer, String>();
		store.put(1, "Azeroth");
		store.put(2, "Duskwood");
		store.put(3, "Elwynn Forest");
		store.put(4, "Deadwind Pass");
		store.put(5, "Dead Mines");
		store.put(6, "Grand Hamlet");
		store.put(7, "Dark Portal");
		store.put(8, "Ashenvale");
		store.put(9, "Felwood");
		store.put(10, "Orgrimmar");
	}
	
	@Override
	public String load(Integer key) {//读取
		if(store.size() < key){
			key = 0;
		}
		return store.get(key);
	}

	@Override
	public Map<Integer, String> loadAll(Collection<Integer> arg0) {//读取所有
		return store;
	}

	@Override
	public Iterable<Integer> loadAllKeys() {// 读取所有键值
		return store.keySet();
	}

	@Override
	public void delete(Integer key) {// 删除键值
		store.remove(key);
	}

	@Override
	public void deleteAll(Collection<Integer> list) {// 删除所有键值
		list.forEach(key->store.remove(key));
	}

	@Override
	public void store(Integer key, String value) {// 存储键值
		store.put(key, value);
	}

	@Override
	public void storeAll(Map<Integer, String> map) {// 存储所有键值
		store.putAll(map);
	}
}
