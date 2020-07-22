package com.geun.campingjoa.hotplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.geun.campingjoa.main.MainActivity;
import com.geun.campingjoa.R;

import java.util.ArrayList;

public class HotplaceActivity extends AppCompatActivity {
    private ArrayList<item_hotplace> data=new ArrayList<item_hotplace>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotplace);
        Button back=findViewById(R.id.back);
        ListView listView=(ListView)findViewById(R.id.listview);

        data=new ArrayList<>();

        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HotplaceActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        data.add(new item_hotplace(R.drawable.camping01,
                "경기도 용인시",
                "기흥IC, 한국민속촌 3분거리에 위치한 캠프레이크 입니다.\n강남역에서 직행버스타고 용인글램핑 놀러오세요^^",
                "120,000원 ~ ",
                "2~4인",
                "캠프레이크",
                "https://booking.naver.com/booking/3/bizes/39050/search?area=plt"));

        data.add(new item_hotplace(R.drawable.camping02,
                "경기도 남양주시",
                "반딧불이, 다슬기, 송사리, 다람쥐 등 아름다운 자연환경이 자랑인캠핑장입니다.\n" +
                        "조용히 자연을 느끼고 싶은 분들을 환영합니다",
                "60,000원 ~",
                "2~4인",
                "힐링별밤수목원",
                "https://booking.naver.com/booking/3/bizes/19384/search?area=plt"));

        data.add(new item_hotplace(R.drawable.camping03,
                "경기도 가평",
               "저희 캠핑장은 주로 [가족][커플]이 많습니다. 큰 말소리와 음악소리는 소음으로 다가와 피해를 줄수 있습니다.",
                "89,000원 ~",
                "2~6인",
                "새연 카라반 글램핑",
                "https://booking.naver.com/booking/3/bizes/165134/search?area=ple"));

        data.add(new item_hotplace(R.drawable.camping04,
                "강원도 춘천",
                "넓은 잔디밭에서 워크샵과 단체 행사 및 공연이 가능하며, 파티플래너 출신 운영자가 프로그램 기획 및 행사 진행해 드립니다.",
                "80,000원 ~",
                "2~6인",
                "더시크릿가든",
                "https://booking.naver.com/booking/3/bizes/981/search?area=plt"));

        data.add(new item_hotplace(R.drawable.camping05,
                "경기도 포천",
                "저희 글램핑장은 대부분의 고객들이 가족과 커플입니다. 그리하여 대부분의 고객님들은 자정 전에 취침에 들어가십니다. 소음을 조심 해주세요",
                "99,000원 ~",
                "2~6인",
                "산중호걸 글램핑",
                "https://booking.naver.com/booking/3/bizes/324913/search?area=plt"));

        data.add(new item_hotplace(R.drawable.camping06,
                "경기도 양평",
                "더휴 라는 이름에 맞게 사람과 나무가 호흡하며더휴식을 더더휴식을 취할 수 있도록  최상의 환경을 만드는데 노력하겠습니다. ",
                "119,000원 ~",
                "2~4인",
                "더휴글램핑",
                "https://booking.naver.com/booking/3/bizes/193148/search?area=plt"));


        hotplace_Adapter adapter=new hotplace_Adapter(getApplicationContext(),R.layout.item_hotplace,data);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(getApplicationContext(), CampdetailActivity.class);


                intent.putExtra("profile",data.get(position).profile);
                intent.putExtra("title",data.get(position).title);
                intent.putExtra("place",data.get(position).place);
                intent.putExtra("show",data.get(position).show);
                intent.putExtra("money",data.get(position).money);
                intent.putExtra("people",data.get(position).people);
                intent.putExtra("url",data.get(position).url);
                startActivity(intent);
            }
        });




    }

}
