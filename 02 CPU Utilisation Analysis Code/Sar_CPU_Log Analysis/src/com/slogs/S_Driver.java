package com.slogs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;


public class S_Driver 
{
	public static void main (String args[]) throws Exception
	{	System.out.println("Driver Sarted");
		
		Configuration conf = new Configuration();
		System.out.println("Driver Sarted");
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		System.out.println("Driver Sarted");
		if (otherArgs.length < 2)
		{
			System.err.println("Usage: wordcount <in> [<in>...] <out>");
			System.exit(2);
		}
		System.out.println("Driver Sarted");
		
		
		Job job = new Job (conf,"Sar_logs");
		System.out.println("Driver Sarted");

		job.setJarByClass(S_Driver.class);
		job.setMapperClass(S_Mapper.class);
		System.out.println("Driver Sarted");
		job.setReducerClass(S_Reducer.class);
		System.out.println("Driver Sarted");
		job.setOutputValueClass(FloatWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(FloatWritable.class);
		for (int i = 0; i < otherArgs.length - 1; ++i)
		{
			FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
		}
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[otherArgs.length - 1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
		
		
	}

}
