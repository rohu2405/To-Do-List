package com.somu.todolist

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listener: MainActivity): RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {
    private val allNotes = ArrayList<Note>()

    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView ) {
        val textView: TextView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<ImageView>(R.id.deletebutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

       val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note , parent , false))
       viewHolder.deleteButton.setOnClickListener {
           listener.onItemClicked(allNotes[viewHolder.adapterPosition])
       }
        return viewHolder
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<ContactsContract.CommonDataKinds.Note>) {
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }



    interface INotesRVAdapter {
        fun onItemClicked(note: Note)
    }

}

private fun <E> java.util.ArrayList<E>.addAll(newList: List<ContactsContract.CommonDataKinds.Note>) {


}
