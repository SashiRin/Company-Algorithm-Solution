package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : Database
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class Database {
    /*
    Database Table :
    In relational databases, and flat file databases, a table is a set of data elements (values) using
    a model of vertical columns (identifiable by name) and horizontal rows, the cell being the unit where a
    row and column intersect. A table has a specified number of columns, but can have any number of rows.
    怎么设计table：https://www.ntu.edu.sg/home/ehchua/programming/sql/Relational_Database_Design.html
    Step 1: Define the Purpose of the Database (Requirement Analysis)
    Step 2: Gather Data, Organize in tables and Specify the Primary Keys
    Step 3: Create Relationships among Tables
    one-to-many
    many-to-many
    one-to-one
    Step 4: Refine & Normalize the Design
    First/Second/Third Normal Form (3NF)
    Integrity Rules: Entity Integrity Rule Referential Integrity Rule Business logic Integrity
    Column Indexing


    Database Schema:
    The term "schema" refers to the organization of data as a blueprint of how the database is constructed
    (divided into database tables in the case of relational databases). The formal definition of a database schema
    is a set of formulas (sentences) called integrity constraints imposed on a database
    如果把database看作是一个仓库，仓库很多房间（schema），一个schema代表一个房间，table可以看作是每个房间中的储物柜
    ，user是每个schema的主人，有操作数据库中每个房间的权利，就是说每个数据库映射的user有每个schema（房间）的钥匙

    什么是Join，
    比较inner join, outer join(left/right/full join)
    inner join : 交集intersection
    outer join : 并集union
    http://www.cnblogs.com/logon/p/3748020.html

    Index :
    索引是对数据库表中一列或多列的值进行排序的一种结构，使用索引可快速访问数据库表中的特定信息。
    如果想按特定职员的姓来查找他或她，则与在表中搜索所有的行相比，索引有助于更快地获取信息。
    MsSql使用的是B+Tree，Oracle及Sysbase使用的是B-Tree。所以在最开始，简单地介绍一下B-Tree。

    写SQL：
    http://blog.csdn.net/suheonline/article/details/17396197
    一个user table  user_id, name, email
    一个photo table  photo_id, user_id, photo_url, title
    找出user_id=123的人的名字邮箱所有照片的Photo_id, photo_url, tile
    select name email photo_id photo_url, title
    from user_table, photo table
    where user_table.user_id = 123 AND  photo_table.user_id = 123

    Scalability. Now we have one server, one database, what if response time is slow? How to optimize?
    如果现在回答的话我先找出哪里slow，if it is the network problem, go talk to the OPS team, buy more server and add load balancer.
    If it is server memory shortage, go find out whether it is the problem of the web server(switch to a light weight engine like Nginx),
    or the backend itself(optimize code, like change it to multi-threading). If the database is slow, find out which query is sluggish and optimize it,
    or add db server and dedicate each one to reading or writing.
     */
}
