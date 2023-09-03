# 버스 정류장
INSERT INTO bus_stop(name,lat,lng) VALUES ('광교중앙역 1번 출구', 37.28792507165555, 127.05207080906703);
INSERT INTO bus_stop(name,lat,lng) values ('수원역 9번/10번 출구', 37.266642681300176, 127.00170518816412);
INSERT INTO bus_stop(name,lat,lng) values ('도서관 도로변', 37.2817913450616, 127.04346000090717);
INSERT INTO bus_stop(name, lat, lng) values ('원천관 입구',37.28280161912451, 127.04350427780675);
INSERT INTO bus_stop(name, lat, lng) values ('율곡관 도로변',37.28174406129355, 127.04637346772104 );

# 버스 노선
INSERT INTO bus_route(name,type,dep_bus_stop_id,mid_bus_stop_id,arr_bus_stop_id,department_time_list) VALUES ('광교중앙역', '등교',1,5,4,'08:30,08:50');
INSERT INTO bus_route(name,type,dep_bus_stop_id,mid_bus_stop_id,arr_bus_stop_id, department_time_list) VALUES ('광교중앙역', '등교',1,5,3,'09:30,10:00,10:15,11:45,16:00,17:00');
INSERT INTO bus_route(name,type,dep_bus_stop_id,mid_bus_stop_id,arr_bus_stop_id, department_time_list) values ('수원역', '등교',2,5,4,'08:20');
INSERT INTO bus_route(name,type,dep_bus_stop_id,arr_bus_stop_id, department_time_list) values ('수원역', '등교',2,3,'09:50,11:20');
INSERT INTO bus_route(name,type,dep_bus_stop_id,arr_bus_stop_id, department_time_list) values ('수원역','하교',3,2,'15:10,16:40');
INSERT INTO bus_route(name,type,dep_bus_stop_id,mid_bus_stop_id,arr_bus_stop_id, department_time_list) values ('수원역','하교',5,4,2,'18:10');
INSERT INTO bus_route(name, type,dep_bus_stop_id,arr_bus_stop_id, department_time_list) values ('광교중앙역','하교',3,1,'08:20,08:40,09:20,09:55,10:05,11:35,13:10,14:35,16:05,17:20');
INSERT INTO bus_route(name, type,dep_bus_stop_id,mid_bus_stop_id,arr_bus_stop_id, department_time_list) values ('광교중앙역','하교',5,4,1,'18:10');

# 버스 공지사항(아주대학교 홈페이지 공지사항)
INSERT INTO bus_notice(title, url) values('광교중앙역 등교 버스 도착 장소 변경 안내','https://www.ajou.ac.kr/kr/ajou/notice.do?mode=view&articleNo=214712');
INSERT INTO bus_notice(title, url) values('5.12(금) 당일 광교중앙역 본교 버스 운행 시각 조정 안내','https://www.ajou.ac.kr/kr/ajou/notice.do?mode=view&articleNo=214334&article.offset=0');
INSERT INTO bus_notice(title, url) values('아주대학교 셔틀버스 운행 시각 조정 안내','https://www.ajou.ac.kr/kr/ajou/notice.do?mode=view&articleNo=211901&article.offset=10&articleLimit=10&srSearchVal=%EB%B2%84%EC%8A%A4');

