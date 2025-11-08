package com.informatika.mobilecomponentdanu.roomdb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.informatika.mobilecomponentdanu.R;
import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> noteList = new ArrayList<>();

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Menggunakan layout item_note.xml yang akan kita buat selanjutnya
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNote = noteList.get(position);
        // Menampilkan teks dari objek Note ke TextView
        holder.tvNoteText.setText(currentNote.text);
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    // Fungsi untuk memperbarui data di adapter dari Activity
    public void updateData(List<Note> newNotes) {
        this.noteList.clear();
        this.noteList.addAll(newNotes);
        notifyDataSetChanged(); // Memberi tahu RecyclerView untuk refresh
    }

    // ViewHolder untuk menampung view dari setiap item
    static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView tvNoteText;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNoteText = itemView.findViewById(R.id.tvNoteText);
        }
    }
}