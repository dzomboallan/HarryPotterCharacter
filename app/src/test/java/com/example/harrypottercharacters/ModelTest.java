package com.example.harrypottercharacters;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ModelTest {

    @Test
    public void testModel() {
        Model model = new Model("Harry Potter", "The Boy Who Lived", "Human", "Male", "Gryffindor", "July 31, 1980", "Half-blood", "Green", "Black", "Holly and phoenix feather, 11\", nice and supple", "Stag", "Daniel Radcliffe", null, null, 1980, true, true, false, true);
        assertEquals("Harry Potter", model.getName());
        assertEquals("Human", model.getSpecies());
        assertEquals("The Boy Who Lived", model.getAlt_names());
        assertEquals("Male", model.getGender());
        assertEquals("Gryffindor", model.getHouse());
        assertEquals("July 31, 1980", model.getDateOfBirth());
        assertEquals("Half-blood", model.getAncestry());
        assertEquals("Green", model.getEyeColor());
        assertEquals("Black", model.getHairColor());
        assertEquals("Holly and phoenix feather, 11\", nice and supple", model.getWand());
        assertEquals("Stag", model.getPatronous());
        assertEquals("Daniel Radcliffe", model.getActor());
        assertNull(model.getAlt_actors());
        assertNull(model.getImage());
        assertEquals(1980, model.getYearOfBirth());
        assertTrue(model.isWizard());
        assertTrue(model.isHowgwartStudent());
        assertFalse(model.isHogwartStaff());
        assertTrue(model.isAlive());
    }
}
