package mx.com.appsevolution.kcalculator

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var clMainScreen: ConstraintLayout
    private lateinit var etResult: EditText

    private var value1 = 0.0f
    private var value2 = 0.0f
    private var operation = ""

    private fun containsDecimals(number: Float) : Boolean{
        val int_number = number.toInt()
        val decimal = number - int_number.toFloat()
        return decimal == 0.0f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= 21) {
            val window: Window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setStatusBarColor(this.resources.getColor(R.color.secondaryDarkColor))
        }

        clMainScreen = findViewById(R.id.clMainScreen)
        clMainScreen.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        etResult = findViewById(R.id.etResult)
    }

    fun ClearScreen(view: View) {
        value1 = 0.0f
        value2 = 0.0f
        operation = "";
        etResult.setText("0")
    }

    fun ChangeSing(view: View) {
        var value: Float = etResult.text.toString().toFloat()
        value *= -1.0f;
        if("." in etResult.text.toString()){
            etResult.setText("" + value);
        }else {
            etResult.setText("" + value.toInt());
        }
    }

    fun SetSquareRoot(view: View) {
        var result: Float = etResult.text.toString().toFloat()
        if(result >= 0.0f){
            result = Math.sqrt(result.toDouble()).toFloat()
        }else{
            Toast.makeText(this, "OPERACION NO VALIDA", Toast.LENGTH_LONG).show();
        }

        if(!containsDecimals(result))
            etResult.setText("" + result)
        else
            etResult.setText("" + result.toInt())
    }

    fun SetDivision(view: View) {
        value1 = etResult.text.toString().toFloat()
        operation = "/"
        etResult.setText("0")
    }

    fun SetMultiplication(view: View) {
        value1 = etResult.text.toString().toFloat()
        operation = "*"
        etResult.setText("0")
    }

    fun SetSubtraction(view: View) {
        value1 = etResult.text.toString().toFloat()
        operation = "-"
        etResult.setText("0")
    }

    fun SetSum(view: View) {
        value1 = etResult.text.toString().toFloat()
        operation = "+"
        etResult.setText("0")
    }

    fun SetEqual(view: View) {
        value2 = etResult.text.toString().toFloat()
        var result = 0.0f

        if(operation=="" && value2!=0.0f){
            result = value2;
        }else {
            if (operation == "/") {
                if (value2 != 0.0f) {
                    result = value1 / value2
                } else {
                    result = 0.0f
                    Toast.makeText(this, "OPERACION NO VALIDA", Toast.LENGTH_LONG).show()
                }
            } else if (operation == "*") {
                result = value1 * value2
            } else if (operation == "-") {
                result = value1 - value2
            } else if (operation == "+") {
                result = value1 + value2
            }
        }

        if(!containsDecimals(result))
            etResult.setText("" + result)
        else
            etResult.setText("" + result.toInt())

        value1 = 0.0f
        value2 = 0.0f
        operation = ""
    }

    fun SetSeven(view: View) {
        var value = etResult.text.toString().toFloat()
        if(value==0.0f && "." !in etResult.text){
            etResult.setText("7")
        }else{
            etResult.setText(etResult.text.toString() + "7");
        }
    }

    fun SetEight(view: View) {
        var value = etResult.text.toString().toFloat()
        if(value==0.0f && "." !in etResult.text){
            etResult.setText("8")
        }else{
            etResult.setText(etResult.text.toString() + "8");
        }
    }

    fun SetNine(view: View) {
        var value = etResult.text.toString().toFloat()
        if(value==0.0f && "." !in etResult.text){
            etResult.setText("9")
        }else{
            etResult.setText(etResult.text.toString() + "9");
        }
    }

    fun SetFour(view: View) {
        var value = etResult.text.toString().toFloat()
        if(value==0.0f && "." !in etResult.text){
            etResult.setText("4")
        }else{
            etResult.setText(etResult.text.toString() + "4");
        }
    }

    fun SetFive(view: View) {
        var value = etResult.text.toString().toFloat()
        if(value==0.0f && "." !in etResult.text){
            etResult.setText("5")
        }else{
            etResult.setText(etResult.text.toString() + "5");
        }
    }

    fun SetSix(view: View) {
        var value = etResult.text.toString().toFloat()
        if(value==0.0f && "." !in etResult.text){
            etResult.setText("6")
        }else{
            etResult.setText(etResult.text.toString() + "6");
        }
    }

    fun SetOne(view: View) {
        var value = etResult.text.toString().toFloat()
        if(value==0.0f && "." !in etResult.text){
            etResult.setText("1");
        }else{
            etResult.setText(etResult.text.toString() + "1");
        }
    }

    fun SetTwo(view: View) {
        var value = etResult.text.toString().toFloat()
        if(value==0.0f && "." !in etResult.text){
            etResult.setText("2");
        }else{
            etResult.setText(etResult.text.toString() + "2");
        }
    }

    fun SetThree(view: View) {
        var value = etResult.text.toString().toFloat()
        if(value==0.0f && "." !in etResult.text){
            etResult.setText("3");
        }else{
            etResult.setText(etResult.text.toString() + "3");
        }
    }

    fun SetZero(view: View) {
        var value = etResult.text.toString().toFloat()
        if(value==0.0f && !etResult.text.toString().contains('.')){
            etResult.setText("0");
        }else{
            etResult.setText(etResult.text.toString() + "0");
        }
    }

    fun SetPoint(view: View) {
        if("." !in etResult.text){
            etResult.setText(etResult.text.toString() + ".");
        }
    }

}