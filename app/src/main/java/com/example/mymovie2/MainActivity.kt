package com.example.mymovie2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_recycler.*
import kotlinx.android.synthetic.main.main.*
import kotlinx.android.synthetic.main.review.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager

    var totalUpCount: Int = 15
    var totalDownCount: Int = 1
    var story = "<b>줄거리</b> <br><br>군도, 백성을 구하라<br>양반과 탐관오리들의 착취가 극에 달했던 조선철종 13년.<br>힘 없는 백성의 편이 되어 세상을 바로 잡고자 하는 의적떼인 군도. 지리산 추설이 있었다. <br><br>쌍칼 도치 vs 백성의 적 조윤<br>잦은 자연재해, 기근과 관의 횡포까지 겹쳐 백성들의 삶이 날로 피폐해 져 가는 사이, 나주 대부호의 서자로 조선 최고의 무관 출신인 조윤은 극악한 수법으로 양민들을 수탈, 삼남지방 최고의 대부호로 성장한다."

    // 선택여부 ( 미선택: 0, up 선택: 1, down 선택: 2)
    var cheakSelect: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }

        // 초기 세팅
        when (cheakSelect) {
            1 -> iv_up.setImageResource(R.drawable.ic_thumb_up_selected)
            2 -> iv_down.setImageResource(R.drawable.ic_thumb_down_selected)
        }
        tv_up.setText(totalUpCount.toString())
        tv_down.setText(totalDownCount.toString())


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tv_story.setText(Html.fromHtml(story, Html.FROM_HTML_MODE_LEGACY))
        } else {
            tv_story.setText(Html.fromHtml(story))
        }




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
