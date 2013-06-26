package net.guillaume.svnbinariescleaner.maven;

import java.util.List;

public class DependencyCopyXmlConfigGenerator {

    private List<MavenFileShell> adapters;
    private static final String TAB = "    ";

    public DependencyCopyXmlConfigGenerator with(List<MavenFileShell> adapters){
	this.adapters = adapters;
	return this;
    }
    
    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append("<plugin>\n");
	sb.append(TAB + "<groupId>org.apache.maven.plugins</groupId>\n");
	sb.append(TAB + "<artifactId>maven-dependency-plugin</artifactId>\n");
	sb.append(TAB + "<version>2.6</version>\n");
	sb.append(TAB + "<executions>\n");
	sb.append(TAB + TAB + "<execution>\n");
	sb.append(TAB + TAB + TAB + "<id>copy</id>\n");
	sb.append(TAB + TAB + TAB + "<phase>package</phase>\n");
	sb.append(TAB + TAB + TAB + "<goals>\n");
	sb.append(TAB + TAB + TAB + TAB + "<goal>copy</goal>\n");
	sb.append(TAB + TAB + TAB + "</goals>\n");
	sb.append(TAB + TAB + TAB + "<configuration>\n");
	sb.append(TAB + TAB + TAB + TAB + "<artifactItems>\n");

	for (MavenFileShell adapter : adapters) {

	    Dependency d = adapter.getDependency();

	    sb.append(TAB + TAB + TAB + TAB + TAB + "<artifactItem>\n");
	    sb.append(TAB + TAB + TAB + TAB + TAB + TAB + "<groupId>" + d.getGroupId() + "</groupId>\n");
	    sb.append(TAB + TAB + TAB + TAB + TAB + TAB + "<artifactId>" + d.getArtifactId() + "</artifactId>\n");
	    sb.append(TAB + TAB + TAB + TAB + TAB + TAB + "<version>" + d.getVersion() + "</version>\n");
	    sb.append(TAB + TAB + TAB + TAB + TAB + TAB + "<type>" + d.getPackaging() + "</type>\n");
	    // sb.append("<overWrite>false</overWrite>\n");
	    sb.append(TAB + TAB + TAB + TAB + TAB + TAB + "<outputDirectory>${basedir}/" + adapter.getOutputDirectory() + "</outputDirectory>\n");
	    sb.append(TAB + TAB + TAB + TAB + TAB + TAB + "<destFileName>" + adapter.getDestFileName() + "</destFileName>\n");
	    sb.append(TAB + TAB + TAB + TAB + TAB + "</artifactItem>\n");
	}

	sb.append(TAB + TAB + TAB + TAB + "</artifactItems>\n");

	// sb.append("<outputDirectory>${project.build.directory}/wars</outputDirectory>\n");
	// sb.append("<overWriteReleases>false</overWriteReleases>\n");
	// sb.append("<overWriteSnapshots>true</overWriteSnapshots>\n");

	sb.append(TAB + TAB + TAB + "</configuration>\n");
	sb.append(TAB + TAB + "</execution>\n");
	sb.append(TAB + "</executions>\n");
	sb.append("</plugin>\n");

	return sb.toString();
    }

}
