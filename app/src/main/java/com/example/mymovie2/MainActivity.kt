package com.example.mymovie2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.main.*
import kotlinx.android.synthetic.main.review.*

class MainActivity : AppCompatActivity() {

    var totalUpCount: Int = 15
    var totalDownCount: Int = 1

    // 선택여부 ( 미선택: 0, up 선택: 1, down 선택: 2)
    var cheakSelect: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 초기 세팅
        when (cheakSelect) {
            1 -> iv_up.setImageResource(R.drawable.ic_thumb_up_selected)
            2 -> iv_down.setImageResource(R.drawable.ic_thumb_down_selected)
        }
        tv_up.setText(totalUpCount.toString())
        tv_down.setText(totalDownCount.toString())


        // 버튼 이벤트
        iv_up.setOnClickListener{
            when (cheakSelect){
                0 -> {
                    cheakSelect+=1
                    iv_up.setImageResource(R.drawable.ic_thumb_up_selected)
                    totalUpCount+=1
                    tv_up.setText(totalUpCount.toString())
                }
                1 -> {
                    cheakSelect-=1
                    iv_up.setImageResource(R.drawable.ic_thumb_up)
                    totalUpCount-=1
                    tv_up.setText(totalUpCount.toString())
                }
                2 -> {
                    cheakSelect -=1
                    iv_up.setImageResource(R.drawable.ic_thumb_up_selected)
                    totalUpCount+=1
                    tv_up.setText(totalUpCount.toString())
                    iv_down.setImageResource(R.drawable.ic_thumb_down)
                    totalDownCount-=1
                    tv_down.setText(totalDownCount.toString())
                }
            }
        }

        iv_down.setOnClickListener{

            when(cheakSelect) {
                0 -> {
                    cheakSelect+=2
                    iv_down.setImageResource(R.drawable.ic_thumb_down_selected)
                    totalDownCount+=1
                    tv_down.setText(totalDownCount.toString())
                }
                1 -> {
                    cheakSelect+=1
                    iv_up.setImageResource(R.drawable.ic_thumb_up)
                    totalUpCount-=1
                    tv_up.setText(totalUpCount.toString())
                    iv_down.setImageResource(R.drawable.ic_thumb_down_selected)
                    totalDownCount+=1
                    tv_down.setText(totalDownCount.toString())
                }
                2 -> {
                    cheakSelect -=2
                    iv_down.setImageResource(R.drawable.ic_thumb_down)
                    totalDownCount-=1
                    tv_down.setText(totalDownCount.toString())
                }
            }
        }

        bt_write.setOnClickListener {
            Toast.makeText(applicationContext, "작성하기", Toast.LENGTH_SHORT).show()
        }

        bt_all_view.setOnClickListener{
            Toast.makeText(applicationContext, "모두보기", Toast.LENGTH_SHORT).show()
        }

    }
}
