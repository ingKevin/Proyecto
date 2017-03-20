package arqSw.DAO;

import arqSw.Hibernate.Tema;
import arqSw.Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TemaDAO {

    private Session sesion;
    private Transaction tx;

    public Integer guardaTema(Tema tema) throws HibernateException {
        Integer id = 0;

        try {
            iniciaOperacion();
            id = (Integer) sesion.save(tema);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
        return id;
    }

    public void actualizaTema(Tema tema) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(tema);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public void eliminaTema(Tema tema) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(tema);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public Tema obtenTema(Integer idTema) throws HibernateException {
        Tema tema = null;
        try {
            iniciaOperacion();
            tema = (Tema) sesion.get(Tema.class, idTema);
        } finally {
            
        }

        return tema;
    }

    public List<Tema> obtenListaTemas() throws HibernateException {
        List<Tema> listaTemas = null;

        try {
            iniciaOperacion();
            listaTemas = sesion.createQuery("from Tema").list();
        } finally {
            
        }

        return listaTemas;
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
