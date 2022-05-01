package by.bsuir.gamestore.ws.entity;

import by.bsuir.gamestore.ws.tool.Searchable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comments", schema = "gamestore")
public class Comment implements Searchable<Integer>, Serializable {

    private int id;
    private String content;
    private String time;
    private User user;
    private Game game;

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
    @JoinColumn(name="game_id", referencedColumnName = "game_id")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}