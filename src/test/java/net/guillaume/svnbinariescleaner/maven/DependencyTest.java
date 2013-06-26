package net.guillaume.svnbinariescleaner.maven;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

public class DependencyTest {

    private final String DUMMY_DEPENDENCY = "<dependency>\n\t<groupId>target.test-classes.pipo.bimbo</groupId>\n\t<artifactId>dummy.txt</artifactId>\n\t<version>1.0</version>\n</dependency>\n";

    @Test
    public void shouldBuildDependencyDescriptor() {

	File f = new File("target/test-classes/pipo/bimbo/dummy.txt");
	Dependency d = new Dependency(f.getName(), "target/test-classes/pipo/bimbo");

	Assert.assertEquals(DUMMY_DEPENDENCY, d.toString());

	System.out.println(f.getAbsolutePath());
	System.out.println(d.toString());

    }

}
