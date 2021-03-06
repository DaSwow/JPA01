/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lv1013
 */
@Entity
@Table(name = "videogame")
public class Videogame extends EntityBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "videogame_id")
    private Integer id;

    @Column(nullable = false)
    private int rating;

    @OneToMany(mappedBy = "videogame", cascade = CascadeType.PERSIST)
    private Collection<Achievement> achievements;

    public Collection<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Collection<Achievement> achievements) {
        this.achievements = achievements;
    }

    @ManyToMany
    private Collection<Player> players;

    public Collection<Player> getPlayers() {
        return players;
    }
    
    public void setPlayers(Collection<Player> player) {
        this.players = player;
    }

    public void addPlayer(Player player) {
        if (this.players == null) {
            this.players = new ArrayList<>();
           
        }

        this.players.add(player);
    }

    
    
    
    
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Videogame() {
        this.achievements = new HashSet();
    }

    public void addAchievement(Achievement a) {
        a.setVideogame(this);
        this.achievements.add(a);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videogame)) {
            return false;
        }
        Videogame other = (Videogame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Videogame[ id=" + id + " ]";
    }

}
