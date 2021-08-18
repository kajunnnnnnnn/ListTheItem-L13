package sg.edu.rp.c346.id20026955.listtheitem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etDo, etDesc, etDate;
    Button btnInsert, btnShow;
    RadioGroup rgUrgency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDo = findViewById(R.id.etDo);
        etDesc = findViewById(R.id.etDescription);
        etDate = findViewById(R.id.editTextDate);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);
        rgUrgency = findViewById(R.id.rgUrgency);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etDo.getText().toString().trim();
                String description = etDesc.getText().toString().trim();
                String date = etDate.getText().toString().trim();
                if (name.length() == 0 || description.length() == 0 || date.length() == 0) {
                    Toast.makeText(MainActivity.this, "Incomplete data", Toast.LENGTH_SHORT).show();
                    return;
                }
                int selectedId = rgUrgency.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
                int urgency = Integer.parseInt(selectedRadioButton.getText().toString());

                DBHelper dbh = new DBHelper(MainActivity.this);

                dbh.insertTask(name, description, date, urgency);
                dbh.close();
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();

                etDo.setText("");
                etDesc.setText("");
                etDate.setText("");
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }
}