package com.example.home_work_7;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import com.example.home_work_7.databinding.ActivityMainBinding;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;
    EditText et;
    Button b1;
    Button b2;
    String link;
    WebView webview;
    ArrayList<String> l = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        et= (EditText)findViewById(R.id.t1);
        b1= (Button)findViewById(R.id.b1);
        b2= (Button)findViewById(R.id.b2);
        webview = (WebView) findViewById(R.id.webview);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link = et.getText().toString();
                webview.loadUrl(link);
            }
        });
        setSupportActionBar(binding.toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        addMenu(menu);
        return true;
    }
    private void addMenu(final Menu menu) {
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=0;
                menu.add(0, i, i, link);
                Toast.makeText(MainActivity.this, "Added BookMark Successfully", Toast.LENGTH_SHORT).show();
                i++;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return menuChoice(item);
    }
    private boolean menuChoice(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                String webview1 =item.getTitle().toString();
                webview.loadUrl(webview1);
                return true;
        }
        return false;
    }
}