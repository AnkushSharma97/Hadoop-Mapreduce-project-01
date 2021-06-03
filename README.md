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
  #### 1) First of all we need to generate logs for CPU, Memory and disk Utilization. And for that we need a command installed on our Linux system which is given below:-
      sudo apt-get install sysstat
       
  #### 2) Generating logs for CPU utilization :- 
      echo "`hostname` `date +%d-%m-%y,%H:%M` ` sar 1 59 |tail -1 `" >> /home/hadoop/sar/logs/`date+%m-%y`-cpu-sar.txt
   
  #### 3) Generating logs for Memory utilization :-
      echo "`hostname` `date +%d%m%y,%H:%M` ` sar -r 1 59 |tail -1 `" >> /home/hadoop/sar/logs/`date+%m-%y`-memory-sar.txt
      
  #### 4) Generating logs for Disk utilization:-
      echo "`hostname` `date +%d%m%y,%H:%M` `df -h |head -3|tail -1 `" >> /home/hadoop/sar/logs/`date+%m-%y`-disk-sar.txt
     
### Note:- 
I have saved the logs in the directory which is suitable to me you can save it in any directory and with any name as per you convenience and permission rights.

