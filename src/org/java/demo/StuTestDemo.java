package org.java.demo;

import org.java.dao.ScoreDao;
import org.java.dao.StuDao;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 学生考试系统测试类
 * 
 * @author FanShengSheng
 * @version
 */
public class StuTestDemo {
	// 分别创建两个dao对象的实例
	private StuDao stuDao = new StuDao();
	private ScoreDao scoreDao = new ScoreDao();
	// 创建扫描器
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StuTestDemo std = new StuTestDemo();
		std.mainPage();
	}

	// 主界面
	public void mainPage() {
		System.out.println();
		System.out.println("----------学生考试系统----------");
		System.out.println("1、添加学生");
		System.out.println("2、添加考试成绩");
		System.out.println("3、学生成绩查询");
		System.out.print("请选择：");
		int op = sc.nextInt();
		switch (op) {
		case 1:
			addStu();
			break;
		case 2:
			addScore();
			break;
		case 3:
			showScore();
			break;
		default:
			break;
		}
	}

	// 添加学生
	public void addStu() {
		System.out.println("-----添加学生");
		System.out.print("请输入学生的姓名：");
		String name = sc.next();
		System.out.print("请输入学生的性别：");
		String gender = sc.next();
		System.out.print("请输入生日：");
		String birthday = sc.next();
		// 添加学生
		stuDao.updateStu(name, gender, birthday);
		System.out.println("=====录入成功");
		System.out.println("1、继续添加");
		System.out.println("2、返回上级");
		System.out.print("请选择：");
		int op = sc.nextInt();
		if (op == 1) {
			addStu();
		} else {
			mainPage();
		}

	}

	// 添加考试成绩
	public void addScore() {
		System.out.println("-----添加考试成绩");
		System.out.print("请输入学生编号：");
		int id = sc.nextInt();
		System.out.print("请输入考试科目（1、语文 2、数学）：");
		int course = sc.nextInt();
		System.out.print("请输入考试成绩：");
		int grade = sc.nextInt();
		// 添加考试成绩
		scoreDao.updateScore(id, course, grade);
		System.out.println("=====录入成功");
		System.out.println("1、继续添加");
		System.out.println("2、返回上级");
		System.out.print("请选择：");
		int op = sc.nextInt();
		if (op == 1) {
			addScore();
		} else {
			mainPage();
			;
		}
	}

	// 学生考试查询界面
	public void showScore() {
		System.out.println("----------学生考试查询系统----------");
		System.out.println("1、查询所有学员信息");
		System.out.println("2、参加考试的学员信息");
		System.out.println("3、查询缺考学员信息");
		System.out.print("请选择：");
		int op = sc.nextInt();
		switch (op) {
		case 1:
			showStu();
			break;
		case 2:
			showTakeExam();
			break;
		case 3:
			showMissExam();
			break;
		default:
			break;
		}
	}

//	查询缺考学员信息
	public void showMissExam() {
		System.out.println("----------缺考学员信息----------");
		System.out.println("学员编号\t学员名称\t性别\t年龄");
		List<Map<String, Object>> list = stuDao.showMissExamInfo();
		for (Map<String, Object> k : list) {
			System.out.println(
					k.get("stuId") + "\t" + k.get("stuName") + "\t" + k.get("stuGender") + "\t" + k.get("stuAge"));
		}
		System.out.println("1、继续查询");
		System.out.println("2、返回上级");
		System.out.print("请选择：");
		int op = sc.nextInt();
		if (op == 1) {
			showScore();
		} else {
			mainPage();
		}
	}

//	参加考试的学员信息
	public void showTakeExam() {
		System.out.println("----------参加考试学员信息----------");
		System.out.println("学员编号\t学员名称\t性别\t年龄\t考试科目\t成绩\t考核结果");
		List<Map<String, Object>> list = stuDao.showTakeExamInfo();
		for (Map<String, Object> k : list) {
			System.out.println(k.get("stuId") + "\t" + k.get("stuName") + "\t" + k.get("stuGender") + "\t"
					+ k.get("stuAge") + "\t" + k.get("cname") + "\t" + k.get("score") + "\t" + k.get("res"));
		}
		System.out.println("1、继续查询");
		System.out.println("2、返回上级");
		System.out.print("请选择：");
		int op = sc.nextInt();
		if (op == 1) {
			showScore();
		} else {
			mainPage();
		}
	}

//	查询所有学员信息
	private void showStu() {
		System.out.println("----------学员信息----------");
		System.out.println("学员编号\t学员名称\t性别\t年龄");
		List<Map<String, Object>> list = stuDao.showAll();
		for (Map<String, Object> k : list) {
			System.out.println(
					k.get("stuId") + "\t" + k.get("stuName") + "\t" + k.get("stuGender") + "\t" + k.get("stuAge"));
		}
		System.out.println("1、继续查询");
		System.out.println("2、返回上级");
		System.out.print("请选择：");
		int op = sc.nextInt();
		if (op == 1) {
			showScore();
		} else {
			mainPage();
		}
	}
}
