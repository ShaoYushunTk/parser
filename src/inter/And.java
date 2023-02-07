package inter;

import lexer.Token;

public class And extends Logical{
	public And(Token tok, Expr x1, Expr x2) { super(tok,x1,x2);}

	// B = B1 && B2
	// t和f表示B的true出口和false出口
	public void jumping(int t, int f){
		// 假设t和f都不是特殊标号0 若B1为假 则B为假 B1的false出口为f，true出口对应B2第一条指令
		// 一般情况下B的false出口f可能为0 变量label保证B1的false出口被设置为B的代码的结尾处
		int label = f != 0 ? f : newlabel();
		expr1.jumping(0,label);
		expr2.jumping(t,f);
		if ( f == 0 ) emitlabel(label); // f为特殊标号0 生成label
	}

}
