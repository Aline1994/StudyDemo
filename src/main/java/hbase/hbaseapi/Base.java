package hbase.hbaseapi;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * hbase的主要客户端接口是client包中的htable提供的
 * 通过这个类用户可以完成向hbase存储和检索数据
 * @author zhuxiu
 *
 */
public class Base {
	public static void main(String[] args) throws IOException {
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "master1,master2,master3");
		HTable table = new HTable(conf,"student");
		Put put = new Put(Bytes.toBytes("row1"));
		put.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("kaka"));
		put.add(Bytes.toBytes("info"),Bytes.toBytes("age"),Bytes.toBytes(25));
		Cell cell =  new KeyValue(Bytes.toBytes("row2"), Bytes.toBytes("info"),Bytes.toBytes("name"),Bytes.toBytes("zhuxiu"));
		put.add(cell);
		table.put(put);
		table.setAutoFlush(false);//激活缓存区
		table.isAutoFlush();//查看是否激活了缓存区
		table.setWriteBufferSize(342432);//设置缓存区大小
		
		table.flushCommits();//强制把数据写到服务端   缓存区在以下两种情况下回刷写，1.显示刷写  用户调用flushCommits()方法
		//2.用户调用put(),setWriteBufferSize()close方法会隐式刷写
		//checkAndPut()保证put的原子性操作
		
		
	}
}
