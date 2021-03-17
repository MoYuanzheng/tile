package com.mo.tile.util;/**
 * @author: MoYz
 * @description:
 * @data: 2021/3/17
 */

import java.util.UUID;

/**
 * 通用功能
 *
 * @author Moyz
 * @date 2021/03/17 11:11
 */
public class GeneralFunctions {
    public static String getRandomId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 18);
    }
}
