package com.example.harrypottercharacters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.Glide;

@RunWith(MockitoJUnitRunner.class)
public class AdapterTest {
    @Mock
    Context context;

    @Mock
    List<Model> modelList;

    @Mock
    Model model;

    @Mock
    View view;

    private Adapter adapter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        adapter = new Adapter(context, modelList);
    }

    @Test
    public void onCreateViewHolder() {
        LayoutInflater inflater = LayoutInflater.from(context);
        when(inflater.inflate(R.layout.item_layout, null)).thenReturn(view);
        Adapter.ModelHolder holder = adapter.onCreateViewHolder(null, 0);
        assertEquals(view, holder.itemView);
    }

    @Test
    public void onBindViewHolder() {
        when(modelList.get(0)).thenReturn(model);
        when(model.getName()).thenReturn("Harry Potter");
        when(model.getHouse()).thenReturn("Gryffindor");
        when(model.getGender()).thenReturn("Male");
        when(model.getImage()).thenReturn("https://example.com/harry.jpg");

        Adapter.ModelHolder holder = adapter.new ModelHolder(view);
        adapter.onBindViewHolder(holder, 0);

        verify(holder.name).setText("Harry Potter");
        verify(holder.house).setText("Gryffindor");
        verify(holder.gender).setText("Male");
        verify(Glide.with(context)).load("https://example.com/harry.jpg").into(holder.imageView);
    }

    @Test
    public void getItemCount() {
        when(modelList.size()).thenReturn(3);
        assertEquals(3, adapter.getItemCount());
    }

    @Test
    public void filterList() {
        ArrayList<Model> searchModel = new ArrayList<>();
        searchModel.add(model);
        adapter.filterList(searchModel);
        verify(modelList).clear();
        verify(modelList).addAll(searchModel);
        verify(adapter).notifyDataSetChanged();
    }
}