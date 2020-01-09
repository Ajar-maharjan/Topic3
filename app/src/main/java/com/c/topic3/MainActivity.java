package com.c.topic3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    TextView tvResult;
    Button btSave;
    AutoCompleteTextView actvBatch;
    Spinner sCountry;

    private String[] Country = {"Nepal", "America", "Canada", "Sweden", "Waganda"};
    private String[] Batch = {"22A", "22B", "22C", "21A", "21B"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        tvResult = findViewById(R.id.tvResult);
        btSave = findViewById(R.id.btSave);
        actvBatch = findViewById(R.id.actvBatch);
        sCountry = findViewById(R.id.sCountry);

        ArrayAdapter adaptercountry = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, Country);
        sCountry.setAdapter(adaptercountry);

        ArrayAdapter adapterbatch = new ArrayAdapter(this,
                android.R.layout.select_dialog_item, Batch);
        actvBatch.setAdapter(adapterbatch);
        actvBatch.setThreshold(1);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etName.getText())) {
                    etName.setError("Please enter Name");
                    return;
                }
                if (TextUtils.isEmpty(actvBatch.getText())) {
                    etName.setError("Please enter Batch");
                    return;
                }
                String Name, Batch, Country, Result;
                Name = etName.getText().toString();
                Batch = actvBatch.getText().toString();
                Country = sCountry.getSelectedItem().toString();
                Result = "Name : " + Name + " Country : " + Country +
                        " Batch : " + Batch + "\n";
                tvResult.append(Result);
            }
        });
    }

}
