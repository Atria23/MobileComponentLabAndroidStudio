package com.informatika.mobilecomponentdanu.sharedprefs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.informatika.mobilecomponentdanu.R;

public class SharedPrefsActivity extends AppCompatActivity {
    EditText edtName, edtNote;
    TextView txtResult;
    Button btnSave;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs);

        edtName = findViewById(R.id.edtName);
        edtNote = findViewById(R.id.edtNote);
        btnSave = findViewById(R.id.btnSave);
        txtResult = findViewById(R.id.txtResult);

        sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // load data sebelumnya
        edtName.setText(sp.getString("name", ""));
        edtNote.setText(sp.getString("note", ""));
        txtResult.setText(sp.getString("name", "") + ": " + sp.getString("note", ""));

        btnSave.setOnClickListener(v -> {
            sp.edit().putString("name", edtName.getText().toString())
                    .putString("note", edtNote.getText().toString())
                    .apply();
            txtResult.setText("Tersimpan: " + edtName.getText().toString());
        });
    }
}
