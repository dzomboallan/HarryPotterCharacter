package com.example.harrypottercharacters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

    @Mock
    private RequestQueue requestQueue;

    @Mock
    private Adapter adapter;

    private MainActivity mainActivity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mainActivity = new MainActivity();
        requestQueue = mainActivity.requestQueue;
        adapter = mainActivity.ad;
    }

    @Test
    public void testFetchCharacters() throws JSONException {
        // Arrange
        List<Model> expectedModelList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Harry Potter");
        jsonObject.put("alternate_names", "");
        jsonObject.put("species", "human");
        jsonObject.put("gender", "male");
        jsonObject.put("house", "Gryffindor");
        jsonObject.put("dateOfBirth", "31-07-1980");
        jsonObject.put("yearOfBirth", 1980);
        jsonObject.put("wizard", true);
        jsonObject.put("ancestry", "half-blood");
        jsonObject.put("eyeColour", "green");
        jsonObject.put("hairColour", "black");
        jsonObject.put("wand", "11\"  Holly  phoenix feather");
        jsonObject.put("patronus", "stag");
        jsonObject.put("hogwartsStudent", true);
        jsonObject.put("hogwartsStaff", false);
        jsonObject.put("actor", "Daniel Radcliffe");
        jsonObject.put("alternate_actors", "");
        jsonObject.put("alive", true);
        jsonObject.put("image", "https://hp-api.onrender.com/images/harry.jpg");
        expectedModelList.add(new Model(
                jsonObject.getString("name"),
                jsonObject.getString("alternate_names"),
                jsonObject.getString("species"),
                jsonObject.getString("gender"),
                jsonObject.getString("house"),
                jsonObject.getString("dateOfBirth"),
                jsonObject.getString("ancestry"),
                jsonObject.getString("eyeColour"),
                jsonObject.getString("hairColour"),
                jsonObject.getString("wand"),
                jsonObject.getString("patronus"),
                jsonObject.getString("actor"),
                jsonObject.getString("alternate_actors"),
                jsonObject.getString("image"),
                jsonObject.getInt("yearOfBirth"),
                jsonObject.getBoolean("wizard"),
                jsonObject.getBoolean("hogwartsStudent"),
                jsonObject.getBoolean("hogwartsStaff"),
                jsonObject.getBoolean("alive")
        ));
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);

        when(requestQueue.add(any(JsonArrayRequest.class))).thenAnswer(invocation -> {
            Response.Listener<JSONArray> listener = invocation.getArgument(2);
            listener.onResponse(jsonArray);
            return null;
        });

        // Act
        mainActivity.fetchCharacters();

        // Assert
        for (Model model : verify(adapter).modelList) {
            assert expectedModelList.contains(model);
        }

    }
}
