package Domain.Dao.ConnectionPool;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

import com.mysql.cj.jdbc.MysqlXADataSource;

public class MysqlXADataSourceFactory implements ObjectFactory {
	
    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx,
                                    Hashtable<?, ?> environment) throws Exception {
        Reference ref = (Reference) obj;

        MysqlXADataSource ds = new MysqlXADataSource();
        ds.setUrl((String) ref.get("url").getContent());
        ds.setUser((String) ref.get("user").getContent());
        ds.setPassword((String) ref.get("password").getContent());

        return ds;
    }
}