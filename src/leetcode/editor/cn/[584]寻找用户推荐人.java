// 开始时间：2025-08-16 21:49:52
// 题目标题：寻找用户推荐人
// 题目标记：find-customer-referee
// 题目编号：584
// 题目描述：
/**
 * 表: Customer
 * <p>
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | name        | varchar |
 * | referee_id  | int     |
 * +-------------+---------+
 * 在 SQL 中，id 是该表的主键列。
 * 该表的每一行表示一个客户的 id、姓名以及推荐他们的客户的 id。
 * <p>
 * 找出以下客户的姓名：
 * <p>
 * <p>
 * 被任何 id != 2 的用户推荐。
 * 没有被 任何用户推荐。
 * <p>
 * <p>
 * 以 任意顺序 返回结果表。
 * <p>
 * 结果格式如下所示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：
 * Customer 表:
 * +----+------+------------+
 * | id | name | referee_id |
 * +----+------+------------+
 * | 1  | Will | null       |
 * | 2  | Jane | null       |
 * | 3  | Alex | 2          |
 * | 4  | Bill | null       |
 * | 5  | Zack | 1          |
 * | 6  | Mark | 2          |
 * +----+------+------------+
 * 输出：
 * +------+
 * | name |
 * +------+
 * | Will |
 * | Jane |
 * | Bill |
 * | Zack |
 * +------+
 * <p>
 * Related Topics 数据库 👍 324 👎 0
 */
//There is no code of Java type for this problem
