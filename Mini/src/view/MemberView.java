package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MemberVO;

public class MemberView {
	Scanner sc = new Scanner(System.in);
	MemberVO mvo = new MemberVO();
	// 게임시작화면
	public int showMenu1() {
		System.out.println("=======메뉴=======");
		System.out.println(" [1]로그인\n [2]회원가입\n [3]게임종료");
		int input1 = sc.nextInt();
		return input1;
	}

	// 로그인 후 화면
	public int showMenu2() {
		System.out.println("=======메뉴=======");
		System.out.println(" [1]게임시작\n [2]게임설명\n [3]점수조회\n [4]게임종료");
		int input2 = sc.nextInt();

		return input2;
	}

	// 로그인 출력하는 메소드
	public MemberVO showLogin() {
		System.out.println("=====로그인=====");
		System.out.print("ID입력 : ");
		String id = sc.next();
		System.out.print("PW입력 : ");
		String pw = sc.next();
		MemberVO mvo = new MemberVO();
		mvo.setId(id); // 입력값 저장
		mvo.setPw(pw); // 입력값 저장

		return mvo;
	}
	
	// 로그인 성공여부를 출력하는 메소드
	public void statusLogin(String result) {

	       if ("NO_ID".equals(result)) {
	           System.out.println("⚠ 존재하지 않는 회원입니다. 회원가입 후 이용해주세요.");
	       } else if ("WRONG_PW".equals(result)) {
	           System.out.println("❌ 비밀번호가 올바르지 않습니다. 다시 입력해주세요.");
	       } else if ("ERROR".equals(result)) {
	           System.out.println("⚠ 시스템 오류가 발생했습니다. 잠시 후 다시 시도해주세요.");
	       } else if (result != null) {
	           // 로그인 성공 (result == 회원 이름)
	           System.out.println("로그인 성공 !");
	           System.out.println(result + "님 환영합니다 !");
	       } else {
	           System.out.println("로그인 실패 (알 수 없는 이유).");
	       }
	   }

	// 회원가입출력하는 메소드
	public MemberVO showJoin() {
		System.out.println("======회원 가입 ========");
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("PW 입력 : ");
		String pw = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		MemberVO mvo = new MemberVO();
		mvo.setId(id);
		mvo.setPw(pw);
		mvo.setName(name);
		return mvo;
	}


	// 회원가입 성공/실패를 출력하는 메소드
	public void statusJoin(int row) {
		if (row > 0) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
	}

	// 난이도선택 출력 메소드
	public int levelMenu() {
		System.out.println("=====난이도선택=====");
		System.out.println("[1]Easy [2]Normal [3]Hard");
		int level = sc.nextInt();

		return level;
	}

	// 사용자가 정답을 입력하는 출력
	public String getUseranswer() {
		System.out.println("정답을 입력하세요 : ");
		String useranswer = sc.next();
		return useranswer;
	}

	// 사용자가 잘못 입력했을 경우 출력
	public void userWrong() {
		System.out.println("자릿수가 일치하지 않습니다 다시 입력하세요");
	}

	// 정답을 맞췄을 시 게임 출력
	public void success(String num, int count) {
		System.out.println(num + " 정답입니다 !!");
		System.out.println("총 " + count + " 회 시도했습니다 !");
	}

	// 실패 했을시 게임 출력
	public void fail(int length, int[] answer) {
		System.out.println("정답을 맞추는데 실패했습니다");
		System.out.println("정답은 ");
		for (int i = 0; i < length; i++) {
			System.out.println(answer[i]);
		}
		System.out.println("입니다");
	}

	// 난이도별 점수
	public int gamePoint(int count, int level, String result) {
	    int point = 0;

	    if (level == 1) {
	        if (count <= 3) point = 30;
	        else if (count <= 6) point = 20;
	        else if (count <= 10) point = 10;
	        else point = 0;
	    } else if (level == 2) {
	        if (count <= 6) point = 60;
	        else if (count <= 14) point = 50;
	        else if (count <= 20) point = 40;
	        else point = 0;
	    } else if (level == 3) {
	        if (count <= 10) point = 100;
	        else if (count <= 20) point = 80;
	        else if (count <= 30) point = 70;
	        else point = 0;
	    }

	    // MemberVO에 결과 세팅
	    mvo.setPoint(point);
	    mvo.setCount(count);
	    mvo.setResult(result);

	    System.out.println(point + " 획득하였습니다");
	    return point;
	    
	    // DB 저장
	}


