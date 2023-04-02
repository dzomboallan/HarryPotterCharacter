package com.example.harrypottercharacters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ModelHolder> {

    private Context context;
    public List<Model> modelList;

    public Adapter(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ModelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
        return new ModelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelHolder holder, int position) {
        Model model = modelList.get(position);
        holder.name.setText(model.getName());
        holder.house.setText(model.getHouse());
        holder.gender.setText(model.getGender());
        Glide.with(context).load(model.getImage()).into(holder.imageView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("name", model.getName());
                bundle.putString("alternate_names", model.getAlt_names());
                bundle.putString("species", model.getSpecies());
                bundle.putString("gender", model.getGender());
                bundle.putString("house", model.getHouse());
                bundle.putString("dateOfBirth", model.getDateOfBirth());
                bundle.putInt("yearOfBirth", model.getYearOfBirth());
                bundle.putBoolean("wizard", model.isWizard());
                bundle.putString("ancestry", model.getAncestry());
                bundle.putString("eyeColour", model.getEyeColor());
                bundle.putString("hairColour", model.getHairColor());
                bundle.putString("wand",  model.getWand());
                bundle.putString("patronus", model.getPatronous());
                bundle.putBoolean("hogwartsStudent", model.isHowgwartStudent());
                bundle.putBoolean("hogwartsStaff", model.isHogwartStaff());
                bundle.putString("actor", model.getActor());
                bundle.putString("alternate_actors",model.getAlt_actors());
                bundle.putBoolean("alive", model.isAlive());
                bundle.putString("image", model.getImage());

                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void filterList(ArrayList<Model> searchModel){
        modelList = searchModel;
        notifyDataSetChanged();
    }

    public class ModelHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name, house, gender;
        CardView cardView;
        public ModelHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.title_tv);
            house = itemView.findViewById(R.id.house);
            gender = itemView.findViewById(R.id.gender);
            cardView = itemView.findViewById(R.id.main_layout);

        }
    }
}
