package sailsandheroes.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sailsandheroes.demo.Service.ShipService;

@Controller
public class ShipController {

    @Autowired
    ShipService shipService;



}
