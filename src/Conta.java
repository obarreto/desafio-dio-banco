
public abstract class Conta implements InterfaceConta{
	
	private static  int SEQUENCIAL = 1;
	private static final int AGENCIA_PADRAO = 1;
	
	protected int agencia;
	protected int numeroConta;
	protected double saldoConta;
	private Cliente cliente;


	public Conta(Cliente cliente) {
		
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numeroConta = SEQUENCIAL++;
		this.cliente = cliente;
	}

	
	public int getNumeroConta() {
		return numeroConta;
	}

	public double getSaldoConta() {
		return saldoConta;
	}
	

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Conta: %d", this.numeroConta));
		System.out.println(String.format("Saldo: %.2f", this.saldoConta));
	}

	@Override
	public void sacar(double valor) {
		// TODO Auto-generated method stub
		saldoConta -= valor;
	}

	@Override
	public void depositar(double valor) {
		// TODO Auto-generated method stub
		this.saldoConta += valor;
		
	}

	@Override
	public void transferir(double valor, InterfaceConta contaDestino) {
		// TODO Auto-generated method stub
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		// TODO Auto-generated method stub
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
}
