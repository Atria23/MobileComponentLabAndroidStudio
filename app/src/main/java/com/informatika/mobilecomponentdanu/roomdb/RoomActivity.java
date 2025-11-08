package com.informatika.mobilecomponentdanu.roomdb;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import com.informatika.mobilecomponentdanu.R;
import java.util.List;

public class RoomActivity extends AppCompatActivity {
    EditText edtNote;
    Button btnAdd;
    AppDatabase db;
    RecyclerView recyclerView; // Ganti TextView dengan RecyclerView
    NoteAdapter noteAdapter;  // Tambahkan Adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        edtNote = findViewById(R.id.edtNote);
        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recyclerViewNotes); // Inisialisasi RecyclerView

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(); // Buat instance adapter
        recyclerView.setAdapter(noteAdapter); // Set adapter ke RecyclerView

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "note_db")
                .allowMainThreadQueries()
                .build();

        btnAdd.setOnClickListener(v -> {
            String noteText = edtNote.getText().toString();
            if (noteText.isEmpty()) {
                return;
            }
            Note n = new Note();
            n.text = noteText;
            db.noteDao().insert(n);

            edtNote.setText(""); // Kosongkan input field setelah menambah
            showAll();
        });

        showAll(); // Tampilkan data saat pertama kali dibuka
    }

    void showAll() {
        List<Note> notes = db.noteDao().getAll();
        noteAdapter.updateData(notes); // Kirim data baru ke adapter
    }
}