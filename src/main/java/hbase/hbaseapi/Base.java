package hbase.hbaseapi;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * hbase����Ҫ�ͻ��˽ӿ���client���е�htable�ṩ��
 * ͨ��������û����������hbase�洢�ͼ�������
 * @author zhuxiu
 *
 */
public class Base {
	public static void main(String[] args) throws IOException {
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "test101,test102,test103");
		getData(conf);
		
		
	}
	public static void putcell(Configuration conf) throws IOException {
		HTable table = new HTable(conf,"student");
		Put put = new Put(Bytes.toBytes("row1"));
		put.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("kaka"));
		put.add(Bytes.toBytes("info"),Bytes.toBytes("age"),Bytes.toBytes(25));
		Cell cell =  new KeyValue(Bytes.toBytes("row2"), Bytes.toBytes("info"),Bytes.toBytes("name"),Bytes.toBytes("zhuxiu"));
		put.add(cell);
		table.put(put);
		table.setAutoFlush(false);//�������
		System.out.println(table.isAutoFlush());//�鿴�Ƿ񼤻��˻�����
		table.setWriteBufferSize(342432);//���û�������С
		
		table.flushCommits();//ǿ�ư�����д�������   ��������������������»�ˢд��1.��ʾˢд  �û�����flushCommits()����
		//2.�û�����put(),setWriteBufferSize()close��������ʽˢд
		//checkAndPut()��֤put��ԭ���Բ���
	}
	public static void createTable(Configuration conf) throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
		/*HBaseAdmin admin = new HBaseAdmin(conf);
		HTableDescriptor ht = new HTableDescriptor(Bytes.toBytes("student"));
		HColumnDescriptor hc = new HColumnDescriptor(Bytes.toBytes("info"));
		ht.addFamily(hc);
		admin.createTable(ht);*/
		HTable table = new HTable(conf,"student");
		Put put = new Put(Bytes.toBytes("row3"));
		put.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("kaka"));
		put.add(Bytes.toBytes("info"),Bytes.toBytes("age"),Bytes.toBytes(25));
		Put put1 = new Put(Bytes.toBytes("row2"));
		Cell cell =  new KeyValue(Bytes.toBytes("row2"), Bytes.toBytes("info"),Bytes.toBytes("name"),Bytes.toBytes("zhuxiu"));
		put1.add(cell);
		table.put(put);
		table.put(put1);
		table.setAutoFlush(true);//�������
		System.out.println(table.isAutoFlush());//�鿴�Ƿ񼤻��˻�����
		table.setWriteBufferSize(342432);//���û�������С
		table.flushCommits();
	}
	
	public static void getData(Configuration conf) throws IOException {
		HTable table = new HTable(conf,"student");
		Get get = new Get(Bytes.toBytes("row1"));
		Result re = table.get(get);
		for(Cell ce:re.listCells()) {
			System.out.println(Bytes.toString(ce.getRow()));
			System.out.println(Bytes.toString(ce.getFamily()));
			System.out.println(Bytes.toString(ce.getQualifier()));
			System.out.println(Bytes.toInt(ce.getValue()));
			System.out.println("----------------------------------------");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
