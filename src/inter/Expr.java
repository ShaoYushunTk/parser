package inter;

import symbols.Type;
import lexer.Token;

public class Expr extends Node{ //表达式节点

	public Token op;  // 操作符
	public Type type; //类型
	
	Expr(Token tok, Type p) { op = tok; type = p; }
	
	public Expr gen() { return this;} //产生三地址码的右部 比如 E = E1+E2，产生return x1+x2 （x1,x2分别对应E1、E2的值的地址）
	public Expr reduce() { return this;} //返回表达式地址（常量、id或临时变量名），比如t（hold the value of E）
	
	/* boolean表达式的跳转代码实现，表达式B的true出口和false出口分别为t和f
	 * 参数t表示label true，f表示 label false
	 * label 0 表示布尔表达式后的第一条指令语句标号
	 * B的值为真，代码中就包含一个目标为t的跳转指令；为假，包含一个目标为f的跳转指令
	 * 特殊标号0表示控制流从B穿越 到达B的代码之后的下一个指令
	 */
	public void jumping(int t, int f) {
		emitjumps(toString(),t,f);
	}
	public void emitjumps(String test, int t, int f){
		if ( t != 0 && f != 0){
			emit("if " + test + " goto L" + t);
			emit("goto L" + f);
		}
		else if ( t != 0){
			emit("if " + test + " goto L" + t);
		}
		else if ( f != 0){
			emit("iffalse " + test + " goto L" + f);
		}
		else ; //不生成指令，因为t和f都直接穿越
	}
	public String toString() { return op.toString(); }
	
}
