## Introduction:-
This is a System Activity Report (SAR) generator project which will generate  reports regarding health of various nodes in a Cluster(Hadoop cluster, Cloud cluster , Greenplum cluster etc).
Here we are going to use SAR logs to do our analysis. So we must have an idea about what is Sar logs?

SAR stands for System Activity Report. It is used to collect a system's Resource utilisation such as CPU uilisation, memory utilsation, disk utilisation etc. We will also do
the same thing in our project here.

## Objective:- 
To generate every Node's Utilisation report on the fly in a cluster to know which node can be used for the new work a cluster is getting. It can also help in identifying any issues a particular node is facing in a cluster. We will see how much utilised a node/system is based on below 3 parameters:-
  1) Node/System's CPU utilization.
  2) Node/Sytem's Memory Utilization.
  3) Node/System's Disk space Utilization.
 
## Steps:- 
###### 1) First of all we need to generate logs for CPU, Memory and disk Utilization. And for that we need a command installed on our Linux system which is given below:-
      sudo apt-get install sysstat
       
###### 2) Generating logs for CPU utilization :- 
      echo "`hostname` `date +%d-%m-%y,%H:%M` ` sar 1 59 |tail -1 `" >> cpu_logs
   
###### 3) Generating logs for Memory utilization :-
      echo "`hostname` `date +%d%m%y,%H:%M` ` sar -r 1 59 |tail -1 `" >> mem_logs
      
###### 4) Generating logs for Disk utilization:-
      echo "`hostname` `date +%d%m%y,%H:%M` `df -h |head -2|tail -1 `" >> disk_logs
     
### Note:- 
a) I have saved the logs in the directory which is suitable to me you can save it in any directory and with any name as per you convenience and permission rights.

b) Above written scripts will generate Utilisation reports for only one interval which is defined there in the scripts in point 2 and 3. But we need logs for the complete life cycle of the cluster. For that purpose , we can schedule the above written scripts so that they will run continuously.

c) Alternatively I can provide the data in the below link which we can use for our Learning and development purpose:-

   [Sample Data](https://github.com/AnkushSharma97/Hadoop-Mapreduce-project-01/tree/main/Sample%20Data)

###### 5) Once the logs are generated , for analysing them we need to send them to Hadoop-HDFS. We will use the following commands for the same :-
###### For Cpu Logs:-
    hadoop fs -put cpu_logs sarlogs/cpu-logs
  
###### For Memory logs:-
    hadoop fs -put mem_logs sarlogs/memory-logs

###### For Disk logs:-
    hadoop fs -put disk_logs sarlogs/disk-logs
 
###### 6) Once the files are saved on HDFS now we need to write Mapreduce Code  to process the files. The code needs to be written separately for all three different types of logs(i.e CPU, Memory and disk logs)
 
###### 7) Mapreduce code for CPU logs:-
          7.1) [CPU utilization code](https://github.com/AnkushSharma97/Hadoop-Mapreduce-project-01/tree/main/02%20CPU%20Utilisation%20Analysis%20Code/Sar_CPU_Log%20Analysis)
          7.2) [Sample Input and Output after running the code](https://github.com/AnkushSharma97/Hadoop-Mapreduce-project-01/tree/main/01%20Sample%20Input%20and%20Output%20Pics/CPU%20Utilization%20Input%20and%20Output%20Pics)
 
###### 8) Mapreduce code for Memory logs:-
          [Memory utilization code](https://github.com/AnkushSharma97/Hadoop-Mapreduce-project-01/tree/main/03%20Memory%20Utilisation%20Analysis%20Code/Sar_Mem_log_analysis)
 
###### 9) Mapreduce code for Disk logs:-
          [Disk utilization code](https://github.com/AnkushSharma97/Hadoop-Mapreduce-project-01/tree/main/04%20Disk%20Utilisation%20Analysis%20Code/Sar_disk_logs_Analysis)
          

 
 

