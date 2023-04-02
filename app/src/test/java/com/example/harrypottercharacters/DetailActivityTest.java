package com.example.harrypottercharacters;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class DetailActivityTest {

    @Rule
    public ActivityTestRule<DetailActivity> activityRule =
            new ActivityTestRule<>(DetailActivity.class);

    @Test
    public void testDetailViewDisplaysCorrectData() {
        onView(withId(R.id.mName)).check(matches(isDisplayed()));
        onView(withId(R.id.mName)).check(matches(withText("Harry Potter")));

        onView(withId(R.id.altNames)).check(matches(isDisplayed()));
        onView(withId(R.id.altNames)).check(matches(withText("The Boy Who Lived")));

        onView(withId(R.id.mSpecies)).check(matches(isDisplayed()));
        onView(withId(R.id.mSpecies)).check(matches(withText("Human")));

        onView(withId(R.id.mGender)).check(matches(isDisplayed()));
        onView(withId(R.id.mGender)).check(matches(withText("Male")));

        onView(withId(R.id.house)).check(matches(isDisplayed()));
        onView(withId(R.id.house)).check(matches(withText("Gryffindor")));

        onView(withId(R.id.dateOfBirth)).check(matches(isDisplayed()));
        onView(withId(R.id.dateOfBirth)).check(matches(withText("31-07-1980")));

        onView(withId(R.id.yearOfBirth)).check(matches(isDisplayed()));
        onView(withId(R.id.yearOfBirth)).check(matches(withText("1980")));

        onView(withId(R.id.wizard)).check(matches(isDisplayed()));
        onView(withId(R.id.wizard)).check(matches(withText("true")));

        onView(withId(R.id.ancestry)).check(matches(isDisplayed()));
        onView(withId(R.id.ancestry)).check(matches(withText("Half-blood")));

        onView(withId(R.id.eyeColor)).check(matches(isDisplayed()));
        onView(withId(R.id.eyeColor)).check(matches(withText("Bright green")));

        onView(withId(R.id.hairColor)).check(matches(isDisplayed()));
        onView(withId(R.id.hairColor)).check(matches(withText("Black")));

        onView(withId(R.id.wand)).check(matches(isDisplayed()));
        onView(withId(R.id.wand)).check(matches(withText("11\" Holly Phoenix feather")));

        onView(withId(R.id.patronus)).check(matches(isDisplayed()));
        onView(withId(R.id.patronus)).check(matches(withText("Stag")));

        onView(withId(R.id.hogwartsStudent)).check(matches(isDisplayed()));
        onView(withId(R.id.hogwartsStudent)).check(matches(withText("true")));

        onView(withId(R.id.hogwartsStaff)).check(matches(isDisplayed()));
        onView(withId(R.id.hogwartsStaff)).check(matches(withText("false")));

        onView(withId(R.id.actor)).check(matches(isDisplayed()));
        onView(withId(R.id.actor)).check(matches(withText("Daniel Radcliffe")));

        onView(withId(R.id.altActor)).check(matches(isDisplayed()));
        onView(withId(R.id.altActor)).check(matches(withText("Unknown")));

        onView(withId(R.id.mAlive)).check(matches(isDisplayed()));
        onView(withId(R.id.mAlive)).check(matches(withText("true")));
    }
}