# 제휴업체
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('ENTERTAINMENT','이스케이프탑 수원점','네이버 예약 결제 후 매장 방문 시, 방탈출카페 20% 할인 (매장에서 학생증 제시)','12/31',37.2652733,127.029984,'https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTExMDFfMTM1%2FMDAxNTcyNTg3MzU2MjI5.40PU5m6gOMiQ7GTPjPuKXQ5Ti1qlIBtsDKTXHqrVjYEg.pTbCTOF0F0HFmJy7ubjEtMfOVkcODtrE0oSzT4XgwKgg.JPEG.hd_dn%2F20190309_184026.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('ETC','이담','계좌이체 시 10% 할인','12/31',37.2788744,127.044839,'https://ajouchongmedia.s3.amazonaws.com/media/image/2022/04/25/%EC%9D%B4%EB%8B%B4.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('BEAUTIY','벨르 뷰티헤어', '대학생 커트 10,000원 / 남성 펌 35,000원 / 남성 커트+다운펌 20,000원 / 남성 염색 40,000원 / 여성 셋팅펌 - 숏: 4만원 미디움:6만원 롱:7만원 / 여성 염색 - 숏:48,000원 미디움:64,000원 롱:72,000원 / 펌 염색 시술 시 크리닉 서비스','12/31',37.2749461,127.044341,'	https://ajouchongmedia.s3.amazonaws.com/media/imag…%EB%A5%B4%EB%B7%B0%ED%8B%B0%ED%97%A4%EC%96%B4.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('ETC','1001안경콘택트 아주대점','할인 금액에서 추가 10% 할인 (오렌즈 제외)','12/31',37.2763968,127.044094, 'https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20210303_282%2F1614757222891OUdnF_JPEG%2FgBSGxcqZoOzXqb7acsNEoXkz.jpeg.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('RESTAURANT','카우보이 버거','600원 할인(오늘의 스페셜 메뉴 제외)','12/31',37.2759368,127.045458, 'https://search.pstatic.net/common/?src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20220127_156%2F16432255130810lHxb_JPEG%2Fupload_855e6581f5a54bb7dc3e43f485f6c8d3.jpeg');
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','아주캠프','테이블 당 음료 1병 제공','12/31', 37.2780547,127.044061,);
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('CAFE','투썸플레이스 아주대점','제조음료에 한해 10% 할인','12/31',37.2792441,127.044005 ,'https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAxMDVfMjU2%2FMDAxNjQxMzQ3MTI5MTk5.iyWYJhNX3zDzJuNXi4j6JNtntkur096SPSrvep993Sog.pOSWc4FjBO1aajx8CCQZc0GTAf7jtjpD5RHdfACoUr8g.JPEG.pinkmom0112%2F20220103%25A3%25DF184249.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('RESTAURANT','포메인 아주대점','결제 금액의 10% 할인','12/31',37.2757488,127.042075, ,'https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAyMTZfMjQg%2FMDAxNjc2NTIxNzYyNTY4.kOqjWBobrnLVKrtGZNuDRS5S8D_bPqtfpAz0nVigm14g.qwOQrJP8jcTq2VPLyqljs6_iwTo-Mg-sIadh5R1Pud0g.JPEG.wjddusrkd%2FIMG_5054.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('PUB','더꼬치다 아주대점','테이블 당 라면 1개, 음료 1병 서비스 제공','12/31', 37.2785055,127.043238,'https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAxMTVfOTAg%2FMDAxNjczNzgwNTM4NDcy.eWMd1hqLW8cKXOhD_OzTo2lp8FQ3ElVuZxF6DtsFRiYg.5Xw-xCX37aZ-Uj_saj5xrFiCdenkIDVPeMSQoGomLaQg.JPEG.yyd1021%2FKakaoTalk_20230115_195205739_23.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('CAFE','스쿱스젤라또 팔달구2호점','도장 5개: 1가지 맛->2가지 맛으로 업그레이드 / 도장 10개: 1가지 맛 컵 무료 제공','12/31',37.2792445,127.043013,'https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20220212_257%2F1644655233288egadv_JPEG%2FKakaoTalk_20220212_173807441_16.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','남바완돈카츠','새우튀김/고로케/맛감자/소스 중 택 1(아주대학교에서 주문시, 요청사항에 작성하면 증정)','12/31', 37.28003114562, 127.04289378098);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('CAFE','아마스빈','펄 추가 무료','12/31', 37.27908489703, 127.04332454436);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','우만주옥','6만원 이상 시, 계좌이체/현금결제 10% 할인','12/31',  37.27918211981, 127.04232668821);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('CAFE','밀크볼','토핑 택 1 (콩포트/아몬드 슬라이스/카카오닙스/그래놀라)','12/31',  37.279055894, 127.042549315);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','119양푼이','포장주문 시, 카드결제 10% 할인 or 현금결제 15% 할인 / 아주대 내부로 전화배달 주문 : 15000원 이상 주문시 배달비 1500원, 35000원 이상 주문시 무료배달','12/31', 37.279988368699, 127.04283173892);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('CAFE','제이스토리 케이크','계좌이체/현금결제 5% 할인','12/31',  37.27542006716, 127.0429108963);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','나우어스 피자','2조각 이상 주문 시, 테이블 당 감자튀김 M사이즈 제공','12/31',37.277339221, 127.0430811192);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','홍희네 주뎅','계좌이체/현금결제 10% 할인, SNS리뷰 작성 시, 택 1 제공(꿀토마토/소주 1병/맥주 1병 제공)','12/31',37.277071826031, 127.0412148673);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','PG술집','계좌이체/현금결제 10% 할인(최대 할인 금액 3만원)','12/31', 37.27851244850, 127.0441050613);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('CAFE','설빙','(1) 인절미 설빙+한입 쏙 붕어빵 : 10000원, (2)애플망고치즈 설빙+한입 쏙 붕어빵 : 14000원','12/31', 37.278523467096, 127.04475624183);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','샹그리라','3인 이상 방문 시, 10% 할인 (런치세트 제외)','12/31',37.2788030547876, 127.044048851937);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('CAFE','포푸리리프','(1) 음료 테이크 아웃 10% 할인, (2) 테이블 당 1만원 이상 시, 음료 10% 할인 (쿠폰 적립 불가)','12/31',37.27719192744, 127.04542071054);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('ENTERTAINMENT','레드버튼','4인 이상 방문 시, 팝콘 M사이즈 제공','12/31', 37.278341261458, 127.044076772126);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('CAFE','요고트팜','(1) 아주대학교 내 결제 시, 배달비 무료(선결제), (2) 1만원 이상 구매 시, 토핑 1개 무료','12/31', 37.27784344329, 127.044059568396);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','심야술집','계좌이체/현금결제 10% 할인','12/31', 37.275265988963, 127.045329351358);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','삼거리 황소곱창','계좌이체/현금결제 10% 할인(최대 할인 금액 3만원)','12/31', 37.2754620974492, 127.044982753915);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','삼거리광장','계좌이체 10% 할인','12/31', 37.275403708836, 127.044509157549);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','아주돈','3인 이상 테이블에 소주 1병 제공(최소 1명이 아주대 학생)','12/31', 37.2771448346093, 127.04486536208);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','옥집','계좌이체/현금결제 10% 할인','12/31', 37.275299817859, 127.04522507548);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','할머니 부대찌개','3인 이상 방문 시, 음료 1개 무료 제공','12/31',37.276626723825, 127.04489888096);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','도야족발','계좌이체/현금결제 10% 할인','12/31',  37.2750836798, 127.04493179022);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('BEAUTY','로꼬미용실','예약 방문 시, 커트 제외 10% 할인(중복할인 불가)','12/31', 37.275644852196, 127.044202047249);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','아대닭발','계좌이체/현금결제 10% 할인','12/31', 37.275097270174, 127.044734481757);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','어풍당당','계좌이체/현금결제 10% 할인','12/31', 37.27536990605, 127.04454578228);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','포차이즈','계좌이체/현금결제 10% 할인(최대 할인 금액 3만원)','12/31', 37.275011473149, 127.045255909834);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('HEALTH','크로스핏 TSF','10% 할인','12/31',  37.276802401593, 127.030906107607);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('HEALTH','태풍복싱 체육관','1개월 이용료 11만원','12/31', 37.303091704007,127.007983002458);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('ETC','다비치안경','10% 할인 + 에그타르트/크로아상 빵 제공','12/31', 37.275039044154, 127.043821154287);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','비담비','(1) 3인 이상 방문 시, 고기만두 1판 15000원에 제공, (2) 6인 이상 방문 시, 고기만두 2판 3000원에 제공', 37.278642515801, 127.045644278408);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','셰프의 고깃집','계좌이체/현금결제 10% 할인','12/31', 37.275597235251, 127.04503075437);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','한마리 정육식당','계좌이체/현금결제 10% 할인(최대 할인 금액 3만원)',  37.275475529302, 127.04520263001);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','804','계좌이체/현금결제 10% 할인', 37.27540113419, 127.04535762058);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','옥상포차','계좌이체/현금결제 10% 할인', 37.275279516434, 127.04529835251);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','셰프의 포차','계좌이체/현금결제 10% 할인', 37.2753201149375, 127.045163073663);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('HEALTH','언더독클라임','(1) 아주대 학생 암벽화&초크백 무료 대여, (2) 회원등록 시 10% 할인',  37.266397538048, 127.031259802265);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','미스터쉐프','3인 이상 주문 시, 음료 제공', 37.279193201305, 127.042831288346);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('CAFE','더 머랭','마카롱 3개 주문 시, 꼬끄 후레이크 추가 제공 / 5개 주문 시, 1개 추가 제공',  37.278959188907, 127.042112323039);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','떡슐랭','감자볼 튀김 제공',  37.278959188907, 127.042112323039);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','이태리밥','10% 할인',  37.279060121538, 127.043316073295);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','유가네 닭갈비','닭갈비 2인분 주문 시, 치즈or음료 1병 제공(세트메뉴 제외)', 37.279046658463, 127.043172298873);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','아롤도그','1만원 이상 계좌이체/현금결제 시, 캔음료 제공',  37.27906680282, 127.04352467985);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('RESTAURANT','사랑집','테이블 당 볶음밥 1개 제공(타 이벤트 중복 가능)', 37.2788193238209, 127.04268167233);
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('CAFE','디저트 39','(1) 아메리카노 20% 할인, (2) 코코넛 젤리/펄 무료 추가',  37.27869964056, 127.04349346008);



