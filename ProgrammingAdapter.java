package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.w3c.dom.Text;

import java.util.List;


public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.viewHolder> {
    private List<String> ID;
    private List<String> Name;
    private List<String> Category;
    private List<String> Country;
    private List<String> Language;
    private List<String> Description;
    private List<String> url;

    public ProgrammingAdapter(List<String> ID,List<String> Name,List<String> Category,List<String> Country,List<String> Language,List<String> Description,List<String>URL) {
        this.ID = ID;
        this.Name = Name;
        this.Category =Category;
        this.Country = Country;
        this.Language = Language;
        this.Description = Description;
        this.url=URL;
    }




    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_adapter2, parent, false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        String Id = ID.get(position);
        String name = Name.get(position);
        String category = Category.get(position);
        String country = Country.get(position);
        String language = Language.get(position);
        String description = Description.get(position);
        String URL=url.get(position);
        // holder.gettxtview().setText(title);
        holder.setData(Id, name, description, category, language, country,URL);

    }

    @Override
    public int getItemCount() {
        return Name.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        TextView ID;
        TextView Name;
        TextView Category;
        TextView Country;
        TextView Language;
        TextView Description;
        TextView Url;

        public viewHolder(@NonNull View itemView) {

            super(itemView);
            ID = itemView.findViewById(R.id.tvID);
            Name = itemView.findViewById(R.id.tvName);
            Category = itemView.findViewById(R.id.tvCategory);
            Country = itemView.findViewById(R.id.tvCountry);
            Language = itemView.findViewById(R.id.tvLanguage);
            Description = itemView.findViewById(R.id.tvDescription);
            Url=itemView.findViewById(R.id.tvURL);


        }

        public void setData(String Id, String name, String description, String category, String language, String country,String URL) {
            ID.setText(Id);
            Name.setText(name);
            Description.setText(description);
            Category.setText(category);
            Language.setText(language);
            Country.setText(country);
            Url.setText(URL);
        }
    }
}

