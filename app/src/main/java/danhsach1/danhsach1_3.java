package danhsach1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tet.Customadapter;
import com.example.tet.DocBao;
import com.example.tet.R;
import com.example.tet.XMLDOMParser;
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

public class danhsach1_3 extends AppCompatActivity {
    ListView listView;
    Customadapter customadapter;
    ArrayList<DocBao> mangdocbao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach1);
        listView = findViewById(R.id.listview);
        mangdocbao = new ArrayList<DocBao>();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Readdate().execute("https://cdn.24h.com.vn/upload/rss/anninhhinhsu.rss");
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(danhsach1_3.this, webview.class);
                intent.putExtra("link", mangdocbao.get(i).link);
                startActivity(intent);
            }
        });
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
            for (int i = 0; i < nodeListitem.getLength(); i++) {
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
            customadapter = new Customadapter(danhsach1_3.this, android.R.layout.simple_list_item_1, mangdocbao);
            listView.setAdapter(customadapter);
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
}
