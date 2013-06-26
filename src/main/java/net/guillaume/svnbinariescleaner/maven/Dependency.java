package net.guillaume.svnbinariescleaner.maven;

public class Dependency {

    private String fileName;
    private String relativePath;

    public Dependency(String fileName, String relativePath) {
	this.fileName = fileName;
	this.relativePath = relativePath;
    }

    public String getArtifactId() {
	return fileName;
    }

    public String getGroupId() {
	return clean(relativePath);
    }

    private String clean(String relativePath) {
	relativePath = relativePath.replace('/', '.');
	relativePath = relativePath.replace('\\', '.');
	return relativePath;
    }

    // FIXME : set version en param de lancement
    public String getVersion() {
	return "1.0";
    }

    public String getPackaging() {
	return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("<dependency>\n");
	sb.append("\t<groupId>");
	sb.append(getGroupId());
	sb.append("</groupId>\n");
	sb.append("\t<artifactId>");
	sb.append(getArtifactId());
	sb.append("</artifactId>\n");
	sb.append("\t<version>");
	sb.append(getVersion());
	sb.append("</version>\n");
	sb.append("</dependency>\n");
	return sb.toString();
    }
}
