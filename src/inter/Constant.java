package inter;

import symbols.Type;
import lexer.Num;
import lexer.Token;
import lexer.Word;
// 常量
public class Constant extends Expr {

	   public Constant(Token tok, Type p) { super(tok, p); }
	   public Constant(int i) { super(new Num(i), Type.Int); } // 根据一个整数构造一个常量对象

	   // 定义静态对象True和False
	   public static final Constant
	      True  = new Constant(Word.True,  Type.Bool),
	      False = new Constant(Word.False, Type.Bool);

	   public void jumping(int t, int f) {
		   // 如果该常量为静态对象True 且 t不是特殊标号0 那么就会生成一个目标为t的跳转指令
		   if ( this == True && t != 0) emit("goto L" + t);
		   // 如果该常量为静态对象False 且 f不是特殊标号0 那么就会生成一个目标为f的跳转指令
		   else if (this == False && f != 0) emit("goto L" + f);
	   }
	}

