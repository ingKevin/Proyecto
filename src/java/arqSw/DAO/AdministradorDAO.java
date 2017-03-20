package arqSw.DAO;

import arqSw.Hibernate.Administrador;
import arqSw.Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdministradorDAO {

    private Session sesion;
    private Transaction tx;

    public Integer guardaAdministrador(Administrador administrador) throws HibernateException {
        Integer id = 0;

        try {
            iniciaOperacion();
            id = (Integer) sesion.save(administrador);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
        return id;
    }

    public void actualizaAdministrador(Administrador administrador) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(administrador);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public void eliminaAdministrador(Administrador administrador) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(administrador);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            
        }
    }

    public Administrador obtenAdministrador(Integer idAdministrador) throws HibernateException {
        Administrador administrador = null;
        try {
            iniciaOperacion();
            administrador = (Administrador) sesion.get(Administrador.class, idAdministrador);
        } finally {
            
        }

        return administrador;
    }

    public List<Administrador> obtenListaAdministradores() throws HibernateException {
        List<Administrador> listaAdministradors = null;

        try {
            iniciaOperacion();
            listaAdministradors = sesion.createQuery("from Administrador").list();
        } finally {
            
        }
        return listaAdministradors;
    }

    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public void updatePass(int AdministradorID, String pass) {
        Transaction tx = null;
        try {
            iniciaOperacion();
            Administrador adm = (Administrador) sesion.get(Administrador.class, AdministradorID);
            adm.setClave(pass);
            sesion.update(adm);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } 
    }
    

}
