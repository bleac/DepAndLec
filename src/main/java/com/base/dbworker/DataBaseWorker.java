package com.base.dbworker;

import com.base.entity.Department;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;

public class DataBaseWorker {

    public Department getHeadOfDepartment(String departmentName) {
        EntityManager entityManager = openEntityManager();

		Query query = entityManager.createQuery("SELECT d FROM Department d WHERE d.name=:departmentName");
		query.setParameter( "departmentName", departmentName );
        Department department = (Department) query.getSingleResult();
//        Hibernate.initialize(department.getLectors());
        entityManager.close();

        return department;
    }

    /** The entity manager factory. */
    private static EntityManagerFactory entityManagerFactory = null;

    /**
     * Open entity manager.
     *
     * @return the entity manager
     */
    private static EntityManager openEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory( "primary" );
        }
        return entityManagerFactory.createEntityManager();
    }

}
