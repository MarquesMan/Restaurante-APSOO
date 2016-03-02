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
public class Mesa {
    
    private final int idmesa;
    private final String status;

    public Mesa(int idmesa, String status) {
        this.idmesa = idmesa;
        this.status = status;
    }

    public int getIdmesa() {
        return idmesa;
    }

    public String getStatus() {
        return status;
    }
    
}
