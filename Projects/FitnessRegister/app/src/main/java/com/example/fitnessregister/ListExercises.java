package com.example.fitnessregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fitnessregister.Adapter.RecyclerViewAdapter;
import com.example.fitnessregister.ModelEx.Exercise;

import java.util.ArrayList;
import java.util.List;

public class ListExercises extends AppCompatActivity {

    List<Exercise> exerciseList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercises);

        initData();

        recyclerView = (RecyclerView) findViewById(R.id.list_exercises);
        adapter= new RecyclerViewAdapter(exerciseList, getBaseContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initData(){
        exerciseList.add(new Exercise(R.drawable.easy_pose, "Posição Fácil"));
        exerciseList.add(new Exercise(R.drawable.cobra_pose, "Posição de Cobra"));
        exerciseList.add(new Exercise(R.drawable.downward_facing_dog, "Adho Mukha Svanasana"));
        exerciseList.add(new Exercise(R.drawable.boat_pose, "Posição de Barco"));
        exerciseList.add(new Exercise(R.drawable.half_pigeon, "Meio Pombo"));
        exerciseList.add(new Exercise(R.drawable.low_lunge, "Lunge baixo"));
        exerciseList.add(new Exercise(R.drawable.upward_bow, "Posição para cima"));
        exerciseList.add(new Exercise(R.drawable.crescent_lunge, "Posição crescente"));
        exerciseList.add(new Exercise(R.drawable.warrior_pose, "Posição de guerreiro 1"));
        exerciseList.add(new Exercise(R.drawable.bow_pose, "Posição de Vénia"));
        exerciseList.add(new Exercise(R.drawable.warrior_pose_2, "Posição de guerreiro 2"));







    }
}
