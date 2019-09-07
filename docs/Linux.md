### Linux命令

- wc  
- top
- ps
- awk
- grep
- sed
- find



### top

- load average    
  - load average后面的三个数分别是1分钟、5分钟、15分钟的负载情况。
  - load average数据是每隔5秒钟检查一次活跃的进程数，然后按特定算法计算出的数值。如果这个数除以逻辑CPU的数量，结果高于5的时候就表明系统在超负荷运转了  
- tasks
  - total
  - running
  - sleep
  - stoped
  - zombie 僵尸状态   
- cpu
  - us — 用户空间占用CPU的百分比。
  - sy — 内核空间占用CPU的百分比。
  - ni — 改变过优先级的进程占用CPU的百分比
  - id — 空闲CPU百分比
  - wa — IO等待占用CPU的百分比
  - hi — 硬中断（Hardware IRQ）占用CPU的百分比
  - si — 软中断（Software Interrupts）占用CPU的百分比
  - st   time stolen from this vm by the hypervisor
- 内核空间和用户空间
- 内存状态
  - total — 物理内存总量（4GB）
  - used — 使用中的内存总量（3.6GB）
  -  free — 空闲内存总量（148M）
  - buffer/cache — 缓存的内存量 （359M）
- swap交换空间
  -  total — 交换区总量（4G）
  -  used — 使用的交换区总量（0M）
  -  free — 空闲交换区总量（4G）
  -  cached — 缓冲的交换区总量（2483M）

### uptime

### vmstat

- procs
  - r : 运行和等待时间片的进程数，原则上1核的CPU运行队列不要超过2，整个系统的运行队列不能超过总核心数的2倍，否则代表系统压力过大
  - b:等待资源的进程数，比如正在等待磁盘I/O、网络I/O等
- cpu
  - us:用户进程消耗cpu的时间百分比，us数值高，用户进程消耗CPU时间多，如果长期大于50%,优化程序
  - sys：内核进程消耗的cpu时间百分比

### mpstat



### free



### pidstat



### df



### iostat



### ifstat

