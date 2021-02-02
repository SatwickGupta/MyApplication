package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.viewHolder> {

    //private List<String> ID;
    //private List<String> Name;
    //private List<String> Category;
    //private List<String> Country;
    //private List<String> Language;
    //private List<String> Description;
    //private List<String> url;
    private List<Item> item;

    /*public ProgrammingAdapter(List<String> ID,List<String> Name,List<String> Category,List<String> Country,List<String> Language,List<String> Description,List<String>URL) {
        this.ID = ID;
        this.Name = Name;
        this.Category =Category;
        this.Country = Country;
        this.Language = Language;
        this.Description = Description;
        this.url=URL;
    }
    */
    public ProgrammingAdapter(List<Item> item)
    {
        this.item=item;
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
       /* String Id = ID.get(position);
        String name = Name.get(position);
        String category = Category.get(position);
        String country = Country.get(position);
        String language = Language.get(position);
        String description = Description.get(position);
        String URL=url.get(position);
        // holder.gettxtview().setText(title);
        */

        Item item1=item.get(position);
        holder.setData(item1.getID(), item1.getName(), item1.getDescription(),item1.getCategory(),item1.getLanguage(),item1.getCountry(),item1.getUrl());

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        Item item;
        TextView tvID;
        TextView tvName;
        TextView tvCategory;
        TextView tvCountry;
        TextView tvLanguage;
        TextView tvDescription;
        TextView tvUrl;

        public viewHolder(@NonNull View itemView) {

            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvName = itemView.findViewById(R.id.tvName);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvCountry = itemView.findViewById(R.id.tvCountry);
            tvLanguage = itemView.findViewById(R.id.tvLanguage);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvUrl=itemView.findViewById(R.id.tvURL);



        }

        public void setData(String Id, String name, String description, String category, String language, String country,String URL) {
            tvID.setText(Id);
            tvName.setText(name);
            tvDescription.setText(description);
            tvCategory.setText(category);
            tvLanguage.setText(language);
            tvCountry.setText(country);
            tvUrl.setText(URL);
        }
    }
}

