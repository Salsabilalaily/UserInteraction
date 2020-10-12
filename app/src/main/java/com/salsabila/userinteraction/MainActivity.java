package com.salsabila.userinteraction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText editText;
    TextView textView;
    String label="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner_label);
        editText=findViewById(R.id.edit_input);
        textView=findViewById(R.id.textPhone);

        //template adapter untuk mengintegrasikan menu dropdown yang ada di spinner di entries yang dikomen:
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.
                createFromResource(this, R.array.labels,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        //lalu disini kita integrasikan antara spinner dan adapter dengan data di dalam array labels:
        if (spinner!=null){
            spinner.setAdapter(adapter);

            //untuk menentukan user memilih spinner yang mana, gunakan on item selected listener:
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    //untuk mengambil data di posisi tersebut:
                    label=adapterView.getItemAtPosition(i).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
    }

    public void showText(View view) {
        String showString="Phone number: "+label+" - "+editText.getText().toString();
        textView.setText(showString);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked=((RadioButton)view).isChecked();
        switch (view.getId()) {
            case R.id.radio_p1:
                if (checked)
                    Toast.makeText(this, "Anda memilih TRPL 2017",
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_p2:
                if (checked)
                    Toast.makeText(this, "Anda memilih TRPL 2018",
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_p3:
                if (checked)
                    Toast.makeText(this, "Anda memilih TRPL 2019",
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_p4:
                if (checked)
                    Toast.makeText(this, "Anda memilih TRPL 2020",
                            Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void showAlert(View view) {
        AlertDialog.Builder myAlertBuilder= new AlertDialog.Builder(this);
        myAlertBuilder.setTitle("Alert");
        myAlertBuilder.setMessage("Click 'Next' to continue or 'Quit' to cancel");
        myAlertBuilder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Anda memilih Next",
                        Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Anda memilih Quit",
                        Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Toast.makeText(this, "Anda memilih menu 1",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu2:
                Toast.makeText(this, "Anda memilih menu 2",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu3:
                Toast.makeText(this, "Anda memilih menu 3",
                        Toast.LENGTH_SHORT).show();
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}