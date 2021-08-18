package sg.edu.rp.c346.id20026955.listtheitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Do> tasks;

    public CustomAdapter(Context context, int resource, ArrayList<Do> objects) {
        super(context, resource, objects);
        this.parent_context = context;
        this.layout_id = resource;
        this.tasks = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvDescription = rowView.findViewById(R.id.textViewDescription);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);
        TextView tvImportance = rowView.findViewById(R.id.textViewImportance);
        ImageView iv = rowView.findViewById(R.id.ivAlert);

        Do currentTask = tasks.get(position);

        tvName.setText(currentTask.getName());
        tvDescription.setText(currentTask.getDescription());
        tvDate.setText("To be completed by: " + currentTask.getDate());
        tvImportance.setText("Level of Importance: " + currentTask.getImportance());
        if (currentTask.getImportance() >= 4) {
            iv.setImageResource(R.drawable.important);
        } else {
            iv.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }

}

