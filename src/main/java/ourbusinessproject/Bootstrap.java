package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bootstrap {

    private InitializationService initializationService;

    @Autowired
    public Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    @PostConstruct
    public void init() {
        try {
            initializationService.initProjects();
            initializationService.initPartnerships();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InitializationService getInitializationService() {
        return initializationService;
    }
}
