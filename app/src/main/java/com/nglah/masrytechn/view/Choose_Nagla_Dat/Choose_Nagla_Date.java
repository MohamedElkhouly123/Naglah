package com.nglah.masrytechn.view.Choose_Nagla_Dat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.view.choose_place.Choose_Element;
import com.nglah.masrytechn.view.main.MainActivity_User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Choose_Nagla_Date extends AppCompatActivity {

    TextView date ,time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__nagla__date);
        ButterKnife.bind(this);
        date =(TextView)findViewById(R.id.dateTxt);
        time =(TextView)findViewById(R.id.time_txt);

    }

    @OnClick(R.id.later)
    void laterTime(){
        final View dialogView = View.inflate(Choose_Nagla_Date.this, R.layout.date_time_picker, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(Choose_Nagla_Date.this).create();

        dialogView.findViewById(R.id.date_time_set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.date_picker);
                TimePicker timePicker = (TimePicker) dialogView.findViewById(R.id.time_picker);

                Calendar calendar = new GregorianCalendar(datePicker.getYear(),
                        datePicker.getMonth(),
                        datePicker.getDayOfMonth(),
                        timePicker.getCurrentHour(),
                        timePicker.getCurrentMinute());

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
                String formattedDate = df.format(calendar.getTime());
                String formattedTime = tf.format(calendar.getTime());
                time.setText(formattedTime);
                date.setText(formattedDate);
                alertDialog.dismiss();
            }});
        alertDialog.setView(dialogView);
        alertDialog.show();
//        Type=getString(R.string.later);


    }
    @OnClick(R.id.now)
    void now(){
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        String formattedTime = tf.format(c.getTime());
        time.setText(formattedTime);
        date.setText(formattedDate);
//        Type=getString(R.string.now);

    }
    @OnClick(R.id.submit)
    void submit(){

    }
    @OnClick(R.id.cancel)
    void cancel(){
        startActivity(new Intent(this, MainActivity_User.class));



    }
}
