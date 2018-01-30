package OperationMongoDB;

import com.mongodb.*;
import org.junit.Test;

import java.net.UnknownHostException;

public class MongoDao {

    /**
     * 创建mongodb的连接
     * @return
     * @throws UnknownHostException
     */
    private DB connection() throws UnknownHostException {
        Mongo mongo=new Mongo("127.0.0.1",27017);          //建立连接
                            //打开数据库
        //DB db=mongo.getDB("test");
        return mongo.getDB("test");
    }

    /**
     * 添加
     * @throws UnknownHostException
     */
    @Test
    public void add() throws UnknownHostException {
        DB    db= connection();

//        DBCollection collection=db.getCollection("zhang");          //获取集合
//        Mongo mongo=new Mongo("127.0.0.1",27017);                   //建立连接
//        DB db=mongo.getDB("test");                                  //打开数据库
        DBCollection collection=db.getCollection("zhang");      //获取集合

        BasicDBObject dbObject=new BasicDBObject();                     //特殊json
        dbObject.put("name","李四");                            //赋值
        dbObject.put("id",888);
        collection.insert(dbObject);                                   //插入

    }

    /**
     * 查询
     * @throws UnknownHostException
     */
    @Test
    public void query() throws UnknownHostException {
        DB    db= connection();
        DBCollection collection=db.getCollection("zhang");      //获取集合

        BasicDBObject dbObject=new BasicDBObject();                     //特殊json  相当于大括号 db.zhang.find( >{}<这个大括号)
        dbObject.put("name","李四");                            //赋值
        DBCursor cursor= collection.find(dbObject);                      //没条件查所有
        while(cursor.hasNext())
        {
            System.out.println(cursor.next().toString());
        }
    }

    /**
     * 删除
     */
    @Test
   public void del() throws UnknownHostException {
     DB    db= connection();
     DBCollection collection=db.getCollection("zhang");      //获取集合
        BasicDBObject dbObject=new BasicDBObject();                     //特殊json
        dbObject.put("name","李四");                            //赋值
        DBCursor cursor= collection.find(dbObject);

 }


}
