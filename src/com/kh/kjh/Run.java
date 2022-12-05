package com.kh.kjh;

import java.util.Scanner;




public class Run {
	public static void main(String[] args) {
		FiveStoneFunction NG;
		NG = new FiveStoneFunction();
		int count = 0;
		int option = 0;
		Scanner sc = new Scanner(System.in);
		Player[] player = new Player[2];
		player[0] = new Player();
		player[1] = new Player();
		player[0].SetMal('o');
		player[1].SetMal('x');
		while(true) {
			System.out.println("======= 메뉴 ======");
			System.out.println("1. 말 설정");
			System.out.println("2. 전적 출력");
			System.out.println("3. 게임시작");
			option = sc.nextInt();
			switch(option) {
			case 1 :
				System.out.println("설정할 player 선택");
				System.out.println("1. player1 말 설정");
				System.out.println("2. plater2 말 설정");
				option = sc.nextInt();
				switch(option) {
				case 1 : 
					while(true){
						System.out.print("바꾸실 영어 알파벳을 입력해주세요 : ");
						char a = sc.next().charAt(0);
						if(a == player[1].GetMal()) {
							System.out.println("player2의 말과 중복됩니다.");
						}else {
							player[0].SetMal(a);
							break;
						}
					}
			         break;
				case 2 : 
					while(true){
						System.out.print("바꾸실 영어 알파벳을 입력해주세요 : ");
						char a = sc.next().charAt(0);
						if(player[0].GetMal() == a) {
							System.out.println("player1의 말과 중복됩니다.");
						}else {
							player[1].SetMal(a);
							break;
						}						
					}
					break;
				}
				break;
			case 2 : 
				System.out.println("player1 전적"); 
				player[0].ShowLate();
				System.out.println("player2 전적");
				player[1].ShowLate();
				break;
			case 3 : 
					NG.cleanBoard();
					END:
					while (true) {
						NG.printBoard();
						switch (count % 2) {
						case 0:
							System.out.println("player1 차례");
							if(NG.input(player[0].GetMal())) {
								NG.victory();
								if (NG.victory()) {
									NG.printBoard();
									System.out.println("player1 승리");
									player[0].upWin();
									player[1].uplose();
									break END;
								}
								count++;
								break;						
							}
							else {
								System.out.println("이미 둔 곳입니다 다시 입력해주세요");
								break;
							}
						case 1:
							System.out.println("player2 차례");
							if(NG.input(player[1].GetMal())) {
								NG.victory();
								if (NG.victory()) {
									NG.printBoard();
									System.out.println("player2 승리");
									player[1].upWin();
									player[0].uplose();
									break END;
								}
								count++;
								break;								
							}
							else {
								System.out.println("이미 둔 곳입니다 다시 입력해주세요");
							     break;
							}
						}
						
					}
				break;
			}
		}
			
		}

}