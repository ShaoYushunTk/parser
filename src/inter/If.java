package inter;

import symbols.Type;

public class If extends Stmt {

   Expr expr; Stmt stmt;

   public If(Expr x, Stmt s) { // if(E)S
      expr = x;  stmt = s;
      if( expr.type != Type.Bool ) expr.error("boolean required in if");
   }

   public void gen(int b, int a) {
       int label = newlabel(); // stmt代码标号
       expr.jumping(0,a); // 表达式为真控制流穿越，为假转向a
       emitlabel(label); stmt.gen(label,a);
   }
   
   public void display(){
	   emit("stmt : if begin");
	   stmt.display();
	   emit("stmt : if end");
   }
}
