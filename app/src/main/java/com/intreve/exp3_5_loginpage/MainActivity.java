package com.intreve.exp3_5_loginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUserName, etPassword;
    RadioGroup radioGroup;
    AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName=findViewById(R.id.etUserName);
        etPassword=findViewById(R.id.etPassword);
        radioGroup=findViewById(R.id.radioGroup);
        btnLogin=findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=etUserName.getText().toString();
                String password=etPassword.getText().toString();
                String rememberChoice="";

                String paymentChoice="";

                int radioButtonId=-1;

                radioButtonId=radioGroup.getCheckedRadioButtonId();

                switch (radioButtonId){
                    case R.id.rbOffline:
                        paymentChoice="Offline";
                        break;

                    case R.id.rbOnline:
                        paymentChoice="Online";
                        break;


                    default:
                        paymentChoice="Undecided";
                }



                String choice1="";
                String choice2="";

                CheckBox cbPassword=findViewById(R.id.cbPassword);
                CheckBox cbUserName=findViewById(R.id.cbUserName);


                if(cbPassword.isChecked()){
                    choice1="Password";

                }

                if(cbUserName.isChecked()){
                    choice2="Username";
                }

                rememberChoice=choice1+" "+choice2;

              if(choice1==""&& choice2==""){
                  rememberChoice="None";
              }

                String toastString="User: "+userName+" created. \nPayment method: "+paymentChoice+"\nRemember choice: "+ rememberChoice;

                Toast.makeText(MainActivity.this, toastString, Toast.LENGTH_SHORT).show();





            }
        });
    }
}