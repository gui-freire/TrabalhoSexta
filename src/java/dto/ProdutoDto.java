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
public class ProdutoDto {
    private long id;
    
    private String nome;
    
    private String secao;
    
    private float preco;
    
    private int unidades;
    
    private float desconto;
    
    private int und_desconto; //UNIDADES NECESSÁRIAS PARA O DESCONTO
    
    //UMA DAS REGRAS DE NEGÓCIO: ALGUNS PRODUTOS ACIMA DE X QNTD
    //GANHAM DESCONTO

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the secao
     */
    public String getSecao() {
        return secao;
    }

    /**
     * @param secao the secao to set
     */
    public void setSecao(String secao) {
        this.secao = secao;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
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
     * @return the und_desconto
     */
    public int getUnd_desconto() {
        return und_desconto;
    }

    /**
     * @param und_desconto the und_desconto to set
     */
    public void setUnd_desconto(int und_desconto) {
        this.und_desconto = und_desconto;
    }
    
    
}
