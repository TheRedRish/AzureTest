package com.testcompany.azuretest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class TestRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private RowMapper<String> partnerRowMapper = new RowMapper<>() {
        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getString("message");
        }
    };

    public Optional<String> getMessage() {
        String sql = "SELECT * FROM messagetable WHERE messageid = ?";
        int id = 1;
        return jdbcTemplate.query(sql, partnerRowMapper, id).stream().findFirst();
    }
}
