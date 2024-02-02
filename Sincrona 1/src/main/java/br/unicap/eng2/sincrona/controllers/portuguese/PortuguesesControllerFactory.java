package br.unicap.eng2.sincrona.controllers.portuguese;

import br.unicap.eng2.sincrona.controllers.ControllerFactory;
import br.unicap.eng2.sincrona.views.HomeView;
import br.unicap.eng2.sincrona.views.MenuView;
import br.unicap.eng2.sincrona.views.PortugueseHomeView;
import br.unicap.eng2.sincrona.views.PortugueseMenuView;

public class PortuguesesControllerFactory implements ControllerFactory {

    @Override
    public MenuView getMenu() {
        return new PortugueseMenuView();
    }
    @Override
    public HomeView getHome() {
        return new PortugueseHomeView();
    }
}