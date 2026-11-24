package org.kotlin.learn.websellbook_backend.repository;

import org.kotlin.learn.websellbook_backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
