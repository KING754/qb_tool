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
1.需开启qb的web UI功能。  
2.在配置文件中配置好web UI的地址与用户名及文件存放地址.  
3.目录下执行如下命令 java -jar qb_too.jar.   
4.生成的execl文件,可按需求进行排序.
5.建议保存历史文件,后续准备增加一个功能.统计本次生成与上次生成之前上传的增量.

