package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;



public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.viewHolder>
{
    private List<ModelClass> data;
    public ProgrammingAdapter(List<ModelClass> data)
    {
        this.data=data;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_adapter,parent,false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        String title=data.get(position).gettxtview();
        int image=data.get(position).getimageView();
        holder.gettxtview().setText(title);
        holder.setData(image,title);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class viewHolder extends RecyclerView.ViewHolder
    {

        TextView txt;
        ImageView img;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            txt=(TextView) itemView.findViewById(R.id.tvText);
            img=(ImageView) itemView.findViewById(R.id.ivMacha);

        }
        public TextView gettxtview()
        {
            return txt;
        }
        public void setData(int image,String title)
        {
            img.setImageResource(image);
            txt.setText(title);
        }
    }
}

