/*package com.java.spring_myprj.qna_dao;

import java.sql.connection;
import java.sql.preparedstatement;
import java.sql.resultset;
import java.sql.sqlexception;
import java.sql.timestamp;
import java.util.arraylist;

import javax.naming.context;
import javax.naming.initialcontext;
import javax.naming.namingexception;
import javax.sql.datasource;

import com.java.spring_myprj.qna_dto.qdto;

public class qdao {

	datasource datasource;

	public qdao() {
		context context;
		try {
			context = new initialcontext();
			datasource = (datasource) context.lookup("java:comp/env/jdbc/orcl");
			system.out.println("db connect!");
		} catch (namingexception e) {
			e.printstacktrace();
		}
	}

	public arraylist<qdto> list() {
		arraylist<qdto> dtos = new arraylist<qdto>();
		connection conn = null;
		preparedstatement pstmt = null;
		resultset rs = null;

		try {
			conn = datasource.getconnection();
			
			string sql = "select qnum,userid,usernick,qtitle,qcontent,qdate"
					+ ",qscheck,qhit,qgroup,qindent,qstep from qnotice order by qgroup desc, qstep asc";

			pstmt = conn.preparestatement(sql);
			rs = pstmt.executequery();

			while (rs.next()) {
				int qnum = rs.getint("qnum");
				string userid = rs.getstring("userid");
				string usernick = rs.getstring("usernick");
				string qtitle = rs.getstring("qtitle");
				string qcontent = rs.getstring("qcontent");
				timestamp qdate = rs.gettimestamp("qdate");
				int qscheck = rs.getint("qscheck");
				int qhit = rs.getint("qhit");
				int qgroup = rs.getint("qgroup");
				int qindent = rs.getint("qindent");
				int qstep = rs.getint("qstep");

				qdto dto = new qdto(qnum, userid, usernick, qtitle, qcontent, qdate, qscheck, qhit, qgroup, qstep,
						qindent);

				dtos.add(dto);
			}

		} catch (sqlexception e) {
			e.printstacktrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (exception e2) {
				e2.printstacktrace();
			}
		}

		return dtos;

	}

	public void write(string usernick, string qtitle, string qcontent) {
		connection conn = null;
		preparedstatement pstmt = null;

		try {
			conn = datasource.getconnection();
			string sql = "insert into qnotice(qnum,usernick,qtitle,qcontent,qscheck,qhit,qgroup,qstep,qindent)"
					+ "values(qnotice_seq.nextval,?,?,?,1,0,qnotice_seq.currval,0,0)";

			system.out.println("usernick : " + usernick);
			system.out.println("qtitle : " + qtitle);
			system.out.println("qcontent : " + qcontent);

			pstmt = conn.preparestatement(sql);
			pstmt.setstring(1, usernick);
			pstmt.setstring(2, qtitle);
			pstmt.setstring(3, qcontent);

			int rn = pstmt.executeupdate();

		} catch (sqlexception e) {

			e.printstacktrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (pstmt != null)
					pstmt.close();
			} catch (exception e2) {
				e2.printstacktrace();
			}
		}
	}

	public void modify(string qnum, string usernick, string qtitle, string qcontent) {
		connection conn = null;
		preparedstatement pstmt = null;

		try {
			conn = datasource.getconnection();
			string sql = "update qnotice set usernick=?, qtitle=?, qcontent=? where qnum=?";
			pstmt = conn.preparestatement(sql);

			pstmt.setstring(1, usernick);
			pstmt.setstring(2, qtitle);
			pstmt.setstring(3, qcontent);
			pstmt.setint(4, integer.parseint(qnum));
			int rn = pstmt.executeupdate();
		} catch (sqlexception e) {
			e.printstacktrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (exception e2) {
				e2.printstacktrace();
			}
		}

	}

	public qdto contenview(string strnum) {
		uphit(strnum);

		qdto dto = null;
		connection conn = null;
		preparedstatement pstmt = null;
		resultset rs = null;

		try {
			conn = datasource.getconnection();
			string sql = "select * from qnotice where qnum=?";

			pstmt = conn.preparestatement(sql);
			pstmt.setint(1, integer.parseint(strnum));

			rs = pstmt.executequery();

			if (rs.next()) {
				int qnum = rs.getint("qnum");
				string userid = rs.getstring("userid");
				string usernick = rs.getstring("usernick");
				string qtitle = rs.getstring("qtitle");
				string qcontent = rs.getstring("qcontent");
				timestamp qdate = rs.gettimestamp("qdate");
				int qscheck = rs.getint("qscheck");
				int qhit = rs.getint("qhit");
				int qgroup = rs.getint("qgroup");
				int qindent = rs.getint("qindent");
				int qstep = rs.getint("qstep");

				dto = new qdto(qnum, userid, usernick, qtitle, qcontent, qdate, qscheck, qhit, qgroup, qstep, qindent);
			}
		} catch (sqlexception e) {

			e.printstacktrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
				}
				conn.close();

			} catch (exception e2) {
				e2.printstacktrace();
			}
		}

		return dto;
	}

	private void uphit(string strid) {

		connection conn = null;
		preparedstatement pstmt = null;
		try {

			conn = datasource.getconnection();

			string sql = "update qnotice set qhit=qhit+1 where qnum=?";

			pstmt = conn.preparestatement(sql);
			pstmt.setstring(1, strid);
			int rn = pstmt.executeupdate();
		} catch (sqlexception e) {
			e.printstacktrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (exception e2) {
				e2.printstacktrace();
			}
		}
	}

	public void delete(string qnum) {
		connection conn = null;
		preparedstatement pstmt = null;

		try {
			conn = datasource.getconnection();
			string sql = "delete from qnotice where qnum=?";

			pstmt = conn.preparestatement(sql);
			pstmt.setint(1, integer.parseint(qnum));
			int rn = pstmt.executeupdate();

		} catch (sqlexception e) {
			e.printstacktrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (exception e2) {
				e2.printstacktrace();
			}
		}

	}

	public void reply(string qnum, string usernick, string qtitle, string qcontent, string qgroup, string qstep,
			string qindent) {

		connection conn = null;
		preparedstatement pstmt = null;

		try {
			conn = datasource.getconnection();
			string sql = "insert into qnotice(qnum,usernick,qtitle,qcontent,qgroup,qstep,qindent)"
					+ "values(qnotice_seq.nextval,?,?,?,?,?,?)";

			pstmt = conn.preparestatement(sql);
			pstmt.setstring(1, usernick);
			pstmt.setstring(2, qtitle);
			pstmt.setstring(3, qcontent);
			pstmt.setint(4, integer.parseint(qgroup));
			pstmt.setint(5, integer.parseint(qstep) + 1);
			pstmt.setint(6, integer.parseint(qindent) + 1);

			int rn = pstmt.executeupdate();

		} catch (sqlexception e) {
			// todo auto-generated catch block
			e.printstacktrace();
		}

	}

	public qdto reply_view(string strid) {
		qdto dto = null;

		connection conn = null;
		preparedstatement pstmt = null;
		resultset rs = null;

		try {
			conn = datasource.getconnection();
			string sql = "select * from qnotice where qnum=?";

			pstmt = conn.preparestatement(sql);
			pstmt.setint(1, integer.parseint(strid));
			rs = pstmt.executequery();

			if (rs.next()) {
				int qnum = rs.getint("qnum");
				string userid = rs.getstring("userid");
				string usernick = rs.getstring("usernick");
				string qtitle = rs.getstring("qtitle");
				string qcontent = rs.getstring("qcontent");
				timestamp qdate = rs.gettimestamp("qdate");

				int qscheck = rs.getint("qscheck");
				int qhit = rs.getint("qhit");
				int qgroup = rs.getint("qgroup");
				int qindent = rs.getint("qindent");
				int qstep = rs.getint("qstep");

				dto = new qdto(qnum, userid, usernick, qtitle, qcontent, qdate, qscheck, qhit, qgroup, qstep, qindent);
			}
		} catch (sqlexception e) {
			e.printstacktrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}if (pstmt != null) {
					pstmt.close();
				}if (conn != null) {
					conn.close();
				}
			} catch (exception e2) {
				e2.printstacktrace();
			}
		}

		return dto;

	}

}*/