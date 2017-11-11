package ru.edhunter.independent_seatwork.gof_patterns.proxy.project;

public class ProxyProject implements Project{
    private String url;
    private Project project;

    public ProxyProject(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        if(project == null) project = new RealProject(url);
        project.run();
    }
}
