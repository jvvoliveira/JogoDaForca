/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;

/**
 *
 * @author Victor Oliveira
 */
public class Forca {

    private String palavra;
    private char[] acertos;
    private char[] erros;
    private int tentativas; //número de vezes que pode errar

    public Forca(String palavra) {
        this.palavra = palavra;
        this.acertos = new char[palavra.length()];
        this.erros = new char[5];
        this.tentativas = 5;

        for (int i = 0; i < this.palavra.length(); i++) {
            this.acertos[i] = '_';
        }
    }

    public boolean fazerPalpite(char letra) {
        if (this.tentativas > 0) {
            boolean possui = false;
            for (int i = 0; i < this.palavra.length(); i++) {
                if (this.palavra.charAt(i) == letra) {
                    this.acertos[i] = letra;
                    possui = true;
                }
            }
            if (possui) {
                return true;
            } else {
                this.erros[tentativas - 1] = letra;
                this.tentativas--;
                return false;
            }
        }
        return false;
    }
    //verifica se as palavras são iguais
    public boolean jogoGanho(){
        boolean ganho = false;
        for(int i = 0; i < this.acertos.length; i++){
            if(this.palavra.charAt(i) != this.acertos[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * @return the palavra
     */
    public String getPalavra() {
        return palavra;
    }

    /**
     * @param palavra the palavra to set
     */
    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    /**
     * @return the acertos
     */
    public char[] getAcertos() {
        return acertos;
    }

    /**
     * @param acertos the acertos to set
     */
    public void setAcertos(char[] acertos) {
        this.setAcertos(acertos);
    }

    /**
     * @return the erros
     */
    public char[] getErros() {
        return erros;
    }

    /**
     * @param erros the erros to set
     */
    public void setErros(char[] erros) {
        this.setErros(erros);
    }

    /**
     * @param acertos the acertos to set
     */
    /**
     * @return the tentativas
     */
    public int getTentativas() {
        return tentativas;
    }

    /**
     * @param tentativas the tentativas to set
     */
    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }
}
