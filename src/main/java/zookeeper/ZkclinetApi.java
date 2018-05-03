package zookeeper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

/**
 * 1.創建連接
 * 2.進行具體的增刪改查操作
 * @author zhuxiu
 *
 */
public class ZkclinetApi {
	private ZooKeeper con;
	private String connectString = "hadoop001";
	private int sessionTimeout = 2000;
	private String nodeParent = "/bro";
	
	@Before
	public void init() throws IOException {
		con = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
			
			@Override
			public void process(WatchedEvent event) {
				System.out.println(event.getType()+"-------"+event.getPath());
				try {
					con.getChildren("/", true);
				} catch (KeeperException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	@Test
	public void createNode() throws UnsupportedEncodingException, KeeperException, InterruptedException {
		con.create(nodeParent, "zhuxiuxiu創建的父節點".getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}
	
	@Test
	public void isExist() throws KeeperException, InterruptedException {
		org.apache.zookeeper.data.Stat s = con.exists("/", false);
		System.out.println(s==null?"not exists":"exists");
	}
	
	@Test
	public void getNode() throws KeeperException, InterruptedException {
		List<String> l = con.getChildren("/", true, null);
		for(String s:l) {
			System.out.println("子節點："+s);
		}
		Thread.sleep(Long.MAX_VALUE);
	}
	
	@Test
	public void getData() throws KeeperException, InterruptedException {
		byte[] bs = con.getData("/", false, null);
		System.out.println(new String(bs));
	}
	
}
