package bancopos;

public interface  OperacaoInterface {
	
        
        public void sacar(double valor);
        
        public double consultarSaldo();
        
        public void depositar(double valor);
        
        public void transferir(double valor);
        

}
