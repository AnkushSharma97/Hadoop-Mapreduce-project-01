package com.sar.mem;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.FloatWritable;


public class M_Mapper extends Mapper<LongWritable,Text,Text,FloatWritable> 
{	String nodename;
	Float memused;
	String val;
	public void map(LongWritable key,Text value,Context context) throws InterruptedException,IOException
	{	
				
		val=value.toString().replaceAll("\\s{2,}", " ");
		String [] tokens= val.split(" ");
		String [] time= tokens[1].split(",");
		nodename=tokens[0]+"-"+time[0];
		memused=Float.parseFloat(tokens[5]);
		System.out.println(nodename);
		System.out.println(memused);
		context.write(new Text(nodename), new FloatWritable(memused));
	}
}
