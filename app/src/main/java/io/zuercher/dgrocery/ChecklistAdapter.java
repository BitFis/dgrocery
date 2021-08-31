package io.zuercher.dgrocery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChecklistAdapter extends RecyclerView.Adapter<ChecklistItemHolder> {

    List<ChecklistItem> items;

    Context context;
    ChecklistClickListener listener;

    public ChecklistAdapter(List<ChecklistItem> list, Context context, ChecklistClickListener listener) {
        this.listener = listener;
        this.context = context;
        this.items = list;
    }

    @NonNull
    @Override
    public ChecklistItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View checklistView = inflater.inflate(R.layout.checklist_card, parent, false);
        ChecklistItemHolder holder = new ChecklistItemHolder(checklistView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChecklistItemHolder holder, int position) {
        holder.message.setText(items.get(position).message);
        holder.name.setText(items.get(position).name);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
