package com.example.reservations;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class weatherActivity extends AppCompatActivity {

    String result = "";
    TextView tv_weather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        tv_weather = (TextView) findViewById(R.id.tv_weather);
        Handler h = new Handler() {
            public void handleMessage(Message msg) {
                tv_weather.setText(result);

            }
        };
        new WorkerThread(h).start();
    }
    class WorkerThread extends Thread{
        Handler h;

        WorkerThread(Handler h) {
            this.h = h;
        }

        public void run() {
            try{
                URL url = new URL(
                        "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4213037000");
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();
                NodeList nodeList = doc.getElementsByTagName("data");
                for(int i = 0; i< nodeList.getLength(); i++){
                    Node node = nodeList.item(i);
                    NodeList childNodeList = node.getChildNodes();
                    for(int j = 0; j < childNodeList.getLength(); j++){
                        Node childNode = childNodeList.item(j);
                        if(childNode.getNodeName().equals("hour"))
                            result += "시각:" +childNode.getFirstChild().getNodeValue() + " ";
                        if(childNode.getNodeName().equals("temp"))
                            result += "기온:" +childNode.getFirstChild().getNodeValue() + " ";
                        if(childNode.getNodeName().equals("wfKor"))
                            result += "날씨:" +childNode.getFirstChild().getNodeValue() + " ";
                        if(childNode.getNodeName().equals("pop"))
                            result += "강수확률:" +childNode.getFirstChild().getNodeValue();
                    }
                    result += "\n";

                }
                h.sendMessage(new Message());
            }catch (Exception e) {
                tv_weather.setText("파싱 에러 : " + e.toString() );
            }
        }
    }
}
