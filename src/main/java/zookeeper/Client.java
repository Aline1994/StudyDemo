package zookeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * 1.���ȴ������ӣ���������
 * 2.��ȡ��������Ϣ�б�
 * 3.ҵ��
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
			//�յ��¼�֪ͨ��Ļص�����  �Լ����¼������߼�
			@Override
			public void process(WatchedEvent e) {
				System.out.println(e.getType()+"**********"+e.getPath());
				try {
					//���·������б���ע�����
					getServerList();
				} catch (KeeperException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void getServerList() throws KeeperException, InterruptedException {
		//��ȡ�������ӽڵ㣬���Ը��ڵ���м���
		List<String>children = zk.getChildren(parentNode, true);
		//�ȴ���һ���ֲ�list�洢��������Ϣ
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
