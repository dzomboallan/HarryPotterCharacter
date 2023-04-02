package com.example.harrypottercharacters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name, altenate_names, species, gender, house, date_of_birth, year_of_birth, wizard, ancestry, eye_color, hair_color, wand, patronus, hogwartsStudent, hogwartsStaff, actor, alternate_actors, alive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = findViewById(R.id.mName);
        altenate_names = findViewById(R.id.altNames);
        species = findViewById(R.id.mSpecies);
        gender = findViewById(R.id.mGender);
        house = findViewById(R.id.house);
        date_of_birth = findViewById(R.id.dateOfBirth);
        year_of_birth = findViewById(R.id.yearOfBirth);
        wizard = findViewById(R.id.wizard);
        ancestry = findViewById(R.id.ancestry);
        eye_color = findViewById(R.id.eyeColor);
        hair_color = findViewById(R.id.hairColor);
        wand = findViewById(R.id.wand);
        patronus = findViewById(R.id.patronus);
        hogwartsStudent = findViewById(R.id.hogwartsStudent);
        hogwartsStaff = findViewById(R.id.hogwartsStaff);
        actor = findViewById(R.id.actor);
        alternate_actors = findViewById(R.id.altActor);
        alive = findViewById(R.id.mAlive);
        imageView = findViewById(R.id.picture);

        Bundle bundle = getIntent().getExtras();

        String cImage = bundle.getString("image");
        String cAlternate_names = bundle.getString("alternate_names");
        String cName = bundle.getString("name");
        String cSpecies = bundle.getString("species");
        String cGender = bundle.getString("gender");
        String cHouse = bundle.getString("house");
        String cDateOfBirth = bundle.getString("dateOfBirth");
        int cYearOfBirth = bundle.getInt("yearOfBirth");
        boolean cWizard = bundle.getBoolean("wizard");
        String cAncestry = bundle.getString("ancestry");
        String cEyeColor = bundle.getString("eyeColour");
        String cHairColor = bundle.getString("hairColour");
        String cWand = bundle.getString("wand");
        String cPatronus = bundle.getString("patronus");
        boolean cHogwartsStudent = bundle.getBoolean("hogwartsStudent");
        boolean cHogwartsStaff = bundle.getBoolean("hogwartsStudent");
        String cActor = bundle.getString("actor");
        String cAlternate_actors = bundle.getString("alternate_actors");
        boolean cAlive = bundle.getBoolean("alive");

        Glide.with(this).load(cImage).into(imageView);
        name.setText(cName);
        altenate_names.setText(cAlternate_names);
        species.setText(cSpecies);
        gender.setText(cGender);
        house.setText(cHouse);
        date_of_birth.setText(cDateOfBirth);
        year_of_birth.setText(String.valueOf(cYearOfBirth));
        wizard.setText(String.valueOf(cWizard));
        ancestry.setText(cAncestry);
        eye_color.setText(cEyeColor);
        hair_color.setText(cHairColor);
        wand.setText(cWand);
        patronus.setText(cPatronus);
        hogwartsStudent.setText(String.valueOf(cHogwartsStudent));
        hogwartsStaff.setText(String.valueOf(cHogwartsStaff));
        actor.setText(cActor);
        alternate_actors.setText(cAlternate_actors);
        alive.setText(String.valueOf(cAlive));

    }
}