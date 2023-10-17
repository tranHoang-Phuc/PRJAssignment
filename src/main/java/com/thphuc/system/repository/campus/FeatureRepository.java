package com.thphuc.system.repository.campus;

import com.thphuc.system.model.Feature;
import com.thphuc.system.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FeatureRepository implements IRepository<Feature>{

    @Override
    public List<Feature> getAll() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Feature> features = entityManager.createQuery("SELECT f FROM Feature f", Feature.class).getResultList();
        entityManager.close();
        return features;

    }

    @Override
    public Feature get(int id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        Feature feature = entityManager.find(Feature.class, id);
        entityManager.close();
        return feature;
    }

    @Override
    public void insert(Feature feature) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(feature);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Feature feature) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(feature);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Feature feature = entityManager.find(Feature.class, id);
        entityManager.remove(feature);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Set<Feature> getFeatureByRole(int id, String url) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        String jpql = "SELECT f FROM Feature f JOIN f.roles r WHERE r.roleId = :id AND f.url = :url";
        TypedQuery<Feature> query = entityManager.createQuery(jpql, Feature.class);
        query.setParameter("id", id);
        query.setParameter("url", url);
        List<Feature> features = query.getResultList();
        entityManager.close();
        Set<Feature> featureSet = new HashSet<>();
        for (Feature feature : features) {
            featureSet.add(feature);
        }
        return featureSet;
    }


}
