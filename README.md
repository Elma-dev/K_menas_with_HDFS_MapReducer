# K_menas_with_HDFS_MapReducer
## ❕About Repo
In this repository, we learn about Hadoop MapReduce and K-means. We try to create K-means allgorithm with Hadoop Map Reducer, if you don't know a litle about HDFS you will find an explanation of it in this [repsitory](https://github.com/Elma-dev/hdfs_Big_Data.git).

## 📚Prerequisite
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Hadoop](https://img.shields.io/badge/Apache%20Hadoop-66CCFF.svg?style=for-the-badge&logo=Apache-Hadoop&logoColor=black)

## 📝Explanation
### K-means
```
K-means is a popular clustering algorithm in machine learning and data analysis. It is used to partition a
dataset into a set of clusters, where each cluster represents agroup of similar data points. The goal of
k-means is to minimize the within-cluster variance, meaning that data points within a cluster should be as
similar as possible, while different clusters should be as dissimilar as possible.
```
![image](https://github.com/Elma-dev/K_menas_with_HDFS_MapReducer/assets/67378945/1d8c9e47-d07c-4449-9684-6ff23be8764c)

### HDFS
```
HDFS divides large files into smaller blocks, typically 128 MB or 256 MB in size.
These blocks are distributed across multiple machines (nodes) in a Hadoop cluster.
This distribution allows HDFS to store and process large files efficiently.
```

### How the K-means algorithm works
```
1. Initialization: Initially, you choose the number of clusters, denoted as "K," and randomly place K cluster
centroids (representative points) in the data space. These centroids can be randomly selected data points or positioned
in other ways.

2. Assignment: Each data point is assigned to the nearest cluster centroid based on a distance metric, typically Euclidean
distance. This means that data points are assigned to the cluster with the nearest centroid, forming K clusters.

3. Update: After all data points have been assigned to clusters, the centroid of each cluster is recomputed as the mean of
all data points within that cluster. This new centroid represents the center of the cluster.

4. Iteration: Steps 2 and 3 are repeated iteratively until convergence. Convergence occurs when the cluster assignments no
longer change significantly, or when a maximum number of iterations is reached.
```
### Allgorithm Schema
<center><img src="https://github.com/Elma-dev/K_menas_with_HDFS_MapReducer/assets/67378945/2257c7a5-09ef-4849-a0e2-1cfff6b33bec"></center>

# 🌴Project Structure

```
└── src
    ├── main
    │   ├── java
    │   │   └── dev
    │   │       └── elma
    │   │           ├── DataMapper.java
    │   │           ├── DataReducer.java
    │   │           ├── Main.java
    │   │           └── MainJob.java
    │   └── resources
    └── test
        └── java

```

