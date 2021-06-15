package com.riftshop.riftshop.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString(exclude = "products")
@EqualsAndHashCode(exclude = "products")
@Data
@Table(name="categorys", schema = "public")
@Entity
public class Category implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Override
    public String getAuthority(){ return this.name; }

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();


}
