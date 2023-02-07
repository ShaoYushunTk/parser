package inter;

import symbols.Type;

public class For extends Stmt {

    Expr expr; Stmt stmt,stmt1,stmt2;

    public For() { expr = null; stmt = null; stmt1 = null; stmt2 = null; }

    public void init(Expr x, Stmt s, Stmt s1, Stmt s2) {
        expr = x; stmt = s; stmt1 = s1; stmt2 = s2;
        if( expr.type != Type.Bool ) expr.error("boolean required in for");
    }

    public void gen(int b, int a) {
        after = a;         //保存标号a
        int label = newlabel();  // label用于expr
        int label2 = newlabel(); // label2用于stmt2
        int label1 = newlabel(); // label1用于stmt1
        stmt.gen(b,label);
        emitlabel(label); expr.jumping(0,a);
        emitlabel(label2); stmt2.gen(label2,label1);
        emitlabel(label1); stmt1.gen(label1,label); emit("goto L" + label);

    }

    public void display() {
        emit("stmt : for begin");
        stmt.display();
        stmt1.display();
        stmt2.display();
        emit("stmt : for end");
    }
}
