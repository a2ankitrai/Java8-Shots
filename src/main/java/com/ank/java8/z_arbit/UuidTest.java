package com.ank.java8.z_arbit;

import java.util.UUID;

public class UuidTest {

    public static void main(String[] args) {
	
	UUID uid1 = UUID.fromString("72da5358-9282-418e-96d9-1e00465f3a9f"); 
	System.out.println("UUID :" + uid1.toString());
	System.out.println("UUID Version : "+uid1.version());
	
	System.out.println("===========================================");
	UUID uid2 = UUID.randomUUID();

	System.out.println("UUID :" + uid2.toString()); 
	System.out.println("UUID Version : "+uid2.version());

	System.out.println("===========================================");
	
	byte[] arr = new byte[4];
	arr[0] = 24;
	arr[1] = 1;
	arr[2] = 2;
	arr[3] = 3;

	UUID uid3 = UUID.nameUUIDFromBytes(arr);
	System.out.println("UUID :" + uid3.toString());
	System.out.println("UUID Version : "+uid3.version());
	
    }
}
