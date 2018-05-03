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
 * hbase����Ҫ�ͻ��˽ӿ���client���е�htable�ṩ��
 * ͨ��������û����������hbase�洢�ͼ�������
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
		table.setAutoFlush(false);//�������
		table.isAutoFlush();//�鿴�Ƿ񼤻��˻�����
		table.setWriteBufferSize(342432);//���û�������С
		
		table.flushCommits();//ǿ�ư�����д�������   ��������������������»�ˢд��1.��ʾˢд  �û�����flushCommits()����
		//2.�û�����put(),setWriteBufferSize()close��������ʽˢд
		//checkAndPut()��֤put��ԭ���Բ���
		
		
	}
}
