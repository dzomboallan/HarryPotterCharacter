package com.example.harrypottercharacters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RequestQueue requestQueue;
    List<Model> model_list;
    private SearchView searchView;
    Adapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getrInstance(this).getRequestQueue();

        model_list = new ArrayList<>();

        fetchCharacters();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String text){
        ArrayList<Model> searchModel = new ArrayList<>();
        for (Model newSearchModel : ad.modelList){
            if (newSearchModel.getName().toLowerCase().contains(text.toLowerCase())){
                searchModel.add(newSearchModel);
            }
        }

        ad.filterList(searchModel);
    }

    void fetchCharacters() {
        String url = "https://hp-api.onrender.com/api/characters";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String name = jsonObject.getString("name");
                        String alt_names = jsonObject.getString("alternate_names");
                        String species = jsonObject.getString("species");
                        String gender = jsonObject.getString("gender");
                        String house = jsonObject.getString("house");
                        String dateOfBirth = jsonObject.getString("dateOfBirth");
                        int yearOfBirth = jsonObject.getInt("yearOfBirth");
                        boolean wizard = jsonObject.getBoolean("wizard");
                        String ancestry = jsonObject.getString("ancestry");
                        String eyeColor = jsonObject.getString("eyeColour");
                        String hairColor = jsonObject.getString("hairColour");
                        String wand = jsonObject.getString("wand");
                        String patronus = jsonObject.getString("patronus");
                        boolean hogwartStudent = jsonObject.getBoolean("hogwartsStudent");
                        boolean hogwartStaff = jsonObject.getBoolean("hogwartsStudent");
                        String actor = jsonObject.getString("actor");
                        String alt_actors = jsonObject.getString("alternate_actors");
                        boolean alive = jsonObject.getBoolean("alive");
                        String image = jsonObject.getString("image");

                        Model model = new Model( name, alt_names, species, gender, house, dateOfBirth, ancestry, eyeColor, hairColor, wand, patronus, actor, alt_actors, image, yearOfBirth, wizard, hogwartStudent, hogwartStaff, alive);
                        model_list.add(model);
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    ad = new Adapter(MainActivity.this, model_list);
                    recyclerView.setAdapter(ad);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}