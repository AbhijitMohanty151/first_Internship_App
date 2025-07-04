package com.example.a2;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class success extends AppCompatActivity {

    private ScrollView menubackground,menuforeground;
    private TextView menuexit;
    private ImageButton menu;
    private Button back,details;
    private String name1,branch1,email1,college1,phone1,percent101,percent121,percentug1,location1,internshipcourse1,internshipduration1,paymentid1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_success);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        menuexit = findViewById(R.id.menuexit);
        menu = findViewById(R.id.menu);
        menubackground = findViewById(R.id.menubackground);
        menuforeground = findViewById(R.id.menuforeground);
        name1=getIntent().getStringExtra("name");
        branch1=getIntent().getStringExtra("branch");
        email1=getIntent().getStringExtra("email");
        college1=getIntent().getStringExtra("college");
        phone1=getIntent().getStringExtra("phone");
        percent101=getIntent().getStringExtra("percent10");
        percent121=getIntent().getStringExtra("percent12");
        percentug1=getIntent().getStringExtra("percentug");
        location1=getIntent().getStringExtra("location");
        internshipcourse1=getIntent().getStringExtra("internshipcourse");
        internshipduration1=getIntent().getStringExtra("internshipduration");
        paymentid1=getIntent().getStringExtra("paymentid");

        back = findViewById(R.id.back4);
        details = findViewById(R.id.details);

        ViewGroup.LayoutParams params = menuforeground.getLayoutParams();
        params.width = (int) (screenWidth * 0.75);
        params.height = screenHeight;
        menuforeground.setLayoutParams(params);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(success.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        details.setOnClickListener(view -> {
            String message =
                    "Name: " + name1 + "\n" +
                            "Branch: " + branch1 + "\n" +
                            "Email: " + email1 + "\n" +
                            "College: " + college1 + "\n" +
                            "Phone No.: " + phone1 + "\n" +
                            "10th Percentage: " + percent101 + "\n" +
                            "12th Percentage: " + percent121 + "\n" +
                            "UG Percentage: " + percentug1 + "\n" +
                            "Location: " + location1 + "\n" +
                            "Internship Course: " + internshipcourse1 + "\n" +
                            "Internship Duration: " + internshipduration1 + "\n" +
                            "Payment ID: " + paymentid1;

            AlertDialog.Builder builder = new AlertDialog.Builder(success.this);
            builder.setTitle("REGISTRATION SUCCESSFUL");
            builder.setMessage(message);
            builder.setPositiveButton("OK", null);
            builder.show();

        });

        menu.setOnClickListener(v -> {
            menubackground.setVisibility(View.VISIBLE);
        });

        menuexit.setOnClickListener(v -> {
            menubackground.setVisibility(View.GONE);
        });

    }
}