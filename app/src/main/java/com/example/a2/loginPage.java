package com.example.a2;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class loginPage extends AppCompatActivity {
    private Button back,login;
    private EditText name,email;
    private TextView nameMessage,emailMessage;
    private String emailPattern = "^(?!\\.)(?!.*\\.\\.)[a-z0-9'_\\-.]{1,64}(?<!\\.)@(googlemail|gmail|yahoo|outlook)\\.com$";

    //    boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        back=findViewById(R.id.back2);
        login=findViewById(R.id.login);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        nameMessage=findViewById(R.id.nameMessage);
        emailMessage=findViewById(R.id.emailMessage);

        back.setOnClickListener(view -> {
            finish();
        });

        login.setOnClickListener(view -> {
            String nameText=name.getText().toString().trim();
            String emailText=email.getText().toString().trim();
            if(nameText.isEmpty()){
                nameMessage.setText("*Name cannot be empty");
                emailMessage.setText("");
                return;
            }else{
                nameMessage.setText("");
            }
            nameText=removeSpaces(nameText+" ");
            if(emailText.isEmpty()){
                emailMessage.setText("*email cannot be empty");
                return;
            }else {
                emailMessage.setText("");
            }
            if(!emailText.matches(emailPattern)){
                emailMessage.setText("*Invalid email");
                return;
            }else {
                emailMessage.setText("");
            }
            Intent intent=new Intent(loginPage.this,explorePage.class);
            intent.putExtra("name",nameText);
            intent.putExtra("email",emailText);
            startActivity(intent);
        });

    }
    private String removeSpaces(String input) {
        int l=input.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<l-1;i++) {
            if (input.charAt(i) != ' ' || input.charAt(i + 1) != ' ') {
                sb.append(input.charAt(i));
            }

        }
        return sb.toString();
    }
}