package org.paranora;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("appName", "anicca-alliance");
        super.onStartup(servletContext);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(final String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }
}
