package org.eminphis.db;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: CustomStatement.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * A prepared statement wrapper. Further enables string comparison using their
 * pool values. We can compare strings using the == operator.
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
class CustomStatement{

    private final PreparedStatement preparedStatement;
    private final String statement;

    CustomStatement(String statement) throws SQLException{
        this.statement=statement;
        this.preparedStatement=DBManager.getDBConnection().prepareStatement(statement);
    }

    String getStatement(){
        return statement;
    }

    ResultSet executeQuery() throws SQLException{
        return preparedStatement.executeQuery();
    }

    int executeUpdate() throws SQLException{
        return preparedStatement.executeUpdate();
    }

    void setNull(int parameterIndex,int sqlType) throws SQLException{
        preparedStatement.setNull(parameterIndex,sqlType);
    }

    void setBoolean(int parameterIndex,boolean x) throws SQLException{
        preparedStatement.setBoolean(parameterIndex,x);
    }

    void setByte(int parameterIndex,byte x) throws SQLException{
        preparedStatement.setByte(parameterIndex,x);
    }

    void setShort(int parameterIndex,short x) throws SQLException{
        preparedStatement.setShort(parameterIndex,x);
    }

    void setInt(int parameterIndex,int x) throws SQLException{
        preparedStatement.setInt(parameterIndex,x);
    }

    void setLong(int parameterIndex,long x) throws SQLException{
        preparedStatement.setLong(parameterIndex,x);
    }

    void setFloat(int parameterIndex,float x) throws SQLException{
        preparedStatement.setFloat(parameterIndex,x);
    }

    void setDouble(int parameterIndex,double x) throws SQLException{
        preparedStatement.setDouble(parameterIndex,x);
    }

    void setBigDecimal(int parameterIndex,BigDecimal x) throws SQLException{
        preparedStatement.setBigDecimal(parameterIndex,x);
    }

    void setString(int parameterIndex,String x) throws SQLException{
        preparedStatement.setString(parameterIndex,x);
    }

    void setBytes(int parameterIndex,byte[] x) throws SQLException{
        preparedStatement.setBytes(parameterIndex,x);
    }

    void setDate(int parameterIndex,Date x) throws SQLException{
        preparedStatement.setDate(parameterIndex,x);
    }

    void setTime(int parameterIndex,Time x) throws SQLException{
        preparedStatement.setTime(parameterIndex,x);
    }

    void setTimestamp(int parameterIndex,Timestamp x) throws SQLException{
        preparedStatement.setTimestamp(parameterIndex,x);
    }

    void setAsciiStream(int parameterIndex,InputStream x,int length) throws SQLException{
        preparedStatement.setAsciiStream(parameterIndex,x,length);
    }

    void setUnicodeStream(int parameterIndex,InputStream x,int length) throws SQLException{
        preparedStatement.setUnicodeStream(parameterIndex,x,length);
    }

    void setBinaryStream(int parameterIndex,InputStream x,int length) throws SQLException{
        preparedStatement.setBinaryStream(parameterIndex,x,length);
    }

    void clearParameters() throws SQLException{
        preparedStatement.clearParameters();
    }

    void setObject(int parameterIndex,Object x,int targetSqlType) throws SQLException{
        preparedStatement.setObject(parameterIndex,x,targetSqlType);
    }

    void setObject(int parameterIndex,Object x) throws SQLException{
        preparedStatement.setObject(parameterIndex,x);
    }

    boolean execute() throws SQLException{
        return preparedStatement.execute();
    }

    void addBatch() throws SQLException{
        preparedStatement.addBatch();
    }

    void setCharacterStream(int parameterIndex,Reader reader,int length) throws SQLException{
        preparedStatement.setCharacterStream(parameterIndex,reader,length);
    }

    void setRef(int parameterIndex,Ref x) throws SQLException{
        preparedStatement.setRef(parameterIndex,x);
    }

    void setBlob(int parameterIndex,Blob x) throws SQLException{
        preparedStatement.setBlob(parameterIndex,x);
    }

    void setClob(int parameterIndex,Clob x) throws SQLException{
        preparedStatement.setClob(parameterIndex,x);
    }

    void setArray(int parameterIndex,Array x) throws SQLException{
        preparedStatement.setArray(parameterIndex,x);
    }

    ResultSetMetaData getMetaData() throws SQLException{
        return preparedStatement.getMetaData();
    }

