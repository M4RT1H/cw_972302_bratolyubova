package by.bsuir.gamestore.ws.entity;

import by.bsuir.gamestore.ws.tool.Searchable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rating", schema = "gamestore")
public class Rating implements Searchable<Integer>, Serializable {

    private int id;
    private Integer value;
    private User user;
    private Game game;

    @Id
    @GeneratedValue
    @Column(name = "raiting_id")
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value", nullable = false)
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
