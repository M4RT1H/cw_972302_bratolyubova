package by.bsuir.gamestore.ws.entity;

import by.bsuir.gamestore.ws.tool.Searchable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders", schema = "gamestore")
public class Order implements Searchable<Integer>, Serializable {
    private int id;
    private String time;
    private String orderKey;
    private Game game;
    private User user;

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datetime")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "order_key")
    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (time != null ? !time.equals(order.time) : order.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id", nullable = false)
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
