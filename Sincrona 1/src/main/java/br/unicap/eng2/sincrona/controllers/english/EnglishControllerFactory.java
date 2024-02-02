package br.unicap.eng2.sincrona.controllers.english;

import br.unicap.eng2.sincrona.controllers.ControllerFactory;
import br.unicap.eng2.sincrona.views.HomeView;
import br.unicap.eng2.sincrona.views.MenuView;
import br.unicap.eng2.sincrona.views.EnglishHomeView;
import br.unicap.eng2.sincrona.views.EnglishMenuView;

public class EnglishControllerFactory implements ControllerFactory {

    @Override
    public MenuView getMenu() {
        return new EnglishMenuView();
    }

    @Override
    public HomeView getHome() {
        return new EnglishHomeView();
    }

}