/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data.persist.util;

import java.sql.CallableStatement;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(LocalDateTime.class)
public class LocalDateTimeTypeHandler 
    extends BaseTypeHandler<LocalDateTime>
{

    @Override
    public void setNonNullParameter (PreparedStatement ps, 
                                     int i, 
                                     LocalDateTime parameter, 
                                     JdbcType jdbcType)
        throws SQLException
    {
        if (parameter == null)
        {
            ps.setTimestamp(i, null);
        } 
        else
        {
            ps.setTimestamp(i, Timestamp.valueOf(parameter),
                            GregorianCalendar.from(ZonedDateTime.of(parameter, ZoneId.systemDefault())));
        }
    }

    @Override
    public LocalDateTime getNullableResult (ResultSet rs, String columnName)
        throws SQLException
    {
        Timestamp ts = rs.getTimestamp(columnName);
        if (ts != null)
        {
            return LocalDateTime.ofInstant(ts.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }

    @Override
    public LocalDateTime getNullableResult (ResultSet rs, int columnIndex)
        throws SQLException
    {
        Timestamp ts = rs.getTimestamp(columnIndex);
        if (ts != null)
        {
            return LocalDateTime.ofInstant(ts.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }

    @Override
    public LocalDateTime getNullableResult(CallableStatement cs, int columnIndex)
        throws SQLException
    {
        Timestamp ts = cs.getTimestamp(columnIndex);
        if (ts != null)
        {
            return LocalDateTime.ofInstant(ts.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }
}

/* THE END */
