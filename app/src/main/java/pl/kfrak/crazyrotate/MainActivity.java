package pl.kfrak.crazyrotate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    private int value;
    private TextView wincyjText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wincyjText = (TextView) findViewById(R.id.wincyjText);
        refreshText();
    }

    public void wincyj(View view){
        value++;
        refreshText();
    }

    public void refreshText(){
        wincyjText.setText(Integer.toString(value));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(getClass().getSimpleName(), "onRestoreInstanceState");
        value = savedInstanceState.getInt("liczba", -1);
        refreshText();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(getClass().getSimpleName(), "onSaveInstanceState");
        outState.putInt("liczba", value);
    }
}
