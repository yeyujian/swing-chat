package info;

import java.io.Serializable;

public class info implements Serializable {

	private static final long serialVersionUID = 8683452581334592189L;
	public String name;
	public String id;
	public String password;
	public int state;//200 -- 连接中   302 --未登录   404 --退出
	public String msg;
	public info(){
		this.state=302;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name:" + name;
	}
}
/* msg 存储查询信息
 * <FIND>(msg)[code]   msg 里面包含书名/作者名/类型       100 表示书名搜素   200作者名查询  300 类型查询 
 * <CHANGEBOOK>(msg)[code]		ID 书名编号    msg 操作值     code  操作类型 100 删除   200 添加  300 修改  301 修改书名   302 修改书本描述  303 修改作者名   400 书本借阅 401 借书  402 还书（此处msg记录读者ID） 
 * 
 * 
 */