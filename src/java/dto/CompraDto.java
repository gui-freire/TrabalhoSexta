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
    
    private ProdutoDto produto;
    
    private int unidades;
    
    private float precoTotal;
    
    private float qntdDesconto; //A CADA X REAIS EM COMPRAS GANHA DESCONTO
    
    private float desconto;

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
     * @return the produto
     */
    public ProdutoDto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ProdutoDto produto) {
        this.produto = produto;
    }

    /**
     * @return the unidades
     */
    public int getUnidades() {
        return unidades;
    }

    /**
     * @param unidades the unidades to set
     */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
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
     * @return the qntdDesconto
     */
    public float getQntdDesconto() {
        return qntdDesconto;
    }

    /**
     * @param qntdDesconto the qntdDesconto to set
     */
    public void setQntdDesconto(float qntdDesconto) {
        this.qntdDesconto = qntdDesconto;
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
    
    
}
