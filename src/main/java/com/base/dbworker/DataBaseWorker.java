package com.base.dbworker;

import com.base.entity.Degree;
import com.base.entity.Department;
import com.base.entity.Lector;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

import static com.base.util.PrettyFormatter.extractNameOfDepAndHeadMaster;
import static com.base.util.PrettyFormatter.extractPrettyNamesForLectors;
import static com.base.util.PrettyFormatter.provideStatisticByDegree;

public class DataBaseWorker {

    public String getHeadOfDepartmentBy(String departmentName) {
        EntityManager entityManager = openEntityManager();
        Query query = entityManager.createQuery("SELECT d FROM Department d WHERE d.name = :departmentName");
        query.setParameter("departmentName", departmentName);
        Department department;
        try {
            department = (Department) query.getSingleResult();
            Query q = entityManager.createQuery("SELECT l FROM Lector l WHERE l.id =:id");
            q.setParameter("id", department.getHeadId());
            Lector lector = (Lector) q.getSingleResult();
            department.setLectors(Collections.singletonList(lector));
        } catch (NoResultException e) {
            return "Not found! Try another parameters.";
        } finally {
            entityManager.close();
        }
        return extractNameOfDepAndHeadMaster(department);
    }

    public String searchBy(String term) {
        EntityManager entityManager = openEntityManager();
        Query query = entityManager.createQuery("SELECT l FROM Lector l WHERE l.firstName LIKE :term OR l.lastName LIKE :term");
        query.setParameter("term", "%" + term + "%");
        List<Lector> lectors = query.getResultList();
        entityManager.close();
        return extractPrettyNamesForLectors(lectors);
    }

    public String showDepStatistic(String departmentName) {
        EntityManager entityManager = openEntityManager();
        Query query = entityManager.createQuery("SELECT l.degree, COUNT(l) FROM Department d LEFT JOIN d.lectors l WHERE d.name =:departmentName GROUP BY l.degree");
        query.setParameter("departmentName", departmentName);
        List<Object> resultList = query.getResultList();
        entityManager.close();
        return provideStatisticByDegree(resultList);
    }

    /**
     * The entity manager factory.
     */
    private static EntityManagerFactory entityManagerFactory = null;

    /**
     * Open entity manager.
     *
     * @return the entity manager
     */
    private static EntityManager openEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("primary");
        }
        return entityManagerFactory.createEntityManager();
    }

}