	// 결과 출력 메소드
	public void printResult(int s, int b, int count) {
		System.out.println(count + " 시도");
		System.out.println("s : " + s + " b : " + b);
	}

	// 정답 생성 메소드
	public void gameStart() {
		System.out.println("정답이 생성되었습니다");
	}

	// 임시 메소드
	public void testView(int length, int[] answer) {
		for (int i = 0; i < length; i++) {
			System.out.print(answer[i]);
		}
	}

	// 게임종료 메소드
	public void endGame() {
		System.out.println("게임이 종료되었습니다");
	}

	//게임설명
	public void showRule() {
	       System.out.println("===== 숫자 야구 게임 설명 =====\n");

	       System.out.println("1. 게임 규칙");
	       System.out.println(" 컴퓨터가 임의로 만든 숫자로 구성된 정답을 맞추는 게임입니다.");
	       System.out.println(" 플레이어는 숫자를 입력하여 정답을 추리합니다.");
	       System.out.println(" 같은 숫자가 같은 위치에 있으면 '스트라이크',");
	       System.out.println(" 같은 숫자가 다른 위치에 있으면 '볼'로 판정됩니다.");
	       System.out.println(" 같은 숫자가 하나도 없으면 '아웃'이지만, 게임에서는 따로 출력하지 않습니다.");
	       System.out.println(" 모든 숫자의 위치를 맞추면 게임에서 승리합니다! (정답 자리수 = 전부 스트라이크)\n");

	       System.out.println("2. 입력 규칙");
	       System.out.println(" 정답은 0~9까지의 숫자로 구성됩니다.");
	       System.out.println(" 같은 숫자는 중복되지 않습니다.");
	       System.out.println(" 플레이어는 난이도에 맞게 정확히 3자리 / 4자리 / 5자리 숫자를 입력해야 합니다.\n");

	       System.out.println("3. 난이도별 규칙");
	       System.out.println(" Easy (쉬움): 정답 3자리, 최대 10번 도전 가능");
	       System.out.println(" Normal (보통): 정답 4자리, 최대 20번 도전 가능");
	       System.out.println(" Hard (어려움): 정답 5자리, 최대 30번 도전 가능\n");

	       System.out.println("예시:");
	       System.out.println(" (난이도 Easy, 정답 123) 첫 입력 130 → 1 스트라이크, 1 볼 ");
	       System.out.println("                    두번째 입력 120 → 2 스트라이크 0 볼");
	       System.out.println(" (난이도 Hard, 정답 45678) 입력 48905 → 1 스트라이크 1볼");
	       System.out.println(" ※ 아웃은 별도로 출력하지 않습니다.\n");

	       System.out.println("4. 보상 점수");
	       System.out.println("Easy");
	       System.out.println(" 3회 이내 정답: 30점");
	       System.out.println(" 6회 이내 정답: 20점");
	       System.out.println(" 10회 이내 정답: 10점\n");

	       System.out.println("Normal");
	       System.out.println(" 6회 이내 정답: 60점");
	       System.out.println(" 14회 이내 정답: 50점");
	       System.out.println(" 20회 이내 정답: 40점\n");

	       System.out.println("Hard");
	       System.out.println(" 10회 이내 정답: 100점");
	       System.out.println(" 20회 이내 정답: 80점");
	       System.out.println(" 30회 이내 정답: 70점\n");

	       System.out.println("5. 게임 종료 조건");
	       System.out.println(" 정답을 맞추거나 도전 횟수를 모두 소진하면 게임이 종료됩니다.");
	       System.out.println(" 실패 시 컴퓨터가 만든 정답이 공개됩니다.");
	       System.out.println("===============================");
	   }

	// 난이도별 횟수를 세팅해야되는데 이걸 어째야할지모르겠음 우선 이건 내일 쌤들한테 물어보기
	// 추후 필요한 메소드는 프로젝트 기간동안 회의 나눠보기
	//회원정보조회
	public void showFind(ArrayList<MemberVO> list) {
		System.out.println("=== 회원정보조회 ===");
		System.out.println("ID \t 이름");
		for (MemberVO i : list) {
			System.out.println(i.getId() + "\t" + i.getName() + "\t");
		}
	}
	
	//잘못입력시 출력
	public void showError() {
		System.out.println("잘못 입력하였습니다.");
	}
}
