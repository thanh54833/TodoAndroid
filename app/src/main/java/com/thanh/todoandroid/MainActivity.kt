package com.thanh.todoandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.ybq.android.spinkit.SpriteFactory
import com.github.ybq.android.spinkit.Style
import com.thanh.sharedpreferences.intPreference
import com.thanh.todoandroid.databinding.SpinkitLayoutBinding


class MainActivity : AppCompatActivity() {

    var versionCodes: Int by intPreference(VERSION_CODES, 100)
    lateinit var binding: SpinkitLayoutBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.spinkit_layout)


        binding.changeBtn.setOnClickListener {
            val lettre: Style = Style.values().get((Math.random() * Style.values().size).toInt())
            val style: Style = lettre//Style.values().get()
            val drawable = SpriteFactory.create(style)
            binding.spinKit.setIndeterminateDrawable(drawable)
        }


        //versionCodes = 200

        /*binding.success.setOnClickListener {
            Toasty.success(this, "Success!", Toast.LENGTH_LONG).show()
        }

        binding.error.setOnClickListener {
            Toasty.error(this, "This is an error toast.", Toast.LENGTH_LONG).show()
        }

        binding.info.setOnClickListener {
            Toasty.info(this, "Here is some info for you.", Toast.LENGTH_LONG).show()
        }

        binding.nomal.setOnClickListener {
            Toasty.normal(this, "Normal toast w/ icon", Toast.LENGTH_LONG).show()
        }

        binding.warning.setOnClickListener {
            Toasty.warning(this, "Beware of the dog.", Toast.LENGTH_LONG).show()
        }

        binding.superId.setOnClickListener {

//            SuperActivityToast.create(this, Style(), Style.TYPE_BUTTON)
//                .setButtonText("UNDO")
//                //.setButtonIconResource(R.drawable.ic_undo)
//                //.setOnButtonClickListener("good_tag_name", null, onButtonClickListener)
//                .setProgressBarColor(Color.WHITE)
//                .setText("Email deleted")
//                .setDuration(Style.DURATION_LONG)
//                .setFrame(Style.FRAME_LOLLIPOP)
//                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_PURPLE))
//                .setAnimations(Style.ANIMATIONS_POP).show()
//
//            val superActivityToast = SuperActivityToast(this, SuperToast.Type.PROGRESS)
//            superActivityToast.text = "Hello world!"
//            superActivityToast.isIndeterminate = true
//            superActivityToast.progressIndeterminate = true
//            superActivityToast.show()

        }**/


    }


    companion object {
        const val VERSION_CODES = "VERSION_CODES"


    }

}
