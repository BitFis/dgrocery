package io.zuercher.dgrocery;

import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ChecklistItemHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView message;
    View view;

    ChecklistItemHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.checklistName);
        message = (TextView) itemView.findViewById(R.id.checklistInfo);
        view = itemView;
    }

}
