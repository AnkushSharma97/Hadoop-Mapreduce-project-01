package com.disk.log;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;

public class D_Mapper extends Mapper<LongWritable,Text,Text,FloatWritable>{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		System.out.println("Mapper started");
		String val= value.toString().replaceAll("\\s{2,}"," ");
		String [] tokens= val.split(" ");
		String [] time =tokens[1].split(",");
		String name=tokens[0]+" "+time[0];
		float f = Float.parseFloat(tokens[5].substring(0,tokens[5].length()-1));
		context.write(new Text(name), new FloatWritable(f));

				
	}

}
