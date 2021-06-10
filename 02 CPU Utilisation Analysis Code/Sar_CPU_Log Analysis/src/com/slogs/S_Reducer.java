package com.slogs;
import java.io.IOException;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;


public class S_Reducer extends Reducer<Text,FloatWritable,Text,FloatWritable> {
	
	public void reduce(Text key, Iterable<FloatWritable> values,Context context) throws IOException,InterruptedException
	{
		System.out.println("Reducer Sarted");
		int count=0;
		float sum =0;
		float average;
		for (FloatWritable val: values)
		{
			sum += val.get();
			count+=1;
		}
		average=sum/count;
		context.write(key, new FloatWritable(average));
		
	}
}
