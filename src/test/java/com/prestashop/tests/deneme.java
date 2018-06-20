package com.prestashop.tests;

import com.github.javafaker.Faker;

public class deneme {

	public static void main(String[] args) {
		Faker n = new Faker();
		
		System.out.println(n.name().firstName());

	}

}
