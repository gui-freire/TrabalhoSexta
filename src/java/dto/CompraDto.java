/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author internet
 */
public class CompraDto {
    private long id;
    
    private float precoTotal;
    
    private float desconto;
    
    private float precoComDesconto;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the precoTotal
     */
    public float getPrecoTotal() {
        return precoTotal;
    }

    /**
     * @param precoTotal the precoTotal to set
     */
    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    /**
     * @return the desconto
     */
    public float getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the precoComDesconto
     */
    public float getPrecoComDesconto() {
        return precoComDesconto;
    }

    /**
     * @param precoComDesconto the precoComDesconto to set
     */
    public void setPrecoComDesconto(float precoComDesconto) {
        this.precoComDesconto = precoComDesconto;
    }
    
    
}
