/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaporta.bean;

import br.com.sistemaporta.dao.PortaDAO;
import br.com.sistemaporta.entidade.Porta;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author Mario Ponce Jr
 */
@ManagedBean
@SessionScoped
public class PortaBean extends CrudBean<Porta, PortaDAO>
{
    private PortaDAO portaDAO;
    
    @Override
    public PortaDAO getDao() 
    {
        if(portaDAO == null)
        {
            portaDAO = new PortaDAO();
        }
        return portaDAO;
    }
    
    @Override
    public Porta criarNovaEntidade()
    {
        return new Porta();
    }
    
}
