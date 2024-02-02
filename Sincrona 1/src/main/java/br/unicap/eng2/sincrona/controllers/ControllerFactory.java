package br.unicap.eng2.sincrona.controllers;

import br.unicap.eng2.sincrona.views.MenuView;
import br.unicap.eng2.sincrona.views.HomeView;

public interface ControllerFactory {
    MenuView getMenu();
    HomeView getHome();
}
