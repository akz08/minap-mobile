package com.team7.minap.xmltesting;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class XMLTestTakeOne {
    Vector students_Vector;

    private Vector readXMLFile(String file) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(file); // 获取到xml文件 // 
        // 下面开始读取 //start reading 
        Element root = doc.getDocumentElement(); // 获取根元素 
        NodeList students = root.getElementsByTagName("student");
        students_Vector = new Vector();
        for (int i = 0; i < students.getLength(); i++) {
            // 一次取得每一个student元素
            Element ss = (Element) students.item(i);

            // 创建一个student的实例
            student stu = new student();
            stu.setgender(ss.getAttribute("gender"));

            NodeList names = ss.getElementsByTagName("name");
            Element e = (Element) names.item(0);
            Node t = e.getFirstChild();
            stu.setName(t.getNodeValue());

            NodeList ages = ss.getElementsByTagName("age");
            e = (Element) ages.item(0);
            t = e.getFirstChild();
            stu.setAge(Integer.parseInt(t.getNodeValue()));

            students_Vector.add(stu);
        }
        return students_Vector;
    }

    /**
     * 功能：直接提取XML格式字符串中的信息
     */
    private Vector readXMLString(String xmlStr) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        InputStream inputStream = new ByteArrayInputStream(xmlStr.getBytes());
        Document doc = builder.parse(inputStream); //
        // 下面开始读取
        Element root = doc.getDocumentElement(); // 获取根元素
        NodeList students = root.getElementsByTagName("student");
        students_Vector = new Vector();
        for (int i = 0; i < students.getLength(); i++) {
            // 一次取得每一个student元素
            Element ss = (Element) students.item(i);

            // 创建一个student的实例
            student stu = new student();
            stu.setgender(ss.getAttribute("gender"));

            NodeList names = ss.getElementsByTagName("name");
            Element e = (Element) names.item(0);
            Node t = e.getFirstChild();
            stu.setName(t.getNodeValue());

            NodeList ages = ss.getElementsByTagName("age");
            e = (Element) ages.item(0);
            t = e.getFirstChild();
            stu.setAge(Integer.parseInt(t.getNodeValue()));

            students_Vector.add(stu);
        }
        return students_Vector;
    }

    // 将Document内容 写入XML字符串并返回
    private String callWriteXmlString(Document doc, String encoding) {

        try {
            Source source = new DOMSource(doc);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            OutputStreamWriter write = new OutputStreamWriter(outStream);
            Result result = new StreamResult(write);

            Transformer xformer = TransformerFactory.newInstance()
                    .newTransformer();
            xformer.setOutputProperty(OutputKeys.ENCODING, encoding);

            xformer.transform(source, result);
            return outStream.toString();

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (TransformerException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 功能：生成XML格式的字符串
     */
    public String writeXMLString() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = dbf.newDocumentBuilder();
        } catch (Exception e) {
        }
        Document doc = builder.newDocument();

        Element root = doc.createElement("studentnamelist");
        doc.appendChild(root); // 将根元素添加到文档上

        // 获取student信息
        for (int i = 0; i < students_Vector.size(); i++) {
            student s = (student) students_Vector.get(i);
            // 创建一个student
            Element stu = doc.createElement("student");
            stu.setAttribute("gender", s.getgender());
            root.appendChild(stu);// 添加属性

            // 创建文本name节点
            Element name = doc.createElement("name");
            stu.appendChild(name);
            Text tname = doc.createTextNode(s.getName());
            name.appendChild(tname);

            // 创建文本age节点
            Element age = doc.createElement("age");
            stu.appendChild(age); // 将age添加到student节点上
            Text tage = doc.createTextNode(String.valueOf(s.getAge()));
            age.appendChild(tage); // 将文本节点放在age节点上
        }
        try {
            String result = callWriteXmlString(doc, "gb2312");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 主函数
     */
    public static void main(String args[]) {
        String str = "test.xml";//文件位置
        XMLTestTakeOne t = new XMLTestTakeOne();
        System.out.println("解析原始XML文件：");
        try {
            Vector v = t.readXMLFile(str);
            Iterator it = v.iterator();
            while (it.hasNext()) {
                student s = (student) it.next();
                System.out.println(s.getName() + "\t" + s.getAge() + "\t"
                        + s.getgender());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        String xmlStr = t.writeXMLString();
        System.out.println("\n生成的XML字符串：\n" + xmlStr);
        try {
            Vector v = t.readXMLString(xmlStr);
            Iterator it = v.iterator();
            System.out.println("\n解析生成的XML字符串：");
            while (it.hasNext()) {
                student s = (student) it.next();
                System.out.println(s.getName() + "\t" + s.getAge() + "\t"
                        + s.getgender());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class student {
    private String gender;
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setgender(String s) {
        gender = s;
    }

    public String getgender() {
        return gender;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
}