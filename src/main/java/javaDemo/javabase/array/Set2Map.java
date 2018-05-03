package javaDemo.javabase.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

class SimpleEntry<K,V>implements Map.Entry<K, V>,java.io.Serializable{
	private final K key;
	private V value;
	public SimpleEntry(K key,V value) {
		this.key = key;
		this.value = value;
	}
	public SimpleEntry(Map.Entry<? extends K,? extends V>entry) {
		this.key = entry.getKey();
		this.value = entry.getValue();
	}
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		V oldvalue = this.value;
		this.value = value;
		return oldvalue;
	}
	public boolean equals(Object o) {
		if(o==this) {
			return true;
		}
		if(o.getClass() == SimpleEntry.class) {
			SimpleEntry se = (SimpleEntry) o;
			return se.getKey().equals(getKey());
		}
		return false;
	}
	public int hashCode() {
		return  key==null?0:key.hashCode();
	}
	public String toString() {
		return key+"-"+value;
	}
}

public class Set2Map<K,V>extends HashSet<SimpleEntry<K,V>> {
	public void clear() {
		super.clear();
	}
	public boolean containsKey(Object key) {
		return super.contains(new SimpleEntry(key,null));
	}
	boolean containsValue(Object value) {
		for(SimpleEntry<K,V>se:this) {
			if(se.getValue().equals(value)) {
				 return true;
			}
		}
		return false;
	}
	
	public V get(Object key) {
		for(SimpleEntry<K,V>se:this) {
			if(se.getKey().equals(key)) {
				 return se.getValue();
			}
		}
		return null;
	}
	public V Put(K key,V value) {
		add(new SimpleEntry(key, value));
		return value;
	}
	public void PutAll(Map<? extends K,? extends V> m) {
		for(K key:m.keySet()) {
			add(new SimpleEntry(key,m.get(key)));
		}
	}
	public V removeEntry(Object key) {
		Iterator<SimpleEntry<K, V>> it  =  this.iterator();
		
		while(it.hasNext()){
			SimpleEntry se = it.next();
			if(se.getKey().equals(key)) {
				V v = (V) se.getValue();
				it.remove();
				return v;
			}
		}
		return null;
	}
	public int size() {
		return super.size();
	}
}






















