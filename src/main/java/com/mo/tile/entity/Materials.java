package com.mo.tile.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

/**
 * (Materials)实体类
 *
 * @author mo
 * @since 2021-01-21 23:52:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Materials implements Serializable {

    @TableId("material_id")
    private String material_id;
    private String material_name;
}