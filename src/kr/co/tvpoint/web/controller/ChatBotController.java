package kr.co.tvpoint.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.tvpoint.web.vo.KeyboardVO;
import kr.co.tvpoint.web.vo.MessageButtonVO;
import kr.co.tvpoint.web.vo.MessageVO;
import kr.co.tvpoint.web.vo.RequestMessageVO;
import kr.co.tvpoint.web.vo.ResponseMessageVO;

@RestController
public class ChatBotController {
	@RequestMapping("/")
//	@ResponseBody
    public String welcome() {//Welcome page, non-rest
		System.out.println("welcome");
        return "Welcome to RestTemplate kakao chatBot page.";
    }
	
	 // 키보드
	 @SuppressWarnings("unchecked")
	 @RequestMapping(value = "/keyboard", method = RequestMethod.GET)
//	 @ResponseBody
	 public KeyboardVO keyboard() {
		 System.out.println("/keyboard");
		 
		 KeyboardVO keyboard = new KeyboardVO(new String[] {"뇽뇽이한테 물어보기!", "사다리게임"});
		 return keyboard;
	 }

	
 	// 메세지
	@RequestMapping(value = "/message", method = RequestMethod.POST, headers = "Accept=application/json")
//	@ResponseBody
	public ResponseMessageVO message(@RequestBody RequestMessageVO resObj) {

		String content;
		content = resObj.getContent();
		System.out.println("/message question="+content);
		ResponseMessageVO res_vo = new ResponseMessageVO();
		MessageVO jobjText = new MessageVO();
		
		// 사용자 구현
		if ("안녕".equals(content) || "안뇽".equals(content)) {
			jobjText.setText("안뇽(야옹)");
		} else if(content.equals("메인화면")){
			jobjText.setText("첫 화면을 호출합니다.");
			
			 KeyboardVO keyboard = new KeyboardVO(new String[] {"뇽뇽이한테 물어보기!", "사다리게임!"});
			
			 res_vo.setKeyboard(keyboard);
		} else if (content.contains("vs") ) {
			jobjText.setText(vsFunction(resObj , "vs"));
		} else if (content.contains("VS") ) {
			jobjText.setText(vsFunction(resObj , "VS"));
		} else if (content.contains("vS") ) {
			jobjText.setText(vsFunction(resObj , "vS"));
		} else if (content.contains("Vs")) {
			jobjText.setText(vsFunction(resObj , "Vs"));
		} else if (content.contains("사랑")) {
			jobjText.setText("뇽뇽이도 사랑한다뇽(뽀뽀)");
		} else if (content.contains("뇽뇽이한테 물어보기!")) {
			jobjText.setText("드디어 뇽뇽이가 돌아왔습니다!!!!!\n\n"
					+ "🐱제 1탄 결정왕 뇽뇽이🐱\n"
					+ "그동안 결정하기 어려우셨던 분들 모두 주목해주세요!\n"
					+"vs를 포함하여 단어를 제시하면 뇽뇽이가 대답할 줄꺼에요.\n\n"
					+"⭐예시⭐\n"
					+"😳결정장애 철수 : 짜장면 vs 짬뽕\n"
					+"🐱결정왕 뇽뇽이 : 짜장면!\n\n"
					+"이제 철수는 결정하기 쉬어질 것입니다😃\n\n\n"
					+"🙏🏻 요청사항은 \"상담원으로 전환\" 후 문의주시면 최대한 빠르게 반영하도록하겠습니다.");
		} else if (content.contains("사다리")) {
			jobjText.setText("사다리게임은 아직 준비중이라뇽..쫌만 기다려 달라뇽!!(미소)");
			MessageButtonVO msgBtn = new MessageButtonVO();
			msgBtn.setLabel("네이버 사다리게임");
			msgBtn.setUrl("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%82%AC%EB%8B%A4%EB%A6%AC%EA%B2%8C%EC%9E%84");

			jobjText.setMessage_button(msgBtn);
			jobjText.setText("사다리게임!");
			
			res_vo.setMessage(jobjText);
			
			return res_vo;
			
		} else if (content.contains("결정") || content.contains("선택")) {
			jobjText.setText("짜장면 vs 짬뽕  요로케 물어보면 뇽뇽이가 대신 골라준다뇽(크크)");
		} else if (content.contains("졸려")) {
			jobjText.setText("졸리면 언능 세수하러 가라뇽!");
		} else if (content.contains("시간") || content.contains("몇 시")) {
			jobjText.setText("섹시(푸하하)");
		} else if (content.contains("손문")) {
			jobjText.setText("월급나오면 사주겠다뇽~");
		} else if (content.contains("나가있어")) {
			jobjText.setText("뇽뇽이 미워하지 말라뇽..(훌쩍)");
		} else if (content.contains("뇽뇽아") || "야".equals(content) ) {
			jobjText.setText("뇽뇽이 불렀뇽??(잘난척)");
		} else {
			jobjText.setText("뇽뇽이 무슨말인지 모르겠다뇽...(허걱)");
		}
		
		System.out.println("/message req="+jobjText.getText());

		res_vo.setMessage(jobjText);
//			System.out.println(jobjRes.toJSONString());

		return res_vo;
	}
		
	protected String vsFunction(RequestMessageVO resObj , String verifier) {
		System.out.println("vsFucntion content="+resObj.getContent());
		int ran = 0;
		String content = resObj.getContent();
		String question[] = content.split(verifier);
		String returnMessage = "";
		for(int i = 0 ; i < question.length ; i++){
			if(question[i].contains("죽음") || question[i].contains("자살") || question[i].contains("죽자") || question[i].contains("죽는다") ){
				returnMessage = "무서운 소리 하지 말라뇽..(눈물)";
				return returnMessage;
			}
		}
		if(question.length < 2){
			returnMessage = "뇽뇽이 그정도로 멍청하지 않다뇽!!";
		}else if(question.length == 2){
			ran = (int) (Math.random() * 100);
			System.out.println("ran2=="+ran);
			if(ran < 50){
				returnMessage = question[0]+"!";
			}else{
				returnMessage = question[1]+"!";
			}
		}else if(question.length == 3){
			ran = (int) (Math.random() * 100);
			System.out.println("ran3=="+ran);
			if(ran > 0 && ran <= 33){
				returnMessage = question[0]+"!";
			}else if(ran > 33 && ran <= 66){
				returnMessage = question[1]+"!";
			}else{
				returnMessage = question[2]+"!";
			}
		}else{
			returnMessage = "뇽뇽이 여러개 말하면 헤깔린다뇽(헤롱)";
		}
		return returnMessage;
	}
	
	
	
}
