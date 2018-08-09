package hadoopMR.bean;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlowMapper extends Mapper{
	
	  protected void map(Long key, Text value, 
	                     Context context) throws IOException, InterruptedException {
	  }
}
