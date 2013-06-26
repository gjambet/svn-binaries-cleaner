package net.guillaume.svnbinariescleaner.maven;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

public class MavenFileShellTest {

    @Test
    public void shouldGetCorrectTargetPath() {
	File root = new File("");
	File file = new File("target\\test-classes\\pipo\\bimbo/dummy.txt");

	MavenFileShell adapter = new MavenFileShell(root, file);

	Assert.assertEquals(file.getName(), adapter.getDestFileName());
	Assert.assertEquals("target\\test-classes\\pipo\\bimbo", adapter.getOutputDirectory());
    }

}
