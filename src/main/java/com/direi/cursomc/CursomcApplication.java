package com.direi.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.direi.cursomc.domain.Categoria;
import com.direi.cursomc.domain.Cidade;
import com.direi.cursomc.domain.Cliente;
import com.direi.cursomc.domain.Endereco;
import com.direi.cursomc.domain.Estado;
import com.direi.cursomc.domain.ItemPedido;
import com.direi.cursomc.domain.Pagamento;
import com.direi.cursomc.domain.PagamentoComBoleto;
import com.direi.cursomc.domain.PagamentoComCartao;
import com.direi.cursomc.domain.Pedido;
import com.direi.cursomc.domain.Produto;
import com.direi.cursomc.domain.enums.EstadoPagamento;
import com.direi.cursomc.domain.enums.TipoCliente;
import com.direi.cursomc.repositories.CategoriaRepository;
import com.direi.cursomc.repositories.CidadeRepository;
import com.direi.cursomc.repositories.ClienteRepository;
import com.direi.cursomc.repositories.EnderecoRepository;
import com.direi.cursomc.repositories.EstadoRepository;
import com.direi.cursomc.repositories.ItemPedidoRepository;
import com.direi.cursomc.repositories.PagamentoRepository;
import com.direi.cursomc.repositories.PedidoRepository;
import com.direi.cursomc.repositories.ProdutoRepository;
import com.fasterxml.jackson.databind.ser.std.ArraySerializerBase;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private  ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired 
	private CidadeRepository cidadeRepository;
	@Autowired 
	private ClienteRepository clienteRepository;
	@Autowired 
	private EnderecoRepository enderecoRepository;
	
	@Autowired 
	private PedidoRepository pedidoRepository;
	
	@Autowired 
	private PagamentoRepository pagamentoRepository;
	
	@Autowired 
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Escritório");
		Categoria cat2 = new Categoria(null,"Informática");
		Categoria cat3 = new Categoria(null,"Cozinha");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",600.00);
		Produto p3 = new Produto(null,"Mouse",30.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		repo.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");
		estadoRepository.saveAll(Arrays.asList(e1,e2));
		
		Cidade c1 = new Cidade(null, "Uberlândia", e1);
		Cidade c2 = new Cidade(null, "São Paulo", e2);
		Cidade c3 = new Cidade(null, "Campinas", e2);
		
		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2,c3));
		
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Valdirei Felipe", "valdireifm@gmail.com", "09099393030", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("3333-3333","9999-99999"));
		
		Endereco end1 = new Endereco(null, "Rua Flor", "234","casa", "Vila Pinho", "30980-098", cli1, c1);
		Endereco end2 = new Endereco(null, "Warley Aparecido", "566","apto 69", "Barreiro", "30980-098", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido pedido1 = new Pedido(null, sdf.parse("30/10/2017 10:40"), cli1, end1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 19:40"), cli1, end2);
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,pedido1, 5);
		pedido1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,pedido2, sdf.parse("20/10/2017 15:00"),null);
		pedido2.setPagamento(pagto2);
		
		
		cli1.getPedidos().addAll(Arrays.asList(pedido1,pedido2));
		
		pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
		
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(pedido1, p1, 0.0, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(pedido1, p3, 0.0, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(pedido2, p2, 100.0, 1, 8000.00);
		
		pedido1.getItens().addAll(Arrays.asList(ip1,ip2));
		pedido1.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
				
		
	}

}
