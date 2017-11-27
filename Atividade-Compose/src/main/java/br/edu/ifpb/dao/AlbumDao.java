
package br.edu.ifpb.dao;

import br.edu.ifpb.model.Album;
import br.edu.ifpb.model.Banda;
import br.edu.ifpb.model.Estilo;
import br.edu.ifpb.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao {
    
    private Connection connection;

    public AlbumDao() {
        connection = Conexao.getConnection();
    }

    public void addAlbum(Album album) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into album(estilo, banda, nomeBanda, anodelancamento) values (?, ?, ?, ?)");
        
            preparedStatement.setString(1, album.getEstilo().name());
            preparedStatement.setInt(2, album.getBanda()); 
            preparedStatement.setString(3, album.getNomeBanda());
            preparedStatement.setString(4, album.getAnoDeLancamento());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAlbum(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from album where id=?");
            
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAlbum(Album album) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update album set estilo=?, nomeBanda=?, banda=?, anodelancamento=?"
                            + "where id=?");
 
            preparedStatement.setString(1, album.getEstilo().name());
            preparedStatement.setString(2, album.getNomeBanda());
            preparedStatement.setInt(3, album.getBanda());
            preparedStatement.setString(4, album.getAnoDeLancamento());
            preparedStatement.setInt(5, album.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Album> getAllAlbums() {
        List<Album> lista = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from album");
            while (rs.next()) {
                Album album = new Album();
                album.setId(rs.getInt("id"));
                album.setEstilo(Estilo.valueOf(rs.getString("estilo")));
                album.setNomeBanda(rs.getString("nomeBanda"));
                album.setBanda(rs.getInt("banda"));
                album.setAnoDeLancamento(rs.getString("anoDeLancamento"));
                
                lista.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Album getAlbumById(int idAlbum) {
        Album album = new Album();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from album where id=?");
            preparedStatement.setInt(1, idAlbum);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                
                album.setId(rs.getInt("id"));
                album.setNomeBanda(rs.getString("nomeBanda"));
                album.setEstilo(Estilo.valueOf(rs.getString("estilo")));
                album.setBanda(rs.getInt("banda"));
                album.setAnoDeLancamento(rs.getString("anoDeLancamento"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return album;
    }
    
     public List<Banda> getAllBandas() {
        List<Banda> lista = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from banda");
            while (rs.next()) {
                Banda banda = new Banda();
                banda.setId(rs.getInt("id"));
                banda.setNome(rs.getString("nome"));
                banda.setLocalDeOrigem(rs.getString("localdeorigem"));
                
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

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return banda;
    }
    
}
