package Domain.Dao.ConnectionPool;

import java.sql.Connection;

import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

public class ConnectionItem {
	private Connection conn;
	private boolean isUse;
	//분산 TX
	private XAResource xaResource ;
	private Xid xid;
	private boolean inTransaction;
	
	public ConnectionItem(Connection conn,XAResource xaResource) {
		this.conn = conn;
		isUse = true;
		this.xaResource = xaResource;
		
	}
	//toString
	//getter and setter

	public Connection getConn() {
		return conn;
	}


	public boolean isUse() {
		return isUse;
	}

	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}

	//분산 TX
	public XAResource getXaResource() {
		return xaResource;
	}

	public void setXaResource(XAResource xaResource) {
		this.xaResource = xaResource;
	}

	public Xid getXid() {
		return xid;
	}

	public void setXid(Xid xid) {
		this.xid = xid;
	}

	public void setInTransaction(boolean b) {
		this.inTransaction = b;
		
	}

	public boolean getInTransaction() {
		// TODO Auto-generated method stub
		return this.inTransaction
				;
	}
	
	
	
}
