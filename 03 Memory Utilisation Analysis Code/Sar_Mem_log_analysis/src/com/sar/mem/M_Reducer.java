package com.sar.mem;
import java.io.IOException;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;

public class M_Reducer extends Reducer<Text,FloatWritable,Text,FloatWritable>
{	
	public void reduce(Text key , Iterable<FloatWritable> values , Context context) throws IOException,InterruptedException
	{	float sum=0;
		int count=0;
		System.out.println("Reducer started");
		for (FloatWritable val : values)
		{
			count+=1;
			sum+=val.get();
		}
		sum=sum/count;
		context.write(key, new FloatWritable(sum));
	}
}
