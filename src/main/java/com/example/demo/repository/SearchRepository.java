package com.example.demo.repository;

import com.example.demo.controller.dto.Combined;
import com.example.demo.controller.dto.Search;
import com.example.demo.entity.Friend;
import com.example.demo.entity.FriendLikesFood;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchRepository {

    @Autowired
    EntityManager entityManager;

    /*List<Combined> advancedSearch(Search search) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Friend> cq = cb.createQuery(Friend.class);

        Root<Friend> friendRoot = cq.from(Friend.class);
        Join<Friend, FriendLikesFood> friendLikesFoodJoin = friendRoot.join(FriendLikesFood)
        Predicate authorNamePredicate = cb.equal(book.get("author"), authorName);
        Predicate titlePredicate = cb.like(book.get("title"), "%" + title + "%");
        cq.where(authorNamePredicate, titlePredicate);

        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList();
    }*/

}
