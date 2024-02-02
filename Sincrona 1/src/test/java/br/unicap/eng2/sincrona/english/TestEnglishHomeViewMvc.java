package br.unicap.eng2.sincrona.english;

import br.unicap.eng2.sincrona.TestHomeViewMvc;
import br.unicap.eng2.sincrona.controllers.ControllerFactory;
import br.unicap.eng2.sincrona.controllers.english.EnglishControllerFactory;

public class TestEnglishHomeViewMvc extends TestHomeViewMvc{

    @Override
    protected ControllerFactory getController() {
        return new EnglishControllerFactory();
    }

    @Override
    protected String getMenuText(){
        return "Home";
    }

    @Override
    protected String getGreetings() {
        return "Hello!";
    }
    
}
