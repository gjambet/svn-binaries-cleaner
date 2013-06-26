package net.guillaume.svnbinariescleaner.maven;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MavenRunner {

    private static String ls_str;

    public static void run(String arg) {

	try {

	    Process ls_proc;

	    // we want to run command "mvn clean install"
	    // It is expected that "mvn" is in your PATH
	    // String arg = "mvn clean install";

	    // We are storing the OS on system in String OS
	    String OS = System.getProperty("os.name");
	    System.out.println("OS is: " + OS);

	    if (OS.contains("Windows")) {
		ls_proc = Runtime.getRuntime().exec("cmd.exe /C " + arg);
	    } else {
		ls_proc = Runtime.getRuntime().exec(arg);
	    }

	    // if (OS.contains("Windows")) {
	    // ls_proc =
	    // Runtime.getRuntime().exec("cmd.exe /C mvn clean install /users/bin/");
	    // } else {
	    // ls_proc =
	    // Runtime.getRuntime().exec("mvn clean install /users/bin/");
	    // }

	    // We can also display the output of the command Here
	    DataInputStream ls_in = new DataInputStream(ls_proc.getInputStream());
	    try {
		BufferedReader br = new BufferedReader(new InputStreamReader(ls_in));
		while ((ls_str = br.readLine()) != null) {
		    System.out.println(ls_str);
		}
	    } catch (IOException e) {
		System.out.println(e.toString());
		e.printStackTrace();
	    }
	} catch (Exception e) {
	    System.out.println(e.toString());
	    e.printStackTrace();

	}
    }
}
