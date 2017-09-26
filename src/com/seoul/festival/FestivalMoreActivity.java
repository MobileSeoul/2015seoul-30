package com.seoul.festival;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FestivalMoreActivity extends Activity implements OnItemClickListener{

	private String[] itemList = {
			"보육포털서비스",
			"서울통계",
			"참여예산·예산낭비신고",
			"서울교통정보",
			"서울시보",
			"법령정보(조례.규칙)",
			"내 손안에 서울",
			"토지정보/주택가격",
			"대중교통분실물",
			"서울부동산정보광장",
			"세금납부",
			"다둥이 행복카드",
			"평생학습포털",
			"재개발재건축조합정보",
			"서울도서관",
			"도로명주소안내시스템",
			"서울 도시계획 포털",
			"시민청",
			"서울 두드림길",
			"서울의 산과 공원",
			"지방세 이의신청",
			"클린재정",
			"입찰정보조회",
			"세무조사신고",
			"대부업등록",
			"전자상거래",
			"서울부동산정보광장",
			"토지(지적)정보서비스",
			"공동주택인터넷상담",
			"중소기업 판로지원",
			"민생침해 시민참여센터",
			"일자리플러스센터",
			"희망창업",
			"사회적기업",
			"마을공동체 종합지원센터",
			"농업기술센터",
			"물가정보",
			"장바구니물가",
			"서울글로벌센터",
			"서울시자매도시현황",
			"도보여행",
			"서울시티투어버스",
			"한눈에 보는 서울",
			"서울시립미술관",
			"서울역사박물관",
			"한성백제박물관",
			"남산골한옥마을",
			"북촌한옥마을",
			"왕궁수문장교대의식",
			"우리동네문화명소",
			"서울시 공연전시",
			"서울한강공원",
			"시청사 ‘통통(通通)투어’ ",
			"시청사 전시",
			"서울의문화재",
			"한류관광",
			"서울관광지도",
			"서울광장",
			"서울대공원",
			"청계천"
	};
	
	private String[] linkList = {
			"http://iseoul.seoul.go.kr",
			"http://stat.seoul.go.kr",
			"http://yesan.seoul.go.kr",
			"http://topis.seoul.go.kr/?SSid=560_04",
			"http://www2.seoul.go.kr/web2004/seoul/citynews/sibo2013/",
			"http://legal.seoul.go.kr?SSid=560_06",
			"http://mediahub.seoul.go.kr/",
			"http://klis.seoul.go.kr",
			"http://www.seoul.go.kr/v2012/find.html?SSid=560_10",
			"http://land.seoul.go.kr/",
			"http://etax.seoul.go.kr",
			"http://woman.seoul.go.kr/archives/261",
			"http://sll.seoul.go.kr/main/MainView.dunet",
			"http://cleanup.seoul.go.kr/?SSid=560_15",
			"http://lib.seoul.go.kr/",
			"http://address.seoul.go.kr/main/main.aspx?SSid=560_16",
			"http://urban.seoul.go.kr?SSid=560_17",
			"http://www.seoulcitizenshall.kr",
			"http://gil.seoul.go.kr",
			"http://parks.seoul.go.kr/park/",
			"http://eungdapso.seoul.go.kr/Gud/Gud01/Gud0102/Gud0102_tab01_reg.jsp",
			"http://cleanplus.seoul.go.kr",
			"http://finance.seoul.go.kr/archives/10232",
			"http://biztax.seoul.go.kr",
			"http://economy.seoul.go.kr/archives/114",
			"http://ecc.seoul.go.kr/?SSid=560_24",
			"http://land.seoul.go.kr",
			"http://klis.seoul.go.kr",
			"http://cb-counsel.seoul.go.kr/apart/apartOnline.do",
			"http://economy.seoul.go.kr/archives/44591",
			"http://eungdapso.seoul.go.kr/Gud/Gud_tab_lis.jsp",
			"http://job.seoul.go.kr/",
			"http://www.hopestart.or.kr",
			"http://economy.seoul.go.kr/archives/44427",
			"http://www.seoulmaeul.org",
			"http://agro.seoul.go.kr",
			"http://economy.seoul.go.kr/life03_01",
			"http://mulga.seoul.go.kr/",
			"http://global.seoul.go.kr/",
			"http://economy.seoul.go.kr/archives/387",
			"http://dobo.visitseoul.net",
			"http://www.seoulcitybus.com/",
			"http://www.visitseoul.net/kr/popular/popular.do?_method=see&m=0003001011005",
			"http://sema.seoul.go.kr",
			"http://www.museum.seoul.kr",
			"http://baekjemuseum.seoul.go.kr",
			"http://hanokmaeul.or.kr/m10_main/main_02.jsp",
			"http://bukchon.seoul.go.kr?SSid=560_47",
			"http://culture.seoul.go.kr/space/exp.do?_method=palace",
			"http://culture.seoul.go.kr/space/exp.do?_method=villageList",
			"http://culture.seoul.go.kr/affair/event.do?_method=calendar",
			"http://hangang.seoul.go.kr",
			"http://sculture.seoul.go.kr/archives/5615",
			"http://sculture.seoul.go.kr/tour/seoul_month_event",
			"http://culture.seoul.go.kr/symp/slhist.do?_method=separate&idx=06",
			"http://www.visitseoul.net/kr/subindex.do?_method=kwave2&m=0003001025001&p=02",
			"http://maps.visitseoul.net/index.jsp?lang=kor",
			"http://plaza.seoul.go.kr/?SSid=560_58",
			"http://grandpark.seoul.go.kr",
			"http://www.cheonggyecheon.or.kr/"
	};
	
	private ListView listview;
	private ArrayAdapter<String> arrayAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more);
		
		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);
		listview = (ListView) findViewById(R.id.list_more);
		listview.setAdapter(arrayAdapter);
		listview.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkList[position]));
		startActivity(intent);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		android.os.Process.killProcess(android.os.Process.myPid());
	}
	
}
