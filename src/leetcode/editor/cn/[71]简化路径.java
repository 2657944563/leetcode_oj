// 开始时间：2023-09-27 11:15:56
// 题目标题：简化路径
// 题目标记：simplify-path
// 题目编号：71
// 题目描述：

/**
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分
 * 。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * <p>
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * <p>
 * <p>
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * <p>
 * <p>
 * 返回简化后得到的 规范路径 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：path = "/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：path = "/a/./b/../../c/"
 * 输出："/c"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= path.length <= 3000
 * path 由英文字母，数字，'.'，'/' 或 '_' 组成。
 * path 是一个有效的 Unix 风格绝对路径。
 * <p>
 * <p>
 * Related Topics 栈 字符串 👍 646 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String simplifyPath(String path) {
        // 存入目录的List
        List<String> temp = new ArrayList<>(); //按顺序存所有目录名
        int len = path.length();
        for (int i = 0; i < len; ) {
            if (path.charAt(i) == '/') i++;
            else {
                // 记录当前位置
                int now_index = i;
                while (i < len && path.charAt(i) != '/') {
                    i++;
                }
                // 截取两个/ 之间的字符串
                String s = path.substring(now_index, i);
                // StringBuilder sb = new StringBuilder(); //记录连续且不含'/'的字符串
                // while(i<len && path.charAt(i)!='/'){
                //     sb.append(path.charAt(i++));
                // }
                // String s = sb.toString();
                if (s.equals("..") && !temp.isEmpty())
                    //返回上一级，删除最后一个目录
                    temp.remove(temp.size() - 1);
                else if (!s.equals(".") && !s.equals(".."))
                    //存储合法目录名
                    temp.add(s);
            }
        }
        // 如果为空 直接返回/
        if (temp.isEmpty())
            return "/"; //仅含根目录
        StringBuilder res = new StringBuilder();
        for (String s : temp)
            res.append("/" + s);
        return res.toString();
    }
}

//leetcode submit region end(Prohibit modification and deletion)

