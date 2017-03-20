package arqSw.DAO;

import arqSw.Hibernate.Cliente;
import arqSw.Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDAO {

    private Session sesion;
    private Transaction tx;

    public Integer guardaCliente(Cliente cliente) throws HibernateException {
        Integer id = 0;

        try {
            iniciaOperacion();
            id = (Integer) sesion.save(cliente);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
        return id;
    }

    public void actualizaCliente(Cliente cliente) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(cliente);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public void eliminaCliente(Cliente cliente) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(cliente);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public Cliente obtenCliente(Integer idCliente) throws HibernateException {
        Cliente cliente = null;
        try {
            iniciaOperacion();
            cliente = (Cliente) sesion.get(Cliente.class, idCliente);
        } finally {
            
        }

        return cliente;
    }

    public List<Cliente> obtenListaClientes() throws HibernateException {
        List<Cliente> listaClientes = null;

        try {
            iniciaOperacion();
            listaClientes = sesion.createQuery("from Cliente").list();
        } finally {
            
        }

        return listaClientes;
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
