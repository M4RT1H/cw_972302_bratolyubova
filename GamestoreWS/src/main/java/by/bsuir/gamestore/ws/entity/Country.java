package by.bsuir.gamestore.ws.entity;

import by.bsuir.gamestore.ws.tool.Searchable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "countries", schema = "gamestore")
public class Country implements Searchable<Integer>, Serializable {
    private int id;
    private String countryName;
    @JsonIgnore
    private Set<Company> companies;
    @JsonIgnore
    private Set<User> users;

    @Id
    @GeneratedValue
    @Column(name = "country_id")
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "country_name", nullable = false, length = 45)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @OneToMany(mappedBy = "country")
    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    @OneToMany(mappedBy = "country")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (countryName != null ? !countryName.equals(country.countryName) : country.countryName != null) return false;
        if (companies != null ? !companies.equals(country.companies) : country.companies != null) return false;
        return users != null ? users.equals(country.users) : country.users == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (companies != null ? companies.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }
}
