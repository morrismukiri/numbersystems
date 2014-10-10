package com.cromemedia.morris.numbersystems;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import  com.cromemedia.morris.numbersystems.NoSystemConversion;
public class Home extends ActionBarActivity {
    private EditText inputNo;
    private Button convertBtn;

    private TextView binAns;
    private TextView octAns;
    private TextView decAns;
    private TextView hexAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inputNo= (EditText) findViewById(R.id.editText);
        convertBtn=(Button) findViewById(R.id.convertBtn);
        binAns=(TextView) findViewById(R.id.binAnswer);
        octAns=(TextView) findViewById(R.id.octAnswer);
        decAns=(TextView) findViewById(R.id.decAnswer);
        hexAns=(TextView) findViewById(R.id.hexAnswer);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String enteredText= inputNo.getText().toString();
                String from=NoSystemConversion.GuessNoSystem(enteredText);
                binAns.setText(NoSystemConversion.convertNo(enteredText,from,"bin"));
                octAns.setText(NoSystemConversion.convertNo(enteredText,from,"oct"));
                decAns.setText(NoSystemConversion.convertNo(enteredText,from,"dec"));
                hexAns.setText(NoSystemConversion.convertNo(enteredText,from,"hex"));

            }


        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public String convertNo(String no,String from,String to){
        String ans="";
        if(from.equals(to)){
            return no;
        }
        if(from.equals("int")){
            return this.convertInt(Integer.parseInt(no),to);
        }else if(from.equals("bin")){
            return  this.convertBin(no,to);
        }else if(from.equals("oct")){
            return this.convertOct(no,to);
        }else if(from.equals("hex")){
            return this.convertHex(no,to);
        }
        return  ans;
    }
    public String convertBin(String bin,String to){
        String ans="";
        if (to.equals("dec")) {
            ans = Integer.toString(Integer.parseInt(bin, 2));

        } else if (to.equals("oct")) {
            ans = Integer.toOctalString(Integer.parseInt(bin, 2));

        } else if (to.equals("hex")) {
            ans = Integer.toHexString(Integer.parseInt(bin, 2));

        }
        return  ans;
    }

    public String convertOct(String oct,String to){
        String ans="";
        if (to.equals("dec")) {
            ans = Integer.toString(Integer.parseInt(oct, 8));

        } else if (to.equals("bin")) {
            ans = Integer.toBinaryString(Integer.parseInt(oct, 8));

        } else if (to.equals("hex")) {
            ans = Integer.toHexString(Integer.parseInt(oct, 8));

        }
        return  ans;
    }
    public String convertHex(String hex,String to){
        String ans="";
        if (to.equals("dec")) {
            ans = Integer.toString(Integer.parseInt(hex, 16));

        } else if (to.equals("bin")) {
            ans = Integer.toBinaryString(Integer.parseInt(hex, 16));

        } else if (to.equals("oct")) {
            ans = Integer.toOctalString(Integer.parseInt(hex, 16));

        }
        return  ans;
    }
    public String convertInt(int no,String to){
        String ans="";
        if(to.equals("bin")){
            ans=Integer.toBinaryString(no);
        }else if(to.equals("oct")){
            ans=Integer.toOctalString(no);
        }else if(to.equals("hex")){
            ans=Integer.toHexString(no);
        }
        return ans;
    }



}
