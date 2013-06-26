package net.guillaume.svnbinariescleaner.maven;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class DeployFileCommandBuilderTest {

    private DeployFileCommandBuilder command;

    @Before
    public void before() {
	command = new DeployFileCommandBuilder("repositoryId", "repositoryUrl");
    }

    @Test
    public void shouldUpload() {
	File root = new File("");
	File file = new File("target\\test-classes\\pipo\\bimbo/dummy.txt");
	MavenFileShell adapter = new MavenFileShell(root, file);

	String cmd = command.buildFor(adapter);

	System.out.println(cmd);
    }

}
