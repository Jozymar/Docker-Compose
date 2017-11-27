package br.edu.ifpb.controller;

import br.edu.ifpb.dao.AlbumDao;
import br.edu.ifpb.model.Album;
import br.edu.ifpb.model.Estilo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlbumController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/album.jsp";
    private static final String LISTA_ALBUM = "/listaAlbum.jsp";
    private static final String LISTA_BANDA = "/listaBanda.jsp";
    private final AlbumDao dao;

    public AlbumController() {
        super();
        dao = new AlbumDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("addBanda")) {
            forward = LISTA_BANDA;
            request.setAttribute("bandas", dao.getAllBandas());
        } else if (action.equalsIgnoreCase("delete")) {
            int idAlbum = Integer.parseInt(request.getParameter("id"));
            dao.deleteAlbum(idAlbum);
            forward = LISTA_ALBUM;
            request.setAttribute("albuns", dao.getAllAlbums());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int albumId = Integer.parseInt(request.getParameter("id"));
            Album album = dao.getAlbumById(albumId);
            request.setAttribute("banda", dao.getBandaById(dao.getAlbumById(albumId).getBanda()));
            request.setAttribute("idBanda", dao.getAlbumById(albumId).getBanda());
            request.setAttribute("album", album);
        } else if (action.equalsIgnoreCase("listaAlbum")) {
            forward = LISTA_ALBUM;
            request.setAttribute("albuns", dao.getAllAlbums());
        } else {
            forward = INSERT_OR_EDIT;
            
            request.setAttribute("banda", 
                    dao.getBandaById(Integer.parseInt(request.getParameter("idBanda"))));
            request.setAttribute("idBanda", request.getParameter("idBanda"));
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Album album = new Album();
        album.setEstilo(Estilo.valueOf(request.getParameter("estilo")));
        String banda = request.getParameter("banda");
        album.setBanda(Integer.parseInt(banda));
        album.setNomeBanda(request.getParameter("nomeBanda"));
        album.setAnoDeLancamento(request.getParameter("anoDeLancamento"));

        String albumId = request.getParameter("id");
        if (albumId == null || albumId.isEmpty()) {
            dao.addAlbum(album);
        } else {
            album.setId(Integer.parseInt(albumId));
            dao.updateAlbum(album);
        }

        RequestDispatcher view = request.getRequestDispatcher(LISTA_ALBUM);
        request.setAttribute("albuns", dao.getAllAlbums());
        view.forward(request, response);
    }
}
