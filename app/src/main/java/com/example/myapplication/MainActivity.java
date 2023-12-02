package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.CursorAdapter;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnadd;
    private Button btnapri;
    private DbManager db=null;
    private EditText testo;
    private TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnadd = (Button) findViewById(R.id.button);
        testo = (EditText) findViewById(R.id.editTextText);
        btnapri = (Button) findViewById(R.id.button2);
        label = (TextView) findViewById(R.id.textView);

        db=new DbManager(this);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Toast toast= Toast.makeText(MainActivity.this,"dati salvati",Toast.LENGTH_LONG);
                    toast.show();
                    db.save(testo.getEditableText().toString(),
                        "prova2",
                        "prova3");

            }
        });

        btnapri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oggetto = null;
                Toast toast= Toast.makeText(MainActivity.this,"carico i dati",Toast.LENGTH_LONG);
                toast.show();
                Cursor crs=db.getAllRecords();
                while(crs.moveToNext()){
                    oggetto=crs.getString(crs.getColumnIndex(DatabaseStrings.FIELD_SUBJECT)).toString();
                }

                label.setText(oggetto);

            }
        });
    }
}