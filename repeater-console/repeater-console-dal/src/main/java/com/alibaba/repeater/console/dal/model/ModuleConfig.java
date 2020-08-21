package com.alibaba.repeater.console.dal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * {@link ModuleConfig}
 * <p>
 *
 * @author zhaoyb1990
 */
@Entity
@Table(name = "module_config")
@Getter
@Setter
public class ModuleConfig implements java.io.Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private App app;

    @OneToMany(mappedBy = "moduleConfig", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<ModuleInfo> moduleInfoList = new ArrayList<>();

    private String environment;

    private String config;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;
}
