package tonghoplist;

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
import com.example.tet.webview;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tonghopp.tonghopnam;

public class tonghopnammot extends AppCompatActivity {
    ImageButton bt, bth;
    ListView listView;
    TextView txttieude;
    Customadapter customadapter;
    ArrayList<DocBao> mangdocbao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tonghopmotmot);
        listView = findViewById(R.id.listview);
        bt = findViewById(R.id.bt);
        txttieude = findViewById(R.id.txttieude);
        bth = findViewById(R.id.bthome);
        mangdocbao = new ArrayList<DocBao>();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Readdate().execute("https://vnexpress.net/rss/the-thao.rss");
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(tonghopnammot.this, webview.class);
                intent.putExtra("link", mangdocbao.get(i).link);
                startActivity(intent);
            }
        });
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Readdate().execute("https://cdn.24h.com.vn/upload/rss/thethao.rss");
            }
        });

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Readdate().execute("https://ngoisao.net/rss/the-thao.rss");
            }
        });
        txttieude.setText("THỂ THAO");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();

            }
        });
        bth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
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
            tron(mangdocbao);
            customadapter = new Customadapter(tonghopnammot.this, android.R.layout.simple_list_item_1, mangdocbao);
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

    public  void tron(ArrayList<DocBao> mangdocbao)
    {
        int n = mangdocbao.size();
        int j;
        Random random = new Random(n);
        for (int i =0; i<n; i++)
        {
            DocBao tam;
            j = random.nextInt(n);
            tam=mangdocbao.get(i);
            mangdocbao.set(i, mangdocbao.get(j));
            mangdocbao.set(j, tam);
        }
    }
    public void openActivity()
    {
        Intent myIntent=new Intent(this, tonghopnam.class);
        startActivity(myIntent);
    }
    public void openActivity2()
    {
        Intent myIntent=new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

}
