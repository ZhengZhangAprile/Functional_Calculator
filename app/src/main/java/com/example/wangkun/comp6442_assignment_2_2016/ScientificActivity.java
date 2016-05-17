package com.example.wangkun.comp6442_assignment_2_2016;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
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
import java.lang.*;
import java.math.RoundingMode;


/**
 * @author Kum Wang and Zheng Zhang
 * @decription Scientific activity is for scientific mode of the calculator.Using GridViewAdapter class
 * build clickable views, which is very similar to button, to help user input their
 * calculation formulas.
 */
public class ScientificActivity extends AppCompatActivity {

    private GridView gridView;
    private TextView textView1, textView2;
    private boolean refresh;

    String filename = "myfile";
    String string="";
    FileOutputStream outputStream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);

        gridView = (GridView) findViewById(R.id.gridView1);
        registerForContextMenu(gridView);

        gridView.setAdapter(new GridViewAdapter(this));//set the gridView adapter.

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

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        refresh = true;

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (refresh) {
                    textView1.setText("");
                    refresh = false;
                }
                String nstr;
                String flag = textView2.getText().toString();//shows the Deg or Rad signal
                int signal = 0;
                // TODO: 11/05/16 finish switch statement
                switch (position) {
                    case 0://Rad/Deg
                        if (flag.equals("") || flag.equals("Rad")) {
                            textView2.setText("Deg");//when textView2 prints Deg, the Deg mode opens
                        }
                        if (flag.equals("Deg")) {
                            textView2.setText("Rad");//when textView2 prints Rad or nothing, the Rad mode opens
                        }
                        break;
                    case 1:
                        nstr = textView1.getText().toString();
                        nstr += "sqrt(";
                        textView1.setText(nstr);
                        break;
                    case 2:
                        nstr = textView1.getText().toString();
                        nstr += "^";
                        textView1.setText(nstr);
                        break;
                    case 3:
                        int n = textView1.getText().toString().length();
                        if (n <= 1) {
                            textView1.setText("0");
                            refresh = true;
                        } else {
                            nstr = textView1.getText().toString().substring(0, n - 1);
                            textView1.setText(nstr);
                        }
                        break;
                    case 4:
                        nstr = textView1.getText().toString();
                        nstr += "(";
                        textView1.setText(nstr);
                        break;
                    case 5:
                        nstr = textView1.getText().toString();
                        nstr += ")";
                        textView1.setText(nstr);
                        break;
                    case 6:
                        nstr = textView1.getText().toString();
                        nstr += "/";
                        textView1.setText(nstr);
                        break;
                    case 7:
                        nstr = textView1.getText().toString();
                        nstr += "sin(";
                        textView1.setText(nstr);
                        break;
                    case 8:
                        nstr = textView1.getText().toString();
                        nstr += "cos(";
                        textView1.setText(nstr);
                        break;
                    case 9:
                        nstr = textView1.getText().toString();
                        nstr += "tan(";
                        textView1.setText(nstr);
                        break;
                    case 10:
                        nstr = textView1.getText().toString();
                        nstr += "7";
                        textView1.setText(nstr);
                        break;
                    case 11:
                        nstr = textView1.getText().toString();
                        nstr += "8";
                        textView1.setText(nstr);
                        break;
                    case 12:
                        nstr = textView1.getText().toString();
                        nstr += "9";
                        textView1.setText(nstr);
                        break;
                    case 13:
                        nstr = textView1.getText().toString();
                        nstr += "×";
                        textView1.setText(nstr);
                        break;
                    case 14:
                        nstr = textView1.getText().toString();
                        nstr += "sinh(";
                        textView1.setText(nstr);
                        break;
                    case 15:
                        nstr = textView1.getText().toString();
                        nstr += "cosh(";
                        textView1.setText(nstr);
                        break;
                    case 16:
                        nstr = textView1.getText().toString();
                        nstr += "tanh(";
                        textView1.setText(nstr);
                        break;
                    case 17:
                        nstr = textView1.getText().toString();
                        nstr += "4";
                        textView1.setText(nstr);
                        break;
                    case 18:
                        nstr = textView1.getText().toString();
                        nstr += "5";
                        textView1.setText(nstr);
                        break;
                    case 19:
                        nstr = textView1.getText().toString();
                        nstr += "6";
                        textView1.setText(nstr);
                        break;
                    case 20:
                        nstr = textView1.getText().toString();
                        nstr += "-";
                        textView1.setText(nstr);
                        break;
                    case 21:
                        nstr = textView1.getText().toString();
                        nstr += "abs(";
                        textView1.setText(nstr);
                        break;
                    case 22:
                        nstr = textView1.getText().toString();
                        nstr += "log(";
                        textView1.setText(nstr);
                        break;
                    case 23:
                        nstr = textView1.getText().toString();
                        nstr += "ln(";
                        textView1.setText(nstr);
                        break;
                    case 24:
                        nstr = textView1.getText().toString();
                        nstr += "1";
                        textView1.setText(nstr);
                        break;
                    case 25:
                        nstr = textView1.getText().toString();
                        nstr += "2";
                        textView1.setText(nstr);
                        break;
                    case 26:
                        nstr = textView1.getText().toString();
                        nstr += "3";
                        textView1.setText(nstr);
                        break;
                    case 27:
                        nstr = textView1.getText().toString();
                        nstr += "+";
                        textView1.setText(nstr);
                        break;
                    case 28:
                        nstr = textView1.getText().toString();
                        nstr += "e";
                        textView1.setText(nstr);
                        break;
                    case 29:
                        nstr = textView1.getText().toString();
                        nstr += "π";
                        textView1.setText(nstr);
                        break;
                    case 30:
                        nstr = textView1.getText().toString();
                        nstr += "rand(";
                        textView1.setText(nstr);
                        break;
                    case 31:
                        textView1.setText("0");
                        refresh = true;
                        break;
                    case 32:
                        nstr = textView1.getText().toString();
                        nstr += "0";
                        textView1.setText(nstr);
                        break;
                    case 33:
                        nstr = textView1.getText().toString();
                        nstr += ".";
                        textView1.setText(nstr);
                        break;
                    case 34:
                        if (textView1.getText().toString().equals("")) {
                            textView1.setText("0");
                            refresh = true;
                            break;
                        }
                        nstr = textView1.getText().toString();
                        String ans = "";
                        String str = hasException(nstr);
                        if (str.equals(nstr)) {//no error, can evaluate the expression
                            if (textView2.getText().toString().equals("Deg"))
                                signal = 1;
                            Expression expression = null;
                            try {
                                expression = Expression.parse(nstr, signal);
                            } catch (Exception e) {
                                textView1.setText("ERROR");
                                refresh = true;
                                break;
                            }
                            if (expression.evaluate() == null)
                                ans = "illegal formula";
                                //keep 6 digits and round the result
                            else {
                                double result = expression.evaluate().setScale(6, RoundingMode.HALF_UP).doubleValue();
                                if (result == 1.633123935319537E16)
                                    ans = "Infinity";
                                else ans = result + "";
                            }
                            textView1.setText(ans);
                        } else {//if there are some errors, print out the error type.
                            textView1.setText(str);
                            ans = str;
                        }
                        nstr = nstr + "=" + ans + "\n";
                        System.out.println(nstr);
                        try {
                            FileInputStream fin = openFileInput(filename);
                            int length = fin.available();
                            byte[] buffer = new byte[length];
                            fin.read(buffer);
                            string = new String(buffer, "UTF-8");
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
                if (textView1.getText().length() < 9) {
                    textView1.setTextSize(72);
                } else if (textView1.getText().length() > 8 && textView1.getText().length() < 12) {
                    textView1.setTextSize(64);
                } else if (textView1.getText().length() > 11 && textView1.getText().length() < 15) {
                    textView1.setTextSize(48);
                } else if (textView1.getText().length() > 14) {
                    textView1.setTextSize(36);
                }
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();


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
        if (id == R.id.history) {
            launchHistoryActivity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //conduct a GridView adapter to modify the gridView. Adding
    //textView to show the calculator keywords and lines between them.
    private class GridViewAdapter extends BaseAdapter {

        private Context context;
        String[] values =
                {"Rad/Deg", "sqrt", "x^y", "<-", "(", ")", "/",
                        "sin", "cos", "tan", "7", "8", "9", "x",
                        "sinh", "cosh", "tanh", "4", "5", "6", "-",
                        "abs", "log", "ln", "1", "2", "3", "+",
                        "e", "π", "rand", "C", "0", ".", "="};
        int count = 35;

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
            result.setTextSize(16);
            result.setLayoutParams(new AbsListView.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)));
            result.setGravity(Gravity.CENTER);
            result.setBackgroundColor(Color.LTGRAY); //set items' background color.
            return result;
        }

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

    private void launchHistoryActivity() {
        Intent launchHistoryActivityIntent = new Intent(this, HistoryActivity.class);
        startActivity(launchHistoryActivityIntent);
    }

}
