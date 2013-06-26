package net.guillaume.svnbinariescleaner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.guillaume.svnbinariescleaner.maven.DependencyCopyXmlConfigGenerator;
import net.guillaume.svnbinariescleaner.maven.DeployFileCommandBuilder;
import net.guillaume.svnbinariescleaner.maven.MavenFileShell;
import net.guillaume.svnbinariescleaner.maven.MavenRunner;

public class SvnBinaryCleaner {

    private File root;
    private List<MavenFileShell> adapters;

    public SvnBinaryCleaner() {
	adapters = new ArrayList<MavenFileShell>();
    }

    public void run() {
	int files = 0;
	long size = 0;
	// BinaryFinder walker = new
	// BinaryFinder(root).withMinKbSize(200).withExtensions(".jar",
	// ".zipped");
	BinaryFinder walker = new BinaryFinder(root).withExtensions(".jar", ".zip");
	// BinaryFinder walker = new BinaryFinder(root).withMinKbSize(500);
	for (File f : walker.getFiles()) {
	    files++;
	    size += f.length();

	    System.out.println(root.getAbsolutePath());
	    System.out.println(f.getAbsolutePath());

	    adapters.add(new MavenFileShell(root, f));
	}

	System.out.println("Found : " + files + ", for a total space of : " + size + " bytes");

	for (MavenFileShell ma : adapters) {
	    DeployFileCommandBuilder cmd = new DeployFileCommandBuilder("nexus-oups", "http://nexus.oups.net/content/repositories/releases/");
	    System.out.println(cmd.buildFor(ma));
	    MavenRunner.run(cmd.buildFor(ma));
	}

	String cmd = new DependencyCopyXmlConfigGenerator().with(adapters).toString();
	System.out.println(cmd);

    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	for (MavenFileShell ma : adapters) {
	    sb.append(ma.toString() + '\n');
	}
	return sb.toString();
    }

    public SvnBinaryCleaner targeting(File root) {
	this.root = root;
	return this;
    }

}
