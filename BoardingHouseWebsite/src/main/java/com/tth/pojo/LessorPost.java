/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TAN DAT
 */
@Entity
@Table(name = "lessor_post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LessorPost.findAll", query = "SELECT l FROM LessorPost l"),
    @NamedQuery(name = "LessorPost.findById", query = "SELECT l FROM LessorPost l WHERE l.id = :id"),
    @NamedQuery(name = "LessorPost.findByPrice", query = "SELECT l FROM LessorPost l WHERE l.price = :price"),
    @NamedQuery(name = "LessorPost.findByLongitude", query = "SELECT l FROM LessorPost l WHERE l.longitude = :longitude"),
    @NamedQuery(name = "LessorPost.findByLatitude", query = "SELECT l FROM LessorPost l WHERE l.latitude = :latitude"),
    @NamedQuery(name = "LessorPost.findByQuantity", query = "SELECT l FROM LessorPost l WHERE l.quantity = :quantity"),
    @NamedQuery(name = "LessorPost.findByLocation", query = "SELECT l FROM LessorPost l WHERE l.location = :location")})
public class LessorPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longitude")
    private BigDecimal longitude;
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Size(max = 100)
    @Column(name = "location")
    private String location;
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    @ManyToOne
    private Area areaId;
    @JoinColumn(name = "lessor_id", referencedColumnName = "id")
    @ManyToOne
    private Lessor lessorId;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    @JsonIgnoreProperties({"imagesSet, commentSet"})
    private Post post;

    public LessorPost() {
    }

    public LessorPost(Integer id) {
        this.id = id;
    }

    public LessorPost(Integer id, float price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Area getAreaId() {
        return areaId;
    }

    public void setAreaId(Area areaId) {
        this.areaId = areaId;
    }

    public Lessor getLessorId() {
        return lessorId;
    }

    public void setLessorId(Lessor lessorId) {
        this.lessorId = lessorId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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
        if (!(object instanceof LessorPost)) {
            return false;
        }
        LessorPost other = (LessorPost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tth.pojo.LessorPost[ id=" + id + " ]";
    }
    
}
