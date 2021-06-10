package com.slogs;
import java.io.IOException;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;



public class S_Mapper extends Mapper <LongWritable,Text,Text,FloatWritable> 

{
	float used;
	String n_key;
	Text op_key = new Text();
	FloatWritable op_value=new FloatWritable();
	public void map(LongWritable key, Text value,Context context) throws InterruptedException,IOException
	
	{	System.out.println("Mapper Sarted");	
		String [] tokens= value.toString().split(" ");
		used=100 - Float.parseFloat(tokens[tokens.length -1]) ;
		String[] date = tokens[1].split(",");
		n_key= tokens[0]+" "+date[0];
		op_key.set(n_key);
		op_value.set(used);
		System.out.print(n_key+" ");
		System.out.println(used);
		context.write(op_key,op_value);
	}
}
