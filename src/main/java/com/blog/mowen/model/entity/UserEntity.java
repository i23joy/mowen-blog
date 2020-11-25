package com.blog.mowen.model.entity;

import lombok.Data;
import org.apache.kafka.common.protocol.types.Field;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_USER")
public class UserEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.blog.mowen.core.CustomIDGenerator")
    private String uid;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "upassword")
    private String password;

    @Column(name = "avatar")
    private String avatar;
}
