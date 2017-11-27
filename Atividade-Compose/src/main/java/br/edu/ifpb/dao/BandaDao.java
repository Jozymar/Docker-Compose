package br.edu.ifpb.dao;

import br.edu.ifpb.model.Album;
import br.edu.ifpb.model.Banda;
import br.edu.ifpb.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BandaDao {

    private Connection connection;

    public BandaDao() {
        connection = Conexao.getConnection();
    }

    public void addBanda(Banda banda) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into banda(nome, localdeorigem, integrantes) values (?, ?, ?)");

            preparedStatement.setString(1, banda.getNome());
            preparedStatement.setString(2, banda.getLocalDeOrigem());
            preparedStatement.setString(3, banda.getIntegrantes().toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBanda(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from banda where id=?");

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBanda(Banda banda) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update banda set nome=?, localdeorigem=?, integrantes=?"
                            + "where id=?");

            preparedStatement.setString(1, banda.getNome());
            preparedStatement.setString(2, banda.getLocalDeOrigem());
            preparedStatement.setString(3, banda.getIntegrantes().toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Banda> getAllBandas() {
        List<Banda> lista = new ArrayList<Banda>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from banda");
            while (rs.next()) {
                Banda banda = new Banda();
                banda.setNome(rs.getString("nome"));
                banda.setLocalDeOrigem(rs.getString("localDeOrigem"));
                
                List<String> in = new ArrayList<String>();
                in.add(rs.getString("integrantes"));
                banda.setIntegrantes(in);

                lista.add(banda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Banda getBandaById(int idBanda) {
        Banda banda = new Banda();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from banda where id=?");
            preparedStatement.setInt(1, idBanda);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                banda.setNome(rs.getString("nome"));
                banda.setLocalDeOrigem(rs.getString("localDeOrigem"));
                
                List<String> in = new ArrayList<String>();
                in.add(rs.getString("integrantes"));
                banda.setIntegrantes(in);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return banda;
    }

}
