/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entitys;

/**
 *
 * @author pet
 */
public class Categoria {
    
    private final int idcategoria;
    private final String nome;

    public int getIdcategoria() {
        return idcategoria;
    }

    public String getNome() {
        return nome;
    }

    public Categoria(int idcategoria, String nome) {
        this.idcategoria = idcategoria;
        this.nome = nome;
    }
}
