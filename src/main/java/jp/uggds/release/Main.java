package jp.uggds.release;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * @auther uga
 */
public class Main {
    public static void main(String[] args) throws MojoFailureException, MojoExecutionException {
        ReleaseMojo mojo = new ReleaseMojo();
        mojo.depends = "core,common,entity";
        mojo.execute();
    }
}
