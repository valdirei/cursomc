package com.direi.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.direi.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoComBoleto extends Pagamento{

	private static final long serialVersionUID = 4680679267200529190L;
	
	@JsonFormat(pattern="dd/MM/yyy")
	private Date dataVencimento;
	@JsonFormat(pattern="dd/MM/yyy")
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}



	public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estadoPagamento, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}



	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
}
