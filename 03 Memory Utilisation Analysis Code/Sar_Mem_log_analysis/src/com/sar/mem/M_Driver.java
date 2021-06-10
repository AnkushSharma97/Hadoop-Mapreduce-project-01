package com.sar.mem;

import java.io.IOException;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.*;


public class M_Driver {
	public static void main(String [] args) throws Exception 
	{
		Configuration conf = new Configuration();
		String[] otherargs= new GenericOptionsParser(conf,args).getRemainingArgs();
		if (otherargs.length<2)
		{
			System.err.println("Argument length is less than 2");
			System.exit(2);
		}
		Job job = new Job(conf,"Mem_log_Analysis");
		
		job.setJarByClass(M_Driver.class);
		job.setMapperClass(M_Mapper.class);
		job.setReducerClass(M_Reducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(FloatWritable.class);
		for (int i =0; i<otherargs.length-1;i++)
		{
			FileInputFormat.addInputPath(job, new Path (otherargs[i]));
		}
		FileOutputFormat.setOutputPath(job, new Path(otherargs[otherargs.length-1]));
		System.exit(job.waitForCompletion(true)?0:1);
		
		
		
	}

}
