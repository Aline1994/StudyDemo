package zookeeper;

import java.io.IOException;

import org.apache.hadoop.util.IdentityHashStore;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * 1.创建连接
 * 2.向集群注册服务器信息
 *3.业务功能
 * @author zhuxiu
 *
 */
public class Server {
	public static final String host = "hadoop001";
	public static final String parentNode = "/servers";
	public static final int stime = 2000;
	
	private ZooKeeper zk= null;
	public void getCon() throws IOException {
		zk = new ZooKeeper(host, stime, new Watcher() {
			
			@Override
			public void process(WatchedEvent e) {
				System.out.println(e.getType()+"**********"+e.getPath());
				try {
					zk.getChildren("/", true);
				} catch (KeeperException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void registerServer(String hostname) throws KeeperException, InterruptedException {
		String create = zk.create(parentNode+"/server1", hostname.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(hostname+"is online"+create);
	}
	
	public void handlebussiness(String hostname) throws InterruptedException {
		System.out.println(hostname+"is working");
		Thread.sleep(Long.MAX_VALUE);
	}
	public static void main(String[] args) throws Exception {
		Server s = new Server();
		s.getCon();
		s.registerServer("server1");
		s.handlebussiness("server1");
	}
}

