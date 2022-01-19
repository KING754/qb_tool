# qb_tool
## 背景
本人刚玩PT，没有用多久的时间，就把我的新16T硬盘装了一半。  
这速度远远超过了一开始的预期。  
此时我准备删除一些资源，但是发现却无从下手。  

## 工具作用
将qb内（目前第一版，只做了qb）,所有种子的部分信息（比如总大小，小传大小，活动时间，做种时间）进行汇总并输出到execl中，这样就可以在execl中按自己的需求进行排序了。然后再对资源进行针对性处理。
## 工具原因
本工具没有与PT站没有任何关系。只是抓取了qb的WEB API上的数据进行处理，然后输出execl.

## 使用方法  
0.需开启qb的web UI功能。  
1.qb_tool/qb_tool/目录为程序运行目录  
2.在qb_tool\qb_tool\bin\conf\conf\config.properties文件中配置好web UI的地址与用户名及文件存放地址.  
3.qb_tool\qb_tool\bin目录下运行run.bat   
4.生成的execl文件,可按需求进行排序.
5.建议保存历史文件,后续准备增加一个功能.统计本次生成与上次生成之前上传的增量.  
------------------
### 生成的execl表头:
![image](https://user-images.githubusercontent.com/42364005/150148997-a9e7eb0d-1374-40e8-bec8-8aa837c131b2.png)

后四列,主要做为排序用.  
后四列,在前面有对应更友好的显示的列.

### 作者常用的排序条件
![image](https://user-images.githubusercontent.com/42364005/150149526-4f86cdb4-836d-4435-b537-b83424941628.png)
依此,可将占用空间大,却上传小的文件,以此到达空间清理的目的.
