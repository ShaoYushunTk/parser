package inter;

import lexer.Token;

public class Or extends Logical {

   public Or(Token tok, Expr x1, Expr x2) { super(tok, x1, x2); }

   // B = B1 || B2
   // t和f表示B的true出口和false出口
   public void jumping(int t, int f) {
      // 假设t和f都不是特殊标号0 若B1为真，则B为真，B1的true出口为t，B1的false出口对应B2第一条指令，因此使用特殊标号0，表示控制流从B1穿越 到达B1的代码之后的下一个指令
      // 一般情况下B的true出口t可能为0 变量label保证B1的true出口被设置为B的代码的结尾处
      int label = t != 0 ? t : newlabel();
      expr1.jumping(label,0);
      expr2.jumping(t,f);
      if ( t == 0 ) emitlabel(label); // t为特殊标号0 生成label
   }
}
