package com.direi.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa juridica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int id, String descricao) {
		this.cod = id;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(TipoCliente tc : TipoCliente.values()) {
			if(cod.equals(tc.getCod())){
				return tc;
			}
		}
		
		throw new IllegalArgumentException("codigo Inválido "+cod);
	}
	
}