    void setDate(int parameterIndex,Date x,Calendar cal) throws SQLException{
        preparedStatement.setDate(parameterIndex,x,cal);
    }

    void setTime(int parameterIndex,Time x,Calendar cal) throws SQLException{
        preparedStatement.setTime(parameterIndex,x,cal);
    }

    void setTimestamp(int parameterIndex,Timestamp x,Calendar cal) throws SQLException{
        preparedStatement.setTimestamp(parameterIndex,x,cal);
    }

    void setNull(int parameterIndex,int sqlType,String typeName) throws SQLException{
        preparedStatement.setNull(parameterIndex,sqlType,typeName);
    }

    void setURL(int parameterIndex,URL x) throws SQLException{
        preparedStatement.setURL(parameterIndex,x);
    }

    ParameterMetaData getParameterMetaData() throws SQLException{
        return preparedStatement.getParameterMetaData();
    }

    void setRowId(int parameterIndex,RowId x) throws SQLException{
        preparedStatement.setRowId(parameterIndex,x);
    }

    void setNString(int parameterIndex,String value) throws SQLException{
        preparedStatement.setNString(parameterIndex,value);
    }

    void setNCharacterStream(int parameterIndex,Reader value,long length) throws SQLException{
        preparedStatement.setNCharacterStream(parameterIndex,value,length);
    }

    void setNClob(int parameterIndex,NClob value) throws SQLException{
        preparedStatement.setNClob(parameterIndex,value);
    }

    void setClob(int parameterIndex,Reader reader,long length) throws SQLException{
        preparedStatement.setClob(parameterIndex,reader,length);
    }

    void setBlob(int parameterIndex,InputStream inputStream,long length) throws SQLException{
        preparedStatement.setBlob(parameterIndex,inputStream,length);
    }

    void setNClob(int parameterIndex,Reader reader,long length) throws SQLException{
        preparedStatement.setNClob(parameterIndex,reader,length);
    }

    void setSQLXML(int parameterIndex,SQLXML xmlObject) throws SQLException{
        preparedStatement.setSQLXML(parameterIndex,xmlObject);
    }

    void setObject(int parameterIndex,Object x,int targetSqlType,int scaleOrLength) throws
            SQLException{
        preparedStatement.setObject(parameterIndex,x,targetSqlType,scaleOrLength);

    }

    void setAsciiStream(int parameterIndex,InputStream x,long length) throws SQLException{
        preparedStatement.setAsciiStream(parameterIndex,x,length);
    }

    void setBinaryStream(int parameterIndex,InputStream x,long length) throws SQLException{
        preparedStatement.setBinaryStream(parameterIndex,x,length);
    }

    void setCharacterStream(int parameterIndex,Reader reader,long length) throws SQLException{
        preparedStatement.setCharacterStream(parameterIndex,reader,length);
    }

    void setAsciiStream(int parameterIndex,InputStream x) throws SQLException{
        preparedStatement.setAsciiStream(parameterIndex,x);
    }

    void setBinaryStream(int parameterIndex,InputStream x) throws SQLException{
        preparedStatement.setBinaryStream(parameterIndex,x);
    }

    void setCharacterStream(int parameterIndex,Reader reader) throws SQLException{
        preparedStatement.setCharacterStream(parameterIndex,reader);
    }

    void setNCharacterStream(int parameterIndex,Reader value) throws SQLException{
        preparedStatement.setNCharacterStream(parameterIndex,value);
    }

    void setClob(int parameterIndex,Reader reader) throws SQLException{
        preparedStatement.setClob(parameterIndex,reader);
    }

    void setBlob(int parameterIndex,InputStream inputStream) throws SQLException{
        preparedStatement.setBlob(parameterIndex,inputStream);
    }

    void setNClob(int parameterIndex,Reader reader) throws SQLException{
        preparedStatement.setNClob(parameterIndex,reader);
    }

    ResultSet executeQuery(String sql) throws SQLException{
        return preparedStatement.executeQuery(sql);
    }

    int executeUpdate(String sql) throws SQLException{
        return preparedStatement.executeUpdate(sql);
    }

    void close() throws SQLException{
        preparedStatement.close();
    }

    int getMaxFieldSize() throws SQLException{
        return preparedStatement.getMaxFieldSize();
    }

