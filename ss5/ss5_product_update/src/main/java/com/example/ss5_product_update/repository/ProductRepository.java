package com.example.ss5_product_update.repository;

import com.example.ss5_product_update.model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
        String query = "select p from product p";
        TypedQuery<Product> typedQuery = BaseRepository.getEntityManager().createQuery(query, Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public Product findById(int id) {
        String query = "select p from product p where p.id = :id";
        TypedQuery<Product> typedQuery = BaseRepository.getEntityManager().createQuery(query, Product.class);
        typedQuery.setParameter("id", id);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Product product) {
        Transaction transaction = null;
        Product root;
        if (product.getId() != 0) {
            root = new Product();
        } else {
            root = findById(product.getId());
        }
        try {
            Session session = BaseRepository.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            root.setName(product.getName());
            root.setPrice(product.getPrice());
            root.setManufacturer(product.getManufacturer());
            root.setManufacturer(product.getManufacturer());
            session.saveOrUpdate(root);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Error when addProduct: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(Product product) {
        Transaction transaction = null;
        try{
            Session session = BaseRepository.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Product currentProduct = findById(product.getId());
            if (currentProduct != null) {
                currentProduct.setName(product.getName());
                currentProduct.setPrice(product.getPrice());
                currentProduct.setManufacturer(product.getManufacturer());
                currentProduct.setManufacturer(product.getManufacturer());
                session.saveOrUpdate(currentProduct);
                transaction.commit();
            }
            session.close();
        } catch (Exception e) {
            System.out.println("Error when updateProduct: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(int id) {
        Product currentProduct = findById(id);
        if (currentProduct != null) {
            Transaction transaction = null;
            try {
                Session session = BaseRepository.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                session.delete(currentProduct);
                transaction.commit();
                session.close();
            } catch (Exception e) {
                System.out.println("Error when deleteProduct: " + e.getMessage());
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }
    }
}
