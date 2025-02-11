package com.thymeleaf.demo.dto;

public enum Etype {
  SUCCESS("Common","success"),
  FALSE("Common","false"),
  EXCEPTION("Common","exception");
  public final String screen;
  public final String message;

  private Etype(String screen, String message){
    this.screen = screen;
    this.message = message;
  }


}
