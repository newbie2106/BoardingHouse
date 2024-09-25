/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TAN DAT
 */
@Entity
@Table(name = "lessor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lessor.findAll", query = "SELECT l FROM Lessor l"),
    @NamedQuery(name = "Lessor.findById", query = "SELECT l FROM Lessor l WHERE l.id = :id"),
    @NamedQuery(name = "Lessor.findByCccd", query = "SELECT l FROM Lessor l WHERE l.cccd = :cccd")})
public class Lessor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "CCCD")
    private String cccd;
    @OneToMany(mappedBy = "lessorId", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Images> imagesSet;
    @OneToMany(mappedBy = "lessorId", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<LessorPost> lessorPostSet;
    @OneToMany(mappedBy = "lessorId", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Follow> followSet;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Users users;

    public Lessor() {
    }

    public Lessor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    @XmlTransient
    public Set<Images> getImagesSet() {
        return imagesSet;
    }

    public void setImagesSet(Set<Images> imagesSet) {
        this.imagesSet = imagesSet;
    }

    @XmlTransient
    public Set<LessorPost> getLessorPostSet() {
        return lessorPostSet;
    }

    public void setLessorPostSet(Set<LessorPost> lessorPostSet) {
        this.lessorPostSet = lessorPostSet;
    }

//    @XmlTransient
//    public Set<Comment> getCommentSet() {
//        return commentSet;
//    }
//
//    public void setCommentSet(Set<Comment> commentSet) {
//        this.commentSet = commentSet;
//    }

    @XmlTransient
    public Set<Follow> getFollowSet() {
        return followSet;
    }

    public void setFollowSet(Set<Follow> followSet) {
        this.followSet = followSet;
    }
    @XmlTransient
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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
        if (!(object instanceof Lessor)) {
            return false;
        }
        Lessor other = (Lessor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tth.pojo.Lessor[ id=" + id + " ]";
    }
    
}
