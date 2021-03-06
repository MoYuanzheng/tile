# 4.28 追溯更新原材料溯源
- [x] 1. 发起追溯后首先追溯物流
- [x] 2. 其次追溯原材料
> 1. 先去product_all中找到对应的batchId
> 2. 去batch中找到对应的materialId
> 3. material中找到对应的名称、生产日期、供应商等属性
# 4.27 历史记录与Token
- [x] 1. 重写部分返回结果的方法，全面改为RestResult类
- [x] 2. 整合JWT
- [x] 3. 完成用户历史记录
- [x] 4. 注册密码加密
------
# 3.22 更新部分函数返回值类型为Map<String, String>
要求：返回错误原因
- [x] 1. UserService.add()
- [x] 2. SmsService.checkCode()
- [x] 3. SmsController.sentSmsCode()
# 3.21 拆箱与ID
- [x] 1. 增加拆箱功能，例如将B从A包装箱中取出
- [x] 2. ID全部改为UUID自动生成
# 3.18用户使用追溯功能更新

- [x] 1. 用户通过扫码后查到追溯信息，按时间顺序排列
------

# 3.17剩余容量更新

- [x] 1. 简单的-1操作只能满足最小单位被装入盒子中，当n容量盒子装入m容量盒子中时，大着容量应为 m - n

# 追溯功能完善

- [x] 详情设计

> 旧逻辑，不符合要求
>
> 1. 查询trace.productId()是否存在于product_all表中
> 2. 查询所有container表中bigId与trace.productId()相同的记录
> 3. 遍历这些记录并取出结果中 container.getSmallId()存到数组中
> 4. 重复1，2，3操作，直至结果为空
> 5. 将最终的数据的getSmallId()作为productId并更新trace表
>
> 以上逻辑全部作废
>
> 新逻辑：
>
> 1. 传进产品ID后应直接写入追溯表
>
> 2. 判断该ID是否为大盒子ID
>
>    是： 则进行对Contrainer表查找（getSmallIdByBigId），返回的小盒子ID列表加入循环的List中
>
>    否：进行下一次循环

找出表中符合条件的记录中的某个字段

```java
//拿到所有关于大盒子的数据
List<Container> containerListByBigId = list(wrapper);
//找出小盒子ID
return containerListByBigId.stream().map(Container::getSmallId).collect(Collectors.toList());
```
------
# 3-16 任务计划

## 配置扫码接口

- [x] 1. 包装盒被分配后应减去库存

     > 逻辑：
     >
     > 1. 当有关系建立时，应检查大容器ID是否被使用
     > 2. 未分配则进行关联以及更新使用标志位
     > 3. 已使用则报错已使用
- [x] 2. packet表增加使用标志位
- [x] 3. packet表增加剩余容量
- [x] 4. 每次商品被放入包装盒时应更新剩余库存
------
# 3.15更新
1. 清除代码中Token部分

2. 将非通用字段时间格式改为字符串，通过时间戳存储及传输

3. 增加订单完成时间更新接口（更新订单同时更新该订单下所有产品的数据）

4. 增加订单删除接口（删除订单同时删除该订单下所有产品的数据）

5. 创建数据表，记录商品打包映射关系

   | 段名       | 类型   | 含义                 |
   | ---------- | ------ | -------------------- |
   | id         | string | 主键，自动生成       |
   | big_size   | string | 相对大包装           |
   | small_size | string | 相对小包装或单个商品 |

   

6. 创建包装盒数据表

   | 段名 | 类型   | 含义           |
   | ---- | ------ | -------------- |
   | id   | string | 主键，自动生成 |
   | size | int    | 尺寸           |

7. 增加包装盒批量生成接口

8. 增加记录包装盒库存统计数据表

   | 段名   | 类型   | 含义     |
   | ------ | ------ | -------- |
   | id     | string | 主键     |
   | size   | int    | 容量     |
   | number | int    | 剩余数量 |

   

9. 批量创建包装盒同时应更新库存统计表

