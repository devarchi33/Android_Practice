package com.iruen.www.adaptersample;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class MainActivity extends ListActivity {

    private List<String> list;
    private ListView lv;
    private ArrayAdapter<String> adapter;
    EditText addText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<String>(Arrays.asList(mString));
        lv = (ListView) findViewById(R.id.list);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

        addText = (EditText) findViewById(R.id.addText);
        Button addItem = (Button) findViewById(R.id.addItem);

        addItem.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence t = addText.getText();
                if(t.length()>0)
                    list.add(t.toString());
                else
                    list.add("Item");
                adapter.notifyDataSetChanged(); //자료를 추가 또는 삭제 시켰다면, 화면에 새롭게 자료를 갱신한다.
            }
        });

//        setContentView(R.layout.activity_main);
//        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mString)); //버튼
//        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mString)); //체크박스
//        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, list)); //라디오 버튼

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });

//        lv.setItemsCanFocus(false); //버튼
//        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); //체크박스
//        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id){
//        Toast.makeText(getApplicationContext(), ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
//    }

    private String[] mString ={"김주찬","신종길","브랫필","나지완","이범호","김주형","최용규","박기남","강한울","양현종"};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
