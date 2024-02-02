package br.unicap.eng2.sincrona.portuguese;

import br.unicap.eng2.sincrona.TestHomeViewMvc;
import br.unicap.eng2.sincrona.controllers.ControllerFactory;
import br.unicap.eng2.sincrona.controllers.portuguese.PortuguesesControllerFactory;

public class TestPortuguesHomeViewMvc extends TestHomeViewMvc{

    @Override
    protected ControllerFactory getController() {
        return new PortuguesesControllerFactory();
    }

    @Override
    protected String getGreetings() {
        return "Olá!";
    }

    @Override
    protected String getMenuText() {
        return "Início";
    }
    
}
