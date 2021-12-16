package com.Vtiger.genericUtil;

import java.util.Random;

import com.github.javafaker.Faker;

public class JavaUtil {

	public static JavaUtil objForJavaUtil() {
		JavaUtil jv = new JavaUtil();
		return jv;

	}


	/**
	 * @author HP Description : this method generate Random numbers
	 * @return random number
	 * 
	 */

	public int generateRandomNumber() {

		Random r = new Random();
		return r.nextInt(1000);
	}

	/**
	 * @author HP Description Entering the duplicate names
	 * @return duplicate names
	 */

	public String getfullname() {
		Faker faker = new Faker();
		return faker.name().fullName();
	}

	public String getfirstname() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}

	public String getlastname() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}
	public String GetPhonenumber() {
		Faker fake = new Faker();
		return fake.phoneNumber().cellPhone();
		
		
	}

}