    void setMaxFieldSize(int max) throws SQLException{
        preparedStatement.setMaxFieldSize(max);
    }

    int getMaxRows() throws SQLException{
        return preparedStatement.getMaxRows();
    }

    void setMaxRows(int max) throws SQLException{
        preparedStatement.setMaxRows(max);
    }

    void setEscapeProcessing(boolean enable) throws SQLException{
        preparedStatement.setEscapeProcessing(enable);
    }

    int getQueryTimeout() throws SQLException{
        return preparedStatement.getQueryTimeout();
    }

    void setQueryTimeout(int seconds) throws SQLException{
        preparedStatement.setQueryTimeout(seconds);
    }

    void cancel() throws SQLException{
        preparedStatement.cancel();
    }

    SQLWarning getWarnings() throws SQLException{
        return preparedStatement.getWarnings();
    }

    void clearWarnings() throws SQLException{
        preparedStatement.clearWarnings();
    }

    void setCursorName(String name) throws SQLException{
        preparedStatement.setCursorName(name);
    }

    boolean execute(String sql) throws SQLException{
        return preparedStatement.execute(sql);
    }

    ResultSet getResultSet() throws SQLException{
        return preparedStatement.getResultSet();
    }

    int getUpdateCount() throws SQLException{
        return preparedStatement.getUpdateCount();
    }

    boolean getMoreResults() throws SQLException{
        return preparedStatement.getMoreResults();
    }

    void setFetchDirection(int direction) throws SQLException{
        preparedStatement.setFetchDirection(direction);
    }

    int getFetchDirection() throws SQLException{
        return preparedStatement.getFetchDirection();
    }

    void setFetchSize(int rows) throws SQLException{
        preparedStatement.setFetchSize(rows);
    }

    int getFetchSize() throws SQLException{
        return preparedStatement.getFetchSize();
    }

    int getResultSetConcurrency() throws SQLException{
        return preparedStatement.getResultSetConcurrency();
    }

    int getResultSetType() throws SQLException{
        return preparedStatement.getResultSetType();
    }

    void addBatch(String sql) throws SQLException{
        preparedStatement.addBatch(sql);
    }

    void clearBatch() throws SQLException{
        preparedStatement.clearBatch();
    }

    int[] executeBatch() throws SQLException{
        return preparedStatement.executeBatch();
    }

    Connection getConnection() throws SQLException{
        return preparedStatement.getConnection();
    }

    boolean getMoreResults(int current) throws SQLException{
        return preparedStatement.getMoreResults(current);
    }

    ResultSet getGeneratedKeys() throws SQLException{
        return preparedStatement.getGeneratedKeys();
    }

    int executeUpdate(String sql,int autoGeneratedKeys) throws SQLException{
        return preparedStatement.executeUpdate(sql,autoGeneratedKeys);
    }

    int executeUpdate(String sql,int[] columnIndexes) throws SQLException{
        return preparedStatement.executeUpdate(sql,columnIndexes);
    }

    int executeUpdate(String sql,String[] columnNames) throws SQLException{
        return preparedStatement.executeUpdate(sql,columnNames);
    }

    boolean execute(String sql,int autoGeneratedKeys) throws SQLException{
        return preparedStatement.execute(sql,autoGeneratedKeys);
    }

    boolean execute(String sql,int[] columnIndexes) throws SQLException{
        return preparedStatement.execute(sql,columnIndexes);
    }

    boolean execute(String sql,String[] columnNames) throws SQLException{
        return preparedStatement.execute(sql,columnNames);
    }

    int getResultSetHoldability() throws SQLException{
        return preparedStatement.getResultSetHoldability();
    }

    boolean isClosed() throws SQLException{
        return preparedStatement.isClosed();
    }

    void setPoolable(boolean poolable) throws SQLException{
        preparedStatement.setPoolable(poolable);
    }

    boolean isPoolable() throws SQLException{
        return preparedStatement.isPoolable();
    }

    void closeOnCompletion() throws SQLException{
        preparedStatement.closeOnCompletion();
    }

    boolean isCloseOnCompletion() throws SQLException{
        return preparedStatement.isCloseOnCompletion();
    }

    <T> T unwrap(Class<T> iface) throws SQLException{
        return preparedStatement.unwrap(iface);
    }

    boolean isWrapperFor(
            Class<?> iface) throws SQLException{
        return preparedStatement.isWrapperFor(iface);
    }
}
