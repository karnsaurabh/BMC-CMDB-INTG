package com.metricstream.itgrc.atr.dao.home;

import java.util.List;
import java.util.Map;

import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.metricstream.itgrc.atr.dao.vo.MsItgBmcLanEndpoint;
import com.metricstream.itgrc.integration.grcf.dao.model.MsItgGrcDaoHome;

@Named
public class MsItgAtrDaoHome extends MsItgGrcDaoHome {
    
    public <T> List<T> getHostedAccessData(Class<T> tClass, String value) {

        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(tClass);
        Root<T> root = criteriaQuery.from(tClass);
        criteriaQuery.select(root);
        Expression<String> exp = root.get("sourceInstanceId");
        Predicate predicate = exp.in(value);
        criteriaQuery.where(predicate);
        Query query = getEntityManager().createQuery(criteriaQuery);
        return query.getResultList();
    }
    
    
    public <T> List<T> getIPAddressData(Class<T> tClass, String value) {

        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(tClass);
        Root<T> root = criteriaQuery.from(tClass);
        criteriaQuery.select(root);
        Expression<String> exp = root.get("instanceId");
        Predicate predicate = exp.in(value);
        criteriaQuery.where(predicate);
        Query query = getEntityManager().createQuery(criteriaQuery);
        return (List<T>) query.getResultList();
    }

    @Override
    public String getTableName() {
        return null;
    }


    public List<MsItgBmcLanEndpoint> getLanAddressData(Class<MsItgBmcLanEndpoint> class1, String destinationInstanceId) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<MsItgBmcLanEndpoint> criteriaQuery = criteriaBuilder.createQuery(class1);
        Root<MsItgBmcLanEndpoint> root = criteriaQuery.from(class1);
        criteriaQuery.select(root);
        Expression<String> exp = root.get("instanceId");
        Predicate predicate = exp.in(destinationInstanceId);
        criteriaQuery.where(predicate);
        Query query = getEntityManager().createQuery(criteriaQuery);
        return (List<MsItgBmcLanEndpoint>) query.getResultList();
    }

}
