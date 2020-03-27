package com.manoj.coronaui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.ramotion.paperonboarding.PaperOnboardingEngine;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnChangeListener;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        if(restorePrefData()){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }

        PaperOnboardingEngine engine = new PaperOnboardingEngine(findViewById(R.id.onboardingRootView), getDataForOnboarding(), getApplicationContext());

        engine.setOnChangeListener(new PaperOnboardingOnChangeListener() {
            @Override
            public void onPageChanged(int oldElementIndex, int newElementIndex) {
              //  Toast.makeText(getApplicationContext(), "Swiped from " + oldElementIndex + " to " + newElementIndex, Toast.LENGTH_SHORT).show();
            }
        });

        engine.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                // Probably here will be your exit action
               // Toast.makeText(getApplicationContext(), "Swiped out right", Toast.LENGTH_SHORT).show();

                savePrefsData();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    // Just example data for Onboarding
    private ArrayList<PaperOnboardingPage> getDataForOnboarding() {
        // prepare data
        PaperOnboardingPage scr1 = new PaperOnboardingPage("Privacy", "Your Privacy, Our Responsibility",
                Color.parseColor("#72A8F4"), R.drawable.lock_key, R.drawable.key) ;
        //Color.parseColor("#678FB4"), R.drawable.privacy_im, R.drawable.key);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Bluetooth", "keeps you nearest & dearest one safe ",
                Color.parseColor("#E879F1"), R.drawable.bluetooth, R.drawable.key);
              //  Color.parseColor("#BBDEFB"), R.drawable.bluetooth_im, R.drawable.key);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Location", "This app needs your Location information to track you, to provide help ",
                Color.parseColor("#A4BBDB"), R.drawable.location, R.drawable.key);
               // Color.parseColor("#9B90BC"), R.drawable.location_im, R.drawable.key);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        return elements;
    }


    private void savePrefsData(){

        SharedPreferences pref = getApplicationContext().getSharedPreferences("onboardingPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isOnBoardingOpened",true);
        editor.commit();

    }

    private boolean restorePrefData(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("onboardingPref",MODE_PRIVATE);
        Boolean isOnBoardingOpendBefore = pref.getBoolean("isOnBoardingOpened",false);
        return isOnBoardingOpendBefore;
    }


}
