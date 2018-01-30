package OperationXml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

public class ResolveXML {
    /**
     * 执行
     */
    @Test
    public void resolve() {
        //开始解析XML文件
        //创建一个SAXreader的对象
        SAXReader reader = new SAXReader();
        //通过SAXreader对象的read()方法加载XML文件
        try {
            Document document = reader.read(new File("src/main/resources/HelloWorld.xml"));
            Element bookstore = document.getRootElement();                 //获取根节点元素
            System.out.println("<"+bookstore.getName()+">");        //获取根节点标签名
            Iterator<Element> it = bookstore.elementIterator();            //创建根节点下层迭代器
            int i=1;
            while(it.hasNext()){
                Element book = it.next();
                System.out.print("   <" +book.getName());
                List<Attribute> bookAttrs = book.attributes();                  //第二节点集合
                for (Attribute attribute : bookAttrs) {
                    System.out.print("  "+attribute.getValue()+"=");
                    if(attribute.getName().equals("id")){
                        System.out.println( attribute.getValue()+">");
                    }
                }
                Iterator<Element> itt = book.elementIterator();                //第三节点结合
                while (itt.hasNext()) {
                    Element bookChild = itt.next();
                    String name = bookChild.getName();
                    String stringValue = bookChild.getStringValue();
                    System.out.println("      <"+name+">" + stringValue+ "</"+name+">");
                }
                i++;
                System.out.println("   </" +book.getName()+">");
            }
            System.out.print("</"+bookstore.getName()+">");
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void alternode() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/main/resources/HelloWorld.xml"));

        Element root = document.getRootElement();           //获取根元素
        Element nameElem=root.element("book").element("name");
        nameElem.setText("王二麻子");                                   //修改文本
//        while(iterator.hasNext()){
//            Element book = iterator.next();
//            List<Attribute> bookAttrs = book.attributes();                  //第二节点集合
//            for (Attribute attribute : bookAttrs) {
//                if(attribute.getName().equals("id")){
//                    attribute.setValue("你您您您");                 //修改属性值
//                    attribute.setData("sdsds");                     //修改属性值
//                }
//            }
//        Iterator<Element> itt = book.elementIterator();                //第三节点集合
//        while (itt.hasNext()) {
//            Element bookChild = itt.next();
//
//            String name = bookChild.getName();
//            String stringValue = bookChild.getStringValue();
//            System.out.println("节点名字："+name + "------" +"节点值："+stringValue);
//            if (name.equals("price"))
//            {
//                bookChild.addAttribute("AAAAAAA","价钱好说");
//            }
//        }D:\ideaproject\CreatUtils\src\main\resources
//        }
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("src/main/resources/HelloWorld.xml"),"utf-8");
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out,format);
                  //将java代码修改了的dom写到xml文件中
        writer.write(document);
        writer.close();

    }
}
