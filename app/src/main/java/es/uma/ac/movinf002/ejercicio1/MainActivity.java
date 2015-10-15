package es.uma.ac.movinf002.ejercicio1;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends ActionBarActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button redButton = (Button) findViewById(R.id.button_red);
        redButton.setOnClickListener(this);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(this);
        ImageView image = (ImageView) findViewById(R.id.logo);
        image.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        TextView tv = (TextView) findViewById(R.id.texto);
        ColorDrawable d = (ColorDrawable) tv.getBackground();
        savedInstanceState.putInt("COLOR", d.getColor());

        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        TextView tv = (TextView) findViewById(R.id.texto);
        int color = savedInstanceState.getInt("COLOR");
        tv.setBackgroundColor(color);
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

    @Override
    public void onClick(View v) {
        TextView texto = (TextView) findViewById(R.id.texto);
        switch (v.getId()) {
            case R.id.button_red:
                texto.setBackgroundColor(getResources().getColor(R.color.RED));
                break;
            case R.id.logo:
                texto.setBackgroundColor(getResources().getColor(R.color.GREY));
                break;
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        TextView texto = (TextView) findViewById(R.id.texto);
        switch (group.getId()) {
            case R.id.radio:
                if (checkedId == R.id.radio_blue) {
                    texto.setBackgroundColor(getResources().getColor(R.color.BLUE));
                } else if (checkedId == R.id.radio_green) {
                    texto.setBackgroundColor(getResources().getColor(R.color.GREEN));
                }
                break;
        }

    }
}
