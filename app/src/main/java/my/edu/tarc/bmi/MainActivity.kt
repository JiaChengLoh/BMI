package my.edu.tarc.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

// variableName : Type
// val = value, var = variable
//E.g. val pi = 3.14159
//E.g. var number : Float

class MainActivity : AppCompatActivity() {
    //Global variable
    private lateinit var editTextWeight: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var textViewBMI: TextView
    private lateinit var imageViewBMI: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Display UI
        //R = resources class (res/ folder)
        setContentView(R.layout.activity_main)
        //Link the UI to program
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)

        val buttonReset: Button = findViewById(R.id.buttonReset)
        buttonReset.setOnClickListener{
            editTextWeight.text = null
            editTextHeight.text.clear()
            textViewBMI.text = "" //clear text for textView
            imageViewBMI.setImageResource(R.drawable.empty)
        }

        val imageViewMoreInfo : ImageView = findViewById(R.id.imageViewMoreInfo)

        buttonCalculate.setOnClickListener {
            //To retrieve value from a View
            val weight: Double = editTextWeight.text.toString().toDouble()
            val height: Double = editTextHeight.text.toString().toDouble()

            //BMI = kg/m pow 2
            val bmi = weight/Math.pow(height/100,2.0)

            //TODO: Determine the status of BMI
            //UnderWeight = <18.5
            //NormalWeight = 18.5 - 24.9
            //OverWeight > 25.0

            if(bmi <= 18.5){
                textViewBMI.text = "BMI : ${bmi.toString()}, Status : ${getString(R.string.underweight)}"
                //textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.underweight))
                imageViewBMI.setImageResource(R.drawable.under)
            }else if(bmi > 25.0){
                textViewBMI.text = "BMI : ${bmi.toString()}, Status : ${getString(R.string.overweight)}"
                //textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.overweight))
                imageViewBMI.setImageResource(R.drawable.over)
            }else{
                textViewBMI.text = "BMI : ${bmi.toString()}, Status : ${getString(R.string.normal)}"
                //textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.normal))
                imageViewBMI.setImageResource(R.drawable.normal)
            }

            //textViewBMI.text = String.format("%1.2f", bmi)

        }//End of listener



    }//End of Function
}//End of Class