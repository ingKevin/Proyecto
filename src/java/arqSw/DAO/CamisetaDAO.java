package arqSw.DAO;

import arqSw.Hibernate.Camiseta;
import arqSw.Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CamisetaDAO {

    private Session sesion;
    private Transaction tx;

    public Integer guardaCamiseta(Camiseta camiseta) throws HibernateException {
        Integer id = 0;

        try {
            iniciaOperacion();
            id = (Integer) sesion.save(camiseta);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
        return id;
    }

    public void actualizaCamiseta(Camiseta camiseta) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(camiseta);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public void eliminaCamiseta(Camiseta camiseta) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(camiseta);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public Camiseta obtenCamiseta(Integer idCamiseta) throws HibernateException {
        Camiseta camiseta = null;
        try {
            iniciaOperacion();
            camiseta = (Camiseta) sesion.get(Camiseta.class, idCamiseta);
        } finally {
            
        }

        return camiseta;
    }

    public List<Camiseta> obtenListaCamisetas() throws HibernateException {
        List<Camiseta> listaCamisetas = null;

        try {
            iniciaOperacion();
            listaCamisetas = sesion.createQuery("from Camiseta").list();
        } finally {
            
        }

        return listaCamisetas;
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
