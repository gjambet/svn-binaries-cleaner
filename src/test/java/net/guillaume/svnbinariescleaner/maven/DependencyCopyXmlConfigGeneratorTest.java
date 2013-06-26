package net.guillaume.svnbinariescleaner.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DependencyCopyXmlConfigGeneratorTest {

    private List<MavenFileShell> adapters;

    @Before
    public void before() {

	adapters = new ArrayList<MavenFileShell>();
	File root = new File("");
	File file = new File("target/test-classes/pipo/bimbo/dummy.txt");
	adapters.add(new MavenFileShell(root, file));

    }

    @Test
    public void nominal() {

	String cmd = new DependencyCopyXmlConfigGenerator().with(adapters).toString();

	System.out.println(cmd);

    }

}
