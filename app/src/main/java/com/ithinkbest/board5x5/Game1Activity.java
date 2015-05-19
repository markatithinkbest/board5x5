package com.ithinkbest.board5x5;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import b5util.B253;
import b5util.Board5x5;
import b5util.Board5x5Counter;


//300#E0E0E0
//        400#BDBDBD
//        500#9E9E9E
//        600#757575


//public class BtnCntLinesActivity extends Activity implements Button.OnClickListener {
    public class Game1Activity extends ActionBarActivity implements Button.OnClickListener {
    private int color300 = 0xFFE0E0E0;
    private int color400 = 0xFFBDBDBD;
    private int color500 = 0xFF9E9E9E;
    private int color600 = 0xFF757575;


    private static String LOG_TAG = "MARK987";
    private TextView txtStatus;
    private TextView txtDebug1;
    private TextView txtDebug2;


    private List<Button> buttons;
    private List<Integer> checkedList;
    private static final int[] BUTTON_IDS = {
            R.id.btn0,
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9,
            R.id.btn10,
            R.id.btn11,
            R.id.btn12,
            R.id.btn13,
            R.id.btn14,
            R.id.btn15,
            R.id.btn16,
            R.id.btn17,
            R.id.btn18,
            R.id.btn19,
            R.id.btn20,
            R.id.btn21,
            R.id.btn22,
            R.id.btn23,
            R.id.btn24,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        txtStatus=(TextView)findViewById(R.id.txtStatus);
        txtDebug1=(TextView)findViewById(R.id.txtDebug1);
        txtDebug2=(TextView)findViewById(R.id.txtDebug2);


        checkedList = new ArrayList<>();
        buttons = new ArrayList<Button>();
        for (int id : BUTTON_IDS) {
            Button button = (Button) findViewById(id);
            button.setOnClickListener(this); // maybe
            button.setTextAppearance(this, android.R.style.TextAppearance_Large);
            buttons.add(button);
        }
        for (int i = 0; i < 25; i++) {
            buttons.get(i).setText("" + i);
        }
        resetBtnBackgroud();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_btn_cnt_lines_land);


        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_btn_cnt_lines);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_btn, menu);
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


    public static int[] getIntArray(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
    @Override
    public void onClick(View v) {
        int index = v.getId() - R.id.btn0;
        Toast.makeText(this, "index=" + index, Toast.LENGTH_SHORT).show();

        buttons.get(index).setBackgroundColor(color600);
        checkedList.add(index);
        Board5x5 lineCounter=new Board5x5Counter();;
        int[] arr=getIntArray(checkedList);
        lineCounter.setChecked(arr);
        int lineCnt=lineCounter.getLineCount();
        txtStatus.setText("line cnt: "+lineCnt);
        txtDebug1.setText(lineCounter.getTextBoard(1));

        B253 b=new B253();
        txtDebug2.setText(b.toString());

    }

    private void resetBtnBackgroud(){
        for (int i = 0; i < 25; i++) {
            buttons.get(i).setBackgroundColor(color300);
        }
    }
    public void onClickBtnReset(View view) {
        resetBtnBackgroud();
        checkedList.clear();
        txtStatus.setText("");
    }
}
