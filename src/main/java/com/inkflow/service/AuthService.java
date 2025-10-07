package com.inkflow.service;

import com.inkflow.dto.LoginResponse;
import com.inkflow.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class AuthService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private final RowMapper<Usuario> usuarioRowMapper = new RowMapper<Usuario>() {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setTelefone(rs.getString("telefone"));
            usuario.setSenha(rs.getString("senha"));
            return usuario;
        }
    };
    
    public LoginResponse login(String email, String senha) {
        try {
            String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
            List<Usuario> usuarios = jdbcTemplate.query(sql, usuarioRowMapper, email, senha);
            
            if (usuarios.isEmpty()) {
                return new LoginResponse(false, null, null, "Email ou senha incorretos");
            }
            
            Usuario usuario = usuarios.get(0);
            return new LoginResponse(true, usuario.getId(), usuario.getNome(), "Login realizado com sucesso");
        } catch (Exception e) {
            return new LoginResponse(false, null, null, "Erro interno do servidor");
        }
    }
    
    public Usuario register(String nome, String email, String senha) {
        try {
            String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?) RETURNING *";
            List<Usuario> usuarios = jdbcTemplate.query(sql, usuarioRowMapper, nome, email, senha);
            return usuarios.isEmpty() ? null : usuarios.get(0);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar usuário: " + e.getMessage());
        }
    }
}