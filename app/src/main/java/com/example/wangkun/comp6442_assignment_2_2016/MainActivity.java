package com.example.wangkun.comp6442_assignment_2_2016;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private TextView textView;
    private boolean refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        gridView = (GridView) findViewById(R.id.gridView);
        registerForContextMenu(gridView);

        gridView.setAdapter(new GridViewAdapter(this));

        textView = (TextView) findViewById(R.id.textView);
        refresh = true;

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (refresh) {
                    textView.setText("");
                    refresh = false;
                }
                String nstr;

                switch (position) {
                    case 0:
                        int n = textView.getText().toString().length();
                        nstr = textView.getText().toString().substring(0, n - 1);//bug length = 0, nothing to enter
                        textView.setText(nstr);
                        System.out.println("press:"+0);
                        break;
                    case 1:
                        ;
                        break;
                    case 2:
                        textView.setText("0");
                        refresh = true;
                        break;
                    case 3:
                        nstr = textView.getText().toString();
                        nstr += "/";
                        textView.setText(nstr);
                        break;
                    case 4:
                        nstr = textView.getText().toString();
                        nstr += "7";
                        textView.setText(nstr);
                        break;
                    case 5:
                        nstr = textView.getText().toString();
                        nstr += "8";
                        textView.setText(nstr);
                        break;
                    case 6:
                        nstr = textView.getText().toString();
                        nstr += "9";
                        textView.setText(nstr);
                        break;
                    case 7:
                        nstr = textView.getText().toString();
                        nstr += "*";
                        textView.setText(nstr);
                        break;
                    case 8:
                        nstr = textView.getText().toString();
                        nstr += "4";
                        textView.setText(nstr);
                        break;
                    case 9:
                        nstr = textView.getText().toString();
                        nstr += "5";
                        textView.setText(nstr);
                        break;
                    case 10:
                        nstr = textView.getText().toString();
                        nstr += "6";
                        textView.setText(nstr);
                        break;
                    case 11:
                        nstr = textView.getText().toString();
                        nstr += "-";
                        textView.setText(nstr);
                        break;
                    case 12:
                        nstr = textView.getText().toString();
                        nstr += "1";
                        textView.setText(nstr);
                        break;
                    case 13:
                        nstr = textView.getText().toString();
                        nstr += "2";
                        textView.setText(nstr);
                        break;
                    case 14:
                        nstr = textView.getText().toString();
                        nstr += "3";
                        textView.setText(nstr);
                        break;
                    case 15:
                        nstr = textView.getText().toString();
                        nstr += "+";
                        textView.setText(nstr);
                        break;
                    case 16:
                        ;
                        break;
                    case 17:
                        nstr = textView.getText().toString();
                        nstr += "0";
                        textView.setText(nstr);
                        break;
                    case 18:
                        nstr = textView.getText().toString();
                        nstr += ".";
                        textView.setText(nstr);
                        break;
                    case 19:
                        if (textView.getText().toString().equals("")){
                            textView.setText("0");
                            refresh = true;
                            break;
                        }
                        nstr = textView.getText().toString();
                        Expression expression = Expression.parse(nstr);
                        nstr = expression.evaluate() + "";
                        textView.setText(nstr);
                        refresh = true;
                        break;


                }
            }
        });
    }


    private class GridViewAdapter extends BaseAdapter {

        private Context context;
        String[] values = {"<-", "+/-", "C", "/", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+","", "0", ".", "="};
        int count = 20;

        public GridViewAdapter(Context context) {
            this.context = context;
        }


        @Override
        public int getCount() {
            return count;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView result = new TextView(context);

            result.setText(values[position]);
            result.setTextColor(Color.BLACK);
            result.setTextSize(66);
            result.setLayoutParams(new AbsListView.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)));
            result.setGravity(Gravity.CENTER);
            result.setBackgroundColor(Color.LTGRAY); //设置背景颜色
            return result;
        }

    }

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
