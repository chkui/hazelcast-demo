package org.palm.hazelcast.map.interceptor;

import java.io.Serializable;

import com.hazelcast.map.MapInterceptor;

public class InterceptorExample implements MapInterceptor, Serializable {
	private static final long serialVersionUID = -7591859317633144192L;
	@Override
	 /**拦截get。可以返回其他值来替换原有值。返回null将不影响原有操作。 */
	public Object interceptGet(Object obj) {
		prinfln("get : " + obj);
		return obj;
	}

	@Override
	 /**在get操作执行完毕后被调用。*/
	public void afterGet(Object obj) {
		prinfln("after get : " + obj);
	}

	@Override
	/**拦截put。返回的值会设置到map中。返回null时原有的put数据不会发生任何改变。 抛出异常会取消put操作。 */
	public Object interceptPut(Object oldValue, Object newValue ) {
		prinfln("put old value : " + oldValue);
		prinfln("put new value : " + newValue);
		return newValue;
	}

	@Override
	 /**在put操作执行完毕后被调用。*/
	public void afterPut(Object obj) {
		prinfln("after put : " + obj);
	}

	@Override
	/**拦截remove。返回被删除对象或null将继续执行删除。 抛出异常会取消remove操作。 */
	public Object interceptRemove(Object obj) {
		prinfln("remove : " + obj);
		return null;
	}

	@Override
	 /**在remove操作执行完毕后被调用。*/
	public void afterRemove(Object obj) {
		prinfln("afrer remove : " + obj);
	}
	
	private void prinfln(Object obj){
		System.out.println(obj);
	}

}
