/* Generated By:JavaCC: Do not edit this line. Analisador.java */
public class Analisador implements AnalisadorConstants {

    public void processa() throws Exception {
        while (true) {
            Token t = getNextToken();
            String nomeToken = tokenImage[t.kind];
            System.out.println(nomeToken);
            if (t.kind == TERMINAIS)
                break;
        }
    }

   public static void main(String[] args) {
            System.out.print("Digite:");
            Analisador analisador = new Analisador(System.in);
            try {
                  analisador.processa();
            }
            catch (Exception e) {
                  System.out.println(e.getMessage());
                  e.printStackTrace();
            }
      }

  static final public void program() throws ParseException {
    jj_consume_token(PROGRAMA);
    jj_consume_token(IDENTIFICADORES);
    jj_consume_token(TERMINAIS);
    block();
  }

  static final public void block() throws ParseException {
    variableDeclarationPart();
    statementPart();
  }

  static final public void variableDeclarationPart() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAZIO:
      jj_consume_token(VAZIO);
      break;
    case PALAVRAS_RESERVADAS:
      jj_consume_token(PALAVRAS_RESERVADAS);
      variableDeclaration();
      jj_consume_token(TERMINAIS);
      jj_consume_token(ABRE_CHAVE);
      variableDeclaration();
      jj_consume_token(TERMINAIS);
      jj_consume_token(FECHA_CHAVE);
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void variableDeclaration() throws ParseException {
    jj_consume_token(IDENTIFICADORES);
    jj_consume_token(ABRE_CHAVE);
    jj_consume_token(TERMINAIS);
    jj_consume_token(IDENTIFICADORES);
    jj_consume_token(FECHA_CHAVE);
    jj_consume_token(TERMINAIS);
    type();
  }

  static final public void type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TIPOS_DE_DADOS:
      simpleType();
      break;
    case PALAVRAS_RESERVADAS:
      arrayType();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void arrayType() throws ParseException {
    jj_consume_token(PALAVRAS_RESERVADAS);
    jj_consume_token(ABRE_COLCHETE);
    indexRange();
    jj_consume_token(FECHA_COLCHETE);
    jj_consume_token(PALAVRAS_RESERVADAS);
    simpleType();
  }

  static final public void indexRange() throws ParseException {
    jj_consume_token(NUMEROS);
  }

  static final public void simpleType() throws ParseException {
    jj_consume_token(TIPOS_DE_DADOS);
  }

  static final public void typeIdentifier() throws ParseException {
    jj_consume_token(IDENTIFICADORES);
  }

  static final public void statementPart() throws ParseException {
    compoundStatement();
  }

  static final public void compoundStatement() throws ParseException {
    jj_consume_token(PALAVRAS_RESERVADAS);
    statement();
    jj_consume_token(ABRE_CHAVE);
    jj_consume_token(TERMINAIS);
    statement();
    jj_consume_token(FECHA_CHAVE);
    jj_consume_token(PALAVRAS_RESERVADAS);
  }

  static final public void statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMANDOS:
    case IDENTIFICADORES:
      simpleStatement();
      break;
    case PALAVRAS_RESERVADAS:
      structuredStatement();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void simpleStatement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADORES:
      assignment();
      break;
    case COMANDOS:
      readStatement();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void structuredStatement() throws ParseException {
    compoundStatement();
  }

  static final public void ifStatement() throws ParseException {
    jj_consume_token(PALAVRAS_RESERVADAS);
    expression();
    jj_consume_token(PALAVRAS_RESERVADAS);
    statement();
  }

  static final public void whileStatement() throws ParseException {
    jj_consume_token(PALAVRAS_RESERVADAS);
    expression();
    jj_consume_token(PALAVRAS_RESERVADAS);
    statement();
  }

  static final public void readStatement() throws ParseException {
    jj_consume_token(COMANDOS);
    jj_consume_token(ABRE_PARENTESE);
    variable();
    jj_consume_token(ABRE_CHAVE);
    jj_consume_token(TERMINAIS);
    variable();
    jj_consume_token(FECHA_CHAVE);
    jj_consume_token(FECHA_PARENTESE);
  }

  static final public void writeStatement() throws ParseException {
    jj_consume_token(COMANDOS);
    jj_consume_token(ABRE_PARENTESE);
    variable();
    jj_consume_token(ABRE_CHAVE);
    jj_consume_token(TERMINAIS);
    variable();
    jj_consume_token(FECHA_CHAVE);
    jj_consume_token(FECHA_PARENTESE);
  }

  static final public void assignment() throws ParseException {
    variable();
    jj_consume_token(COMPARADORES);
    expression();
  }

  static final public void variable() throws ParseException {
    entireVariable();
  }

  static final public void entireVariable() throws ParseException {
    variableIdentifier();
  }

  static final public void variableIdentifier() throws ParseException {
    jj_consume_token(IDENTIFICADORES);
  }

  static final public void indexedVariable() throws ParseException {
    arrayVariable();
    jj_consume_token(ABRE_COLCHETE);
    expression();
    jj_consume_token(FECHA_COLCHETE);
  }

  static final public void arrayVariable() throws ParseException {
    entireVariable();
  }

  static final public void expression() throws ParseException {
    simpleExpression();
  }

  static final public void relationalOperator() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPERADORES:
      jj_consume_token(OPERADORES);
      break;
    case COMPARADORES:
      jj_consume_token(COMPARADORES);
      break;
    case PALAVRAS_RESERVADAS:
      jj_consume_token(PALAVRAS_RESERVADAS);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void simpleExpression() throws ParseException {
    sing();
    term();
    jj_consume_token(ABRE_CHAVE);
    addingOperator();
    term();
    jj_consume_token(FECHA_CHAVE);
  }

  static final public void sing() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPERADORES:
      jj_consume_token(OPERADORES);
      break;
    case VAZIO:
      jj_consume_token(VAZIO);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void addingOperator() throws ParseException {
    jj_consume_token(OPERADORES);
  }

  static final public void term() throws ParseException {
    factor();
    jj_consume_token(ABRE_CHAVE);
    multiplyingOperator();
    factor();
    jj_consume_token(FECHA_CHAVE);
  }

  static final public void factor() throws ParseException {
    variable();
  }

  static final public void multiplyingOperator() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPERADORES:
      jj_consume_token(OPERADORES);
      break;
    case PALAVRAS_RESERVADAS:
      jj_consume_token(PALAVRAS_RESERVADAS);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void constant() throws ParseException {
    integerConstante();
  }

  static final public void integerConstante() throws ParseException {
    jj_consume_token(NUMEROS);
  }

  static final public void characterConstant() throws ParseException {
    lettetOrDigit();
  }

  static final public void lettetOrDigit() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADORES:
      jj_consume_token(IDENTIFICADORES);
      break;
    case NUMEROS:
      jj_consume_token(NUMEROS);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public AnalisadorTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[8];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x80010,0x50,0x130,0x120,0x610,0x80200,0x210,0x180,};
   }

  /** Constructor with InputStream. */
  public Analisador(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Analisador(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AnalisadorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Analisador(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalisadorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Analisador(AnalisadorTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(AnalisadorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[20];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 8; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 20; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
