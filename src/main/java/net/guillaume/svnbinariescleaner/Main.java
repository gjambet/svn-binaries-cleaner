package net.guillaume.svnbinariescleaner;

import java.io.File;

public class Main {

    public static void main(String[] args) {
    	SvnBinaryCleaner cleaner = new SvnBinaryCleaner().targeting(new File("C:\\Temp\\Nesclub2\\Sources"));
    	cleaner.run();
    	System.out.println(cleaner.toString());
    }

}
