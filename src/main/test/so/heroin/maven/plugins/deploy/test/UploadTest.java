package so.heroin.maven.plugins.deploy.test;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;

import java.io.File;
import java.io.IOException;

public class UploadTest {

    private final static String HOSTNAME = "192.168.12.111";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private final static File UPLOAD = new File("test.txt");
    private final static String PATH = "/tmp";


    public static void main(String[] args) throws IOException {
        Connection connection = new Connection(HOSTNAME, 22);
        try {
            connection.connect();
            boolean isAuth = connection.authenticateWithPassword(USERNAME, PASSWORD);
            System.err.println("auth hostname: " + HOSTNAME + " username: " + USERNAME + " password: " + PASSWORD);
            if (isAuth) {
                SCPClient scp = connection.createSCPClient();
                scp.put(UPLOAD.getAbsolutePath(), PATH);
                connection.close();
            } else {
                System.err.println("auth error, hostname: " + HOSTNAME);
            }
        } catch (IOException e) {
            System.err.println("connection to server error, hostname: " + HOSTNAME + ", " + e);
        }
    }
}
