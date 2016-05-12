package com.example.wangkun.comp6442_assignment_2_2016;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
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

public class ScientificActivity extends AppCompatActivity {

    private GridView gridView;
    private TextView textView;
    private boolean refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);

        gridView = (GridView) findViewById(R.id.gridView1);
        registerForContextMenu(gridView);

        gridView.setAdapter(new GridViewAdapter(this));//set the gridView adapter.

        textView = (TextView) findViewById(R.id.textView1);

        refresh = true;

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (refresh) {
                    textView.setText("");
                    refresh = false;
                }
                String nstr;
                // TODO: 11/05/16 finish switch statement
                /*switch (position) {
                    case 0:
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

                        String str = hasException(nstr);
                        if (str.equals(nstr)) {//no error, can evaluate the expression
                            Expression expression = Expression.parse(nstr);
                            nstr = expression.evaluate().toString();
                            System.out.println(nstr);
                            textView.setText(nstr);
                        } else {//if there are some errors, print out the error type.
                            textView.setText(str);
                        }
                        refresh = true;
                        break;
                }*/
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

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void launchMainActivity(View view) {
//        Intent launchMainActivityIntent = new Intent(this, MainActivity.class);
//        startActivity(launchMainActivityIntent);
//    }

    private class GridViewAdapter extends BaseAdapter {

        private Context context;
        String[] values = {"<-", "(", ")", "Rand", "x^-1", "x^y", "", "sin", "cos", "tan", "cot", "e", "π", "ln", "log10", "Abs", "sqrt", "x^2", "/", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+", "C", "0", ".", "="};
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


        //this method is for set the items' attributes.
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

}
