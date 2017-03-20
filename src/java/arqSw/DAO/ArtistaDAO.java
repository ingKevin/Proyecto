package arqSw.DAO;

import arqSw.Hibernate.Artista;
import arqSw.Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ArtistaDAO {

    private Session sesion;
    private Transaction tx;

    public Integer guardaArtista(Artista artista) throws HibernateException {
        Integer id = 0;
        try {
            iniciaOperacion();
            id = (Integer)sesion.save(artista);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } 
        return id;
    }

    public void actualizaArtista(Artista artista) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(artista);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public void eliminaArtista(Artista artista) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(artista);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public Artista obtenArtista(Integer idArtista) throws HibernateException {
        Artista artista = null;
        try {
            iniciaOperacion();
            artista = (Artista) sesion.get(Artista.class, idArtista);
        } finally {
            
        }

        return artista;
    }

    public List<Artista> obtenListaArtistas() throws HibernateException {
        List<Artista> listaArtistas = null;

        try {
            iniciaOperacion();
            listaArtistas = sesion.createQuery("from Artista").list();
        } finally {
            
        }

        return listaArtistas;
    }

    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
}
