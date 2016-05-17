package com.example.wangkun.comp6442_assignment_2_2016;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.RoundingMode;


/**
 * @author Zheng Zhang and Kun Wang
 * @description Main activity shows the basic mode of the calculator. Using GridViewAdapter class
 *               build clickable views, which is very similar to button, to help user input their
 *               calculation formulas.
 */
public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private TextView textView;
    private boolean refresh;

    String filename = "myfile";
    String string="";

    FileOutputStream outputStream;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            File f = Environment.getDataDirectory();
            //if(!f.exists()){

                outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                outputStream.write(string.getBytes());
                outputStream.close();
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }

        gridView = (GridView) findViewById(R.id.gridView);
        registerForContextMenu(gridView);

        gridView.setAdapter(new GridViewAdapter(this));//set the gridView adapter.

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
                    case 0://Rad and Deg transfer
                        int n = textView.getText().toString().length();
                        if (n <= 1) {
                            textView.setText("0");
                            refresh = true;
                        } else {
                            nstr = textView.getText().toString().substring(0, n - 1);
                            textView.setText(nstr);
                        }
                        break;
                    case 1:
                        nstr = textView.getText().toString();
                        nstr += "(";
                        textView.setText(nstr);
                        break;
                    case 2:
                        nstr = textView.getText().toString();
                        nstr += ")";
                        textView.setText(nstr);
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
                        nstr += "×";
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
                        textView.setText("0");
                        refresh = true;
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
                        if (textView.getText().toString().equals("")) {
                            textView.setText("0");
                            refresh = true;
                            break;
                        }

                        nstr = textView.getText().toString();
                        String ans = "";
                        String str = hasException(nstr);
                        if (str.equals(nstr)) {//no error, can evaluate the expression
                            Expression expression = null;
                            try {
                                expression = Expression.parse(nstr, 0);
                            } catch (Exception e) {
                                textView.setText("ERROR");
                                break;
                            }
                            if(expression.evaluate()==null){
                                ans = "illegal formula ";
                            }else{
                            //keep 6 digits and round the result
                            double result = expression.evaluate().setScale(6, RoundingMode.HALF_UP).doubleValue();
                                if(result==1.633123935319537E16)
                                    ans = "Infinity";
                                else ans = result+"";
                            }
                            textView.setText(ans);
                        } else {//if there are some errors, print out the error type.
                            textView.setText(str);
                            ans = str;
                        }
                        nstr = nstr + "=" + ans + "\n";
                        System.out.println("string is :"+nstr);
                        try {
                            FileInputStream fin = openFileInput(filename);
                            int length = fin.available();
                            System.out.println("file length :" + length);
                            byte [] buffer = new byte[length];
                            fin.read(buffer);
                            String string = new String(buffer,"UTF-8");
                            fin.close();
                            nstr = string + nstr;
                            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                            outputStream.write(nstr.getBytes());
                            outputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        refresh = true;
                        break;
                }

                // Minimise the text size when the digits of input number increasing.
                if (textView.getText().length() < 9) {
                    textView.setTextSize(72);
                } else if (textView.getText().length() > 8 && textView.getText().length() < 12) {
                    textView.setTextSize(64);
                } else if (textView.getText().length() > 11 && textView.getText().length() < 15) {
                    textView.setTextSize(48);
                } else if (textView.getText().length() > 14) {
                    textView.setTextSize(36);
                }
            }
        });
    }

    //conduct a GridView adapter to modify the gridView. Adding
    //textView to show the calculator keywords and lines between them.
    private class GridViewAdapter extends BaseAdapter {

        private Context context;
        String[] values = {"<-", "(", ")", "/", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+", "C", "0", ".", "="};
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


        //this method is for setting the items' attributes.
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView result = new TextView(context);

            result.setText(values[position]);
            result.setTextColor(Color.BLACK);
            result.setTextSize(48);
            result.setLayoutParams(new AbsListView.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)));
            result.setGravity(Gravity.CENTER);
            result.setBackgroundColor(Color.LTGRAY); //set items' background color.
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
        if (id == R.id.scientific) {
            launchScientificActivity();
            return true;
        }
        if(id == R.id.history){
            launchHistoryActivity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    //judge if this expression is legal for parse.when the str is legal return it back, else return
    //different string to show different problem
    public String hasException(String nstr) {
        char[] operators = {'+', '-', '×', '/', '.'};

        //the string starts with operators "×" and "/" are not allowed
        if (nstr.charAt(0) == '×' || nstr.charAt(0) == '/')
            return "parameter missing";
        //the number of front and back brackets is same
        int front = 0, back = 0;
        for (char c : nstr.toCharArray()) {
            if (c == '(') {
                front++;
            }
            if (c == ')') {
                back++;
            }
        }
        if (front != back) {
            return "bracket missing";
        } else {
            char c = nstr.charAt(nstr.length() - 1);
            for (int i = 0; i < operators.length; i++) {
                if (c == operators[i]) {
                    return "parameter missing";
                }//last element can't be an operator.
            }

            for (int k = 0; k < nstr.length(); k++) {
                for (int j = 0; j < operators.length; j++) {
                    if (nstr.charAt(k) == operators[j] || nstr.charAt(k) == '(') {
                        for (int l = 0; l < operators.length; l++) {
                            if (nstr.charAt(k + 1) == operators[l] || nstr.charAt(k + 1) == ')') {
                                if (nstr.charAt(k) == '(' && nstr.charAt(k + 1) == '-' || nstr.charAt(k) == '(' && nstr.charAt(k + 1) == '+')
                                    return nstr;
                                else
                                    return "two operators near by";

                            }
                        }
                    }
                }
            }
        }
        return nstr;
    }

    public void launchScientificActivity() {
        Intent launchScientificActivityIntent = new Intent(this, ScientificActivity.class);
        startActivity(launchScientificActivityIntent);
    }

    private void launchHistoryActivity() {
        Intent launchHistoryActivityIntent = new Intent(this, HistoryActivity.class);
        startActivity(launchHistoryActivityIntent);
    }

}
