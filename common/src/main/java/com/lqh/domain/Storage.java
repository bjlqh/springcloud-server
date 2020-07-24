package com.lqh.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "t_storage")
public class Storage implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;


    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
