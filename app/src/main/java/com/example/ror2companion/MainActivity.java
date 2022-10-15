package com.example.ror2companion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnSurvivors, btnItems, btnMonsters, btnChallenges, btnInteractables, btnDrones, btnShrines,
    btnArtifacts, btnNewtAltars, btnLore, btnMechanics, btnItemStacking, btnStatusEffects, btnDamage, btnPrismaticTrial, btnModding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSurvivors = (Button) findViewById(R.id.btn_survivors);
        btnItems = (Button) findViewById(R.id.btn_items);
        btnMonsters = (Button) findViewById(R.id.btn_monsters);
        btnChallenges = (Button) findViewById(R.id.btn_challenges);
        btnInteractables = (Button) findViewById(R.id.btn_interactables);
        btnDrones = (Button) findViewById(R.id.btn_drones);
        btnShrines = (Button) findViewById(R.id.btn_shrines);
        btnArtifacts = (Button) findViewById(R.id.btn_artifacts);
        btnNewtAltars = (Button) findViewById(R.id.btn_newtAltars);
        btnLore = (Button) findViewById(R.id.btn_lore);
        btnMechanics = (Button) findViewById(R.id.btn_mechanics);
        btnItemStacking = (Button) findViewById(R.id.btn_itemStacking);
        btnStatusEffects = (Button) findViewById(R.id.btn_statusEffects);
        btnDamage = (Button) findViewById(R.id.btn_damage);
        btnPrismaticTrial = (Button) findViewById(R.id.btn_prismaticTrial);
        btnModding = (Button) findViewById(R.id.btn_modding);

        btnSurvivors.setOnClickListener(this);
        btnItems.setOnClickListener(this);
        btnMonsters.setOnClickListener(this);
        btnChallenges.setOnClickListener(this);
        btnInteractables.setOnClickListener(this);
        btnDrones.setOnClickListener(this);
        btnShrines.setOnClickListener(this);
        btnArtifacts.setOnClickListener(this);
        btnNewtAltars.setOnClickListener(this);
        btnLore.setOnClickListener(this);
        btnMechanics.setOnClickListener(this);
        btnItemStacking.setOnClickListener(this);
        btnStatusEffects.setOnClickListener(this);
        btnDamage.setOnClickListener(this);
        btnPrismaticTrial.setOnClickListener(this);
        btnModding.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btn_survivors:
                launchSurvivors();
                break;
            case R.id.btn_items:
                launchItems();
                break;

        }
    }

    public void launchSurvivors(){
        Intent intent = new Intent(this, SurvivorsActivity.class);
        startActivity(intent);
    }

    public void launchItems(){
        Intent intent = new Intent(this, ItemsActivity.class);
        startActivity(intent);
    }
}