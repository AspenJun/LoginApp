package org.veteranhealthcarecenter.loginapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class InfoActivity extends AppCompatActivity {
    //public static final String EXTRA_TEXT = "org.veteranhealthcarecenter.loginapp.EXTRA_TEXT";
    //public static final int EXTRA_SKILL = "org.veteranhealthcarecenter.loginapp.EXTRA_SKILL"

    TextView mTv;
    Button mBtn;
    RadioGroup skill;
    RadioButton Rbtn;
    TextView titleInfo;
    TextView phone;
    TextView command;


    //private TextView titleInfo;
    //private TextView date, phone, hobby, gender, occupation, command;
    //private TextView tvskill;
    //private EditText  firstname, lastname, infophone, infohobby, infocommand;
    //private RadioGroup infoskill;
    //private RadioButton look, run, climb;
    //private Button btncompleted;
    //private Spinner infogender, infooccup;

    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        titleInfo = (TextView) findViewById(R.id.tvTitleInfo);
        //date = (TextView) findViewById(R.id.tvInfoDate);
        phone = (TextView) findViewById(R.id.tvInfoPhone);
        //hobby = (TextView) findViewById(R.id.tvInfoHobby);
        //gender = (TextView) findViewById(R.id.tvInfoGender);
        //occupation = (TextView) findViewById(R.id.tvInfoOccup);
        command = (TextView) findViewById(R.id.tvInfoCommand);
        TextView tvskill = (TextView) findViewById(R.id.tvInfoSkill);

        mTv = (TextView) findViewById(R.id.txtView);
        mBtn = (Button) findViewById(R.id.btnPick);
        skill = (RadioGroup) findViewById(R.id.rdSkill);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(InfoActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        mTv.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);
                    }
                }, day, month, year);
                dpd.show();
            }
        });

        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(InfoActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(InfoActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.occupts));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpinner1.setAdapter(myAdapter1);
        mySpinner2.setAdapter(myAdapter2);

        Button btncompleted = (Button) findViewById(R.id.btnCompleted);
        btncompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = skill.getCheckedRadioButtonId();
                Rbtn = findViewById(radioId);

                EditText firstname = (EditText) findViewById(R.id.etInfoFirstName);
                EditText lastname = (EditText) findViewById(R.id.etInfoLastName);
                //String infophone = ((EditText) findViewById(R.id.etInfoPhone)).getText().toString();
                EditText infohobby = (EditText) findViewById(R.id.etInfoHobby);
                EditText infocommand = (EditText) findViewById(R.id.etInfoCommand);
                TextView txtView =(TextView) findViewById(R.id.txtView);
                Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
                Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
                RadioGroup radioselected = (RadioGroup) findViewById(R.id.rdSkill);
                int selectedRadio = radioselected.getCheckedRadioButtonId();
                String selectedText = ((RadioButton)findViewById(selectedRadio)).getText().toString();
                //System.out.print("Rdiotext" + selectedText);

                Intent startIntent = new Intent(getApplicationContext(), ConfirmationActivity.class);
                startIntent.putExtra("org.veteranhealthcarecenter.loginapp.SOMETHING", "Thank you");
                startIntent.putExtra("firstname", firstname.getText().toString());
                startIntent.putExtra("lastname", lastname.getText().toString());
                //startIntent.putExtra("infophone", infophone);
                startIntent.putExtra("infohobby", infohobby.getText().toString());
                startIntent.putExtra("dateofbirth", txtView.getText().toString());
                startIntent.putExtra("gender",spinner1.getSelectedItem().toString());
                startIntent.putExtra("occupation",spinner2.getSelectedItem().toString());
                startIntent.putExtra("radio", selectedText);
                startIntent.putExtra("description", "We got your information:");
                startIntent.putExtra("datedesc", "Date of Birth:");
                startIntent.putExtra("occupdesc", "Occupation:");
                startIntent.putExtra("hobbydesc", "Hobby:");
                startIntent.putExtra("genderdesc", "Gender:");
                startIntent.putExtra("radiodesc", "Welcome to our");
                startIntent.putExtra("result", "Please confirm your information!");
                //startIntent.putExtra("phonedesc", "Phone number:");


                startActivity(startIntent);
            }
        });
    }
    public void checkButton(View v){
        int radioId = skill.getCheckedRadioButtonId();

        Rbtn = findViewById(radioId);

        Toast.makeText(this, Rbtn.getText(), Toast.LENGTH_SHORT).show();
    }

}
