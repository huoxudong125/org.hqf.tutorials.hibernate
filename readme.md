Centos 7 comes with MariaDB instead of MySQL. MariaDb is a open source equivalent to MySQL and can be installed with `yum -y install mariadb-server mariadb`. If you must have mysql you need to add the mysql-community repo `sudo rpm -Uvh http://dev.mysql.com/get/mysql-community-release-el7-5.noarch.rpm` and then you can install MySQLl like you normally do.



```sql
SET PASSWORD FOR 'root'@'localhost' = PASSWORD('MyNewPass');  

# 
service mysql stop
mysqld_safe --skip-grant-tables &
mysql -u root

use mysql;
update user set password=PASSWORD("121") where User='root';
flush privileges;

```

[install mysql](https://dev.mysql.com/doc/mysql-yum-repo-quick-guide/en/#repo-qg-yum-installing)  
[CentOS 7 下开启Mysql-5.7.19远程访问](http://blog.csdn.net/u010758410/article/details/76381632)   


[Hibernate ORM 5.1 User Guide](https://docs.jboss.org/hibernate/orm/5.1/userguide/html_single/Hibernate_User_Guide.html#mapping-types)        