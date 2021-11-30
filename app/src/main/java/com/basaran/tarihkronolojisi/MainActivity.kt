package com.basaran.tarihkronolojisi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    var startpoint=0
    var endpoint=0
    var sifirbesyuz=0
    var besyuzbin=0
    var binbizbesyuz=0
    var binbesyuzikibin=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tarihtext=findViewById<TextView>(R.id.tarih)
        val seekbar=findViewById<SeekBar>(R.id.seekBar)

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    tarihtext.text=progress.toString()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                startpoint=seekbar.progress

                if (besyuzbin==1)
                {
                    findNavController(R.id.fragmentContainerView).navigate(besyuzbinFragmentDirections.actionBesyuzbinFragmentToTariharaligi())
                    besyuzbin=0
                }
                else if(sifirbesyuz==1){
                    findNavController(R.id.fragmentContainerView).navigate(yuzveikiyuzFragmentDirections.actionYuzveikiyuzFragmentToTariharaligi())
                    sifirbesyuz=0
                }
                else if(binbizbesyuz==1){
                    findNavController(R.id.fragmentContainerView).navigate(binbizbesyuzFragmentDirections.actionBinbizbesyuzFragmentToTariharaligi())
                    binbizbesyuz=0
                }
                else if(binbesyuzikibin==1){
                    findNavController(R.id.fragmentContainerView).navigate(binbesyuzikibinFragmentDirections.actionBinbesyuzikibinFragmentToTariharaligi())
                    binbesyuzikibin=0
                }
                else{
                    binbesyuzikibin=0
                    binbizbesyuz=0
                    sifirbesyuz=0
                    besyuzbin=0
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                endpoint=seekbar.progress


                    if (endpoint>=0 && endpoint<=500 && sifirbesyuz==0){

                        findNavController(R.id.fragmentContainerView).navigate(tariharaligiDirections.actionTariharaligiToYuzveikiyuzFragment())
                        sifirbesyuz++
                        besyuzbin=0
                        binbizbesyuz=0
                        binbesyuzikibin=0
                    }else if (endpoint>=501 && endpoint<=1000 && besyuzbin==0){
                        sifirbesyuz=0
                        besyuzbin++
                        binbizbesyuz=0
                        binbesyuzikibin=0
                        findNavController(R.id.fragmentContainerView).navigate(tariharaligiDirections.actionTariharaligiToBesyuzbinFragment())
                    }
                    else if(endpoint>=1001 && endpoint<=1500 && binbizbesyuz==0){
                        findNavController(R.id.fragmentContainerView).navigate(tariharaligiDirections.actionTariharaligiToBinbizbesyuzFragment())
                        sifirbesyuz = 0
                        besyuzbin = 0
                        binbizbesyuz++
                        binbesyuzikibin=0
                    }
                    else if(endpoint>=1501 && endpoint<=2000 && binbesyuzikibin==0){
                    findNavController(R.id.fragmentContainerView).navigate((tariharaligiDirections.actionTariharaligiToBinbesyuzikibinFragment()))
                        sifirbesyuz = 0
                        besyuzbin = 0
                        binbizbesyuz=0
                        binbesyuzikibin++
                    }

                    }

        })
    }

}