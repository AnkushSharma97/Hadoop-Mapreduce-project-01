package com.disk.log;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;

public class D_reducer extends Reducer <Text, FloatWritable,Text,FloatWritable> 
{
	public void reduce(Text key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException
	{
		//System.out.println("Reducer started");
		int count=0;
		float sum=0;
		for (FloatWritable val:values) 
		{
			count++;
			sum+=val.get();
		}
		float average=sum/count;
		context.write(key,new FloatWritable(average));
	}
}
