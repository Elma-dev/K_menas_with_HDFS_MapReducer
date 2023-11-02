package dev.elma;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainJob{
    public static void main(String[] args) throws IOException, URISyntaxException {
        Configuration configuration=new Configuration();
        Job job=Job.getInstance(configuration);
        job.addCacheFile(new URI("/centroids"));


    }
}
