package br.com.sistemaporta.dao;

import br.com.sistemaporta.entidade.Porta;
import br.com.sistemaporta.util.FabricaConexao;
import br.com.sistemaporta.util.exception.ErroSistema;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Ponce Jr
 */
public class PortaDAO implements CrudDAO<Porta>
{
    @Override
    public void salvar(Porta porta) throws ErroSistema
    {
            try 
            {
                Connection conexao = FabricaConexao.getConexao();
                PreparedStatement ps;
            
                if(porta.getIdporta() == null)
                {
                    ps = conexao.prepareStatement("INSERT INTO public.portas( nome, momento, status, info)VALUES ( ?, ?, ?, ?);");
                } 
                else 
                {
                    ps = conexao.prepareStatement("update portas set nome=?, momento=?, status=?, info=? where idportas=?");
                    ps.setInt(5, porta.getIdporta());
                }

                ps.setString(1, porta.getNome());
                ps.setDate(2, new Date(porta.getMomento().getTime()));
                ps.setBoolean(3,porta.isStatus());
                ps.setString(4, porta.getInfo());
                ps.execute();
                FabricaConexao.fecharConexao();
            
        } 
        catch (SQLException ex) 
        {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }
    
    @Override
    public List<Porta> buscar() throws ErroSistema
    {
        try 
        {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from portas");
            ResultSet resultSet = ps.executeQuery();
            
            List<Porta> portas = new ArrayList<>();
            
            while(resultSet.next())
            {
                Porta porta = new Porta();
                porta.setIdporta(resultSet.getInt("idportas"));
                porta.setNome(resultSet.getString("nome"));
                porta.setMomento(resultSet.getDate("momento"));
                porta.setStatus(resultSet.getBoolean("status"));
                porta.setInfo(resultSet.getString("info"));
                portas.add(porta);
            }
            FabricaConexao.fecharConexao();
            return portas;
            
        } 
        catch (SQLException ex) 
        {
            throw new ErroSistema("Erro ao buscar as portas!",ex);
        }
    }

    @Override
    public void deletar(Porta porta) throws ErroSistema 
    {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from portas where idportas = ?");
            ps.setInt(1, porta.getIdporta());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar a porta!", ex);
        }
    }
}
