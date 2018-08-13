package JavaRush.patern;

interface Expression {
    String interpret(Contexts context);
}

class Contexts {
    public String getLoverCase(String s) {
        return s.toLowerCase();
    }

    public String getUpperCase(String s) {
        return s.toUpperCase();
    }
}

class LoverExpression implements Expression {
    private String s;

    public LoverExpression(String s) {
        this.s = s;
    }

    public String interpret(Contexts context) {
        return context.getLoverCase( s );
    }
}

class UpperExpression implements Expression {
    private String s;

    public UpperExpression(String s) {
        this.s = s;
    }

    public String interpret(Contexts context) {
        return context.getUpperCase( s );
    }
}

public class InterpreterTest {//тест

    public static void main(String[] args) {
        String str = "TesT";
        Contexts context = new Contexts();
        Expression loverExpression = new LoverExpression( str );
        str = loverExpression.interpret( context );
        System.out.println( str );
        Expression upperExpression = new UpperExpression( str );
        str = upperExpression.interpret( context );
        System.out.println( str );
    }
}