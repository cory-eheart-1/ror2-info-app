package com.example.ror2companion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class SurvivorsActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton acrid, artificer, bandit, captain, commando, engineer, heretic, huntress,
    loader, mercenary, mult, railgunner, rex, voidFiend;
    private ScrollView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survivors);

        sv = (ScrollView) findViewById(R.id.sv_survivors);
        sv.setClickable(true);

        acrid = (ImageButton) findViewById(R.id.ib_acrid);
        artificer = (ImageButton) findViewById(R.id.ib_artificer);
        bandit = (ImageButton) findViewById(R.id.ib_bandit);
        captain = (ImageButton) findViewById(R.id.ib_captain);
        commando = (ImageButton) findViewById(R.id.ib_commando);
        engineer = (ImageButton) findViewById(R.id.ib_engineer);
        heretic = (ImageButton) findViewById(R.id.ib_heretic);
        huntress = (ImageButton) findViewById(R.id.ib_huntress);
        loader = (ImageButton) findViewById(R.id.ib_loader);
        mercenary = (ImageButton) findViewById(R.id.ib_mercenary);
        mult = (ImageButton) findViewById(R.id.ib_mult);
        railgunner = (ImageButton) findViewById(R.id.ib_railgunner);
        rex = (ImageButton) findViewById(R.id.ib_rex);
        voidFiend = (ImageButton) findViewById(R.id.ib_voidFiend);

        acrid.setOnClickListener(this);
        artificer.setOnClickListener(this);
        bandit.setOnClickListener(this);
        captain.setOnClickListener(this);
        commando.setOnClickListener(this);
        engineer.setOnClickListener(this);
        heretic.setOnClickListener(this);
        huntress.setOnClickListener(this);
        loader.setOnClickListener(this);
        mercenary.setOnClickListener(this);
        mult.setOnClickListener(this);
        railgunner.setOnClickListener(this);
        rex.setOnClickListener(this);
        voidFiend.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        sv.setClickable(false);

        String str = "";
        switch(v.getId())
        {
            case R.id.ib_acrid:
                str = "acrid";
                break;
            case R.id.ib_artificer:
                str = "artificer";
                break;
            case R.id.ib_bandit:
                str = "bandit";
                break;
            case R.id.ib_captain:
                str = "captain";
                break;
            case R.id.ib_commando:
                str = "commando";
                break;
            case R.id.ib_engineer:
                str = "engineer";
                break;
            case R.id.ib_heretic:
                str = "heretic";
                break;
            case R.id.ib_huntress:
                str = "huntress";
                break;
            case R.id.ib_loader:
                str = "loader";
                break;
            case R.id.ib_mercenary:
                str = "mercenary";
                break;
            case R.id.ib_mult:
                str = "mult";
                break;
            case R.id.ib_railgunner:
                str = "railgunner";
                break;
            case R.id.ib_rex:
                str = "rex";
                break;
            case R.id.ib_voidFiend:
                str = "voidFiend";
                break;
        }

        if (str != "")
        {
            Intent intent = new Intent(this, SurvivorsInfoActivity.class);
            intent.putExtra("character", str);
            startActivity(intent);
        }
    }
}