package jp.uggds.release;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.concurrent.*;

/**
 * @auther uga
 */
public class ReleaseMojoTest {
    @Test
    public void test() throws MojoFailureException, MojoExecutionException, ExecutionException, InterruptedException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Y\r\n".getBytes());
        System.setIn(byteArrayInputStream);
        final ReleaseMojo mojo = new ReleaseMojo();
        mojo.depends = "core,common,entity";
        mojo.execute();
    }
}