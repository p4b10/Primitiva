package com.example.primitiva;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	TextView numerosPrimitiva;
	SharedPreferences datosGuardados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numerosPrimitiva=(TextView)findViewById(R.id.textView2);
    	 datosGuardados=getSharedPreferences("datos_guardados",Context.MODE_PRIVATE);
    	numerosPrimitiva.setText(datosGuardados.getString("primitiva",""));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onClickButton(View view){
    	Primitiva.generar();
    	numerosPrimitiva.setText(Primitiva.getNum());
    	this.guardar(view);
    }
    
    public void guardar(View view){
    	Editor editor=datosGuardados.edit();
        editor.putString("primitiva", numerosPrimitiva.getText().toString());
        editor.commit();

    	
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
}
