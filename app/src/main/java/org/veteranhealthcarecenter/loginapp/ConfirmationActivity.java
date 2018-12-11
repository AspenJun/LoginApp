package org.veteranhealthcarecenter.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ConfirmationActivity extends AppCompatActivity {

    private TextView confirmation;
    //private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        confirmation = (TextView) findViewById(R.id.textView10);
        //description = (TextView) findViewById(R.id.textView4);


        if(getIntent().hasExtra("org.veteranhealthcarecenter.loginapp.SOMETHING")) {
            String firstname = getIntent().getStringExtra("firstname");
            String lastname = getIntent().getStringExtra("lastname");
            String dateofbirth = getIntent().getStringExtra("dateofbirth");
            String hobby = getIntent().getStringExtra("infohobby");
            //String phone = getIntent().getStringExtra("infophone");
            String gender = getIntent().getStringExtra("gender");
            String occupation = getIntent().getStringExtra("occupation");
            String radio = getIntent().getStringExtra("radio");

            TextView tv = (TextView) findViewById(R.id.tvThank);
            TextView tv2 =(TextView) findViewById(R.id.textView4);
            TextView tv3 = (TextView) findViewById(R.id.textView5);
            TextView tv4 = (TextView) findViewById(R.id.textView6);
            //TextView tv5 = (TextView) findViewById(R.id.textView7);
            TextView tv6 = (TextView) findViewById(R.id.textView8);
            TextView tv7 = (TextView) findViewById(R.id.textView9);
            TextView tv8 = (TextView) findViewById(R.id.textView11);
            TextView tv9 = (TextView) findViewById(R.id.textView10);

            String text = getIntent().getExtras().getString("org.veteranhealthcarecenter.loginapp.SOMETHING") + " " + firstname + " " + lastname +"!";
            String text2 = getIntent().getExtras().getString("description" );
            String text3 = getIntent().getExtras().getString("datedesc") + " " + dateofbirth;
            String text4 = getIntent().getExtras().getString("hobbydesc") + " " + hobby;
            //String text5 = getIntent().getExtras().getString("phonedesc") + " " + phone;
            String text6 = getIntent().getExtras().getString("genderdesc") + " " + gender;
            String text7 = getIntent().getExtras().getString("occupdesc") + " " + occupation;
            String text8 = getIntent().getExtras().getString("radiodesc") + " " + radio + " " + "club!";
            String text9 = getIntent().getExtras().getString("result" );

            tv.setText(text);
            tv2.setText(text2);
            tv3.setText(text3);
            tv4.setText(text4);
            //tv5.setText(text5);
            tv6.setText(text6);
            tv7.setText(text7);
            tv8.setText(text8);
            tv9.setText(text9);


        }

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmationActivity.this, SecondActivity.class));
            }
        });

    }
}
