package net.guillaume.svnbinariescleaner.maven;

public class DeployFileCommandBuilder {

	private String repositoryId;
	private String repositoryUrl;

	public DeployFileCommandBuilder(String repositoryId, String repositoryUrl) {
		super();
		this.repositoryId = repositoryId;
		this.repositoryUrl = repositoryUrl;
	}

	public String buildFor(MavenFileShell adapter) {

		Dependency dependency = adapter.getDependency();

		StringBuilder sb = new StringBuilder();
		sb.append("mvn deploy:deploy-file ");
		sb.append("-Dfile=" + adapter.getFile().getPath() + " ");

		sb.append("-DgroupId=" + dependency.getGroupId() + " ");
		sb.append("-DartifactId=" + dependency.getArtifactId() + " ");
		sb.append("-Dversion=" + dependency.getVersion() + " ");
		sb.append("-Dpackaging=" + dependency.getPackaging() + " ");
		
		sb.append("-DrepositoryId=" + repositoryId + " ");
		sb.append("-Durl=" + repositoryUrl + " ");

		return sb.toString();

	}

}
