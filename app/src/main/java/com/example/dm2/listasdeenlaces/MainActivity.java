package com.example.dm2.listasdeenlaces;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView milista;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         MisWebs[] datos =
                new MisWebs[]{
                        new MisWebs("Google", "http://www.google.es", ContextCompat.getDrawable(this, R.drawable.google)),
                        new MisWebs("Bing", "http://www.bing.com", ContextCompat.getDrawable(this, R.drawable.bing)),
                        new MisWebs("yahoo", "http://www.yahoo.es", ContextCompat.getDrawable(this, R.drawable.yahoo)),
                        new MisWebs("Google", "http://www.google.es", ContextCompat.getDrawable(this, R.drawable.google)),
                        new MisWebs("Bing", "http://www.bing.com", ContextCompat.getDrawable(this, R.drawable.bing)),
                        new MisWebs("yahoo", "http://www.yahoo.es", ContextCompat.getDrawable(this, R.drawable.yahoo)),
                        new MisWebs("Google", "http://www.google.es", ContextCompat.getDrawable(this, R.drawable.google)),
                        new MisWebs("Bing", "http://www.bing.com", ContextCompat.getDrawable(this, R.drawable.bing)),
                        new MisWebs("yahoo", "http://www.yahoo.es", ContextCompat.getDrawable(this, R.drawable.yahoo))
                };

        Adaptador adaptador =
                new Adaptador(this, datos);

        milista = (ListView)findViewById(R.id.milista);

        milista.setAdapter(adaptador);


        milista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Alternativa 1:
                // String opcionSeleccionada =
                //((Titular)a.getItemAtPosition(position)).getTitulo();

                //Alternativa 2:
                String opcionSeleccionada = ((TextView) v.findViewById(R.id.url)).getText().toString();
                AbrirNueva (v , opcionSeleccionada);
               // Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(opcionSeleccionada));
               // startActivity(intent);
                //lblEtiqueta.setText("Opción seleccionada: " + opcionSeleccionada);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void AbrirNueva (View view, String sel) {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(sel));
        startActivity(intent);
    }



}
