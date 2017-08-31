package com.example.chapa.tarea3u1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private SeekBar sk_br;
    private TextView prog;
    private ListView lista;

    //private ArrayAdapter<String> adp=new ArrayAdapter<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sk_br=(SeekBar)findViewById(R.id.seekBar);
        prog=(TextView)findViewById(R.id.progreso);
        lista=(ListView)findViewById(R.id.lista);


        sk_br.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                prog.setText(progress+"");
                llenarList(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void llenarList(int num){
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getTabla(num));
        //ArrayAdapter<String> adp = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,getTabla(num));//Cambia tamaño
        lista.setAdapter(adp);
    }

    private Vector getTabla(int n){
        Vector<String> vt = new Vector<String>();
        vt.add(n+"");
        for (int i=1;i<11;i++){
            vt.add(n+" x "+i+" = "+(n*i));
        }
        return vt;
    }
}
