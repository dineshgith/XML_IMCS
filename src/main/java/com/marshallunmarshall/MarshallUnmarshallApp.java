package com.marshallunmarshall;

import java.util.Scanner;

public class MarshallUnmarshallApp {

	public static void main(String[] args) {
		while (true) {
			System.out.println("Welcome!\n");
			System.out.println("1. Marshall");
			System.out.println("2. Unmarshall");
			System.out.println("\n");
			System.out.println("Provide your choice");
			Scanner sc = new Scanner(System.in);
			int selector = sc.nextInt();
			switch (selector) {

			case 1:
				MarshallUnmarshall mar = new MarshallUnmarshall();
				mar.marshall();
				System.out.println("\n");
				break;
			case 2:
				MarshallUnmarshall unm = new MarshallUnmarshall();
				unm.unMarshall();
				System.out.println("\n");
				break;

			}

		}
	}
}
