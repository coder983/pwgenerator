package edu.aws.pwgenerator;

import edu.aws.pwgenerator.domain.NamesRepository;
import edu.aws.pwgenerator.service.builder.PasswordDataLoader;
import edu.aws.pwgenerator.service.PwGeneratorService;
import edu.aws.pwgenerator.service.manager.StatusManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PwGeneratorController {

    private final PwGeneratorService service;
    private final NamesRepository namesRepository;
    private final PasswordDataLoader loader;

    public PwGeneratorController(PwGeneratorService service, NamesRepository namesRepository, PasswordDataLoader loader) {
        this.service = service;
        this.namesRepository = namesRepository;
        this.loader = loader;
    }

    StatusManager initializer = new StatusManager();

    @RequestMapping
    public String showMain(){

        return "mainview";
    }

    @RequestMapping("/password")
    public String getNewPassword(ModelMap model) {
        long pLength = 6; //TODO Temporary until password length installed
        String pw = service.getAPassword(initializer, loader, pLength);
        model.put("password", pw);
        return "mainview";
    }

    @RequestMapping("/updatesc")
    public String updateSpecialCharacters(ModelMap model) {

        return "preparation";
    }

    @RequestMapping("/procsc")
    public String processSpecialCharacters(ModelMap model){

        return "mainview";
    }


}
