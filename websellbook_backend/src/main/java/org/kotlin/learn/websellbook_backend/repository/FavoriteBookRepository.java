package org.kotlin.learn.websellbook_backend.repository;

import org.kotlin.learn.websellbook_backend.entity.FavoriteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteBookRepository extends JpaRepository<FavoriteBook, Long> {
}
