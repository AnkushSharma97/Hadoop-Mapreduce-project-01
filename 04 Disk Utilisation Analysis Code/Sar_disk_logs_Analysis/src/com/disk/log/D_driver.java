package com.disk.log;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.*;
public class D_driver {
	public static void main (String [] args)  throws Exception
	{
		System.out.println("Driver started");
		Configuration conf = new Configuration();
		String [] otherargs=  new GenericOptionsParser(conf,args).getRemainingArgs();
			if (otherargs.length <2)
			{
				System.out.println("less arguments");
				System.exit(2);
			}
		Job job = new Job(conf,"Disk logs");
		job.setJarByClass(D_driver.class);
		job.setMapperClass(D_Mapper.class);
		job.setReducerClass(D_reducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(FloatWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);
		
		for( int i =0; i<otherargs.length-1;i++)
		{
			FileInputFormat.addInputPath(job,new Path (otherargs[i]));
		}

		FileOutputFormat.setOutputPath(job, new Path( otherargs[otherargs.length-1]));	
		System.exit(job.waitForCompletion(true)?0:1);
	}

}
