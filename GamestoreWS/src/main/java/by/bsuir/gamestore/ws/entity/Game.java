package by.bsuir.gamestore.ws.entity;

import by.bsuir.gamestore.ws.tool.Searchable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "games", schema = "gamestore")
public class Game implements Searchable<Integer>, Serializable {
    private int id;
    private String title;
    private String poster;
    private String description;
    private String systemRequirements;
    private String restrictions;
    private Double rating;
    private BigDecimal price;
    private String releaseDate;
    private Company company;
    private Integer commentNumber;
    private Set<Genre> genres;
    @JsonIgnore
    private Set<Order> orders;

    @JsonIgnore
    private Set<Comment> comments;
    @JsonIgnore
    private Set<Rating> ratings;

    @Id
    @GeneratedValue
    @Column(name = "game_id")
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "poster", length = 300)
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "system_requirements")
    public String getSystemRequirements() {
        return systemRequirements;
    }

    public void setSystemRequirements(String systemRequirements) {
        this.systemRequirements = systemRequirements;
    }

    @Basic
    @Column(name = "restrictions", nullable = false, length = 45)
    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    @Basic
    @Column(name = "rating")
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 3)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "release_date", nullable = false, length = 45)
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = false)
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Basic
    @Column(name = "comment_number")
    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "games_has_genres", joinColumns = {
            @JoinColumn(name = "game_id", nullable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "genre_id", nullable = false)})
    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @OneToMany(mappedBy = "game", orphanRemoval = true)
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }



    @OneToMany(mappedBy = "game", orphanRemoval = true)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "game", orphanRemoval = true)
    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (id != game.id) return false;
        if (Double.compare(game.rating, rating) != 0) return false;
        if (title != null ? !title.equals(game.title) : game.title != null) return false;
        if (poster != null ? !poster.equals(game.poster) : game.poster != null) return false;
        if (description != null ? !description.equals(game.description) : game.description != null) return false;
        if (restrictions != null ? !restrictions.equals(game.restrictions) : game.restrictions != null) return false;
        if (price != null ? !price.equals(game.price) : game.price != null) return false;
        if (releaseDate != null ? !releaseDate.equals(game.releaseDate) : game.releaseDate != null) return false;
        if (company != null ? !company.equals(game.company) : game.company != null) return false;
        if (genres != null ? !genres.equals(game.genres) : game.genres != null) return false;
        if (orders != null ? !orders.equals(game.orders) : game.orders != null) return false;
       return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (restrictions != null ? restrictions.hashCode() : 0);
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);

        return result;
    }
}
