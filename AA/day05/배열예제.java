package day05;

import java.util.Scanner;

public class 배열예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
//		int[] a = {1,3,4,2,42,55,23,41,23,45};
//		for(int i=0; i<a.length; i++) {
//			System.out.println(a[i]);
//		}
		// a배열에 있는 모든 수의 합 출력
//		int sum=0;
//		for(int i=0; i<a.length; i++) {
//			sum+=a[i];
//		}System.out.println(sum);
//		
		// a배열에 있는 짝수의 합 출력
//		int sum = 0;
//		for(int i = 0; i<a.length; i++) {
//			if(a[i]%2==0) {
//				sum+=a[i];
//			}
//		}System.out.println("a열의 짝수 합 : "+sum);
//		// a배열에서 인덱스가 짝수인 수의 합 출력
//		int sum1=0;
//		for(int j=0; j<a.length; j++) {
//			if(j%2==0) {
//				sum1+=a[j];
//			}
//		}System.out.println("a열에서 짝수인덱스 값의 합 : "+sum1);
		
		// a배열 0~99인덱스에 1~100까지 숫자 대입
//		int[] a= new int[100];
//		for(int i=0; i<a.length; i++) {
//			a[i]=i+2;
//		}
//		for(int i =0; i<a.length; i++)}
//			System.out.println(a[i]);
//		
//		
		int[] a = new int[10];
		for(int i=0; i<a.length; i++) {
			System.out.print("a의 "+i+"인덱스 대입 : ");
			a[i] = sc.nextInt();
			
		}
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		

	}

}
