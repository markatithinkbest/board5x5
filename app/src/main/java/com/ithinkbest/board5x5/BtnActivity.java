package com.ithinkbest.board5x5;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class BtnActivity extends ActionBarActivity implements Button.OnClickListener{
    private static String LOG_TAG="MARK987";
    private List<Button> buttons;
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
        setContentView(R.layout.activity_btn);

        buttons = new ArrayList<Button>();
        for (int id : BUTTON_IDS) {
            Button button = (Button) findViewById(id);
            button.setOnClickListener(this); // maybe
            button.setTextAppearance(this, android.R.style.TextAppearance_Large);
            buttons.add(button);
        }
        for (int i=0;i<25;i++){
            buttons.get(i).setText(""+i);
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

    @Override
    public void onClick(View v) {
        int index = v.getId() - R.id.btn0;
        Toast.makeText(this,"index="+index,Toast.LENGTH_SHORT).show();
        Log.d(LOG_TAG,"..."+buttons.get(index).getBackground());
//        if (buttons.get(index).getBackground())
    }

    public void onClickBtnReset(View view) {
        for (int i=0;i<25;i++){
          //  buttons.get(i).setBackgroundColor(null);
            buttons.get(i).setBackgroundResource(android.R.drawable.btn_default);
        }
    }
}
