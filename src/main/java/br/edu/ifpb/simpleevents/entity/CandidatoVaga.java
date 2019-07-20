package br.edu.ifpb.simpleevents.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_candidato_vaga")
public class CandidatoVaga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Vaga vaga;
	private int notaDesempenho = -1;
	private Status status;
	@OneToOne
	private User candidato;

	public CandidatoVaga() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public int getNotaDesempenho() {
		return notaDesempenho;
	}

	public void setNotaDesempenho(int nota) {
		this.notaDesempenho = nota;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status state) {
		this.status = state;
	}

	public User getCandidato() {
		return candidato;
	}

	public void setCandidato(User candidato) {
		this.candidato = candidato;
	}

	@Override
	public String toString() {
		return "Candidato_Vaga [id=" + id + ", vaga=" + vaga.getEspecialidade().getNome() + ", nota desempenho=" + notaDesempenho + ", state="
				+ status + ", candidato=" + candidato.getNome() + "]";
	}

}
