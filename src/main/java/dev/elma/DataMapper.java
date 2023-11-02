package dev.elma;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.*;
import java.net.URI;

public class DataMapper extends Mapper<LongWritable, Text,Text, DoubleWritable[]> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, DoubleWritable[]>.Context context) throws IOException, InterruptedException {

    }

    @Override
    protected void setup(Mapper<LongWritable, Text, Text, DoubleWritable[]>.Context context) throws IOException, InterruptedException {
        URI[] cacheFiles = context.getCacheFiles();
        if(cacheFiles!=null && cacheFiles.length>0){
            try {
                FileSystem fileSystem = FileSystem.get(context.getConfiguration());
                Path path = new Path(cacheFiles[0].toString());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileSystem.open(path)));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
