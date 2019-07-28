package br.edu.ifpb.simpleevents.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_usuario")
//@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class User implements Participante {
//implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@NotEmpty(message = "Nome e obrigatorio")
	private String nome;

	//@Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", message = "Informe um telefone [(83) 98892-1223]")
	private String telefone;
	
	@Column(unique=true)
	private String email;
	
//	@Size(min = 8, message = "a senha deve conter no minino 8 caracteres")
	private String senha;
	
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@Past(message = "A data deve estar no passado")
	private Date datanascimento;
	
	/* rela��o com eventos */
	@OneToMany(mappedBy = "dono", cascade = CascadeType.ALL)
	private List<Evento> eventos = new ArrayList<>();
	
	/* relacao com candidato_vaga */
	@OneToOne
	private CandidatoVaga candidatoVaga;
	
	/* relacao com Avaliacao_evento */
	@OneToOne
	private AvaliacaoEvento avaliacaoEvento;
	
	private boolean isAdmin = false;

	public User() {
	}

	public AvaliacaoEvento getAvaliacaoEvento() {
		return avaliacaoEvento;
	}

	public void setAvaliacaoEvento(AvaliacaoEvento avaliacao) {
		this.avaliacaoEvento = avaliacao;
	}

	public CandidatoVaga getCandidatoVaga() {
		return candidatoVaga;
	}

	public void setCandidatoVaga(CandidatoVaga candidatoVaga) {
		this.candidatoVaga = candidatoVaga;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void add(Evento ev) {
		this.eventos.add(ev);
	}

	public void remove(Evento ev) {
		this.eventos.remove(ev);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", senha=" + senha
				+ ", datanascimento=" + datanascimento + "]";
	}

	@Override
	public int getCount() {
		return 1;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		
//		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//		grantList.add(new SimpleGrantedAuthority("ROLE_USER"));
//		
//		if (this.isAdmin()) {
//			GrantedAuthority autorizacaoAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
//			grantList.add(autorizacaoAdmin);
//		}
//		return grantList;
//	}

//	@Override
//	public String getPassword() {
//		return this.getSenha();
//	}
//
//	@Override
//	public String getUsername() {
//		return this.getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}

}
