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
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('ENTERTAINMENT','이스케이프탑 수원점','네이버 예약 결제 후 매장 방문 시, 방탈출카페 20% 할인 (매장에서 학생증 제시)','12/31',127.029984,37.2652733,'https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTExMDFfMTM1%2FMDAxNTcyNTg3MzU2MjI5.40PU5m6gOMiQ7GTPjPuKXQ5Ti1qlIBtsDKTXHqrVjYEg.pTbCTOF0F0HFmJy7ubjEtMfOVkcODtrE0oSzT4XgwKgg.JPEG.hd_dn%2F20190309_184026.jpg&type=sc960_832');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('ETC','이담','계좌이체 시 10% 할인','12/31',127.044839,37.2788744,'https://ajouchongmedia.s3.amazonaws.com/media/image/2022/04/25/%EC%9D%B4%EB%8B%B4.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('BEAUTIY','벨르 뷰티헤어', '대학생 커트 10,000원 / 남성 펌 35,000원 / 남성 커트+다운펌 20,000원 / 남성 염색 40,000원 / 여성 셋팅펌 - 숏: 4만원 미디움:6만원 롱:7만원 / 여성 염색 - 숏:48,000원 미디움:64,000원 롱:72,000원 / 펌 염색 시술 시 크리닉 서비스','12/31',127.044341,37.2749461,'	https://ajouchongmedia.s3.amazonaws.com/media/imag…%EB%A5%B4%EB%B7%B0%ED%8B%B0%ED%97%A4%EC%96%B4.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('ETC','1001안경콘택트 아주대점','할인 금액에서 추가 10% 할인 (오렌즈 제외)','12/31',127.044094, 37.2763968 ,'https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20210303_282%2F1614757222891OUdnF_JPEG%2FgBSGxcqZoOzXqb7acsNEoXkz.jpeg.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('RESTAURANT','카우보이 버거','600원 할인(오늘의 스페셜 메뉴 제외)','12/31',127.045458, 37.2759368,'https://search.pstatic.net/common/?src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20220127_156%2F16432255130810lHxb_JPEG%2Fupload_855e6581f5a54bb7dc3e43f485f6c8d3.jpeg');
INSERT INTO partnership(category,name,detail,expired,lat,lng) values('PUB','아주캠프','테이블 당 음료 1병 제공','12/31', 127.044061,37.2780547);
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('CAFE','투썸플레이스 아주대점','제조음료에 한해 10% 할인','12/31',127.044005,37.2792441 ,'https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAxMDVfMjU2%2FMDAxNjQxMzQ3MTI5MTk5.iyWYJhNX3zDzJuNXi4j6JNtntkur096SPSrvep993Sog.pOSWc4FjBO1aajx8CCQZc0GTAf7jtjpD5RHdfACoUr8g.JPEG.pinkmom0112%2F20220103%25A3%25DF184249.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('RESTAURANT','포메인 아주대점','결제 금액의 10% 할인','12/31',127.042075,37.2757488 ,'https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAyMTZfMjQg%2FMDAxNjc2NTIxNzYyNTY4.kOqjWBobrnLVKrtGZNuDRS5S8D_bPqtfpAz0nVigm14g.qwOQrJP8jcTq2VPLyqljs6_iwTo-Mg-sIadh5R1Pud0g.JPEG.wjddusrkd%2FIMG_5054.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('PUB','더꼬치다 아주대점','테이블 당 라면 1개, 음료 1병 서비스 제공','12/31',127.043238, 37.2785055 ,'https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAxMTVfOTAg%2FMDAxNjczNzgwNTM4NDcy.eWMd1hqLW8cKXOhD_OzTo2lp8FQ3ElVuZxF6DtsFRiYg.5Xw-xCX37aZ-Uj_saj5xrFiCdenkIDVPeMSQoGomLaQg.JPEG.yyd1021%2FKakaoTalk_20230115_195205739_23.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('CAFE','스쿱스젤라또 팔달구2호점','도장 5개: 1가지 맛->2가지 맛으로 업그레이드 / 도장 10개: 1가지 맛 컵 무료 제공','12/31',127.043013,37.2792445 ,'https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20220212_257%2F1644655233288egadv_JPEG%2FKakaoTalk_20220212_173807441_16.jpg');
INSERT INTO partnership(category,name,detail,expired,lat,lng,image) values('RESTAURANT','홍콩반점0410 아주대점','5만원 이상 결제 시, 군만두 제공','12/31',127.043396, 37.2785956,'https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAxMjdfMjk0%2FMDAxNjc0Nzg1ODIzODk1.MflmeneWSe2OIxVtVooItCb7_AvSxVw_A5hltsOM2Ngg.6K-9-bCMW9eFB0jkG0aAfBPWn7bMc6C7kXmoeijl_pUg.JPEG.wpfhwleoqkddur%2F20221117_110257.jpg');

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
