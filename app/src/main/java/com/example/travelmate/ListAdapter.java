package com.example.travelmate;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ListAdapter extends BaseAdapter
{
    Context context;

    List<Subject> subject_list;

    public ListAdapter(List<Subject> listValue, Context context)
    {
        this.context = context;
        this.subject_list = listValue;
    }

    @Override
    public int getCount()
    {
        return this.subject_list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return this.subject_list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewItem viewItem = null;
        if(convertView == null)
        {
            viewItem = new ViewItem();

            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInfiater.inflate(R.layout.listview_items, null);

            viewItem.SubNameTextView = (TextView)convertView.findViewById(R.id.SubjectNameTextView);

            viewItem.SubFullFormTextView = (TextView)convertView.findViewById(R.id.SubjectFullFormTextView);

            viewItem.SubLongitude = (TextView)convertView.findViewById(R.id.subjectLongitude);

            viewItem.SubLat = (TextView)convertView.findViewById(R.id.subjectLatitude);

            viewItem.Subfeedback = (TextView)convertView.findViewById(R.id.subjectfeedback) ;
        convertView.setTag(viewItem);
        }
        else
        {
            viewItem = (ViewItem) convertView.getTag();
        }

        viewItem.SubNameTextView.setText(subject_list.get(position).Subject_Name);

        viewItem.SubFullFormTextView.setText(subject_list.get(position).Subject_Full_Form);

        viewItem.SubLongitude.setText(subject_list.get(position).SubjectLongitude);

        viewItem.SubLat.setText(subject_list.get(position).SubjectLatitude);

        viewItem.Subfeedback.setText(subject_list.get(position).Subjectfeedback);

        return convertView;
    }
}

class ViewItem
{
    TextView SubNameTextView;
    TextView SubFullFormTextView;
    TextView SubLongitude;
    TextView SubLat;
    TextView Subfeedback;
}
