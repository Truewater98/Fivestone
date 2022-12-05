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
				System.out.println("======= ë©”ë‰´ ======");
				System.out.println("1. ë§? ?„¤? •");
				System.out.println("2. ? „?  ì¶œë ¥");
				System.out.println("3. ê²Œì„?‹œ?‘");
				option = sc.nextInt();
				switch(option) {
				case 1 :
					System.out.println("?„¤? •?•  player ?„ ?ƒ");
					System.out.println("1. player1 ë§? ?„¤? •");
					System.out.println("2. plater2 ë§? ?„¤? •");
					option = sc.nextInt();
					switch(option) {
					case 1 : 
						while(true){
							System.out.print("ë°”ê¾¸?‹¤ ?˜?–´ ?•Œ?ŒŒë²³ì„ ?…? ¥?•´ì£¼ì„¸?š” : ");
							char a = sc.next().charAt(0);
							if(a == player[1].GetMal()) {
								System.out.println("player2?˜ ë§ê³¼ ì¤‘ë³µ?©?‹ˆ?‹¤.");
							}else {
								player[0].SetMal(a);
								break;
							}
						}
				         break;
					case 2 : 
						while(true){
							System.out.print("ë°”ê¾¸?‹¤ ?˜?–´ ?•Œ?ŒŒë²³ì„ ?…? ¥?•´ì£¼ì„¸?š” : ");
							char a = sc.next().charAt(0);
							if(player[0].GetMal() == a) {
								System.out.println("player1?˜ ë§ê³¼ ì¤‘ë³µ?©?‹ˆ?‹¤.");
							}else {
								player[1].SetMal(a);
								break;
							}						
						}
						break;
					}
					break;
				case 2 : 
					System.out.println("player1 ? „? "); 
					player[0].ShowLate();
					System.out.println("player2 ? „? ");
					player[1].ShowLate();
					break;
				case 3 : 
						NG.cleanBoard();
						END:
						while (true) {
							NG.printBoard();
							switch (count % 2) {
							case 0:
								System.out.println("player1 ì°¨ë?");
								if(NG.input(player[0].GetMal())) {
									NG.victory();
									if (NG.victory()) {
										NG.printBoard();
										System.out.println("player1 ?Š¹ë¦?");
										player[0].upWin();
										player[1].uplose();
										break END;
									}
									count++;
									break;						
								}
								else {
									System.out.println("?´ë¯? ?‘” ê³³ì…?‹ˆ?‹¤ ?‹¤?‹œ ?…? ¥?•´ì£¼ì„¸?š”");
									break;
								}
							case 1:
								System.out.println("player2 ì°¨ë?");
								if(NG.input(player[1].GetMal())) {
									NG.victory();
									if (NG.victory()) {
										NG.printBoard();
										System.out.println("player2 ?Š¹ë¦?");
										player[1].upWin();
										player[0].uplose();
										break END;
									}
									count++;
									break;								
								}
								else {
									System.out.println("?´ë¯? ?‘” ê³³ì…?‹ˆ?‹¤ ?‹¤?‹œ ?…? ¥?•´ì£¼ì„¸?š”");
								     break;
								}
							}
							
						}
					break;
				}
			}
				
			}

	}