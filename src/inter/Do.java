package inter;

import symbols.Type;

public class Do extends Stmt {

   Expr expr; Stmt stmt;

   public Do() { expr = null; stmt = null; }

   public void init(Stmt s, Expr x) {
      expr = x; stmt = s;
      if( expr.type != Type.Bool ) expr.error("boolean required in do");
   }

   public void gen(int b, int a) {
       after = a;
       int label = newlabel(); //用于expr的标号
       stmt.gen(b,label);
       emitlabel(label); expr.jumping(b,0); //表达式为真，转向b,为假控制流穿越

   }
   
   public void display(){
	  emit("stmt : do begin");
	  stmt.display();
	  //expr.jumping(b,0);
	  emit("stmt : do end");
   }
}