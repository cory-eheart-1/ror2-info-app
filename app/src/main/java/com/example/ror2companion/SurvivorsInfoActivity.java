package com.example.ror2companion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Vector;

public class SurvivorsInfoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String[] characterStats, skillsText, characterPassive, characterPrimary, characterSecondary, characterUtility, characterSpecial;
    private String str;
    private ImageView icon;
    private TextView title, description, health, damage, regen, type, armor, speed, mass, abilityCooldown, abilityProc, abilityDescr;
    private LinearLayout abilityInfo;
    private Spinner typeSelector, abilitySelector;
    private ScrollView window;
    private boolean firstOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survivors_info);

        Intent intent = getIntent();
        str = intent.getStringExtra("character");
        characterStats = getResources().getStringArray(this.getResources().getIdentifier(str + "Stats", "array", this.getPackageName()));
        skillsText = getResources().getStringArray(this.getResources().getIdentifier("skillsText", "array", this.getPackageName()));
        characterPassive = Arrays.copyOfRange(getResources().getStringArray(this.getResources().getIdentifier(str + "Passive", "array", this.getPackageName())), 1, getResources().getStringArray(this.getResources().getIdentifier(str + "Passive", "array", this.getPackageName())).length);
        characterPrimary = Arrays.copyOfRange(getResources().getStringArray(this.getResources().getIdentifier(str + "Primary", "array", this.getPackageName())), 1, getResources().getStringArray(this.getResources().getIdentifier(str + "Primary", "array", this.getPackageName())).length);
        characterSecondary = Arrays.copyOfRange(getResources().getStringArray(this.getResources().getIdentifier(str + "Secondary", "array", this.getPackageName())), 1, getResources().getStringArray(this.getResources().getIdentifier(str + "Secondary", "array", this.getPackageName())).length);
        characterUtility = Arrays.copyOfRange(getResources().getStringArray(this.getResources().getIdentifier(str + "Utility", "array", this.getPackageName())), 1, getResources().getStringArray(this.getResources().getIdentifier(str + "Utility", "array", this.getPackageName())).length);
        characterSpecial = Arrays.copyOfRange(getResources().getStringArray(this.getResources().getIdentifier(str + "Special", "array", this.getPackageName())), 1, getResources().getStringArray(this.getResources().getIdentifier(str + "Special", "array", this.getPackageName())).length);

        window = (ScrollView) findViewById(R.id.sv_characterInfo);

        icon = (ImageView) findViewById(R.id.iv_characterIcon);
        icon.setImageResource(this.getResources().getIdentifier(str.toLowerCase(), "drawable", this.getPackageName()));

        title = (TextView) findViewById(R.id.tv_characterLabel);
        title.setText(characterStats[0]);

        description = (TextView) findViewById(R.id.tv_characterDescription);
        description.setText(characterStats[1]);

        health = (TextView) findViewById(R.id.tv_healthStat);
        health.setText(characterStats[2]);

        damage = (TextView) findViewById(R.id.tv_damageStat);
        damage.setText(characterStats[3]);

        regen = (TextView) findViewById(R.id.tv_regenStat);
        regen.setText(characterStats[4] + "\n\n" + characterStats[5] + "\n\n" + characterStats[6]);

        type = (TextView) findViewById(R.id.tv_classStat);
        type.setText(characterStats[7]);

        armor = (TextView) findViewById(R.id.tv_armorStat);
        armor.setText(characterStats[8]);

        speed = (TextView) findViewById(R.id.tv_speedStat);
        speed.setText(characterStats[9]);

        mass = (TextView) findViewById(R.id.tv_massStat);
        mass.setText(characterStats[10]);

        abilityCooldown = (TextView) findViewById(R.id.tv_abilityCooldown);
        abilityProc = (TextView) findViewById(R.id.tv_abilityProc);
        abilityDescr = (TextView) findViewById(R.id.tv_abilityDescr);

        typeSelector = (Spinner) findViewById(R.id.sp_typeSelector);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, skillsText);
        typeSelector.setAdapter(adapter);
        typeSelector.getBackground().setColorFilter(getResources().getColor(R.color.text_color), PorterDuff.Mode.SRC_ATOP);

        abilitySelector = (Spinner) findViewById(R.id.sp_abilitySelector);

        abilityInfo = (LinearLayout) findViewById(R.id.ll_abilityInfo);

        Vector<String> numAbility = new Vector<String>();

        typeSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                abilityInfo.setVisibility(View.VISIBLE);
                abilitySelector.setVisibility(View.VISIBLE);
                numAbility.clear();
                if (position == 0)
                {
                    if (Integer.parseInt(getResources().getStringArray(getResources().getIdentifier(str + "Passive", "array", getPackageName()))[0]) == 0)
                    {
                        abilityInfo.setVisibility(View.GONE);
                        abilitySelector.setVisibility(View.GONE);
                    } else {
                        for (int i = 0; i < Integer.parseInt(getResources().getStringArray(getResources().getIdentifier(str + "Passive", "array", getPackageName()))[0]); i++)
                            numAbility.add(characterPassive[i * 4]);
                    }
                }
                else if (position == 1)
                {
                    for (int i = 0; i < Integer.parseInt(getResources().getStringArray(getResources().getIdentifier(str + "Primary", "array", getPackageName()))[0]); i++)
                        numAbility.add(characterPrimary[i * 4]);
                }
                else if (position == 2)
                {
                    for (int i = 0; i < Integer.parseInt(getResources().getStringArray(getResources().getIdentifier(str + "Secondary", "array", getPackageName()))[0]); i++)
                        numAbility.add(characterSecondary[i * 4]);
                }
                else if (position == 3)
                {
                    for (int i = 0; i < Integer.parseInt(getResources().getStringArray(getResources().getIdentifier(str + "Utility", "array", getPackageName()))[0]); i++)
                        numAbility.add(characterUtility[i * 4]);
                }
                else if (position == 4)
                {
                    for (int i = 0; i < Integer.parseInt(getResources().getStringArray(getResources().getIdentifier(str + "Special", "array", getPackageName()))[0]); i++)
                        numAbility.add(characterSpecial[i * 4]);
                }

                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, numAbility);
                abilitySelector.setAdapter(adapter2);
                abilitySelector.getBackground().setColorFilter(getResources().getColor(R.color.text_color), PorterDuff.Mode.SRC_ATOP);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });

        abilitySelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                switch(typeSelector.getSelectedItemPosition())
                {
                    case 0:
                        for (int i = (position * 4) + 1; i < (position * 4) + 4; i++)
                        {
                            if (i == (position * 4) + 1)
                            {
                                abilityCooldown.setText(characterPassive[i]);
                            }
                            else if (i == (position * 4) + 2)
                            {
                                abilityProc.setText(characterPassive[i]);
                            }
                            else if (i == (position * 4) + 3)
                            {
                                abilityDescr.setText(characterPassive[i]);
                            }
                        }
                        break;
                    case 1:
                        for (int i = (position * 4) + 1; i < (position * 4) + 4; i++)
                        {
                            if (i == (position * 4) + 1)
                            {
                                abilityCooldown.setText(characterPrimary[i]);
                            }
                            else if (i == (position * 4) + 2)
                            {
                                abilityProc.setText(characterPrimary[i]);
                            }
                            else if (i == (position * 4) + 3)
                            {
                                abilityDescr.setText(characterPrimary[i]);
                            }
                        }
                        break;
                    case 2:
                        for (int i = (position * 4) + 1; i < (position * 4) + 4; i++)
                        {
                            if (i == (position * 4) + 1)
                            {
                                abilityCooldown.setText(characterSecondary[i]);
                            }
                            else if (i == (position * 4) + 2)
                            {
                                abilityProc.setText(characterSecondary[i]);
                            }
                            else if (i == (position * 4) + 3)
                            {
                                abilityDescr.setText(characterSecondary[i]);
                            }
                        }
                        break;
                    case 3:
                        for (int i = (position * 4) + 1; i < (position * 4) + 4; i++)
                        {
                            if (i == (position * 4) + 1)
                            {
                                abilityCooldown.setText(characterUtility[i]);
                            }
                            else if (i == (position * 4) + 2)
                            {
                                abilityProc.setText(characterUtility[i]);
                            }
                            else if (i == (position * 4) + 3)
                            {
                                abilityDescr.setText(characterUtility[i]);
                            }
                        }
                        break;
                    case 4:
                        for (int i = (position * 4) + 1; i < (position * 4) + 4; i++)
                        {
                            if (i == (position * 4) + 1)
                            {
                                abilityCooldown.setText(characterSpecial[i]);
                            }
                            else if (i == (position * 4) + 2)
                            {
                                abilityProc.setText(characterSpecial[i]);
                            }
                            else if (i == (position * 4) + 3)
                            {
                                abilityDescr.setText(characterSpecial[i]);
                            }
                        }
                        break;
                }
                if (firstOpen)
                    firstOpen = false;
                else
                    window.scrollTo(0, window.getBottom());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });
        
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

}