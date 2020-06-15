$(document).ready(function (){
	$.i18n.init({
        lng: 'ko',
//        resGetPath: './locales/__lng__.json',
		resStore: {
            "ko": {
				"common" : {
					"nationality":"국적",
					
					"name":"이름",
					"pefamliyName":"여권 영문 성",
					"peName":"여권 영문 이름",
					"engName":"영문이름",
					
					"gender":"성별",
					"man":"남자",
					"woman":"여자",
					
					"birthday":"생년월일",
					"birthdayForm":"19820525",
					
					"contact":"연락처",
					"EmergencyContact":"긴급 연락처",
					"relationship":"긴급 연락처와의 관계",
					"locationContact":"현지연락처",
					"Email":"이메일 주소",
					"massenger":"메신저 계정 정보",
					"englishName":"영어 이름",
					
					"save":"저장",
                    "bookmark":"즐겨찾기",
                    
                    "personal":"개인정보",
                    "personalInfo":"개인정보",
                    "eduInfo":"학사정보",
                    "campusInfo":"캠퍼스정보",
                    
                    "basicInfoChange":"기본정보 변경요청",
                    "basicInfoChangeButton":"변경요청",
                    "basicInfoChageCaption":"담당자가 확인 후 변경 할 예정입니다.",
                    "contractInfo":"계약정보",
                    
                    "date":"날짜",
                    "time":"시간",
                    "yes":"yes",
                    "loaction":"장소",
                    "etc":"기타",
                    "download":"다운로드",
                    "apply":"신청",
                    "request":"요청사항",
                    "room":"방",
					"qdownload":"증명서 다운로드",
                    
                    "data":"데이터",
					"nodata":"해당 사항 없음",
					"data-date":"2017-10-13",
					"none":"-",
                    
					"replyStaff":"응답자",
					"replyDate":"응답 등록일시",
					"close":"닫기",
				},
				
				"signin": {
					"id": "학번을 입력해주세요",
					"pw": "비밀번호를 입력해주세요(YYMMDD 혹은 000000)",
					"signIn": "로그인",
					"SignINpw":"초기 비밀번호는 생년월일 6자리로 설정됩니다.(ex: YYMMDD 혹은 000000)",				
				},				
				
				"freshman": {
					"title": "PIA 신입생 안내",
					"personalInforamtion":"개인정보수정",
					
					"detailWriter":"작성자",
					"detailTitle":"제목",
					"detailContent":"내용",
					"detailAttachment":"첨부파일",
					"detailRegisterDate":"작성일시",
				},
                
				"bookmark": {
					"bookmarkinfo": "즐겨찾기를 추가해보세요",
                    "bookmarkinfo01":"각 항목의 ☆를 누르면 즐겨찾기에 보여집니다.",
                    "bookmarkinfo02":"즐겨찾기를 추가한 순서대로 보여지게 됩니다.",
                    "bookmarkinfo03":"☆를 한번 더 누르면 즐겨찾기에서 제외됩니다.",

				},
                
				"contract": {
					"coursePeriodRoom": "코스·기간·방타입",
                    "entranceInfo":"입국정보",
                    "airplan":"비행정보",
                    "leaveInfo":"출국정보",
                    "pickup":"픽업정보",
                    "agency":"에이전시",
                    "chargeStaff":"담당자",
                    "contractInfoChage":"계약정보 변경요청",
                    "deposit":"디파짓",
                    "privateSafe":"E-Money",
					"moneyDown":"입출금내역 다운로드",
                    
                    "changeCourse":"코스변경",
                    "roomType":"방타입",
                    "extentionPeriod":"기간연장",
                    "cutPeriod":"기간축소",
                    "delayContract":"계약연기",
                    "cancleContrac":"계약취소",
                    "contractCpation":"담당자가 확인 후 상담 가능한 시간에 상담 요청을 할 예정입니다.",
				},   
                
                "education": {
                    
                    "classInfo":"수업정보",
                    "classPeriod":"수업기간",
                    "classLevel":"수업레벨",
                    "classNum":"수업횟수",
                    "className":"수업명",
                    "course":"코스",
                    "levelCampus":"레벨·캠퍼스",
					
                    "optionClass":"Option Class",
                    "optionTime":"time",
                    "optionClassName":"Self-study (M3)",
					"morning":"오전",
					"afternoon":"오후",

                    
                    "classTimeTable":"정규 수업 시간표",
					"classTimeTableCaption":"이전 수업 평가가 완료되어야 시간표 확인이 가능합니다.",
                    "classRoom":"교실",
                    "subject":"과목",
                    "teacher":"선생님",
					"noClass":"배정된 수업이 없습니다.",
                    
                    "optionP":"166H 신청기간",
                    "optionSpan":"2017.06.01 09AM ~ 2017.07.02 12PM",
                    "testDate":"시험 일정",
                    
                    "optionClassSchedule":"시험일정",                    
                    "testInfo_1":"시험 당일 3일전 취소 가능",
                    "testInfo_2":"MPT는 필수 시험입니다.",
					"testApply":"시험신청",
					"otpApply":"OPT신청",
					"applyCencel":"신청취소",
                    
                    "testResult":"시험결과",
                    "testName":"Test Name",
                    "testScore":"Test Score",
                    "listing":"Listing",
                    "speaking":"Speaking",
                    "writing":"Writing",
                    "attendance":"출석",
                    "teacherEvaluation":"선생님 평가",
                    "classEvaluation":"수업 평가",
                    
                    "weekendStudy":"주말공",
                    "weekendStudyTime":"총 주말공 시간",
                    "weekendPriod":"조회기간",
                    "weekendPriodtime":"2017.06.01 ~ 2017.07.02",
                    "weekendStudyList":"주말공 내역",
                    "weekendStudyApply":"주말공 신청",
                    "perfect":"Perfect Attandance!!",
					"perfect_01":"소정의 상품이 준비되어 있습니다.",
					"perfect_02":"빠른 시일안에 매니저 사무실에 방문해주세요!",
					
					
                    "weekendStudyDate":"신청날짜",
                    "classRoomSelect":"교실선택",
                    "wekindTime":"주말공 시간",
                    "classMap":"교실지도",
                    
                    "eduCaption_1":"주말공은 9시부터 지정한 주말공 시간만큼 진행하면 됩니다.",
                    "eduCaption_2":"담당자가 CCTV를 확인하여 주말공을 최종 확인합니다.(캠퍼스 입장시 얼굴을 보여주세요)",
                    "eduCaption_3":"신청하지 않은 주말공은 주말공 최종 확인에서 제외됩니다.",
                    "eduCaption_4":"점심시간(12시 ~ 1시)는 주말공에서 제외됩니다.",
                    "eduCaption_5":"주말공 최종 확인에 이상이 있을 시 매니저 사무실을 찾아오시면 됩니다. ",    
                    
                    "classEvaluation_1":"선생님은 밝은 인상과 친절한 말씨를 갖추었다.",
                    "classEvaluation_2":"선생님은 나의 가치관, 문화적 차이와 감정을 고려 및 존중해 주었다.",
                    "classEvaluation_3":"선생님은 좋은 수업 분위기를 유지하며 적절한 피드백을 주었다.",
                    "classEvaluation_4":"선생님은 수업 50분 내내 교과목 진도 및 학습목표에 부합하였다.",

                    
                },
                
				"siteSetting": {
                    "siteSetting":"사이트설정",
                    "language":"사용언어",
                    "notificationList":"알림내역",
                    "totalDown":"전체 다운로드",
                    "logout":"로그아웃",
                    
                    "pwChange":"비밀번호 변경",
                    "pwOriginal":"기존 비밀번호",
                    "newPw":"새 비밀번호",
                    "newPwConfirm":"새 비밀번호 확인",
                    "resetPw":"비밀번호 초기화",
                    "pwCaption":"비밀번호 초기화의 경우 저장된 생년월일 6자리로 설정됩니다.",
                    
                    "languageChange":"사이트 사용언어 변경",
				},      
                
                "campus": {
                		"requestNotice":"* 요청사항은 업무시간(9AM ~ 6PM) 중에 처리 됩니다.",
                    "requestCaption":"요청사항을 적어주세요. 영어로 적어주시면 보다 빠르게 처리 될 수 있습니다.",
                    
                    "request":"요청",
                    "division":"구분",
                    "content":"내용",
                    "stauts":"상태", 
                    "progress":"진행중",   
					"notYetReply":"요청",   
                    "reply":"응답",    
                    
                    "consult":"상담신청",
                    "consultCaption":"원하는 상담 내용을 적어주세요",
                    
                    "activity":"액티비티",
                    "activityNo":"예정된 액티비티가 없습니다.",
					"citytour":"시티투어",
					"movingWay":"이동수단",
					"pay":"비용",
					"free":"무료",
					"applicationPeriod":"접수기간",
					"activetyCaption":"2017-06-8(금) 오후 6시 까지",
					"join":"참여",
                    
                    "todayMenu":"오늘의 식단",
                    "evalution":"평가",
                    "brackfast":"아침",
                    "lunch":"점심",
                    "dinner":"저녁",
                    "menu":"어묵국, 흰밥, 야채죽, 호박볶음, 야채 계란말이, 바나나쨈 샌드위치, 커피",
                    
                    "notice":"공지사항",
                    "title":"제목",
                    
                    "freshmanGuide":"신입생 가이드",
                    
                    "againstruleList":"규정 위반 내역",
                    "against":"위반 규정",
                    "rule":"규정집",
                    
                    "quantity":"전기·물 사용량",
                    "electric":"이번 주 전기세",
                    "water":"이번 주 물세",
                    "amount":"이번주 금액 합계",
                    "maximum":"이번주 최대 사용 가능 금액",
                    "exceedUsage":"사용량 초과!",
                    "usageList":"이전 사용량 보기",
                    
                    "tourPlan":"여행계획서",
                    "location":"여행지",
                    "edit":"작성",
                    "tourCaption":"출발일 2일전까지 작성해야합니다.",
                    "register":"등록",
                    "finish":"종료",
                    
                    "evalutionBrackfast":"아침 식단 평가",
					"menuEvalution":"식사만족도",
					"opnion":"상세의견",
					"menuCaption":"식사에 대해 어려움이 있으시다면 상세의견을 작성해주세요. 자세한 상세의견은 다음 식단에 반영 됩니다.",
					"menuEvalutionBtn":"평가하기",
					
					"tourAttention":"여행시 주의사항",
					"tourAttentionCaption":"주의사항을 모두 숙지 한 후 아래 버튼을 누르세요. 버튼을 누르면 주의사항 확인으로 처리 됩니다.",
					"tourAttentionConfirm":"주의사항을 숙지하였습니다.",
					"attention1":"주의사항 1",
					"attention2":"주의사항 2",
					"attention3":"주의사항 3",
					
					"transfer":"교통",
					"transferCaption":"선택 가능한 시간 이외에는 상담 후 설정 가능합니다.",
					"van":"벤",
					"departureTime4":"출발 가능 시간 4AM",
					"bus":"버스",
					"departureTime11":"출발 가능 시간 11AM",
					"contsult":"상담 후 결정",
					"driver":"운전자 연락처",
					"departureDay":"출발일시",
					"departureDayCaption":"출발 시간은 상담 후 결정됩니다.",
					"consultRequest":"상담요청",
					"returnDaty":"복귀일시",
					"contactNumber":"연락 가능한 현지번호",
					"participant":"참가자",
					"number":"Num",
					"roomNumber":"방번호",
					"del":"삭제",
					"accept":"접수",
					"tourTimetable":"여행지별 출발 가능 시간표",
					"tourCaption1":"작성자에게 상담 가능한 시간이 알림으로 공지 됩니다.",
					"tourCaption2":"여행 참가자는 여행 계획서 접수 후 본인의 계정으로 사이트에 접속하면 여행시 주의사항이 보여집니다.",
					"tourCaption3":"여행 참가자 중 주의사항을 숙지 하지 않은 참가자는 캠퍼스 출입시 제한을 받습니다.",
					"tourCaption4":"자연재해시 모든 여행은 자동으로 취소됩니다.",
					"tourCaption5":"주말 여행 전 1일까지 접수가 가능합니다. ",
					"anotherLocation":"그 외 지역",
					"datailLocation":"상세지역",
                    
                },
                "popup" : {
	            		"registration" : "등록일",
	            		"tourContact" : "여행자 긴급 연락처",
	            		"blockMessage1" : "중요한 행정 문제가 처리되지 않아",
	            		"blockMessage2" : "홈페이지를 이용할 수 없습니다.",
	            		"blockMessage3" : "빠른 시간안에 매니저 사무실로",
	            		"blockMessage4" : "찾아 오시기 바랍니다.",
					"dontShow" : "Do not show this pop up today.",
					"neverShow" : "Do not show this pop up again.",
	            		
	            		"writer" : "작성자",
                },
                
			},			
			"en": {
				"common" : {
					"nationality":"Nationality",
					
					"name":"Name",
					"pefamliyName":"Last name",
					"peName":"First name",
					"engName":"English name",
					
					"gender":"Gender",
					"man":"M",
					"woman":"F",
					
					"birthday":"Date of birth",
					"birthdayForm":"19820525",
					
					"contact":"Contact",
					"EmergencyContact":"In case of emergency, plase contact : ",
					"relationship":"Relationship",
					"locationContact":"Mobile Number",
					"Email":"Email Address",
					"massenger":"Messenger Account",
					"englishName":"English name",
					
					"save":"Save",
					"bookmark":"Bookmark",
					
					"personal":"Personal",
					"personalInfo":"Personal information",
					"eduInfo":"Academy",
					"campusInfo":"Campus",
					
					"basicInfoChange":"Change personal information",
                    "basicInfoChangeButton":"Request",
					"basicInfoChageCaption":"The person in charge will change the updated information.",
					"contractInfo":"Contract",
					
					"date":"Date",
					"time":"Time",
					"yes":"Yes",
					"loaction":"Place",
					"etc":"Etc",
					"download":"Download",
					"apply":"Apply",
					"request":"Requests",
					"room":"Room",
					"qdownload":"Certificate download",
					
					"data":"data",
					"nodata":"None",
					"data-date":"2017/10/13",
					"none":"-",

					"replyStaff":"writer",
					"replyDate":"Reply Date",
					"close":"Close"
				},
				
				"signin": {
					"id": "Student Number",
					"pw": "Password(YYMMDD or 000000)",
					"signIn": "Sign In",
					"SignINpw":"The initial password is created with 6-digit of your birth date.(ex: YYMMDD or 000000)",				
				},				
				
				"freshman": {
					"title": "PIA Guideline",
					"personalInforamtion":"Personal information",
					
					"detailWriter":"Writer",
					"detailTitle":"Title",
					"detailContent":"Content",
					"detailAttachment":"Attachment",
					"detailRegisterDate":"Date",
				},
				
				"bookmark": {
					"bookmarkinfo": "Let's add bookmark.",
					"bookmarkinfo01":"It is shown in bookmark if you press the button (☆) in each item.",
					"bookmarkinfo02":"It is shown in order of when you press the button (☆).",
					"bookmarkinfo03":"It is excluded from bookmark if you press the button (★).",
					
				},
				
				"contract": {
					"coursePeriodRoom": "Course·period·Room",
					"entranceInfo":"Entry",
					"airplan":"Flight(entry)",
					"leaveInfo":"Flight(exit)",
					"pickup":"Pick-up",
					"agency":"Agent",
					"chargeStaff":"Person in charge",
					"contractInfoChage":"Change contract request",
					"deposit":"Deposit",
					"privateSafe":"E-Money",
					"moneyDown":"Breakdown(download)",
					
					"changeCourse":"Course change",
					"roomType":"Room",
					"extentionPeriod":"Extension",
					"cutPeriod":"Reduction",
					"delayContract":"Postpone",
					"cancleContrac":"Cancellation",
					"contractCpation":"The person in charge will contact and consult with you during the break time.",
				},   

				"siteSetting": {
					"siteSetting":"Site settings",
					"language":"Language",
					"notificationList":"Notification",
					"totalDown":"Download(full)",
					"logout":"Sign Out",
					
					"pwChange":"Change password",
					"pwOriginal":"Old password",
					"newPw":"New password",
					"newPwConfirm":"New password(confirm)",
					"resetPw":"Password reset",
					"pwCaption":"In the event of reset, the password will be set with 6-digit number of date of birthday.",
					
					"languageChange":"Changing site usage language",
				},    
				
				"education": {
					
					"classInfo":"Academic Information",
					"classPeriod":"Duration of Study",
					"classLevel":"Level",
					"classNum":"Classes number",
					"className":"Subject",
					"course":"Course",
					"levelCampus":"Level·Campus",
					
					"optionClass":"Option Classes",
					"optionTime":"time",
					"optionClassName":"Self-study",
					"morning":"Morning",
					"afternoon":"Afternoon",
					
					
					"classTimeTable":"Regular class Schedule",
					"classTimeTableCaption":"You can check your schedule after the class evaluation for the last term.",
					"classRoom":"Class Room",
					"subject":"Subject",
					"teacher":"Teacher",
					"noClass":"There is no class assigned.",
					
					"optionP":"Enrollment period",
					"optionSpan":"2017.06.01 09AM ~ 2017.07.02 12PM",
					"testDate":"Exam Date",
					
					"optionClassSchedule":"Exam Schedule",                    
					"testInfo_1":"You can cancel the OPT three days before.",
					"testInfo_2":"The MPT is mandatory exam.",
					"testApply":"Test apply",
					"otpApply":"OPT apply",
					"applyCencel":"Cancel",
					
					"testResult":"Exam Result",
					"testName":"Test Name",
					"testScore":"Test Score",
					"listing":"Listing",
					"speaking":"Speaking",
					"writing":"Writing",
					"attendance":"Attendance",
					"teacherEvaluation":"Teachers evaluation",
					"classEvaluation":"Class evaluation",
					
					"weekendStudy":"Weekend Study",
					"weekendStudyTime":"Total study hours",
					"weekendPriod":"Inquiry period",
					"weekendPriodtime":"2017.06.01 ~ 2017.07.02",
					"weekendStudyList":"History",
					"weekendStudyApply":"Apply",
					"perfect":"Perfect Attandance!!",
					"perfect_01":"We have a small gift for you.",
					"perfect_02":"Please visit main office as soon as possible.",
					
					
					"weekendStudyDate":"Date",
					"classRoomSelect":"Class room",
					"wekindTime":"Time",
					"classMap":"Campus",
					"eduCaption_1":"You can have weekend study from 9A.M that you designate class room and time.",
					"eduCaption_2":"The supervisor will check CCTV and confirm that you have weekend study or not. Please show your face to CCTV before you have weekend study. (Refresher front desk)",
					"eduCaption_3":"We will exclude final weekend study if you do not apply weekend study.",
					"eduCaption_4":"We will exclude during lunch time. (12-1PM)",
					"eduCaption_5":"If you have any question about weekend study feel free to come main office and look for managers.",    
					
					"classEvaluation_1":"The teacher's way of speaking is very kind and she is always bright.",
					"classEvaluation_2":"She respects my values, culture and emotions.",
					"classEvaluation_3":"She never shared my personal things with others.",
					"classEvaluation_4":"She maintained good class mood and she encouraged me with good feedback.",
					
					
				},
				
				"campus": {
					"requestNotice":"* Your request will be dealt with during the working hours of the PIA staffs (9AM-6PM)",
					"requestCaption":"If you write your requests in English, we can attend to it immediately.",
					
					"request":"Requests",
					"division":"Section",
					"content":"Content",
					"stauts":"Confirm",
					"progress":"Progress",
					"notYetReply":"Request",    
					"reply":"Confirm",    
					
					"consult":"Consultation",
					"consultCaption":"Feel free to write if you want to have a consultation with the manager.",
					
					"activity":"Activity",
					"activityNo":"We do not have any scheduled activity as of the moment",
					"citytour":"CITY TOUR",
					"movingWay":"Transportation",
					"pay":"Cost",
					"free":"Free",
					"applicationPeriod":"Registration",
					"activetyCaption":"2017-06-8(Fir) until 6PM",
					"join":"Join",
					   
					"todayMenu":"Today's Menu",
					"evalution":"Evaluation",
					"brackfast":"Breakfast",
					"lunch":"Lunch",
					"dinner":"Dinner",
					"menu":"Fishcake soup, rice, vegetable porridge, stir-fried pumpkin, vegetable egg rolls, banana jam sandwich, coffee",
					
					"notice":"Notice",
					"title":"Title",
                    
                    "freshmanGuide":"Freshman Guide",
					
					"againstruleList":"Regulation of Violation",
					"against":"Violated rules",
					"rule":"Rule book download",
					
					"quantity":"Consumption (water·electricity)",
					"electric":"Electricity usage (this week)",
					"water":"Water usage (this week)",
					"amount":"Total usage (this week)",
					"maximum":"Maximum usage (this week)",
					"exceedUsage":"OVER",
					"usageList":"Previous usage",
					
					"tourPlan":"Itinerary",
					"location":"Destination",
					"edit":"Write",
					"tourCaption":"You must submit the Itinerary 2 days before you leave.",
                    "register":"Register",
                    "finish":"End",
					
					"evalutionBrackfast":"Today's breakfast menu evaluation",
					"menuEvalution":"Meal satisfaction",
					"opnion":"Suggestion",
					"menuCaption":"If you have any problems about the meals served please write your concerns down. We will consider your opinion next time.",
					"menuEvalutionBtn":"Save",
					
					"tourAttention":"Guide for weekend trips",
					"tourAttentionCaption":"After you have read the  terms and conditions set, press the button below and it will be treated as a notice confirmation.",
					"tourAttentionConfirm":"I accept.",
					"attention1":"Guide 1",
					"attention2":"Guide 2",
					"attention3":"Guide 3",
					
					"transfer":"Transportation",
					"transferCaption":"If you want to set another time please come to the managers' office.",
					"van":"Van",
					"departureTime4":"Available time : 4 AM",
					"bus":"Bus",
					"departureTime11":"Available time : 11 AM",
					"contsult":"Undecided",
					"driver":"Driver's contact number",
					"departureDay":"Departure Time",
					"departureDayCaption":"After consultation I will decide.",
					"consultRequest":"Request for Consultation",
					"returnDaty":"Return Time",
					"contactNumber":"Local contact number",
					"participant":"Member",
					"number":"No",
					"roomNumber":"Room no.",
					"del":"Delete",
					"accept":"Submit",
					"tourTimetable":"Schedule",
					"tourCaption1":"We will notify you when you can have the consultation.",
					"tourCaption2":"People who will be joining the trip will be given a notification when they login.",
					"tourCaption3":"Ignorance is not an excuse. Please read all the guidelines,policies and rules of this institution.",
					"tourCaption4":"Trips will be automatically canceled during the existence of natural calamities or imminent threat.",
					"tourCaption5":"You have to submit your itinerary a day before the weekend trip.",
					"anotherLocation":"Other",
					"datailLocation":"Detail of destination",
				},
				
				"popup" : {
					"registration" : "Date",
					"tourContact" : "Emergency contact number",
					"blockMessage1" : "This pop up is emergency alarm.",
					"blockMessage2" : "You can not use this web page before you settle this problem.",
					"blockMessage3" : "Please come to managers' office as soon as possible.",
					"blockMessage4" : "",
					"dontShow" : "Do not show this pop up today.",
					
					"writer" : "writer",
				},
				
			},			
			"jp": {
				"common" : {
					"nationality":"Nationality",
					
					"name":"Name",
					"pefamliyName":"Last name",
					"peName":"First name",
					"engName":"English name",
					
					"gender":"Gender",
					"man":"M",
					"woman":"F",
					
					"birthday":"Date of birth",
					"birthdayForm":"19820525",
					
					"contact":"Contact",
					"EmergencyContact":"In case of emergency, plase contact : ",
					"relationship":"Relationship",
					"locationContact":"Mobile Number",
					"Email":"Email Address",
					"massenger":"Messenger Account",
					"englishName":"English name",
					
					"save":"Save",
					"bookmark":"Bookmark",
					
					"personal":"Personal",
					"personalInfo":"Personal information",
					"eduInfo":"Academy",
					"campusInfo":"Campus",
					
					"basicInfoChange":"Change personal information",
                    "basicInfoChangeButton":"Request",
					"basicInfoChageCaption":"The person in charge will change the updated information.",
					"contractInfo":"Contract",
					
					"date":"Date",
					"time":"Time",
					"yes":"Yes",
					"loaction":"Place",
					"etc":"Etc",
					"download":"Download",
					"apply":"Apply",
					"request":"Requests",
					"room":"Room",
					"qdownload":"Certificate download",
					
					"data":"data",
					"nodata":"None",
					"data-date":"2017/10/13",
					"none":"-",

					"replyStaff":"writer",
					"replyDate":"Reply Date",
					"close":"Close"
				},
				
				"signin": {
					"id": "Student Number",
					"pw": "Password(YYMMDD or 000000)",
					"signIn": "Sign In",
					"SignINpw":"The initial password is created with 6-digit of your birth date.(ex: YYMMDD or 000000)",				
				},				
				
				"freshman": {
					"title": "PIA Guideline",
					"personalInforamtion":"Personal information",
					
					"detailWriter":"Writer",
					"detailTitle":"Title",
					"detailContent":"Content",
					"detailAttachment":"Attachment",
					"detailRegisterDate":"Date",
				},
				
				"bookmark": {
					"bookmarkinfo": "Let's add bookmark.",
					"bookmarkinfo01":"It is shown in bookmark if you press the button (☆) in each item.",
					"bookmarkinfo02":"It is shown in order of when you press the button (☆).",
					"bookmarkinfo03":"It is excluded from bookmark if you press the button (★).",
					
				},
				
				"contract": {
					"coursePeriodRoom": "Course·period·Room",
					"entranceInfo":"Entry",
					"airplan":"Flight(entry)",
					"leaveInfo":"Flight(exit)",
					"pickup":"Pick-up",
					"agency":"Agent",
					"chargeStaff":"Person in charge",
					"contractInfoChage":"Change contract request",
					"deposit":"Deposit",
					"privateSafe":"E-Money",
					"moneyDown":"Breakdown(download)",
					
					"changeCourse":"Course change",
					"roomType":"Room",
					"extentionPeriod":"Extension",
					"cutPeriod":"Reduction",
					"delayContract":"Postpone",
					"cancleContrac":"Cancellation",
					"contractCpation":"The person in charge will contact and consult with you during the break time.",
				},   

				"siteSetting": {
					"siteSetting":"Site settings",
					"language":"Language",
					"notificationList":"Notification",
					"totalDown":"Download(full)",
					"logout":"Sign Out",
					
					"pwChange":"Change password",
					"pwOriginal":"Old password",
					"newPw":"New password",
					"newPwConfirm":"New password(confirm)",
					"resetPw":"Password reset",
					"pwCaption":"In the event of reset, the password will be set with 6-digit number of date of birthday.",
					
					"languageChange":"Changing site usage language",
				},    
				
				"education": {
					
					"classInfo":"Academic Information",
					"classPeriod":"Duration of Study",
					"classLevel":"Level",
					"classNum":"Classes number",
					"className":"Subject",
					"course":"Course",
					"levelCampus":"Level·Campus",
					
					"optionClass":"Option Classes",
					"optionTime":"time",
					"optionClassName":"Self-study",
					"morning":"Morning",
					"afternoon":"Afternoon",
					
					
					"classTimeTable":"Regular class Schedule",
					"classTimeTableCaption":"You can check your schedule after the class evaluation for the last term.",
					"classRoom":"Class Room",
					"subject":"Subject",
					"teacher":"Teacher",
					"noClass":"There is no class assigned.",
					
					"optionP":"Enrollment period",
					"optionSpan":"2017.06.01 09AM ~ 2017.07.02 12PM",
					"testDate":"Exam Date",
					
					"optionClassSchedule":"Exam Schedule",                    
					"testInfo_1":"You can cancel the OPT three days before.",
					"testInfo_2":"The MPT is mandatory exam.",
					"testApply":"Test apply",
					"otpApply":"OPT apply",
					"applyCencel":"Cancel",
					
					"testResult":"Exam Result",
					"testName":"Test Name",
					"testScore":"Test Score",
					"listing":"Listing",
					"speaking":"Speaking",
					"writing":"Writing",
					"attendance":"Attendance",
					"teacherEvaluation":"Teachers evaluation",
					"classEvaluation":"Class evaluation",
					
					"weekendStudy":"Weekend Study",
					"weekendStudyTime":"Total study hours",
					"weekendPriod":"Inquiry period",
					"weekendPriodtime":"2017.06.01 ~ 2017.07.02",
					"weekendStudyList":"History",
					"weekendStudyApply":"Apply",
					"perfect":"Perfect Attandance!!",
					"perfect_01":"We have a small gift for you.",
					"perfect_02":"Please visit main office as soon as possible.",
					
					
					"weekendStudyDate":"Date",
					"classRoomSelect":"Class room",
					"wekindTime":"Time",
					"classMap":"Campus",
					"eduCaption_1":"You can have weekend study from 9A.M that you designate class room and time.",
					"eduCaption_2":"The supervisor will check CCTV and confirm that you have weekend study or not. Please show your face to CCTV before you have weekend study. (Refresher front desk)",
					"eduCaption_3":"We will exclude final weekend study if you do not apply weekend study.",
					"eduCaption_4":"We will exclude during lunch time. (12-1PM)",
					"eduCaption_5":"If you have any question about weekend study feel free to come main office and look for managers.",    
					
					"classEvaluation_1":"The teacher's way of speaking is very kind and she is always bright.",
					"classEvaluation_2":"She respects my values, culture and emotions.",
					"classEvaluation_3":"She never shared my personal things with others.",
					"classEvaluation_4":"She maintained good class mood and she encouraged me with good feedback.",
					
					
				},
				
				"campus": {
					"requestNotice":"* Your request will be dealt with during the working hours of the PIA staffs (9AM-6PM)",
					"requestCaption":"If you write your requests in English, we can attend to it immediately.",
					
					"request":"Requests",
					"division":"Section",
					"content":"Content",
					"stauts":"Confirm",
					"progress":"Progress",
					"notYetReply":"Request",    
					"reply":"Confirm",    
					
					"consult":"Consultation",
					"consultCaption":"Feel free to write if you want to have a consultation with the manager.",
					
					"activity":"Activity",
					"activityNo":"We do not have any scheduled activity as of the moment",
					"citytour":"CITY TOUR",
					"movingWay":"Transportation",
					"pay":"Cost",
					"free":"Free",
					"applicationPeriod":"Registration",
					"activetyCaption":"2017-06-8(Fir) until 6PM",
					"join":"Join",
					   
					"todayMenu":"Today's Menu",
					"evalution":"Evaluation",
					"brackfast":"Breakfast",
					"lunch":"Lunch",
					"dinner":"Dinner",
					"menu":"Fishcake soup, rice, vegetable porridge, stir-fried pumpkin, vegetable egg rolls, banana jam sandwich, coffee",
					
					"notice":"Notice",
					"title":"Title",
                    
                    "freshmanGuide":"Freshman Guide",
					
					"againstruleList":"Regulation of Violation",
					"against":"Violated rules",
					"rule":"Rule book download",
					
					"quantity":"Consumption (water·electricity)",
					"electric":"Electricity usage (this week)",
					"water":"Water usage (this week)",
					"amount":"Total usage (this week)",
					"maximum":"Maximum usage (this week)",
					"exceedUsage":"OVER",
					"usageList":"Previous usage",
					
					"tourPlan":"Itinerary",
					"location":"Destination",
					"edit":"Write",
					"tourCaption":"You must submit the Itinerary 2 days before you leave.",
                    "register":"Register",
                    "finish":"End",
					
					"evalutionBrackfast":"Today's breakfast menu evaluation",
					"menuEvalution":"Meal satisfaction",
					"opnion":"Suggestion",
					"menuCaption":"If you have any problems about the meals served please write your concerns down. We will consider your opinion next time.",
					"menuEvalutionBtn":"Save",
					
					"tourAttention":"Guide for weekend trips",
					"tourAttentionCaption":"After you have read the  terms and conditions set, press the button below and it will be treated as a notice confirmation.",
					"tourAttentionConfirm":"I accept.",
					"attention1":"Guide 1",
					"attention2":"Guide 2",
					"attention3":"Guide 3",
					
					"transfer":"Transportation",
					"transferCaption":"If you want to set another time please come to the managers' office.",
					"van":"Van",
					"departureTime4":"Available time : 4 AM",
					"bus":"Bus",
					"departureTime11":"Available time : 11 AM",
					"contsult":"Undecided",
					"driver":"Driver's contact number",
					"departureDay":"Departure Time",
					"departureDayCaption":"After consultation I will decide.",
					"consultRequest":"Request for Consultation",
					"returnDaty":"Return Time",
					"contactNumber":"Local contact number",
					"participant":"Member",
					"number":"No",
					"roomNumber":"Room no.",
					"del":"Delete",
					"accept":"Submit",
					"tourTimetable":"Schedule",
					"tourCaption1":"We will notify you when you can have the consultation.",
					"tourCaption2":"People who will be joining the trip will be given a notification when they login.",
					"tourCaption3":"Ignorance is not an excuse. Please read all the guidelines,policies and rules of this institution.",
					"tourCaption4":"Trips will be automatically canceled during the existence of natural calamities or imminent threat.",
					"tourCaption5":"You have to submit your itinerary a day before the weekend trip.",
					"anotherLocation":"Other",
					"datailLocation":"Detail of destination",
				},
				
				"popup" : {
					"registration" : "Date",
					"tourContact" : "Emergency contact number",
					"blockMessage1" : "This pop up is emergency alarm.",
					"blockMessage2" : "You can not use this web page before you settle this problem.",
					"blockMessage3" : "Please come to managers' office as soon as possible.",
					"blockMessage4" : "",
					"dontShow" : "Do not show this pop up today.",
					
					"writer" : "writer",
				},
				
			},			
			"cn": {
				"common" : {
					"nationality":"国籍",
					
					"name":"姓名",
					"pefamliyName":"姓",
					"peName":"名",
					"engName":"英文名",
					
					"gender":"性别",
					"man":"男",
					"woman":"女",
					
					"birthday":"出生日期",
					"birthdayForm":"19820525",
					
					"contact":"电话",
					"EmergencyContact":"应急电话",
					"relationship":"联系人",
					"locationContact":"联系电话",
					"Email":"邮箱",
					"massenger":"即时通讯",
					"englishName":"英文名",
					
					"save":"保存",
					"bookmark":"书签",
					
					"personal":"个人",
					"personalInfo":"个人信息",
					"eduInfo":"学院",
					"campusInfo":"校区",
					
					"basicInfoChange":"更改个人信息",
                    "basicInfoChangeButton":"请求更改",
					"basicInfoChageCaption":"以上学生信息将被更改.",
					"contractInfo":"注册信息",
					
					"date":"日期",
					"time":"时间",
					"yes":"yes",
					"loaction":"位置",
					"etc":"其他",
					"download":"下载",
					"apply":"申请",
					"request":"要求",
					"room":"房间",
					"qdownload":"下载证书",
					
					"data":"data",
					"nodata":"无",
					"data-date":"2017-10-13",
					"none":"-",

					"replyStaff":"writer",
					"replyDate":"Reply Date",
					"close":"确定"
				},
				
				"signin": {
					"id": "账号",
					"pw": "密码(YYMMDD or 000000)",
					"signIn": "登录",
					"SignINpw":"初始密码为您生日的后六位数(ex: YYMMDD or 000000)",				
				},				
				
				"freshman": {
					"title": "PIA 信息指南",
					"personalInforamtion":"个人信息",
					
					"detailWriter":"作家",
					"detailTitle":"内容",
					"detailContent":"内容",
					"detailAttachment":"Attachment",
					"detailRegisterDate":"日期",
				},
				
				"bookmark": {
					"bookmarkinfo": "Let's add bookmark.",
					"bookmarkinfo01":"点击所有按钮显示书签 (☆)。",
					"bookmarkinfo02":"点击按钮显示书签 (☆)。",
					"bookmarkinfo03":" I点击按钮显示书签之外内容 (★)。",
					
				},
				
				"contract": {
					"coursePeriodRoom": "课程·学期·房间类型",
					"entranceInfo":"条目信息",
					"airplan":"入境信息",
					"leaveInfo":"离境信息",
					"pickup":"接机服务",
					"agency":"中介",
					"chargeStaff":"学生姓名",
					"contractInfoChage":"Change contract request",
					"deposit":"保证金",
					"privateSafe":"E-Money",
					"moneyDown":"详细(下载)",
					
					"changeCourse":"更改课程",
					"roomType":"房间",
					"extentionPeriod":"延期",
					"cutPeriod":"Reduction",
					"delayContract":"Postpone",
					"cancleContrac":"取消课程",
					"contractCpation":"经理会在您的休息时间联系并给予您相关咨询。",
				},   
				
				"education": {
					
					"classInfo":"学习信息",
					"classPeriod":"学期",
					"classLevel":"等级",
					"classNum":"课程数",
					"className":"科目",
					"course":"课程",
					"levelCampus":"等级·校区",
					
					"optionClass":"选修课",
					"optionTime":"time",
					"optionClassName":"Self-study (M3)",
					"morning":"上午",
					"afternoon":"下午",
					
					
					"classTimeTable":"一般课程表",
					"classTimeTableCaption":"进行完上学期教学评价后可查看新课表。",
					"classRoom":"教室",
					"subject":"科目",
					"teacher":"教师",
					"noClass":"无注册课程。",
					
					"optionP":"신청기간",
					"optionSpan":"2017.06.01 09AM ~ 2017.07.02 12PM",
					"testDate":"选修课",
					
					"optionClassSchedule":"考试日程表",                    
					"testInfo_1":"OPT开考前三天可取消。",
					"testInfo_2":"MPT 是强制性考试。",
					"testApply":"Test 申请",
					"otpApply":"OPT 申请",
					"applyCencel":"取消",
					
					"testResult":"考试结果",
					"testName":"Test Name",
					"testScore":"Test Score",
					"listing":"Listing",
					"speaking":"Speaking",
					"writing":"Writing",
					"attendance":"出勤",
					"teacherEvaluation":"老师评价",
					"classEvaluation":"教学评价",
					
					"weekendStudy":"周末学习",
					"weekendStudyTime":"缺勤",
					"weekendPriod":"完成期限",
					"weekendPriodtime":"2017.06.01 ~ 2017.07.02",
					"weekendStudyList":"学习记录",
					"weekendStudyApply":"申请",
					"perfect":"完美出勤!!",
					"perfect_01":"我们有个小礼物给你作为出勤奖励.",
					"perfect_02":"请尽快到经理办公室来!",
					
					
					"weekendStudyDate":"申请周末学习",
					"classRoomSelect":"教室",
					"wekindTime":"时间",
					"classMap":"校区概图",
					
					"eduCaption_1":"你可以在周六上午9点后在制定的教室学习。",
					"eduCaption_2":"经理会在周一检查监控以确认你是否学习。所以在进行周末学习之前请站在refresher校区CCTV(办公室前台)前打个招呼",
					"eduCaption_3":"如果你不申请周末学习，我们将取消最后一个周末的学习。",
					"eduCaption_4":"午餐时间不包含在周末学习时间里。(12-1PM)。",
					"eduCaption_5":"如果你对周末的学习有任何疑问，可以到办公室去找经理咨询。",    
					
					"classEvaluation_1":"老师的表达方式很友善且开朗。",
					"classEvaluation_2":"她尊重我的价值观、文化和心情。",
					"classEvaluation_3":"从来不和别人分享我的私事。",
					"classEvaluation_4":"她善于保持良好的课堂气氛，经常鼓励我参与到讨论等学习当中来。",
					
				},
				
				"siteSetting": {
					"siteSetting":"应用设置",
					"language":"语言",
					"notificationList":"通知",
					"totalDown":"下载(全)",
					"logout":"注销登录",

					"pwChange":"修改密码",
					"pwOriginal":"旧密码",
					"newPw":"新密码",
					"newPwConfirm":"再次确认新密码",
					"resetPw":"重置密码",
					"pwCaption":"若重置密码，密码则恢复到出生年月的六位初始密码。",
					
					"languageChange":"更改网站使用语言",
				},      
				
				"campus": {
					"requestNotice":"* 您的请求将由PIA的工作人员在工作时间内（上午9点〜下午6点）处理。",
					"requestCaption":"请您用英语写下相关要求，我们会尽快处理。",
					
					"request":"要求",
					"division":"部门",
					"content":"内容",
					"stauts":"确认", 
					"progress":"进展",
					"notYetReply":"未确认",   
					"reply":"确认",    
					
					"consult":"咨询",
					"consultCaption":"请写下你想和经理咨询的内容。",
					
					"activity":"活动",
					"activityNo":"现阶段无任何活动.",
					"citytour":"关于城市观光的通知",
					"movingWay":"交通方式",
					"pay":"费用",
					"free":"免费",
					"applicationPeriod":"申请",
					"activetyCaption":"2017-06-08(周五) 6pm 截止",
					"join":"参加",
					
					"todayMenu":"今日菜单",
					"evalution":"评价",
					"brackfast":"早饭",
					"lunch":"午饭",
					"dinner":"晚饭",
					"menu":"鱼饼汤, 米饭, 蔬菜粥, 炒南瓜, 煎蛋卷,香蕉酱抹三明治, 咖啡",
					
					"notice":"通知",
					"title":"内容",
                    
                    "freshmanGuide":"新生指南",
					
					"againstruleList":"校规违反",
					"against":"违反规则",
					"rule":"校规手册下载",
					
					"quantity":"消费量 (水费·电费)",
					"electric":"用电量 (本周)",
					"water":"用水量 (本周)",
					"amount":"总计 (本周)",
					"maximum":"用量上限 (本周)",
					"exceedUsage":"超额",
					"usageList":"历史记录",
					
					"tourPlan":"旅行日程",
					"location":"目的地",
					"edit":"申请",
					"tourCaption":"请务必在出发两天前提交申请。",
                    "register":"未确认",
                    "finish":"确认",
					
					"evalutionBrackfast":"今日早餐评价",
					"menuEvalution":"饭菜满意度",
					"opnion":"意见或建议",
					"menuCaption":"如果您对饭菜有任何意见或建议，请写下来。我们会认真考虑您的意见。",
					"menuEvalutionBtn":"评价",
					
					"tourAttention":"周末旅行指南",
					"tourAttentionCaption":"阅读完相关条款后若无意见，请按下\"同意\"按钮",
					"tourAttentionConfirm":"同意",
					"attention1":"Guide 1",
					"attention2":"Guide 2",
					"attention3":"Guide 3",
					
					"transfer":"交通方式",
					"transferCaption":"如果你想选择其他时间，请来经理办公室商谈",
					"van":"小汽车",
					"departureTime4":"可运营时间 : 4 AM",
					"bus":"大巴",
					"departureTime11":"可运营时间 : 11 AM",
					"contsult":"未定",
					"driver":"司机联系方式",
					"departureDay":"出发时间",
					"departureDayCaption":"请求咨询",
					"consultRequest":"咨询后决定",
					"returnDaty":"返回时间",
					"contactNumber":"目的地联系方式",
					"participant":"同行成员",
					"number":"序号",
					"roomNumber":"房间号",
					"del":"删除",
					"accept":"提交",
					"tourTimetable":"日程表",
					"tourCaption1":"当你可以来咨询的时候会收到我们的通知",
					"tourCaption2":"将参加旅行的人会在登录时收到通知",
					"tourCaption3":"请仔细阅读所有指南、政策和规定",
					"tourCaption4":"在自然灾害或有紧急情况发生时，行程将自动取消",
					"tourCaption5":"你必须在周末旅行前一天提交你的行程安排",
					"anotherLocation":"Other",
					"datailLocation":"Detail of destination",
					
				},
				"popup" : {
					"registration" : "日期",
					"tourContact" : "应急联系方式",
					"blockMessage1" : "本页面为紧急提示",
					"blockMessage2" : "在解决问题之前本页面不可用。",
					"blockMessage3" : "请尽快来经理办公室。",
					"blockMessage4" : "",
					"dontShow" : "今天内不再显示本页面。",
					
					"writer" : "作家",
				},
				
			},			
			"dn": {
				"common" : {
					"nationality":"Quốc tịch",
					
					"name":"Họ và Tên",
					"pefamliyName":"Tên",
					"peName":"Họ",
					"engName":"English name",
					
					"gender":"Giới tính",
					"man":"M",
					"woman":"F",
					
					"birthday":"Ngày sinh",
					"birthdayForm":"19820525",
					
					"contact":"contact",
					"EmergencyContact":"Số điện thoại khẩn cấp",
					"relationship":"Tình trạng hôn nhân",
					"locationContact":"Số điện thoại",
					"Email":"Email Address",
					"massenger":"Messenger Account",
					"englishName":"English name",
					
					"save":"Save",
					"bookmark":"Ghi chú",
					
					"personal":"cá nhân",
					"personalInfo":"trường học",
					"eduInfo":"Học viện",
					"campusInfo":"cơ sở",

					"basicInfoChange":"Change personal information",
                    "basicInfoChangeButton":"Request",
					"basicInfoChageCaption":"The person in charge will change the updated information.",
					"contractInfo":"Contract",
					
					"date":"Date",
					"time":"Time",
					"yes":"Yes",
					"loaction":"Place",
					"etc":"Etc",
					"download":"Download",
					"apply":"Apply",
					"request":"Requests",
					"room":"Room",
					"qdownload":"Certificate download",
					
					"data":"data",
					"nodata":"None",
					"data-date":"2017/10/13",
					"none":"-",

					"replyStaff":"writer",
					"replyDate":"Reply Date",
					"close":"Close"
				},
				
				"signin": {
					"id": "Số thẻ sinh viên",
					"pw": "Mật khẩu(YYMMDD or 000000)",
					"signIn": "Đăng nhập",
					"SignINpw":"Mật khẩu ban đầu được tạo bởi 6 chữ số trong ngày sinh của bạn(ex: YYMMDD or 000000)",				
				},				
				
				"freshman": {
					"title": "Hướng dẫn",
					"personalInforamtion":"Thông  tin cá nhân",

					"detailTitle":"Title",
					"detailWriter":"Writer",
					"detailTitle":"Tiêu đề",
					"detailContent":"Nội dung",
					"detailAttachment":"Attachment",
					"detailRegisterDate":"Date",
				},
				
				"bookmark": {
					"bookmarkinfo": "Let's add bookmark.",
					"bookmarkinfo01":"It is shown in bookmark if you press the button (☆) in each item.",
					"bookmarkinfo02":"It is shown in order of when you press the button (☆).",
					"bookmarkinfo03":"It is excluded from bookmark if you press the button (★).",
					
				},

				"contract": {
					"coursePeriodRoom": "Course·period·Room",
					"entranceInfo":"Entry",
					"airplan":"Flight(entry)",
					"leaveInfo":"Flight(exit)",
					"pickup":"Pick-up",
					"agency":"Agent",
					"chargeStaff":"Person in charge",
					"contractInfoChage":"Yêu cầu thay đổi",
					"deposit":"Deposit",
					"privateSafe":"E-Money",
					"moneyDown":"Breakdown(download)",
					
					"changeCourse":"Thay đổi khóa học",
					"roomType":"Phòng",
					"extentionPeriod":"Gia hạn học",
					"cutPeriod":"Reduction",
					"delayContract":"Tạm hoãn",
					"cancleContrac":"Hủy",
					"contractCpation":"Quản lý sẽ liên lạc và tư vấn với bạn trong thời gian sớm nhất.",
				},   

				"education": {
					
					"classInfo":"Thông tin bài học",
					"classPeriod":"Giai đoạn",
					"classLevel":"Level",
					"classNum":"Số lượng lớp học",
					"className":"Môn học",
					"course":"Khóa học",
					"levelCampus":"Level·Cơ sở",
					
					"optionClass":"Lớp học tự chọn",
					"optionTime":"Thời gian",
					"optionClassName":"Self-study",
					"morning":"Buổi sáng",
					"afternoon":"Buổi trưa",
					
					
					"classTimeTable":"Lịch học",
					"classTimeTableCaption":"Bạn có thể kiểm tra lịch học sau khi đánh giá lớp học cho kỳ học trước.",
					"classRoom":"Lớp học",
					"subject":"Môn học",
					"teacher":"Giáo viên",
					"noClass":"Chưa có lịch học ở đây",
					
					"optionP":"Giai đoạn đăng ký 166Th ",
					"optionSpan":"2017.06.01 09AM ~ 2017.07.02 12PM",
					"testDate":"Người hướng dẫn",
					
					"optionClassSchedule":"Lịch thi",                    
					"testInfo_1":"Bạn có thể hủy thi OPT trước 3 ngày.",
					"testInfo_2":"MPT là kỳ thi bắt buột.",
					"testApply":"Đăng ký thi",
					"otpApply":"Đăng ký thi OPT",
					"applyCencel":"Hủy",
					
					"testResult":"Kết quả kiểm tra",
					"testName":"Test Name",
					"testScore":"Test Score",
					"listing":"Listing",
					"speaking":"Speaking",
					"writing":"Writing",
					"attendance":"Attendance",
					"teacherEvaluation":"Teachers evaluation",
					"classEvaluation":"Đánh giá",
					
					"weekendStudy":"Học cuối tuần",
					"weekendStudyTime":"Vắng mặt",
					"weekendPriod":"Thời gian yêu cầu",
					"weekendPriodtime":"2017.06.01 ~ 2017.07.02",
					"weekendStudyList":"Lịch sử",
					"weekendStudyApply":"Đăng ký",
					"perfect":"Tham gia học đầy đủ!!",
					"perfect_01":"Sẽ có món quà nhỏ dành cho bạn.",
					"perfect_02":"Hãy đến nhận tại Main office sớm nhất có thể.",
					
					
					"weekendStudyDate":"Ngày",
					"classRoomSelect":"Phòng học",
					"wekindTime":"Thời gian",
					"classMap":"Bản đồ cơ sở",
					
					"eduCaption_1":"Bạn sẽ học cuối tuần từ 9h sáng thứ 7 tại phòng học và số giờ học mà bạn đã đăng ký.",
					"eduCaption_2":"Sẽ có người kiểm tra CCTV và xác nhận là bạn đã tham gia học cuối tuần hay không. Hãy đứng trước CCTV (Refresher front desk) trước khi vào học.",
					"eduCaption_3":"Nếu bạn không đăng ký trước, trường sẽ không tính là bạn đã có tham gia học.",
					"eduCaption_4":"Trường sẽ không tính thời gian nghỉ trưa. (12-1PM)",
					"eduCaption_5":"Nếu bạn có bất cứ thắc măc gì về các giờ học cuối tuần, vui lòng đến văn phòng gặp quản lý để hỏi thêm thông tin chi tiết.",    
					
					"classEvaluation_1":"Giáo viên rất thân thiện và vui vẻ. Giáo viên tôn trọng những giá trị cá nhân, văn hóa riêng và cảm xúc của sinh viên.",
					"classEvaluation_2":"Giáo viên không bao giờ chia sẻ những điều cá nhân của sinh viên cho người khác.",
					"classEvaluation_3":"Giáo viên mang đến một không khí học tập tốt và cổ vũ sinh viên bằng những góp ý chân thành.",
					"classEvaluation_4":"Giáo viên đem đến những giờ học hiệu quả mỗi ngày. Nếu sinh viên đề xuất một điều gì, giáo viên thường tích cực hưởng ứng.",
					
					
				},

				"siteSetting": {
					"siteSetting":"Site settings",
					"language":"Language",
					"notificationList":"Notification",
					"totalDown":"Download(full)",
					"logout":"Sign Out",
					
					"pwChange":"Change password",
					"pwOriginal":"Old password",
					"newPw":"New password",
					"newPwConfirm":"New password(confirm)",
					"resetPw":"Password reset",
					"pwCaption":"In the event of reset, the password will be set with 6-digit number of date of birthday.",
					
					"languageChange":"Changing site usage language",
				},    
				
				"campus": {
					"requestNotice":"* Yêu cầu của bạn sẽ được nhân viên chúng tôi giải quyết vào thời gian làm việc ( 9 giờ sáng - 6 giờ chiều).",
					"requestCaption":"Nếu bạn viết yêu cầu của bạn bằng tiếng anh , chúng tôi sẽ giải quyết sớm nhất có thể.",
					
					"request":"Yêu cầu",
					"division":"Mục",
					"content":"Nội dung",
					"stauts":"Xác nhận",
					"progress":"Phát triển",
					"notYetReply":"Chưa xác nhận",    
					"reply":"Xác nhận",    
					
					"consult":"Tư vấn",
					"consultCaption":"Đừng ngại viết ra yêu cầu của bạn nếu bạn cần một buổi tư vấn với quản lý sinh viên",
					
					"activity":"Hoạt động ngoại khóa",
					"activityNo":"Chúng ta không có hoạt động nào trong thời gian này",
					"citytour":"CITY TOUR",
					"movingWay":"Phương tiện",
					"pay":"Lệ phí",
					"free":"Miễm phí",
					"applicationPeriod":"Thời gian đăng kí",
					"activetyCaption":"2017-06-08 (Fri)  đến 6pm",
					"join":"Tham gia",
					   
					"todayMenu":"Thực đơn hôm nay",
					"evalution":"Đánh giá",
					"brackfast":"Buổi sáng",
					"lunch":"Buổi trưa",
					"dinner":"Buổi tối",
					"menu":"Fishcake soup, rice, vegetable porridge, stir-fried pumpkin, vegetable egg rolls, banana jam sandwich, coffee",
					
					"notice":"Lưu ý",
					"title":"Tiêu đề",
                    
                    "freshmanGuide":"hướng dẫn sinh viên năm nhất",
					
					"againstruleList":"Qui định",
					"against":"Vi phạm nội qui",
					"rule":"Tải về quy định trường",
					
					"quantity":"Phí sinh hoạt (Tiền nước,tiền điện)",
					"electric":"Tiền điện sử dụng (tuần này)",
					"water":"Tiền nước (tuần này)",
					"amount":"Tổng sử dụng (tuần này)",
					"maximum":"Tối đa sử dụng (tuần này)",
					"exceedUsage":"Vượt quá",
					"usageList":"Đã sử dụng",
					
					"tourPlan":"Lịch trình",
					"location":"Nơi đến",
					"edit":"Viết",
					"tourCaption":"Bạn phải ghi cụ thể lịch trình của hai ngày",
                    "register":"Register",
                    "finish":"End",
					
					"evalutionBrackfast":"Nhận xét bữa sáng hôm nay",
					"menuEvalution":"Meal satisfaction",
					"opnion":"Suggestion",
					"menuCaption":"Nếu bạn có bất cứ vấn đề nào về cung cách phục vụ, vui lòng ghi lại cho chúng tôi biết Chúng tôi sẽ cân nhắc ý kiến của bạn",
					"menuEvalutionBtn":"Save",
					
					"tourAttention":"Guide for weekend trips",
					"tourAttentionCaption":"After you have read the  terms and conditions set, press the button below and it will be treated as a notice confirmation.",
					"tourAttentionConfirm":"I accept.",
					"attention1":"Guide 1",
					"attention2":"Guide 2",
					"attention3":"Guide 3",
					
					"transfer":"Transportation",
					"transferCaption":"If you want to set another time please come to the managers' office.",
					"van":"Van",
					"departureTime4":"Available time : 4 AM",
					"bus":"Bus",
					"departureTime11":"Available time : 11 AM",
					"contsult":"Undecided",
					"driver":"Driver's contact number",
					"departureDay":"Departure Time",
					"departureDayCaption":"After consultation I will decide.",
					"consultRequest":"Request for Consultation",
					"returnDaty":"Return Time",
					"contactNumber":"Local contact number",
					"participant":"Member",
					"number":"No",
					"roomNumber":"Room no.",
					"del":"Delete",
					"accept":"Submit",
					"tourTimetable":"Schedule",
					"tourCaption1":"We will notify you when you can have the consultation.",
					"tourCaption2":"People who will be joining the trip will be given a notification when they login.",
					"tourCaption3":"Ignorance is not an excuse. Please read all the guidelines,policies and rules of this institution.",
					"tourCaption4":"Trips will be automatically canceled during the existence of natural calamities or imminent threat.",
					"tourCaption5":"You have to submit your itinerary a day before the weekend trip.",
					"anotherLocation":"Other",
					"datailLocation":"Detail of destination",
				},

				"popup" : {
					"registration" : "Ngày",
					"tourContact" : "Số điện thoại quan trọng",
					"blockMessage1" : "Thông báo này là lời nhắc nhở khẩn cấp.",
					"blockMessage2" : "Bạn không thể sử dụng trang web trước khi giải quyết vấn đề này.",
					"blockMessage3" : "Hãy đến văn phòng quản lý sớm nhất có thể.",
					"blockMessage4" : "",
					"dontShow" : "Không hiện thông báo này nữa",
					
					"writer" : "writer",
				},
				
			},			
        }
    }, function () {
        $('.translation').i18n();
		$('html').removeClass();
		$('html').addClass('ko-font');
    });
});

var changeLang = function (lang) {
    $.i18n.setLng(lang, function(){
    	$('.translation').i18n();
		$('html').removeClass();
		$('html').addClass(lang + '-font');
    });
};