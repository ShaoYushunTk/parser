package inter;

import lexer.Token;

public class Or extends Logical {

   public Or(Token tok, Expr x1, Expr x2) { super(tok, x1, x2); }

   // B = B1 || B2
   // t��f��ʾB��true���ں�false����
   public void jumping(int t, int f) {
      // ����t��f������������0 ��B1Ϊ�棬��BΪ�棬B1��true����Ϊt��B1��false���ڶ�ӦB2��һ��ָ����ʹ��������0����ʾ��������B1��Խ ����B1�Ĵ���֮�����һ��ָ��
      // һ�������B��true����t����Ϊ0 ����label��֤B1��true���ڱ�����ΪB�Ĵ���Ľ�β��
      int label = t != 0 ? t : newlabel();
      expr1.jumping(label,0);
      expr2.jumping(t,f);
      if ( t == 0 ) emitlabel(label); // tΪ������0 ����label
   }
}
