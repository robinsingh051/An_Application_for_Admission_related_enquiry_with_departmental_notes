package com.example.faqNnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_subject.*

class subject : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore
    var branch: String? = null
    var sem: String? = null
    lateinit var sub_list: List<String>
    val cse_sem3_sub = listOf<String>("maths", "dsa", "ade", "co", "se")
    val cse_sem4_sub = listOf<String>("maths", "daa", "os", "mes", "dc")
    val cse_sem5_sub = listOf<String>("cns", "dbms", "atc", "adp", "up")
    val cse_sem6_sub = listOf<String>("ssc", "cgv", "wta", "dmdw", "scm")
    val cse_sem7_sub = listOf<String>("aiml", "bda", "sadp", "dip", "nlp")
    val cse_sem8_sub = listOf<String>("iot", "mobile computing", "san", "nosql db", "map")
    val ele_sem3_sub = listOf<String>(
        "maths",
        "Electric Circuit Analysis",
        "Transformers and Generators",
        "Analog Electronic Circuits",
        "Digital System Design"
    )
    val ele_sem4_sub = listOf<String>(
        "maths",
        "Power Generation and Economics",
        "Transmission and Distribution",
        "Electric Motors",
        "Electromagnetic Field Theory",
        "Operational Amplifiers and Linear ICs"
    )
    val ele_sem5_sub = listOf<String>(
        "Management and Entrepreneurship",
        "Microcontroller",
        "Power Electronics",
        "Signals and Systems",
        "Electrical Machine Design"
    )
    val ele_sem6_sub = listOf<String>(
        "control systems",
        "power systems analysis",
        "digital signal processing",
        "embedded systems",
        "renewable energy sources"
    )
    val ele_sem7_sub = listOf<String>(
        "power systems analysis",
        "power systems protection",
        "solar and wind energy",
        "Advanced Control Systems",
        "smart grid"
    )
    val ele_sem8_sub = listOf<String>(
        "power system operation",
        "Facts and HDVC Transmission",
        "Electrical Estimation and Costing",
        "big data analytics",
        "power system planning"
    )
    val cv_sem3_sub = listOf<String>(
        "maths",
        "STRENGTH OF MATERIALS",
        "FLUIDS MECHANICS",
        "BUILDING MATERIALS AND CONSTRUCTION",
        "BASIC SURVEYING"
    )
    val cv_sem4_sub = listOf<String>(
        "maths",
        "analysis of determinate structures",
        "applied hydraulics",
        "concrete technology",
        "advanced surveying"
    )
    val cv_sem5_sub = listOf<String>(
        "Management and Entrepreneurship",
        "ANALYSIS OF INDETERMINATE STRUCTURES",
        "DESIGN OF RC STRUCTURAL ELEMENTS",
        "BASIC GEOTECHNICAL ENGINEERING",
        "MUNICIPAL WASTEWATER ENGINEERING"
    )
    val cv_sem6_sub = listOf<String>(
        "Design of Steel Structural Elements",
        "Applied Geotechnical Engineering",
        "Hydrology and Irrigation Engineering",
        "Solid Waste Management",
        "Traffic Engineering"
    )
    val cv_sem7_sub = listOf<String>(
        "Quality Surveying and Contract Management",
        "Design of RCC and Steel Structures",
        "Theory of Elasticity",
        "Air Pollution and Control",
        "Ground Water Hydraulics"
    )
    val cv_sem8_sub = listOf<String>(
        " Design of Pre-stressed Concrete",
        "Bridge Engineering",
        "Prefabricated Structure",
        "Advanced Foundation Engineering",
        "Pavement Design"
    )
    val me_sem3_sub = listOf<String>(
        "maths",
        "MECHANICS OF MATERIALS",
        "BASIC THERMODYNAMICS",
        "MATERIAL SCIENCE",
        "METAL CUTTING AND FORMING"
    )
    val me_sem4_sub = listOf<String>(
        "maths",
        "APPLIED THERMODYNAMICS",
        "FLUID MECHANIC",
        "KINEMATICS OF MACHINES",
        "METAL CUTTING AND FORMING"
    )
    val me_sem5_sub = listOf<String>(
        "MANAGEMENT AND ECONOMICS",
        "DESIGN OF MACHINE ELEMENTS-I",
        "DYNAMICS OF MACHINES",
        "TURBO MACHINES",
        "FLUID POWER ENGINEERING"
    )
    val me_sem6_sub = listOf<String>(
        "Finite Element Methods",
        "Design of Machine Elements–II",
        "Heat Transfer",
        "Theory of Elasticity",
        "supply chain management"
    )
    val me_sem7_sub = listOf<String>(
        "control engineering",
        "computer aided design",
        "design for manufacture",
        "automation and robotics",
        "Computational Fluid Dynamics"
    )
    val me_sem8_sub = listOf<String>(
        "energy engineering",
        "cnc machine tools",
        "Tribology",
        "automobile engineering",
        "tool design"
    )
    val chem_sub = listOf<String>(
        "maths",
        "ENGINEERING CHEMISTRY",
        "C PROGRAMMING FOR PROBLEM SOLVING",
        "BASIC ELECTRONICS",
        "ELEMENTS OF MECHANICAL ENGINEERING"
    )
    val phy_sub = listOf<String>(
        "maths",
        "ENGINEERING PHYSICS",
        "BASIC ELECTRICAL ENGINEERING",
        "ELEMENTS OF CIVIL ENGINEERING",
        "ENGINEERING GRAPHICS"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)
        var b: String? = intent.getStringExtra("branch")
        var s: String? = intent.getStringExtra("sem")
        branch = b
        sem = s
        val actionbar=supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //Toast.makeText(this, branch + " " + sem, Toast.LENGTH_LONG).show()

        if (branch == "chem")
            sub_list = chem_sub
        else if (branch == "phy")
            sub_list = phy_sub
        else if (branch == "cse" || branch == "ise") {
            if (sem == "sem3")
                sub_list = cse_sem3_sub
            else if (sem == "sem4")
                sub_list = cse_sem4_sub
            else if (sem == "sem5")
                sub_list = cse_sem5_sub
            else if (sem == "sem6")
                sub_list = cse_sem6_sub
            else if (sem == "sem7")
                sub_list = cse_sem7_sub
            else if (sem == "sem8")
                sub_list = cse_sem8_sub

        } else if (branch == "civil") {
            if (sem == "sem3")
                sub_list = cv_sem3_sub
            else if (sem == "sem4")
                sub_list = cv_sem4_sub
            else if (sem == "sem5")
                sub_list = cv_sem5_sub
            else if (sem == "sem6")
                sub_list = cv_sem6_sub
            else if (sem == "sem7")
                sub_list = cv_sem7_sub
            else if (sem == "sem8")
                sub_list = cv_sem8_sub

        } else if (branch == "mech") {
            if (sem == "sem3")
                sub_list = me_sem3_sub
            else if (sem == "sem4")
                sub_list = me_sem4_sub
            else if (sem == "sem5")
                sub_list = me_sem5_sub
            else if (sem == "sem6")
                sub_list = me_sem6_sub
            else if (sem == "sem7")
                sub_list = me_sem7_sub
            else if (sem == "sem8")
                sub_list = me_sem8_sub

        } else if (branch == "ele") {
            if (sem == "sem3")
                sub_list = ele_sem3_sub
            else if (sem == "sem4")
                sub_list = ele_sem4_sub
            else if (sem == "sem5")
                sub_list = ele_sem5_sub
            else if (sem == "sem6")
                sub_list = ele_sem6_sub
            else if (sem == "sem7")
                sub_list = ele_sem7_sub
            else if (sem == "sem8")
                sub_list = ele_sem8_sub

        }


        val sub1: Button = findViewById(R.id.sub1)
        sub1.apply {
            text = sub_list[0].toString()
        }
        val sub2: Button = findViewById(R.id.sub2)
        sub2.apply {
            text = sub_list[1].toString()
        }
        val sub3: Button = findViewById(R.id.sub3)
        sub3.apply {
            text = sub_list[2].toString()
        }
        val sub4: Button = findViewById(R.id.sub4)
        sub4.apply {
            text = sub_list[3].toString()
        }
        val sub5: Button = findViewById(R.id.sub5)
        sub5.apply {
            text = sub_list[4].toString()
        }

        sub1.setOnClickListener {
            var intent = Intent(this, module::class.java)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", sem)
            startActivity(intent)
        }
        sub2.setOnClickListener {
            var intent = Intent(this, module::class.java)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", sem)
            startActivity(intent)
        }
        sub3.setOnClickListener {
            var intent = Intent(this, module::class.java)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", sem)
            startActivity(intent)
        }
        sub4.setOnClickListener {
            var intent = Intent(this, module::class.java)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", sem)
            startActivity(intent)
        }
        sub5.setOnClickListener {
            var intent = Intent(this, module::class.java)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", "sem4")
            startActivity(intent)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.logoutaction, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                Intent(this, MainActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.also { startActivity(it) }
                finish()
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}