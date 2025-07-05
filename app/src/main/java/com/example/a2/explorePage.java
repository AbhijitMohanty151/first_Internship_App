package com.example.a2;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class explorePage extends AppCompatActivity {
    private TextView selectionmenu,courses,register,appdevelopmentm,businessdevelopmentassociatem,contentwritingm,cybersecuritym,datasciencem,digitalmarketingm,digitalmediapromotionm,fullstackdevelopmentm,hrm,iotm,softwaredevelopmentm,uiuxdesignm,webdevm,processassociatem;
    private LinearLayout courseslist;
    private Button menulogout;
    private ScrollView menubackground,menuforeground;
    private TextView menuexit;
    private ImageButton menu;
    private ImageButton appdevelopment;
    private ImageButton businessdevelopmentassociate;
    private ImageButton contentwriting;
    private ImageButton cybersecurity;
    private ImageButton datascience;
    private ImageButton digitalmarketing;
    private ImageButton digitalmediapromotion;
    private ImageButton fullstackdevelopment;
    private ImageButton hr;
    private ImageButton iot;
    private ImageButton softwaredevelopment;
    private ImageButton uiuxdesign;
    private ImageButton webdev;
    private ImageButton processassociate;
    private ImageButton searchButton;
    private AutoCompleteTextView searchText;
    private Button logout;
    private TextView welcome;
    private String name,email;
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

    private String selectedCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_explore_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        selectionmenu = findViewById(R.id.selectionmenu);
        courses = findViewById(R.id.courses);
        register = findViewById(R.id.register);
        appdevelopmentm = findViewById(R.id.appdevm);
        businessdevelopmentassociatem = findViewById(R.id.businessdevelopmentassociatem);
        contentwritingm = findViewById(R.id.contentwritingm);
        cybersecuritym = findViewById(R.id.cybersecuritym);
        datasciencem = findViewById(R.id.datasciencem);
        digitalmarketingm = findViewById(R.id.digitalmarketingm);
        digitalmediapromotionm = findViewById(R.id.digitalmediapromotionm);
        fullstackdevelopmentm = findViewById(R.id.fullstackdevelopmentm);
        hrm = findViewById(R.id.hrm);
        iotm = findViewById(R.id.iotm);
        softwaredevelopmentm = findViewById(R.id.softwaredevelopmentm);
        uiuxdesignm = findViewById(R.id.uiuxdesignm);
        webdevm = findViewById(R.id.webdevm);
        processassociatem = findViewById(R.id.processassociatem);
        courseslist = findViewById(R.id.courslist);
        menulogout = findViewById(R.id.menulogout);
        menuexit = findViewById(R.id.menuexit);
        menu = findViewById(R.id.menu);
        menubackground = findViewById(R.id.menubackground);
        menuforeground = findViewById(R.id.menuforeground);
        logout = findViewById(R.id.back1);
        welcome = findViewById(R.id.welcome);
        appdevelopment = findViewById(R.id.appdevelopment);
        businessdevelopmentassociate = findViewById(R.id.businessdevelopmentassociate);
        contentwriting = findViewById(R.id.contentwriting);
        cybersecurity = findViewById(R.id.cybersecurity);
        datascience = findViewById(R.id.datascience);
        digitalmarketing = findViewById(R.id.digitalmarketing);
        digitalmediapromotion = findViewById(R.id.digitalmediapromotion);
        fullstackdevelopment = findViewById(R.id.fullstackdevelopment);
        hr = findViewById(R.id.hr);
        iot = findViewById(R.id.iot);
        softwaredevelopment = findViewById(R.id.softwaredevelopment);
        uiuxdesign = findViewById(R.id.uiuxdesign);
        webdev = findViewById(R.id.webdev);
        processassociate = findViewById(R.id.processassociate);
        searchButton = findViewById(R.id.search);
        searchText = findViewById(R.id.searchtext);

        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");

        welcome.setText("Welcome "+name.substring(0,(name+" ").indexOf(' ')));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, courseNames);
        searchText.setAdapter(adapter);

        ViewGroup.LayoutParams params = menuforeground.getLayoutParams();
        params.width = (int) (screenWidth * 0.75);
        params.height = screenHeight - (int)(45*getResources().getDisplayMetrics().density+0.5f);
        menuforeground.setLayoutParams(params);

        selectionmenu.setOnClickListener(v -> {
            menubackground.setVisibility(View.GONE);
        });

        courses.setOnClickListener(v -> {
            if(courseslist.getVisibility() == View.GONE){
                courseslist.setVisibility(View.VISIBLE);
            }
            else{
                courseslist.setVisibility(View.GONE);
            }
        });

        register.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, regester.class);
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);

        });

        searchText.setOnItemClickListener((parent, view, position, id) -> {
            selectedCourse = parent.getItemAtPosition(position).toString();
            if (selectedCourse.isEmpty()) {
                return;
            }

            switch (selectedCourse.toLowerCase()) {
                case "app development":
                    startExplore("appdevelopment");
                    break;
                case "business development associate":
                    startExplore("businessdevelopmentassociate");
                    break;
                case "content writing":
                    startExplore("contentwriting");
                    break;
                case "cyber security":
                    startExplore("cybersecurity");
                    break;
                case "data science":
                    startExplore("datascience");
                    break;
                case "digital marketing":
                    startExplore("digitalmarketing");
                    break;
                case "digital media promotion":
                    startExplore("digitalmediapromotion");
                    break;
                case "full stack development":
                    startExplore("fullstackdevelopment");
                    break;
                case "human resources (hr)":
                    startExplore("hr");
                    break;
                case "internet of things (iot)":
                    startExplore("iot");
                    break;
                case "software development":
                    startExplore("softwaredevelopment");
                    break;
                case "ui/ux design":
                    startExplore("uiuxdesign");
                    break;
                case "web development":
                    startExplore("webdev");
                    break;
                case "process associate":
                    startExplore("processassociate");
                    break;
                default:
                    Toast.makeText(this, "No match found", Toast.LENGTH_SHORT).show();
                    break;
            }
        });

        searchButton.setOnClickListener(v -> {
            if(searchText.getVisibility() == View.GONE){
                searchText.setVisibility(View.VISIBLE);
                searchButton.setBackgroundColor(Color.parseColor("#80000000"));
                searchText.requestFocus();
                return;
            }
            selectedCourse = searchText.getText().toString();
            if (selectedCourse.isEmpty()) {
                return;
            }
            switch (selectedCourse.toLowerCase()) {
                case "app development":
                    startExplore("appdevelopment");
                    break;
                case "business development associate":
                    startExplore("businessdevelopmentassociate");
                    break;
                case "content writing":
                    startExplore("contentwriting");
                    break;
                case "cyber security":
                    startExplore("cybersecurity");
                    break;
                case "data science":
                    startExplore("datascience");
                    break;
                case "digital marketing":
                    startExplore("digitalmarketing");
                    break;
                case "digital media promotion":
                    startExplore("digitalmediapromotion");
                    break;
                case "full stack development":
                    startExplore("fullstackdevelopment");
                    break;
                case "human resources (hr)":
                    startExplore("hr");
                    break;
                case "internet of things (iot)":
                    startExplore("iot");
                    break;
                case "software development":
                    startExplore("softwaredevelopment");
                    break;
                case "ui/ux design":
                    startExplore("uiuxdesign");
                    break;
                case "web development":
                    startExplore("webdev");
                    break;
                case "process associate":
                    startExplore("processassociate");
                    break;
                default:
                    Toast.makeText(this, "No match found", Toast.LENGTH_SHORT).show();
                    break;
            }


        });

        menulogout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(explorePage.this);
            builder.setTitle("Logging out");
            builder.setMessage("Are you sure you want to logout?");
            builder.setNegativeButton("Cancel", null);
            builder.setPositiveButton("Yes", (dialog, which) -> {
                Intent intent = new Intent(explorePage.this, loginPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            });
            builder.show();
        });

        logout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(explorePage.this);
            builder.setTitle("Logging out");
            builder.setMessage("Are you sure you want to logout?");
            builder.setNegativeButton("Cancel", null);
            builder.setPositiveButton("Yes", (dialog, which) -> {
                Intent intent = new Intent(explorePage.this, loginPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            });
            builder.show();
        });

        appdevelopment.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "appdevelopment");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        businessdevelopmentassociate.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "businessdevelopmentassociate");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        contentwriting.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "contentwriting");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        cybersecurity.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "cybersecurity");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        datascience.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "datascience");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        digitalmarketing.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "digitalmarketing");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        digitalmediapromotion.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "digitalmediapromotion");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        fullstackdevelopment.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "fullstackdevelopment");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        hr.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "hr");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        iot.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "iot");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        softwaredevelopment.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "softwaredevelopment");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        uiuxdesign.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "uiuxdesign");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        webdev.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "webdev");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        processassociate.setOnClickListener(v -> {
            Intent intent = new Intent(explorePage.this, explore2.class);
            intent.putExtra("category", "processassociate");
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        menu.setOnClickListener(v -> {
            menubackground.setVisibility(View.VISIBLE);
        });

        menuexit.setOnClickListener(v -> {
            menubackground.setVisibility(View.GONE);
        });

    }
    private void startExplore(String category) {
        Intent intent = new Intent(explorePage.this, explore2.class);
        intent.putExtra("category", category);
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        startActivity(intent);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View searchBar = findViewById(R.id.searchtext); // your AutoCompleteTextView
            View searchButton = findViewById(R.id.search); // your search button

            if (searchBar.getVisibility() == View.VISIBLE) {
                int[] locSearchBar = new int[2];
                int[] locSearchButton = new int[2];
                searchBar.getLocationOnScreen(locSearchBar);
                searchButton.getLocationOnScreen(locSearchButton);

                float x = ev.getRawX();  // X coordinate of touch
                float y = ev.getRawY();  // Y coordinate of touch

                // Check if the touch is within searchBar bounds
                boolean inSearchBar = x >= locSearchBar[0] && x <= (locSearchBar[0] + searchBar.getWidth()) &&
                        y >= locSearchBar[1] && y <= (locSearchBar[1] + searchBar.getHeight());

                // Check if the touch is within searchButton bounds
                boolean inSearchButton = x >= locSearchButton[0] && x <= (locSearchButton[0] + searchButton.getWidth()) &&
                        y >= locSearchButton[1] && y <= (locSearchButton[1] + searchButton.getHeight());

                // If the touch is NOT inside either view, hide the search bar
                if (!inSearchBar && !inSearchButton) {
                    searchBar.setVisibility(View.GONE);
                    searchButton.setBackgroundColor(Color.parseColor("#00000000"));
                }
            }
        }

        return super.dispatchTouchEvent(ev); // Pass event on to other views
    }

}