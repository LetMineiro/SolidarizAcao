/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidarizacao.model;

/**
 *
 * @author Janylson
 */
public class Doacao {
    private int id;
    private int idDoador;
    private int roupas, calcados, livros, brinquedos, alimentos, outroQtd;
    private String outroItem;

    // getters e setters
    public int getIdDoador() { return idDoador; }
    public void setIdDoador(int idDoador) { this.idDoador = idDoador; }
    public int getRoupas() { return roupas; }
    public void setRoupas(int roupas) { this.roupas = roupas; }
    public int getCalcados() { return calcados; }
    public void setCalcados(int calcados) { this.calcados = calcados; }
    public int getLivros() { return livros; }
    public void setLivros(int livros) { this.livros = livros; }
    public int getBrinquedos() { return brinquedos; }
    public void setBrinquedos(int brinquedos) { this.brinquedos = brinquedos; }
    public int getAlimentos() { return alimentos; }
    public void setAlimentos(int alimentos) { this.alimentos = alimentos; }
    public int getOutroQtd() { return outroQtd; }
    public void setOutroQtd(int outroQtd) { this.outroQtd = outroQtd; }
    public String getOutroItem() { return outroItem; }
    public void setOutroItem(String outroItem) { this.outroItem = outroItem; }
}