# 교내 편의시설
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFETERIA','교직원식당','기숙사 식당 2층',37.284638903, 127.045721198);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFETERIA','감탄떡볶이 아주대학교점','제 1학생회관(구학생회관) 1층 아슐랭',37.283623118, 127.04536537366);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFETERIA','바겟버거 아주대점','제 1학생회관(구학생회관) 1층 아슐랭',37.283623118, 127.04536537366);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFETERIA','만권화밥 아주대점','제 1학생회관(구학생회관) 1층 아슐랭',37.283623118, 127.04536537366);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFETERIA','삼삼돈까스 아주대점','제 1학생회관(구학생회관) 1층 아슐랭',37.283623118, 127.04536537366);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFETERIA','밀양국밥냉면','제 1학생회관(구학생회관) 1층 아슐랭',37.283623118, 127.04536537366);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFETERIA','기숙사식당', '기숙사 식당1층',37.2846389033, 127.045721198);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFETERIA','팔달관매점','팔달관 1층', 37.2843735854, 127.0444383225);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFETERIA','다산관매점','',37.283045521483, 127.0477358936);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFETERIA','코너스톤','연암관 12층', 37.282250377277, 127.04767900987);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFETERIA','선인재식당','송재관 지하 1층',37.28092601812, 127.04725813971);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFE','팬도로시 아주대 학생회관점','제 1학생회관(구학생회관) 1층',37.28351512217, 127.0450298334);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFE','팬도로시 아주대도서관점','도서관 카페',37.28199944689, 127.0441719345);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFE','다산관 카페','다산관 1층',37.283045521483, 127.0477358936);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFE','무인카페','기숙사 식당 1층',37.2846389033, 127.045721198);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('CAFE','아이엔지 아주대학교 일신관점','일신관 지하 1층 CU 옆',37.2843050133, 127.04701216725);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('STORE','CU 아주대성호관점','성호관 1층',37.2830128699,127.0448265587);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('STORE','CU 아주대일신관점','일신관 지하 1층',37.2843050133, 127.04701216725);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('STORE','CU 아주대팔달관점','1층 팔달관매점 내',37.2843735854, 127.0444383225);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('PRINTER','신학생회관 프린터','1층 웹PC 검색대', 37.2831386027, 127.04590353239);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('PRINTER','신학생회관 팩스','제 2학생회관(신학생회관) 116호 종합지원센터',37.2831386027, 127.04590353239);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('PRINTER','팔달관 프린터','1층 계단실', 37.28438253749,127.0445933813);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('PRINTER','인문대 프린터실','성호관 103-1호, 무료', 37.28298358089,127.0448406368);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('FACILITIES','다산관 로비','다산관 1층', 37.2830410367,127.04768514686);
INSERT INTO campus_amenity(category, name, detail, lat,lng) values('FACILITIES','더테라스','도서관 테라스', 37.28266393586, 127.0442456192);
INSERT INTO campus_amenity(category, name, lat,lng) values('FACILITIES','테니스장', 37.28212126349, 127.04942393254);
INSERT INTO campus_amenity(category, name, lat,lng) values('FACILITIES','체육관', 37.2799603577, 127.04545902091);
INSERT INTO campus_amenity(category, name, detail,lat,lng) values('STORE','아주문고','제1학생회관(구학생회관) 1층 서점', 37.28356895239, 127.045635977);
INSERT INTO campus_amenity(category, name, detail,lat,lng) values('STORE','안경점', '성호관 1층',37.28300609618, 127.04486884122);
