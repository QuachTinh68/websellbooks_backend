package org.kotlin.learn.websellbook_backend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@Data
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "book_id")
        private Long bookId;

        @Column(name = "book_title", nullable = false, length = 256)
        private String bookTitle;

        @Column(name = "author_name", length = 256)
        private String authorName;

        @Column(name = "isbn", length = 32, unique = true)
        private String isbn;

        @Column(name = "book_description", columnDefinition = "TEXT")
        private String bookDescription;

        @Column(name = "list_price", precision = 12, scale = 2)
        private BigDecimal listPrice;

        @Column(name = "selling_price", nullable = false, precision = 12, scale = 2)
        private BigDecimal sellingPrice;

        @Column(name = "stock_quantity", nullable = false)
        private int stockQuantity;

        @Column(name = "average_rating")
        private Double averageRating;

        @ManyToMany(fetch = FetchType.LAZY, cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE,
                CascadeType.DETACH,
                CascadeType.REFRESH
        })
        @JoinTable(name = "book_category", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
        @ToString.Exclude
        @EqualsAndHashCode.Exclude
        private List<Category> categories = new ArrayList<>();

        @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @ToString.Exclude
        @EqualsAndHashCode.Exclude
        private List<Image> images = new ArrayList<>();

        @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @ToString.Exclude
        @EqualsAndHashCode.Exclude
        private List<Review> reviews = new ArrayList<>();

        @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE,
                CascadeType.DETACH,
                CascadeType.REFRESH
        })
        @ToString.Exclude
        @EqualsAndHashCode.Exclude
        private List<OrderDetail> orderDetails = new ArrayList<>();

        @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @ToString.Exclude
        @EqualsAndHashCode.Exclude
        private List<FavoriteBook> favoriteBooks = new ArrayList<>();


}