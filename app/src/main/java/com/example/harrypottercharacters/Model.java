package com.example.harrypottercharacters;

import org.json.JSONArray;

public class Model {
    private String name, species, gender, house, dateOfBirth,ancestry, eyeColor, hairColor, patronous, actor, image;
    private int yearOfBirth;
    private boolean  wizard, howgwartStudent, hogwartStaff, alive;
    private String alt_names, wand, alt_actors;

    public Model(String name, String alt_names, String species, String gender, String house, String dateOfBirth, String ancestry, String eyeColor, String hairColor, String wand, String patronous, String actor, String alt_actors, String image, int yearOfBirth, boolean wizard, boolean howgwartStudent, boolean hogwartStaff, boolean alive) {
        this.name = name;
        this.alt_names = alt_names;
        this.species = species;
        this.gender = gender;
        this.house = house;
        this.dateOfBirth = dateOfBirth;
        this.ancestry = ancestry;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.wand = wand;
        this.patronous = patronous;
        this.actor = actor;
        this.alt_actors = alt_actors;
        this.image = image;
        this.yearOfBirth = yearOfBirth;
        this.wizard = wizard;
        this.howgwartStudent = howgwartStudent;
        this.hogwartStaff = hogwartStaff;
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getAlt_names(){return alt_names;}

    public String getGender() {
        return gender;
    }

    public String getHouse() {
        return house;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAncestry() {
        return ancestry;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getWand(){return wand;}

    public String getPatronous() {
        return patronous;
    }

    public String getActor() {
        return actor;
    }

    public String getAlt_actors(){return alt_actors;}

    public String getImage() {
        return image;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public boolean isWizard() {
        return wizard;
    }

    public boolean isHowgwartStudent() {
        return howgwartStudent;
    }

    public boolean isHogwartStaff() {
        return hogwartStaff;
    }

    public boolean isAlive() {
        return alive;
    }
}
