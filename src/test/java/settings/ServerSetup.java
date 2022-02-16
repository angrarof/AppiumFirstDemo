package settings;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ServerSetup {
    private final AppiumDriverLocalService server;

    public ServerSetup(){
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingAnyFreePort();
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();
    }

    public void StopServer(){
        System.out.println("--------------Stopping server");
        server.stop();
    }

    public AppiumDriverLocalService getServer(){
        return server;
    }

}
