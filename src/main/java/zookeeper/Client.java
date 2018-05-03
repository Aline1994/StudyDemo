package zookeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * 1.首先创建连接，创建监听
 * 2.获取服务器信息列表
 * 3.业务
 * @author zhuxiu
 *
 */
public class Client {
	public static final String host = "hadoop001";
	public static final String parentNode = "/servers";
	public static final int stime = 2000;
	
	public volatile List<String>serverList;
	
	private ZooKeeper zk= null;
	public void getCon() throws IOException {
		zk = new ZooKeeper(host, stime, new Watcher() {
			//收到事件通知后的回调函数  自己的事件处理逻辑
			@Override
			public void process(WatchedEvent e) {
				System.out.println(e.getType()+"**********"+e.getPath());
				try {
					//更新服务器列表，并注册监听
					getServerList();
				} catch (KeeperException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void getServerList() throws KeeperException, InterruptedException {
		//获取服务器子节点，并对父节点进行监听
		List<String>children = zk.getChildren(parentNode, true);
		//先创建一个局部list存储服务器信息
		List<String> servers = new ArrayList<String>();
		for(String child:children) {
			byte[]data = zk.getData(parentNode+"/"+child, false, null);
			servers.add(new String(data));
		}
		serverList = servers;
		System.out.println(serverList);
	}
	
	public void handleBussiness() throws InterruptedException {
		System.out.println("client start working....");
		Thread.sleep(2000);
	}
	public static void main(String[] args) throws Exception {
		Client c = new Client();
		c.getCon();
		c.getServerList();
		c.handleBussiness();
	}
}
