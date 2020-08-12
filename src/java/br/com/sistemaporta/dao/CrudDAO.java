/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaporta.dao;

import br.com.sistemaporta.util.exception.ErroSistema;
import java.util.List;

/**
 *
 * @author Mario Ponce Jr
 */
public interface CrudDAO<E> //E Representa minha entidade
{
    public void salvar (E entidade) throws ErroSistema;
    public void deletar (E entidade) throws ErroSistema;
    public List<E> buscar() throws ErroSistema;
    
}
