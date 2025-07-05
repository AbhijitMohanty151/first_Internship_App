package com.example.a2;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class explore2 extends AppCompatActivity {
    private TextView selectionmenu,courses,register,appdevelopmentm,businessdevelopmentassociatem,contentwritingm,cybersecuritym,datasciencem,digitalmarketingm,digitalmediapromotionm,fullstackdevelopmentm,hrm,iotm,softwaredevelopmentm,uiuxdesignm,webdevm,processassociatem;
    private LinearLayout courseslist;
    private Button menulogout;
    private ScrollView menubackground,menuforeground;
    private TextView menuexit;
    private ImageButton menu;
    private Button regester;
    private String name;
    private String email;
    private String category;
    private TextView course,outText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_explore2);
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
        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        category = getIntent().getStringExtra("category");

        regester = findViewById(R.id.regester);
        course = findViewById(R.id.course);
        outText = findViewById(R.id.outtext);

        ViewGroup.LayoutParams params = menuforeground.getLayoutParams();
        params.width = (int) (screenWidth * 0.75);
        params.height = screenHeight - (int)(110*getResources().getDisplayMetrics().density+0.5f);
        menuforeground.setLayoutParams(params);

        selectionmenu.setOnClickListener(v -> {
            Intent intent = new Intent(explore2.this, explorePage.class);
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
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
            Intent intent = new Intent(explore2.this, regester.class);
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        switch (category) {
            case "appdevelopment":
                course.setText(" App Development ");
                outText.setText("App development involves creating software applications for mobile devices, typically using Android Studio for Android and Xcode for iOS.\n\n" +
                        "Developers use programming languages like Java, Kotlin, or Swift to design intuitive user interfaces and optimize app performance.\n\n" +
                        "The course covers full mobile app life cycle management, UI/UX design, database integration, and deployment on app stores.");
                break;

            case "businessdevelopmentassociate":
                course.setText(" Business Development Associate ");
                outText.setText("This role focuses on identifying growth opportunities and building strategic business partnerships.\n\n" +
                        "Associates conduct market research, pitch products or services, and coordinate with sales teams to meet client needs.\n\n" +
                        "The course trains students in communication, lead generation, CRM tools, and professional client interaction.");
                break;

            case "contentwriting":
                course.setText(" Content Writing ");
                outText.setText("Content writing is about creating engaging, informative, and SEO-optimized written material for websites, blogs, and marketing channels.\n\n" +
                        "Writers are trained to understand target audiences, write in different tones, and structure content for readability and ranking.\n\n" +
                        "The course explores blog writing, web content, copywriting, technical documentation, and portfolio development.");
                break;

            case "cybersecurity":
                course.setText(" Cyber Security ");
                outText.setText("Cybersecurity focuses on protecting systems and networks from digital attacks, data breaches, and unauthorized access.\n\n" +
                        "Students learn about threat detection, ethical hacking, firewalls, cryptography, and network security protocols.\n\n" +
                        "This course emphasizes real-world attack scenarios, security best practices, and risk management.");
                break;

            case "datascience":
                course.setText(" Data Science ");
                outText.setText("Data Science is the study of extracting meaningful insights from structured and unstructured data using tools like Python, R, and SQL.\n\n" +
                        "It involves statistics, machine learning, data visualization, and predictive modeling.\n\n" +
                        "The course teaches data cleaning, model building, visualization (using libraries like Matplotlib, Seaborn), and use of tools like Jupyter and Pandas.");
                break;

            case "digitalmarketing":
                course.setText(" Digital Marketing ");
                outText.setText("Digital marketing involves promoting products and services through digital platforms like Google, Facebook, Instagram, and email.\n\n" +
                        "Students learn SEO, SEM, email campaigns, analytics, and social media strategies.\n\n" +
                        "This course includes practical projects like running ad campaigns, tracking traffic, and analyzing engagement data.");
                break;

            case "digitalmediapromotion":
                course.setText(" Digital Media Promotion ");
                outText.setText("Digital media promotion focuses on creating campaigns that maximize digital reach and engagement.\n\n" +
                        "It includes social media promotions, video marketing, influencer collaboration, and branding strategies.\n\n" +
                        "Students learn content scheduling, engagement analysis, audience targeting, and digital brand positioning.");
                break;

            case "fullstackdevelopment":
                course.setText(" Full Stack Development ");
                outText.setText("Full stack development means working with both the frontend (HTML, CSS, JS) and backend (Node.js, Java, Python) of a web application.\n\n" +
                        "Students learn to build complete apps, manage databases, and deploy using platforms like Heroku or Firebase.\n\n" +
                        "The course includes REST API creation, user authentication, database schemas, and responsive UI design.");
                break;

            case "hr":
                course.setText(" Human Resources (HR) ");
                outText.setText("HR involves recruitment, employee engagement, policy implementation, and team coordination.\n\n" +
                        "Students learn about interviewing techniques, onboarding, HR software tools, labor laws, and conflict resolution.\n\n" +
                        "This course prepares individuals to handle organizational structure, employee welfare, and training needs.");
                break;

            case "iot":
                course.setText(" Internet of Things (IoT) ");
                outText.setText("IoT is about connecting physical devices to the internet to collect and exchange data.\n\n" +
                        "This course covers sensors, microcontrollers (like Arduino or Raspberry Pi), data transmission, and cloud integration.\n\n" +
                        "Students work on real-world projects like home automation, health monitoring, and smart agriculture systems.");
                break;

            case "softwaredevelopment":
                course.setText(" Software Development ");
                outText.setText("Software development involves designing, coding, testing, and maintaining applications for desktop, mobile, or web platforms.\n\n" +
                        "Students learn SDLC, object-oriented programming, version control (Git), and testing strategies.\n\n" +
                        "The course emphasizes project-based learning, teamwork, and coding standards across different languages.");
                break;

            case "uiuxdesign":
                course.setText(" UI/UX Design ");
                outText.setText("UI/UX design focuses on creating interfaces that are user-friendly, attractive, and functional.\n\n" +
                        "Students explore design tools like Figma, Adobe XD, wireframing, prototyping, and usability testing.\n\n" +
                        "This course teaches design thinking, user research, and accessibility principles to improve the overall user experience.");
                break;

            case "webdev":
                course.setText(" Web Development ");
                outText.setText("Web development includes building responsive and interactive websites using HTML, CSS, JavaScript, and frameworks like React or Angular.\n\n" +
                        "Students also learn backend basics (like PHP or Node.js), API integration, and hosting/deployment.\n\n" +
                        "The course prepares learners to build portfolio websites, blogs, and small business web platforms.");
                break;

            case "processassociate":
                course.setText(" Process Associate ");
                outText.setText("A Process Associate plays a vital role in managing and optimizing business operations, ensuring tasks are completed efficiently and accurately.\n\n" +
                        "In this course, students learn documentation practices, workflow analysis, basic data entry, customer service communication, and using business tools like Excel and CRM software.\n\n" +
                        "The training prepares learners for roles in BPOs, administrative departments, and support functions, enhancing attention to detail and organizational skills.");
                break;

            default:
                course.setText(" Unknown Course ");
                outText.setText("The selected course is currently not recognized. Please go back and choose a valid course category.");
                break;
        }

        menulogout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(explore2.this);
            builder.setTitle("Logging out");
            builder.setMessage("Are you sure you want to logout?");
            builder.setNegativeButton("Cancel", null);
            builder.setPositiveButton("Yes", (dialog, which) -> {
                Intent intent = new Intent(explore2.this, loginPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            });
            builder.show();
        });

        regester.setOnClickListener(v -> {
            Intent intent=new Intent(explore2.this,regester.class);
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            intent.putExtra("category",course.getText().toString().trim());
            startActivity(intent);
        });

        menu.setOnClickListener(v -> {
            menubackground.setVisibility(View.VISIBLE);
        });

        menuexit.setOnClickListener(v -> {
            menubackground.setVisibility(View.GONE);
        });

    }
}