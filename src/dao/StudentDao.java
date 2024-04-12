package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import bean.School;
import bean.Student;

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
		private String baseSql = "select * from student where school_cd=?" ;
		private List<Student> postFilter(ResultSet rSet, School school) throws Exception {
			// リストを初期化
			List<Student> list = new ArrayList<>();
			try {
				// リザルトセットを全件走査
				while (rSet.next()) {
					// 学生インスタンスを初期化
					Student student = new Student();
					// 学生インスタンスに検索結果をセット
					student.setNo(rSet.getString("no"));
					student.setName(rSet.getString("name"));
					student.set.EntYear(rSet.getInt("ent_year"));
					student.setAttend(rSet.getBoolean("is_attend"));
					student.setSchool(school);
					// リストに追加
					list.add(student);
				}
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}

			return list;
		}
		public List<Student> filter(School school, int entYear, String classNum, boolean isAttend) throws Exception {
			// リストを初期化
			List<Student> list = new ArrayList<>();
			// コネクションを確立
			Connection connection = getConnuection();
			// プリペアードステートメント
			PreparedStatement statement = null;
			// リザルトセット
			ResultSet rSet = null;
			// SQL文の条件
			String condition = "and ent_year=? and class_num=?";
			// SQL文のソート
			String order = "order by no asc";

			// SQL文の在学フラグ条件
			String conditionIsAttend ="";
			// 在学フラグがtrueの場合
			if (isAttend) {
				conditionIsAttend = "and is_attend=true";
			}

			try {
				// プリペアードステートメントにSQL文をセット
				statement = connection.prepareStatement(baseSql + condition + conditionIsAttend + order);
				// プリペアードステートメントに学校コードをバインド
				statement.setString(1, school.getCd());
				// プリペアードステートメントに入学年度をバインド
				statement.setInt(2, entYear);
				// プリペアードステートメントにクラス番号をバインド
				statement.setString(3, classNum);
				// プリペアードステートメントを実行
				rSet = statement.executeQuery();
				// リストへの格納処理を実行
				list = postFilter(rSet, school);
			} catch (Exception e) {
				throw e;
			} finally {
				// プリペアードステートメントを閉じる
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException sqle) {
						throw sqle;
					}
				}
			}

			return list;
		}
		public List<Student> filter(School school, int entYear, boolean isAttend) throws Exeption {
			// リストを初期化
			List<Student> list = new ArrayList<>();
			// コネクションを確立
			Connection connection = getConnection();
			// プリペアードステートメント
			PreparedStatement statement = null;
			// リザルトセット
			ResultSet rSet = null;
			// SQL文の条件
			String condition = "and ent_year=?";
			// SQL文のソート
			String order = "order by no asc";

			// SQL文の在学フラグ
			String conditionIsAttend = "";
			// 在学フラグがtureだった場合
			if (isAttend) {
				conditionIsAttend = "and is_attend=ture";
			}

			try {
				// プリペアードステートメントにSQL文をセット
				statement = coonection.prepareStatement(baseSql + condition + conditionIsAttend + order);
				// プリペアードステートメントに学校コードをバインド
				statement.setString(1, school.getCd());
				// プリペアードステートメントに入学年度をバインド
				atatement.setInt(2, entYear);
				// プリペアードステートメントを実行
				rSet = statement.executeQuery();
				// リストへの格納を実行
				list = postFilter(rSet, school);
			} catch (Exception e) {
				throw e;
			} finally {
				// プリペアードステートメントを閉じる
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException sqle) {
						throw sqle;
					}
				}
				// コネクションを閉じる
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException sqle) {
						throw sqle;
					}
				}
			}

			return list;
		}
		public List<Student> filter(School school, boolean isAttend) throws Exception {
			// リストを初期化
			List<student> list = new ArrayList<>();
			//コネクションを確立
			Connection connection = getConnection();
			// プリペアードステートメント
			PreparedStatement statement = null;
			// リザルトセット
			Resultset rSet = null;
			//SQL文の条件
			String order = "order by no asc";

			// SQL文の在学フラグ
			String conditionIsAttend = "";
			// 在学フラグがtureの場合
			if (isAttend) {
				conditionIsAttend = "and is_attend=ture";
			}

			try {

			}
		}
	}
}