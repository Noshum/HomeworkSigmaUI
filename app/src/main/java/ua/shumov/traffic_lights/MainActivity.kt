package ua.shumov.traffic_lights

/*  author Nik Shumov
    app sigmaSoftWearLight
    version 1.0.0
 */


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {
    var imGreyLight : ImageView? = null
    var count : Int = 0
    var timer : Timer? = null
    var isRun = false
    var imageArray : IntArray = intArrayOf(R.drawable.semafor_green,
        R.drawable.semafor_yellow,R.drawable.semafor_red)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imGreyLight = findViewById(R.id.imGreyLight)

    }
    fun onClickStartStop(view: View) {
        view as ImageButton


        if(!isRun) {
            startStop()
            view.setImageResource(R.drawable.button_stop)
            isRun = true
        }
        else{
            imGreyLight?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
            isRun = false
            count = 0
        }
    }
    fun startStop(){
        timer = Timer()
        timer?.schedule(object : TimerTask(){
            override fun run() {
                imGreyLight?.setImageResource(imageArray[count])
                count++
                    if (count == 3) count = 0
            }

        }, 1,1000)
    }

}
