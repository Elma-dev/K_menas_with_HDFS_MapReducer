package dev.elma;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataReducer extends Reducer<Text, DoubleWritable[],Text,DoubleWritable[]> {
    @Override
    protected void reduce(Text key, Iterable<DoubleWritable[]> values, Reducer<Text, DoubleWritable[], Text, DoubleWritable[]>.Context context) throws IOException, InterruptedException {
        Iterator<DoubleWritable[]> iterator = values.iterator();
        double x=0;
        double y=0;
        int i=0;
        while (iterator.hasNext()){
            List<DoubleWritable> points = Arrays.stream(iterator.next()).toList();
            x+=(points.get(0)).get();
            y+=(points.get(1)).get();
            i++;
        }
        x/=i;
        y/=i;
        context.write(key,new DoubleWritable[]{new DoubleWritable(x),new DoubleWritable(y)});

    }
}
