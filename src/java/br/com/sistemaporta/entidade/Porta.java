/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaporta.entidade;

import java.util.Date;

/**
 *
 * @author Mario Ponce Jr
 */
public class Porta {
    private Integer idporta;
    private String nome;
    private Date momento;
    private boolean status;
    private String info;

    public Integer getIdporta() {
        return idporta;
    }

    public void setIdporta(Integer idporta) {
        this.idporta = idporta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idporta;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Porta other = (Porta) obj;
        if (this.idporta != other.idporta) {
            return false;
        }
        return true;
    }

    public void add(Porta porta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
