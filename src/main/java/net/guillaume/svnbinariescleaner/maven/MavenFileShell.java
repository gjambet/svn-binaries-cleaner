package net.guillaume.svnbinariescleaner.maven;

import java.io.File;

public class MavenFileShell {

    private File file;
    private File root;
    private Dependency dependency;

    public MavenFileShell(File root, File file) {
	this.file = file;
	this.root = root;
	this.dependency = new Dependency(file.getName(), getOutputDirectory());
    }

    public Dependency getDependency() {
	return dependency;
    }

    public String getOutputDirectory() {
	String full = file.getAbsolutePath();
	full = full.substring(root.getAbsolutePath().length() + File.pathSeparator.length());
	full = full.substring(0, full.length() - (File.pathSeparator.length() + file.getName().length()));
	return full;
    }

    public String getDestFileName() {
	return file.getName();
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("File : " + file.getAbsolutePath() + " : " + file.length() + '\n');
	sb.append("MavenFileShell outputDirectory : " + getOutputDirectory() + '\n');
	sb.append("MavenFileShell destFileName : " + getDestFileName() + '\n');
	sb.append("Dependency - groupId : " + dependency.getGroupId() + '\n');
	sb.append("Dependency - artifactId : " + dependency.getArtifactId() + '\n');
	sb.append("Dependency - Version : " + dependency.getVersion() + '\n');
	sb.append("Dependency - packaging : " + dependency.getPackaging() + '\n');
	return sb.toString();
    }

    public File getFile() {
	return file;
    }
}
