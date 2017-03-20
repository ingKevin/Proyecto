package arqSw.DAO;

import arqSw.Hibernate.Estampa;
import arqSw.Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EstampaDAO {

    private Session sesion;
    private Transaction tx;

    public Integer guardaEstampa(Estampa estampa) throws HibernateException {
        Integer id = 0;

        try {
            iniciaOperacion();
            id = (Integer) sesion.save(estampa);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
        return id;
    }

    public void actualizaEstampa(Estampa estampa) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(estampa);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public void eliminaEstampa(Estampa estampa) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(estampa);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public Estampa obtenEstampa(Integer idEstampa) throws HibernateException {
        Estampa estampa = null;
        try {
            iniciaOperacion();
            estampa = (Estampa) sesion.get(Estampa.class, idEstampa);
        } finally {
            
        }

        return estampa;
    }

    public List<Estampa> obtenListaEstampas() throws HibernateException {
        List<Estampa> listaEstampas = null;

        try {
            iniciaOperacion();
            listaEstampas = sesion.createQuery("from Estampa").list();
        } finally {
            
        }

        return listaEstampas;
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
