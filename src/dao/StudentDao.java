package dao;

import java.sql.ResultSet;
import java.util.List;

public class StudentDao extends Dao {
	private String baseSql;

	public Student get(String no) throws Exception {

	}

	private List<student> postFilter(ResultSet rSet, School school) throws Exception {

	}

	public List<student> filter(School school, int entYear, String classNum, boolean isAttend) throws Exception {

	}

	public List<student> filter(School school, int entYear, boolean isAttend) throws Exception {

	}

	public List<student> filter(School school, boolean isAttend) throws Exception {

	}

	public boolean save(Student student) throws Exception {

	}
}