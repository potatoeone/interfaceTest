package com.lss.test.interfaceTest;

public class Nine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("九九乘法表");
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(+i+ " * " +j +" = "+ i*j+ " ");
				
				if(i==j) {
					System.out.println();
				}
			}
		}

	}

}
