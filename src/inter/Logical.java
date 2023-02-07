package inter;

import symbols.Type;
import lexer.Token;

// 逻辑运算符
public class Logical extends Expr{
	public Expr expr1, expr2;
	// 构造语法树节点，运算符为tok 运算分量为x1 x2
	Logical(Token tok, Expr x1, Expr x2){
		super(tok,null);
		expr1 = x1; expr2 = x2;
		type = check(expr1.type, expr2.type); // 检查p1 p2类型是否为bool
		if(type==null) error("type error");
	}

	// 保证p1 p2都是bool类型
	public Type check(Type p1, Type p2){
		if(p1==Type.Bool&&p2==Type.Bool) return Type.Bool;
		else return null;
	}
	
	public Expr gen(){
		int f = newlabel(); int a = newlabel();
		Temp temp = new Temp(type);
		this.jumping(0,f);
		emit(temp.toString()+" = true");
		emit("goto L"+a);
		emitlabel(f);emit(temp.toString()+" = false");
		emitlabel(a);
		return temp;
	}
	public String toString(){
		return expr1.toString() + " " + op.toString() + " " + expr2.toString();
	}
}
