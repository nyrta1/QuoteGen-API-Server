package jsonserver.quotegenapi.database.repository;

import jsonserver.quotegenapi.database.config.ConfigDataSource;
import jsonserver.quotegenapi.models.QuoteContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class QuoteContentRepositoryImpl implements QuoteContentRepository {
    private final ConfigDataSource configDataSource;

    @Autowired
    public QuoteContentRepositoryImpl(ConfigDataSource configDataSource) {
        this.configDataSource = configDataSource;
    }

    @Override
    public Optional<QuoteContent> findById(Long quoteId) {
        DataSource dataSource = null;
        Connection connection = null;
        PreparedStatement prepStatement = null;
        ResultSet resultSet = null;
        QuoteContent content = new QuoteContent();

        try {
            dataSource = configDataSource.dataSource();
            connection = dataSource.getConnection();
            prepStatement = connection.prepareStatement(
                    "SELECT qc.id AS content_id, qc.author, qc.content, " +
                            "qc.date_added, qc.date_modified, " +
                            "qt.id AS tag_id, qt.tag_name " +
                            "FROM quote_content qc " +
                            "LEFT JOIN quote_tags_mapping qtm ON qtm.quote_id = qc.id " +
                            "LEFT JOIN quote_tags qt ON qtm.tag_id = qt.id " +
                            "WHERE qc.id = ?");
            prepStatement.setLong(1, quoteId);

            resultSet = prepStatement.executeQuery();

            List<String> tags = new ArrayList<>();
            while (resultSet.next()) {
                content.setId(resultSet.getLong("content_id"));
                content.setAuthor(resultSet.getString("author"));
                content.setContent(resultSet.getString("content"));
                content.setDateAdded(resultSet.getDate("date_added"));
                content.setDateModified(resultSet.getDate("date_modified"));
                tags.add(resultSet.getString("tag_name"));
            }
            content.setTags(tags);
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (prepStatement != null) prepStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }

        return Optional.of(content);
    }
}
