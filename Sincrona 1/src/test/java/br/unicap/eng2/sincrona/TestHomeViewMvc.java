package br.unicap.eng2.sincrona;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unicap.eng2.sincrona.views.HomeView;
import br.unicap.eng2.sincrona.views.MenuView;
import br.unicap.eng2.sincrona.controllers.ControllerFactory;


public abstract class TestHomeViewMvc {


  protected abstract ControllerFactory getController();
  protected ControllerFactory controller;

  protected abstract String getGreetings();
  protected abstract String getMenuText();

  @BeforeEach
  public void setUp() {
    controller = getController();
  }

  @Test
  public void testGreetings() {
    HomeView home = controller.getHome();
    String expected = getGreetings();
    String actual = home.getGreetings();
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void testMenu(){
    MenuView menu = controller.getMenu();
    String expected = getMenuText();
    String actual = menu.getText();
    Assertions.assertEquals(expected, actual);
  }
 
}
