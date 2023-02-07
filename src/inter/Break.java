package inter;

public class Break extends Stmt {
   Stmt stmt; // 保存外围语句构造

   public Break() {
      if( Stmt.Enclosing == Stmt.Null ) error("unenclosed break");
      stmt = Stmt.Enclosing;
   }

   public void gen(int b, int a) {
      emit("goto L" + stmt.after); // stmt.after标记紧跟在stmt的代码之后的指令
   }
   
   public void display(){
	   emit(" break ");
   }
}
