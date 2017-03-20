package arqSw.DAO;

import arqSw.Hibernate.Venta;
import arqSw.Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VentaDAO {

    private Session sesion;
    private Transaction tx;

    public Integer guardaVenta(Venta venta) throws HibernateException {
        Integer id = 0;

        try {
            iniciaOperacion();
            id = (Integer) sesion.save(venta);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
        return id;
    }

    public void actualizaVenta(Venta venta) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(venta);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public void eliminaVenta(Venta venta) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(venta);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public Venta obtenVenta(Integer idVenta) throws HibernateException {
        Venta venta = null;
        try {
            iniciaOperacion();
            venta = (Venta) sesion.get(Venta.class, idVenta);
        } finally {
            
        }

        return venta;
    }

    public List<Venta> obtenListaVentas() throws HibernateException {
        List<Venta> listaVentas = null;

        try {
            iniciaOperacion();
            listaVentas = sesion.createQuery("from Venta").list();
        } finally {
            
        }

        return listaVentas;
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
