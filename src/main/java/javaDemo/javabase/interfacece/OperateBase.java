package javaDemo.javabase.interfacece;

import java.util.List;

public interface OperateBase {
	boolean add();
	boolean delete(int id);
	List<Object> select(int id);
	List<Object>selectAll();
	
}
