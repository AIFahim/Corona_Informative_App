package com.manoj.coronaui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    ExpandableRelativeLayout ExpandableLayout1;

    ListView list;
    ListView list2;
    List<NumberPojoClass> numberPojoClassList;
    List<NumberPojoClass> ArmryPojoClassList;
    CustomUserAdapter customUserAdapter;
    Button Jatio,Sastho;


    ViewPager viewPagerOne, viewPagerTwo,viewPagerThree,viewPagerFour,viewPagerFive,viewPagerSix,viewPagerSeven;

    TextView TextSlider,TextSliderTwo,TextSliderThree,TextSliderFour,TextSliderFive,TextSliderSix,TextSliderSeven;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextSliderr();
        ImageSetSlideShow();
        AllCall();

 }

    private void AllCall() {
        HotlineCall();
        otherCall();
        Army_NumberList();
    }

    public void expandableButton(View view) {
         ExpandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1);
          ExpandableLayout1.toggle(); // toggle expand and collapse
    }




    private void otherCall(){

        Jatio = findViewById(R.id.idJatioSebacall);
        Sastho = findViewById(R.id.idSastho);

        Jatio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String s = "tel:999";
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse(s));

                        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                                    Manifest.permission.CALL_PHONE}, 1);
                            return;
                        }
                        startActivity(intent);

                    }
                }
        );

        Sastho.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {

                                         String s = "tel:16263";
                                         Intent intent = new Intent(Intent.ACTION_CALL);
                                         intent.setData(Uri.parse(s));

                                         if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                                             ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                                                     Manifest.permission.CALL_PHONE}, 1);
                                             return;
                                         }
                                         startActivity(intent);

                                     }
                                 }
        );


    }

    private void ImageSetSlideShow() {

        viewPagerOne = (ViewPager) findViewById(R.id.viewPagerOne);
        viewPagerTwo = (ViewPager) findViewById(R.id.viewPager_two);
        viewPagerThree = (ViewPager) findViewById(R.id.viewPager_three);
        viewPagerFour = (ViewPager) findViewById(R.id.viewPager_four);
        viewPagerFive = (ViewPager) findViewById(R.id.viewPager_five);
        viewPagerSix = (ViewPager) findViewById(R.id.viewPager_six);
        viewPagerSeven = (ViewPager) findViewById(R.id.viewPager_seven);

        SliderPageOne sliderPageOne = new SliderPageOne(this);
        Slider_two slider_two = new Slider_two(this);
        Slider_three slider_three = new Slider_three(this);
        Slider_four slider_four = new Slider_four(this);
        Slider_five slider_five = new Slider_five(this);
        Slider_six slider_six = new Slider_six(this);
        Slider_seven slider_seven = new Slider_seven(this);

        viewPagerOne.setAdapter(sliderPageOne);
        viewPagerTwo.setAdapter(slider_two);
        viewPagerThree.setAdapter(slider_three);
        viewPagerFour.setAdapter(slider_four);
        viewPagerFive.setAdapter(slider_five);
        viewPagerSix.setAdapter(slider_six);
        viewPagerSeven.setAdapter(slider_seven);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
    }




    private void TextSliderr() {
        TextSlider = findViewById(R.id.idTextSLider);
        TextSliderTwo = findViewById(R.id.idTextSLider_two);
        TextSliderThree = findViewById(R.id.idTextSLider_three);
        TextSliderFour = findViewById(R.id.idTextSLider_four);
        TextSliderFive = findViewById(R.id.idTextSLider_five);
        TextSliderSix = findViewById(R.id.idTextSLider_six);
        TextSliderSeven = findViewById(R.id.idTextSLider_seven);

        TextSlider.setSelected(true);
        TextSliderTwo.setSelected(true);
        TextSliderThree.setSelected(true);
        TextSliderFour.setSelected(true);
        TextSliderFive.setSelected(true);
        TextSliderSix.setSelected(true);
        TextSliderSeven.setSelected(true);
    }

    private void HotlineCall() {

        list = findViewById(R.id.IEDCRnumberlist);
        numberPojoClassList = new ArrayList();

        IEDCR_NumberList();



        customUserAdapter = new CustomUserAdapter(this, R.layout.custom_number_layout, numberPojoClassList);
        list.setAdapter(customUserAdapter);
    }

    private void IEDCR_NumberList(){
        numberPojoClassList.add(new NumberPojoClass("01401184551"));
        numberPojoClassList.add(new NumberPojoClass("01550064905"));
        numberPojoClassList.add(new NumberPojoClass("01401184554"));
        numberPojoClassList.add(new NumberPojoClass("01401184555"));
        numberPojoClassList.add(new NumberPojoClass("01937110011"));
        numberPojoClassList.add(new NumberPojoClass("01550064901"));
        numberPojoClassList.add(new NumberPojoClass("01401184559"));
        numberPojoClassList.add(new NumberPojoClass("01937000011"));
        numberPojoClassList.add(new NumberPojoClass("01550064902"));
        numberPojoClassList.add(new NumberPojoClass("01401184560"));
        numberPojoClassList.add(new NumberPojoClass("01927711784"));
        numberPojoClassList.add(new NumberPojoClass("01550064903"));
        numberPojoClassList.add(new NumberPojoClass("01401184563"));
        numberPojoClassList.add(new NumberPojoClass("01927711785"));
        numberPojoClassList.add(new NumberPojoClass("01550064904"));
        numberPojoClassList.add(new NumberPojoClass("01401184568"));
    }
    private void Army_NumberList(){

        list2 = findViewById(R.id.ArmyRnumberlist);
        ArmryPojoClassList = new ArrayList();

        ArmryPojoClassList.add(new NumberPojoClass("01769013420"));
        ArmryPojoClassList.add(new NumberPojoClass("0176901330"));
        ArmryPojoClassList.add(new NumberPojoClass("01769013090"));
        ArmryPojoClassList.add(new NumberPojoClass("0176901306"));

        customUserAdapter = new CustomUserAdapter(this, R.layout.custom_number_layout, ArmryPojoClassList);
        list2.setAdapter(customUserAdapter);

    }


    public class CustomUserAdapter extends ArrayAdapter<NumberPojoClass> {

        private List<NumberPojoClass> numberPojoClassList;
        private Context context;

        public CustomUserAdapter(@NonNull Context context, int textViewResourceId, List<NumberPojoClass> numberPojoClassList) {
            super(context, textViewResourceId, numberPojoClassList);
            this.context = context;
            this.numberPojoClassList = numberPojoClassList;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable final View convertView, @NonNull ViewGroup parent) {

            View customView= convertView;
            if (customView==null)
            {
                LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                customView = vi.inflate(R.layout.custom_number_layout, null);

            }

            final NumberPojoClass numberPojoClass = numberPojoClassList.get(position);


            if(numberPojoClass !=null)
            {

                final TextView nameTextView = (TextView) customView.findViewById(R.id.idNumber);
                nameTextView.setText(numberPojoClass.getName());



                //Call Button
                Button CDeleteButton = (Button) customView.findViewById( R.id.idCallButton );

                CDeleteButton.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                   //     Toast.makeText(context, ""+ numberPojoClass.getName().toString(), Toast.LENGTH_SHORT).show();

                        String s = "tel:" + numberPojoClass.getName();
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse(s));

                        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                                    Manifest.permission.CALL_PHONE}, 1);
                            return;
                        }
                        startActivity(intent);
                    }
                } );

            }

            return  customView;

        }
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPagerOne.getCurrentItem() == 0){
                        viewPagerOne.setCurrentItem(1);
                    } else if(viewPagerOne.getCurrentItem() == 1){
                        viewPagerOne.setCurrentItem(2);
                    } else if(viewPagerOne.getCurrentItem() == 2){
                        viewPagerOne.setCurrentItem(3);
                    } else if(viewPagerOne.getCurrentItem() == 3){
                        viewPagerOne.setCurrentItem(4);
                    } else if(viewPagerOne.getCurrentItem() == 4){
                        viewPagerOne.setCurrentItem(5);
                    } else if(viewPagerOne.getCurrentItem() == 5){
                        viewPagerOne.setCurrentItem(6);
                    } else if(viewPagerOne.getCurrentItem() == 6){
                        viewPagerOne.setCurrentItem(7);
                    } else {
                        viewPagerOne.setCurrentItem(0);
                    }


                    if(viewPagerTwo.getCurrentItem() == 0){
                        viewPagerTwo.setCurrentItem(1);
                    } else {
                        viewPagerTwo.setCurrentItem(0);
                    }

                    if(viewPagerThree.getCurrentItem() == 0){
                        viewPagerThree.setCurrentItem(1);
                    } else if(viewPagerThree.getCurrentItem() == 1){
                        viewPagerThree.setCurrentItem(2);
                    } else if(viewPagerThree.getCurrentItem() == 2){
                        viewPagerThree.setCurrentItem(3);
                    } else if(viewPagerThree.getCurrentItem() == 3){
                        viewPagerThree.setCurrentItem(4);
                    } else if(viewPagerThree.getCurrentItem() == 5){
                        viewPagerThree.setCurrentItem(6);
                    } else {
                        viewPagerThree.setCurrentItem(0);
                    }

                    if(viewPagerFour.getCurrentItem() == 0){
                        viewPagerFour.setCurrentItem(1);
                    } else if(viewPagerFour.getCurrentItem() == 1){
                        viewPagerFour.setCurrentItem(2);
                    } else if(viewPagerFour.getCurrentItem() == 2){
                        viewPagerFour.setCurrentItem(3);
                    } else if(viewPagerFour.getCurrentItem() == 3){
                        viewPagerFour.setCurrentItem(4);
                    } else if(viewPagerFour.getCurrentItem() == 4){
                        viewPagerFour.setCurrentItem(5);
                    } else if(viewPagerFour.getCurrentItem() == 5){
                        viewPagerFour.setCurrentItem(6);
                    } else if(viewPagerFour.getCurrentItem() == 6){
                        viewPagerFour.setCurrentItem(7);
                    } else {
                        viewPagerFour.setCurrentItem(0);
                    }

                    if(viewPagerFive.getCurrentItem() == 0){
                        viewPagerFive.setCurrentItem(1);
                    } else if(viewPagerFive.getCurrentItem() == 1){
                        viewPagerFive.setCurrentItem(2);
                    } else if(viewPagerFive.getCurrentItem() == 2){
                        viewPagerFive.setCurrentItem(3);
                    } else if(viewPagerFive.getCurrentItem() == 3){
                        viewPagerFive.setCurrentItem(4);
                    } else if(viewPagerFive.getCurrentItem() == 4){
                        viewPagerFive.setCurrentItem(5);
                    } else if(viewPagerFive.getCurrentItem() == 5){
                        viewPagerFive.setCurrentItem(6);
                    } else if(viewPagerFive.getCurrentItem() == 6){
                        viewPagerFive.setCurrentItem(7);
                    } else if(viewPagerFive.getCurrentItem() == 7){
                        viewPagerFive.setCurrentItem(8);
                    } else if(viewPagerFive.getCurrentItem() == 8){
                        viewPagerFive.setCurrentItem(9);
                    } else if(viewPagerFive.getCurrentItem() == 9){
                        viewPagerFive.setCurrentItem(10);
                    } else if(viewPagerFive.getCurrentItem() == 11){
                        viewPagerFive.setCurrentItem(12);
                    } else if(viewPagerFive.getCurrentItem() == 12){
                        viewPagerFive.setCurrentItem(13);
                    } else {
                        viewPagerFive.setCurrentItem(0);
                    }


                    if(viewPagerSix.getCurrentItem() == 0){
                        viewPagerSix.setCurrentItem(1);
                    } else if(viewPagerSix.getCurrentItem() == 1){
                        viewPagerSix.setCurrentItem(2);
                    } else {
                        viewPagerSix.setCurrentItem(0);
                    }

                    if(viewPagerSeven.getCurrentItem() == 0){
                        viewPagerSeven.setCurrentItem(1);
                    } else if(viewPagerSeven.getCurrentItem() == 1){
                        viewPagerSeven.setCurrentItem(2);
                    } else if(viewPagerSeven.getCurrentItem() == 2){
                        viewPagerSeven.setCurrentItem(3);
                    } else if(viewPagerSeven.getCurrentItem() == 3){
                        viewPagerSeven.setCurrentItem(4);
                    } else if(viewPagerSeven.getCurrentItem() == 4){
                        viewPagerSeven.setCurrentItem(5);
                    } else if(viewPagerSeven.getCurrentItem() == 5){
                        viewPagerSeven.setCurrentItem(6);
                    } else if(viewPagerSeven.getCurrentItem() == 6){
                        viewPagerSeven.setCurrentItem(7);
                    } else if(viewPagerSeven.getCurrentItem() == 7){
                        viewPagerSeven.setCurrentItem(8);
                    } else if(viewPagerSeven.getCurrentItem() == 8){
                        viewPagerSeven.setCurrentItem(9);
                    } else {
                        viewPagerSeven.setCurrentItem(0);
                    }



                }
            });

        }
    }

}



