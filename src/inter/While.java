package inter;

import symbols.Type;

public class While extends Stmt {

   Expr expr; Stmt stmt;

   public While() { expr = null; stmt = null; }

   public void init(Expr x, Stmt s) {
      expr = x;  stmt = s;
      if( expr.type != Type.Bool ) expr.error("boolean required in while");
   }
   public void gen(int b, int a) {
       after = a;         //保存标号a
       expr.jumping(0,a);
       int label = newlabel();
       emitlabel(label); stmt.gen(label,b);
       emit("goto L" + b); //目标为b的跳转指令
   }
   
   public void display() {
	   emit("stmt : while begin");
	   stmt.display();
	   emit("stmt : while end");
   }
}
