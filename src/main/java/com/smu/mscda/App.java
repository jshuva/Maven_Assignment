package com.smu.mscda;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.Scanner;

/**
 * Maven Assignment – MCDA 5512
 *
 * Takes a lowercase string from the user, capitalizes it using
 * Apache Commons Lang3 (StringUtils), and prints its MD5 hex digest
 * using Apache Commons Codec (DigestUtils).
 */
public class App {

    public static void main(String[] args) {

        System.out.println("This program will capitalize the input string and generate hex hex!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().trim();
        scanner.close();

        // Capitalize: first letter of each word becomes uppercase
        // Using Apache Commons Lang3 StringUtils to demonstrate the dependency
        String capitalized = StringUtils.capitalize(input);

        // Generate MD5 hex digest using Apache Commons Codec
        String md5Hex = DigestUtils.md5Hex(input);

        System.out.println("Capitalized string is: " + capitalized);
        System.out.println("MD5 Hex is: " + md5Hex);
    }
}
