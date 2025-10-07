package com.inkflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Nome do cliente é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Column(name = "cliente_nome")
    private String clienteNome;
    
    @Size(max = 20, message = "Telefone deve ter no máximo 20 caracteres")
    private String telefone;
    
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
    private String email;
    
    private Integer idade;
    
    @Size(max = 200, message = "Serviço deve ter no máximo 200 caracteres")
    private String servico;
    
    @NotNull(message = "Data do agendamento é obrigatória")
    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;
    
    @Size(max = 10, message = "Horário deve ter no máximo 10 caracteres")
    private String horario;
    
    @Size(max = 100, message = "Artista deve ter no máximo 100 caracteres")
    private String artista;
    
    @Size(max = 50, message = "Tamanho deve ter no máximo 50 caracteres")
    private String tamanho;
    
    @Size(max = 100, message = "Local do corpo deve ter no máximo 100 caracteres")
    @Column(name = "local_corpo")
    private String localCorpo;
    
    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    @Size(max = 50, message = "Orçamento deve ter no máximo 50 caracteres")
    private String orcamento;
    
    @Column(name = "primeira_tatuagem", columnDefinition = "boolean default false")
    private Boolean primeiraTatuagem = false;
    
    @Column(columnDefinition = "varchar(20) default 'pendente'")
    private String status = "pendente";
    
    @Column(precision = 10, scale = 2, columnDefinition = "decimal(10,2) default 0")
    private BigDecimal preco = BigDecimal.ZERO;
    
    @Column(name = "criado_em", columnDefinition = "timestamp default now()")
    private LocalDateTime criadoEm;
    
    // Constructors
    public Agendamento() {
        this.criadoEm = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getClienteNome() { return clienteNome; }
    public void setClienteNome(String clienteNome) { this.clienteNome = clienteNome; }
    
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }
    
    public String getServico() { return servico; }
    public void setServico(String servico) { this.servico = servico; }
    
    public LocalDate getDataAgendamento() { return dataAgendamento; }
    public void setDataAgendamento(LocalDate dataAgendamento) { this.dataAgendamento = dataAgendamento; }
    
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    
    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }
    
    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }
    
    public String getLocalCorpo() { return localCorpo; }
    public void setLocalCorpo(String localCorpo) { this.localCorpo = localCorpo; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public String getOrcamento() { return orcamento; }
    public void setOrcamento(String orcamento) { this.orcamento = orcamento; }
    
    public Boolean getPrimeiraTatuagem() { return primeiraTatuagem; }
    public void setPrimeiraTatuagem(Boolean primeiraTatuagem) { this.primeiraTatuagem = primeiraTatuagem; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    
    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}