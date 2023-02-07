package inter;

import symbols.Type;
import lexer.Token;

public class Arith extends Op { //算术表达式

	   public Expr expr1, expr2;
	   /* tok算术运算符*/
	   public Arith(Token tok, Expr x1, Expr x2)  {
	      super(tok, null); //null类型占位符
	      expr1 = x1; expr2 = x2;
	      type = Type.max(expr1.type, expr2.type); //确定类型，检查两个运算分量是否可以被类型强制转换为一个常见的数字类型
	      if (type == null ) error("type error");
	   }

	   // 把表达式的子表达式归约为地址，并将表达式的运算符作用于这些地址，从而构造出一个三地址指令的右部
	   public Expr gen() {
	      return new Arith(op, expr1.reduce(), expr2.reduce());
	   }

	   public String toString() {
	      return expr1.toString()+" "+op.toString()+" "+expr2.toString();
	   }
	}
