package tonghopp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tet.Customadapter;
import com.example.tet.DocBao;
import com.example.tet.MainActivity;
import com.example.tet.R;
import com.example.tet.XMLDOMParser;
import tonghoplist.tonghopbaymot;
import com.example.tet.webview;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tonghopbay extends AppCompatActivity {
    ListView listView, listView2, listView3;
    TextView txttieude;
    ImageButton bt, bth;
    Customadapter customadapter, customadapter2, customadapter3;
    ArrayList<DocBao> mangdocbao, mangdocbao2, mangdocbao3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tonghop);
        listView = findViewById(R.id.listview);
        listView2 = findViewById(R.id.listview2);
        bt = findViewById(R.id.bt);
        bth = findViewById(R.id.bthome);
        txttieude = findViewById(R.id.txttieude);
        listView3 = findViewById(R.id.listview3);
        mangdocbao = new ArrayList<DocBao>();
        mangdocbao2 = new ArrayList<DocBao>();
        mangdocbao3 = new ArrayList<DocBao>();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();

            }
        });
        bth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Readdate().execute("https://vnexpress.net/rss/kinh-doanh.rss");
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(tonghopbay.this, webview.class);
                intent.putExtra("link", mangdocbao.get(i).link);
                startActivity(intent);
            }
        });
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Readdate2().execute("https://cdn.24h.com.vn/upload/rss/taichinhbatdongsan.rss");
            }
        });
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(tonghopbay.this, webview.class);
                intent.putExtra("link", mangdocbao2.get(i).link);
                startActivity(intent);
            }
        });
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Readdate3().execute("https://ngoisao.net/rss/thuong-truong.rss");
            }
        });
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(tonghopbay.this, webview.class);
                intent.putExtra("link", mangdocbao3.get(i).link);
                startActivity(intent);
            }
        });
        txttieude.setText("KINH DOANH");
    }



    class Readdate extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            return docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeListitem = document.getElementsByTagName("item");
            NodeList nodeListDiscription = document.getElementsByTagName("description");
            String hinhAnh = "";
            String title = "";
            String link = "";
            String pubDate = "";
            for (int i = 0; i < 5; i++) {
                String cdata = nodeListDiscription.item(i + 1).getTextContent();
                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher m = p.matcher(cdata);
                if (m.find()) {
                    hinhAnh = m.group(1);
                }
                Element element = (Element) nodeListitem.item(i);
                title = parser.getValue(element, "title");
                link = parser.getValue(element, "link");
                pubDate = parser.getValue(element, "pubDate");
                mangdocbao.add(new DocBao(title, link, hinhAnh, pubDate));
            }
            customadapter = new Customadapter(tonghopbay.this, android.R.layout.simple_list_item_1, mangdocbao);
            listView.setAdapter(customadapter);
            super.onPostExecute(s);

        }
    }

    class Readdate2 extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            return docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeListitem = document.getElementsByTagName("item");
            NodeList nodeListDiscription = document.getElementsByTagName("description");
            String hinhAnh = "";
            String title = "";
            String link = "";
            String pubDate = "";
            for (int i = 0; i < 5; i++) {
                String cdata = nodeListDiscription.item(i + 1).getTextContent();
                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher m = p.matcher(cdata);
                if (m.find()) {
                    hinhAnh = m.group(1);
                }
                Element element = (Element) nodeListitem.item(i);
                title = parser.getValue(element, "title");
                link = parser.getValue(element, "link");
                pubDate = parser.getValue(element, "pubDate");
                mangdocbao2.add(new DocBao(title, link, hinhAnh, pubDate));
            }
            customadapter2 = new Customadapter(tonghopbay.this, android.R.layout.simple_list_item_1, mangdocbao2);
            listView2.setAdapter(customadapter2);
            super.onPostExecute(s);

        }
    }

    class Readdate3 extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            return docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeListitem = document.getElementsByTagName("item");
            NodeList nodeListDiscription = document.getElementsByTagName("description");
            String hinhAnh = "";
            String title = "";
            String link = "";
            String pubDate = "";
            for (int i = 0; i < 5; i++) {
                String cdata = nodeListDiscription.item(i + 1).getTextContent();
                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher m = p.matcher(cdata);
                if (m.find()) {
                    hinhAnh = m.group(1);
                }
                Element element = (Element) nodeListitem.item(i);
                title = parser.getValue(element, "title");
                link = parser.getValue(element, "link");
                pubDate = parser.getValue(element, "pubDate");
                mangdocbao3.add(new DocBao(title, link, hinhAnh, pubDate));
            }
            customadapter3 = new Customadapter(tonghopbay.this, android.R.layout.simple_list_item_1, mangdocbao3);
            listView3.setAdapter(customadapter3);
            super.onPostExecute(s);

        }
    }
    private String docNoiDung_Tu_URL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public void openActivity1()
    {
        Intent myIntent=new Intent(this, tonghopbaymot.class);
        startActivity(myIntent);
    }
    public void openActivity2()
    {
        Intent myIntent=new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
