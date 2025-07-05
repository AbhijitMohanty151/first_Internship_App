package com.example.a2;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import android.Manifest;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class regester extends AppCompatActivity {

    private Button menulogout;
    private ScrollView menubackground,menuforeground;
    private TextView menuexit;
    private ImageButton menu;
    private Button submit,reset;
    private ImageButton getLocationBtn;
    private TextView outputtext;
    private EditText name,branch,email,college,phone,percent10,percent12,percentug,locationField,internshipcourse,internshipduration,paymentid;
    private String name1,branch1,email1,college1,phone1,percent101,percent121,percentug1,location1,internshipcourse1,internshipduration1,paymentid1;
    private String[] courseNames = {
            "App Development",
            "Business Development Associate",
            "Content Writing",
            "Cyber Security",
            "Data Science",
            "Digital Marketing",
            "Digital Media Promotion",
            "Full Stack Development",
            "Human Resources (HR)",
            "Internet of Things (IoT)",
            "Software Development",
            "UI/UX Design",
            "Web Development",
            "Process Associate"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_regester);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        menulogout = findViewById(R.id.menulogout);
        menuexit = findViewById(R.id.menuexit);
        menu = findViewById(R.id.menu);
        menubackground = findViewById(R.id.menubackground);
        menuforeground = findViewById(R.id.menuforeground);
        name1=getIntent().getStringExtra("name");
        email1=getIntent().getStringExtra("email");
        internshipcourse1=getIntent().getStringExtra("category");

        submit = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);
        outputtext = findViewById(R.id.outputtext);

        name = findViewById(R.id.name1);
        branch = findViewById(R.id.branch);
        email = findViewById(R.id.email);
        college = findViewById(R.id.college);
        phone = findViewById(R.id.phone);
        percent10 = findViewById(R.id.percent10);
        percent12 = findViewById(R.id.percent12);
        percentug = findViewById(R.id.percentug);
        locationField = findViewById(R.id.location);
        getLocationBtn = findViewById(R.id.locationbutton);
        internshipcourse = findViewById(R.id.internshipcourse);
        internshipduration = findViewById(R.id.internshipduration);
        paymentid = findViewById(R.id.paymentid);

        name.setText(name1);
        internshipcourse.setText(internshipcourse1);
        email.setText(email1);

        ViewGroup.LayoutParams params = menuforeground.getLayoutParams();
        params.width = (int) (screenWidth * 0.75);
        params.height = screenHeight - (int)(110*getResources().getDisplayMetrics().density+0.5f);
        menuforeground.setLayoutParams(params);

        reset.setOnClickListener(view -> {
            name.setText("");
            branch.setText("");
            email.setText("");
            college.setText("");
            phone.setText("");
            percent10.setText("");
            percent12.setText("");
            percentug.setText("");
            locationField.setText("");
            internshipcourse.setText("");
            internshipduration.setText("");
            paymentid.setText("");
        });

        submit.setOnClickListener(view -> {
            name1 = name.getText().toString();
            branch1 = branch.getText().toString();
            email1 = email.getText().toString();
            college1 = college.getText().toString();
            phone1 = phone.getText().toString();
            percent101 = percent10.getText().toString();
            percent121 = percent12.getText().toString();
            percentug1 = percentug.getText().toString();
            location1 = locationField.getText().toString();
            internshipduration1 = internshipduration.getText().toString();
            internshipcourse1 = internshipcourse.getText().toString();
            paymentid1 = paymentid.getText().toString();

            if(name1.isEmpty()||branch1.isEmpty()||email1.isEmpty()||college1.isEmpty()||phone1.isEmpty()||percent101.isEmpty()||percent121.isEmpty()||percentug1.isEmpty()||location1.isEmpty()||internshipduration1.isEmpty()||internshipcourse1.isEmpty()||paymentid1.isEmpty()){
                outputtext.setText("*Please fill all the fields");
                return;
            }
            name1 = removeSpaces(name1+" ");
            if(!email1.matches("^(?!\\.)(?!.*\\.\\.)[a-z0-9'_\\-.]{1,64}(?<!\\.)@(googlemail|gmail|yahoo|outlook)\\.com$")){
                outputtext.setText("*Invalid email");
                email.setText("");
                return;
            }
            if(phone1.length()!=10){
                outputtext.setText("*Enter a 10 digit phone number");
                phone.setText("");
                return;
            }
            if(!(Integer.parseInt(percent101)<=100)||!(Integer.parseInt(percent101)>=0)){
                outputtext.setText("*10th percentage should be between 0 and 100");
                percent10.setText("");
                return;
            }
            if(!(Integer.parseInt(percent121)<=100)||!(Integer.parseInt(percent121)>=0)){
                outputtext.setText("*12th percentage should be between 0 and 100");
                percent12.setText("");
                return;
            }
            if(!(Integer.parseInt(percentug1)<=100)||!(Integer.parseInt(percentug1)>=0)){
                outputtext.setText("*UG percentage should be between 0 and 100");
                percentug.setText("");
                return;
            }
            if(!checkCourse(internshipcourse1)){
                outputtext.setText("*Select a course");
                internshipcourse.setText("");
                return;
            }

            outputtext.setText("");
            Intent intent=new Intent(regester.this,success.class);
            intent.putExtra("name",name1);
            intent.putExtra("branch",branch1);
            intent.putExtra("email",email1);
            intent.putExtra("college",college1);
            intent.putExtra("phone",phone1);
            intent.putExtra("percent10",percent101);
            intent.putExtra("percent12",percent121);
            intent.putExtra("percentug",percentug1);
            intent.putExtra("location",location1);
            intent.putExtra("internshipcourse",internshipcourse1);
            intent.putExtra("internshipduration",internshipduration1);
            intent.putExtra("paymentid",paymentid1);
            startActivity(intent);
        });

        internshipduration.setOnClickListener(view -> {
            String[] courseDurations = {
                    "1W",
                    "1M",
                    "2M",
                    "3M",
                    "4M",
                    "5M",
                    "6M",
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(regester.this);
            builder.setTitle("Select Duration");

            builder.setItems(courseDurations, (dialog, which) -> {
                internshipduration.setText(courseDurations[which]);
            });
            builder.show();
        });

        internshipcourse.setOnClickListener(view -> {
            String[] courseNames = {
                    "App Development",
                    "Business Development Associate",
                    "Content Writing",
                    "Cyber Security",
                    "Data Science",
                    "Digital Marketing",
                    "Digital Media Promotion",
                    "Full Stack Development",
                    "Human Resources (HR)",
                    "Internet of Things (IoT)",
                    "Software Development",
                    "UI/UX Design",
                    "Web Development",
                    "Process Associate"
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(regester.this);
            builder.setTitle("Select Course");
            builder.setItems(courseNames, (dialog, which) -> {
                internshipcourse.setText(courseNames[which]);
            });
            builder.show();
        });

        getLocationBtn.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1001);
            } else {
                fusedLocationClient.getLastLocation()
                        .addOnSuccessListener(location -> {
                            if (location != null) {
                                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                                try {
                                    List<Address> addresses = geocoder.getFromLocation(
                                            location.getLatitude(), location.getLongitude(), 1);
                                    if (!addresses.isEmpty()) {
                                        String city = addresses.get(0).getLocality();
                                        String state = addresses.get(0).getAdminArea();
                                        locationField.setText(city + ", " + state);
                                    }
                                } catch (IOException e) {
                                    locationField.setText("Error getting location");
                                    e.printStackTrace();
                                }
                            }
                        });
            }
        });

        menu.setOnClickListener(v -> {
            menubackground.setVisibility(View.VISIBLE);
        });

        menuexit.setOnClickListener(v -> {
            menubackground.setVisibility(View.GONE);
        });

        menulogout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(regester.this);
            builder.setTitle("Logging out");
            builder.setMessage("Are you sure you want to logout?");
            builder.setNegativeButton("Cancel", null);
            builder.setPositiveButton("Yes", (dialog, which) -> {
                Intent intent = new Intent(regester.this, loginPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            });
            builder.show();
        });

    }
    private boolean checkCourse(String course) {
        for (String c : courseNames) {
            if (c.equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
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