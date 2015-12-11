package jp.uggds.release;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @auther uga
 */
@Mojo(name = "jp/uggds/release")
public class ReleaseMojo extends AbstractMojo {

    @Parameter(required = true)
    protected String depends;

    public void execute() throws MojoExecutionException, MojoFailureException {

        String[] dependencies = depends.split(",");
        for (String dependency : dependencies) {
            stdin(dependency);
        }
    }

    public void stdin(String dependency) {

        System.out.println("Is " + dependency +" up? (Y/N)");
        try (BufferedReader stdReader =
                     new BufferedReader(new InputStreamReader(System.in)) ) {
            String line;
            while ((line = stdReader.readLine()) != null) { // ユーザの一行入力を待つ
                if (line.equals("Y")) {
                    System.out.println(dependency + "'s version up to 0.2.30");
                }
                System.exit(0); // プログラムを終了
            }
        } catch (Exception e) {
            e.getStackTrace();
            System.exit(-1); // プログラムを終了
        }
    }
}
