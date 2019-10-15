### truncate / delete from/drop

### is null/ifnull(原值，替代值)

### like(%,_)

### mysql中文乱码

- mysql有六处使用了字符集，分别为：client 、connection、database、results、server 、system。
  - client是客户端使用的字符集。 
  - connection是连接数据库的字符集设置类型，如果程序没有指明连接数据库使用的字符集类型就按照服务器端默认的字符集设置。       
  - database是数据库服务器中某个库使用的字符集设定，如果建库时没有指明，将使用服务器安装时指定的字符集设置。    
  - results是数据库给客户端返回时使用的字符集设定，如果没有指明，使用服务器默认的字符集。
  - server是服务器安装时指定的默认字符集设定。       
  - system是数据库系统使用的字符集设定。（utf-8不可修改）

- show variables like'character%';

- set names gbk;临时修改当前CMD窗口和mysql的通信编码字符集
- 通过修改my.ini 修改字符集编码 default-character-set=gbk



### order by影响查询效率

### count(1)/count(*)

 





