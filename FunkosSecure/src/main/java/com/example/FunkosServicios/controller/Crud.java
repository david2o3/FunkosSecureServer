package com.example.FunkosServicios.controller;

public interface Crud <T>{
    T getFunko();

    T postFunko();

    T putFunko();

    T patchFunko();

    void deleteFunko();


}
