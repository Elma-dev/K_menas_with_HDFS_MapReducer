package dev.elma;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class DataMapper extends Mapper<LongWritable, Text,Text, DoubleWritable[]> {
    BufferedReader bufferedReader;

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, DoubleWritable[]>.Context context) throws IOException, InterruptedException {
        List<Double[]> centers = readCenters();
        String[] s = value.toString().split(" ");
        double x = Double.parseDouble(s[0]);
        double y = Double.parseDouble(s[1]);
        centers.forEach(c->{
            double X = Math.pow(x - c[0], 2);
            double Y = Math.pow(y - c[1], 2);
        });


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

    public List<Double[]> readCenters() throws IOException {
        String line;
        List<Double[]> centers=new ArrayList<Double[]>();
        while ((line=bufferedReader.readLine())!=null){
            String[] s = line.split(" ");
            centers.add(new Double[]{Double.parseDouble(s[0]),Double.parseDouble(s[1])});
        }
        return centers;
    }
}
