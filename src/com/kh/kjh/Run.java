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
				System.out.println("======= λ©λ΄ ======");
				System.out.println("1. λ§? ?€? ");
				System.out.println("2. ? ?  μΆλ ₯");
				System.out.println("3. κ²μ??");
				option = sc.nextInt();
				switch(option) {
				case 1 :
					System.out.println("?€? ?  player ? ?");
					System.out.println("1. player1 λ§? ?€? ");
					System.out.println("2. plater2 λ§? ?€? ");
					option = sc.nextInt();
					switch(option) {
					case 1 : 
						while(true){
							System.out.print("λ°κΎΈ?€ ??΄ ??λ²³μ ?? ₯?΄μ£ΌμΈ? : ");
							char a = sc.next().charAt(0);
							if(a == player[1].GetMal()) {
								System.out.println("player2? λ§κ³Ό μ€λ³΅?©??€.");
							}else {
								player[0].SetMal(a);
								break;
							}
						}
				         break;
					case 2 : 
						while(true){
							System.out.print("λ°κΎΈ?€ ??΄ ??λ²³μ ?? ₯?΄μ£ΌμΈ? : ");
							char a = sc.next().charAt(0);
							if(player[0].GetMal() == a) {
								System.out.println("player1? λ§κ³Ό μ€λ³΅?©??€.");
							}else {
								player[1].SetMal(a);
								break;
							}						
						}
						break;
					}
					break;
				case 2 : 
					System.out.println("player1 ? ? "); 
					player[0].ShowLate();
					System.out.println("player2 ? ? ");
					player[1].ShowLate();
					break;
				case 3 : 
						NG.cleanBoard();
						END:
						while (true) {
							NG.printBoard();
							switch (count % 2) {
							case 0:
								System.out.println("player1 μ°¨λ?");
								if(NG.input(player[0].GetMal())) {
									NG.victory();
									if (NG.victory()) {
										NG.printBoard();
										System.out.println("player1 ?Ήλ¦?");
										player[0].upWin();
										player[1].uplose();
										break END;
									}
									count++;
									break;						
								}
								else {
									System.out.println("?΄λ―? ? κ³³μ??€ ?€? ?? ₯?΄μ£ΌμΈ?");
									break;
								}
							case 1:
								System.out.println("player2 μ°¨λ?");
								if(NG.input(player[1].GetMal())) {
									NG.victory();
									if (NG.victory()) {
										NG.printBoard();
										System.out.println("player2 ?Ήλ¦?");
										player[1].upWin();
										player[0].uplose();
										break END;
									}
									count++;
									break;								
								}
								else {
									System.out.println("?΄λ―? ? κ³³μ??€ ?€? ?? ₯?΄μ£ΌμΈ?");
								     break;
								}
							}
							
						}
					break;
				}
			}
				
			}

	}