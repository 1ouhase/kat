package net.iouhase.kat.adapters;

import net.iouhase.kat.model.Cat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatRepository {
    private final JdbcTemplate jdbcTemplate;

    public CatRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Cat cat) {
        String sql = "INSERT INTO cat (owner, name, race age) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, cat.getOwner(), cat.getName(), cat.getRace(), cat.getAge());
    }

    public Cat findByID(Cat cat) {
        String sql = "SELECT * FROM kat WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Cat.class), cat.getId());
    }

    public List<Cat> findAll() {
        String sql = "SELECT id, owner, name, race, age FROM kat ORDER BY id DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cat.class));
    }

    public void update(Cat cat) {
        String sql = "UPDATE kat SET owner = ?, name = ?, race = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, cat.getOwner(), cat.getName(), cat.getRace(), cat.getAge());
    }

    public void delete(Cat cat) {
        String sql = "DELETE FROM cat WHERE id = ?";
        jdbcTemplate.update(sql, cat.getId());
    }
}
