package com.momolela.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class TzAutoProjectUtil {
	
	private static String author="momolela";
	private static  String description = "统计管理";
	private static  String date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
	private static  String entity = "Stat";
	private static  String lowEntity = "stat";
	
	//定义所有模板目录
	/**
	 * dao接口方法
	 * 方法名：createDao
	 * 创建人：xuchengfei 时间：2015年5月5日-下午9:37:41  void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createEntity(){
		try {
			//模板页面
			String daoTemplate = getPath("template\\entity.txt");
			//写入到磁盘里面去
			String result = replaceModel(daoTemplate);
			//要生成的根目录
			String daoRoot =  getPath("src\\com\\tz\\model\\");
			File rootPath  = new File(daoRoot);
			//如果不存在那么久创建
			if(!rootPath.exists())rootPath.mkdirs();
			//产生接口文件
			File daoJava = new File(rootPath, entity+".java");
			//讲模板中替换好的数据通过写入目录中去
			FileUtils.writeStringToFile(daoJava, result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * dao接口方法
	 * 方法名：createDao
	 * 创建人：xuchengfei 时间：2015年5月5日-下午9:37:41  void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createDao(){
		try {
			//模板页面
			String daoTemplate = getPath("template\\dao.txt");
			//写入到磁盘里面去
			String result = replaceModel(daoTemplate);
			//要生成的根目录
			String daoRoot =  getPath("src\\com\\tz\\dao\\"+lowEntity);
			File rootPath  = new File(daoRoot);
			//如果不存在那么久创建
			if(!rootPath.exists())rootPath.mkdirs();
			//产生接口文件
			File daoJava = new File(rootPath, "I"+entity+"Dao.java");
			//讲模板中替换好的数据通过写入目录中去
			FileUtils.writeStringToFile(daoJava, result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * dao接口方法
	 * 方法名：createDaoImpl
	 * 创建人：xuchengfei 时间：2015年5月5日-下午9:37:41  void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createDaoImpl(){
		try {
			//模板页面
			String daoTemplate = getPath("template\\daoImpl.txt");
			//写入到磁盘里面去
			String result = replaceModel(daoTemplate);
			//要生成的根目录
			String daoRoot =  getPath("src\\com\\tz\\dao\\"+lowEntity+"\\impl");
			File rootPath  = new File(daoRoot);
			//如果不存在那么久创建
			if(!rootPath.exists())rootPath.mkdirs();
			//产生接口文件
			File daoJava = new File(rootPath, entity+"DaoImpl.java");
			//讲模板中替换好的数据通过写入目录中去
			FileUtils.writeStringToFile(daoJava, result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * dao接口方法
	 * 方法名：createDao
	 * 创建人：xuchengfei 时间：2015年5月5日-下午9:37:41  void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createService(){
		try {
			//模板页面
			String daoTemplate = getPath("template\\service.txt");
			//写入到磁盘里面去
			String result = replaceModel(daoTemplate);
			//要生成的根目录
			String daoRoot =  getPath("src\\com\\tz\\service\\"+lowEntity);
			File rootPath  = new File(daoRoot);
			//如果不存在那么久创建
			if(!rootPath.exists())rootPath.mkdirs();
			//产生接口文件
			File daoJava = new File(rootPath, "I"+entity+"Service.java");
			//讲模板中替换好的数据通过写入目录中去
			FileUtils.writeStringToFile(daoJava, result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * dao接口方法
	 * 方法名：createDaoImpl
	 * 创建人：xuchengfei 时间：2015年5月5日-下午9:37:41  void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createServiceImpl(){
		try {
			//模板页面
			String serviceTemplate = getPath("template\\serviceImpl.txt");
			//写入到磁盘里面去
			String result = replaceModel(serviceTemplate);
			//要生成的根目录
			String daoRoot =  getPath("src\\com\\tz\\service\\"+lowEntity+"\\impl");
			File rootPath  = new File(daoRoot);
			//如果不存在那么久创建
			if(!rootPath.exists())rootPath.mkdirs();
			//产生接口文件
			File daoJava = new File(rootPath, entity+"ServiceImpl.java");
			//讲模板中替换好的数据通过写入目录中去
			FileUtils.writeStringToFile(daoJava, result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createAction(){
		try {
			//模板页面
			String serviceTemplate = getPath("template\\action.txt");
			//写入到磁盘里面去
			String result = replaceModel(serviceTemplate);
			//要生成的根目录
			String daoRoot =  getPath("src\\com\\tz\\web\\"+lowEntity);
			File rootPath  = new File(daoRoot);
			//如果不存在那么久创建
			if(!rootPath.exists())rootPath.mkdirs();
			//产生接口文件
			File daoJava = new File(rootPath, entity+"Action.java");
			//讲模板中替换好的数据通过写入目录中去
			FileUtils.writeStringToFile(daoJava, result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * dao接口方法
	 * 方法名：createDao
	 * 创建人：xuchengfei 时间：2015年5月5日-下午9:37:41  void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createList(){
		try {
			//模板页面
			String daoTemplate = getPath("template\\list.txt");
			String result = replaceModel(daoTemplate);
			//要生成的根目录
			String daoRoot =  getPath("WebRoot\\WEB-INF\\pages\\"+lowEntity);
			File rootPath  = new File(daoRoot);
			//如果不存在那么久创建
			if(!rootPath.exists())rootPath.mkdirs();
			//产生接口文件
			File daoJava = new File(rootPath, "list.jsp");
			//讲模板中替换好的数据通过写入目录中去
			FileUtils.writeStringToFile(daoJava, result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * listtemplate页面
	 * 方法名：createDao
	 * 创建人：xuchengfei 时间：2015年5月5日-下午9:37:41  void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createListTemplate(){
		try {
			//模板页面
			String daoTemplate = getPath("template\\listTemplate.txt");
			String result = replaceModel(daoTemplate);
			//要生成的根目录
			String daoRoot =  getPath("WebRoot\\WEB-INF\\pages\\"+lowEntity);
			File rootPath  = new File(daoRoot);
			//如果不存在那么久创建
			if(!rootPath.exists())rootPath.mkdirs();
			//产生接口文件
			File daoJava = new File(rootPath, "listTemplate.jsp");
			//讲模板中替换好的数据通过写入目录中去
			FileUtils.writeStringToFile(daoJava, result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * js
	 * 方法名：createJs
	 * 创建人：xuchengfei 
	 * 时间：2015年5月17日-上午12:20:53  void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createJs(){
		try {
			//模板页面
			String daoTemplate = getPath("template\\js.txt");
			String result = replaceModel(daoTemplate);
			//要生成的根目录
			String daoRoot =  getPath("WebRoot\\js\\admin\\"+lowEntity);
			File rootPath  = new File(daoRoot);
			//如果不存在那么久创建
			if(!rootPath.exists())rootPath.mkdirs();
			//产生接口文件
			File daoJava = new File(rootPath, "tz_"+lowEntity+".js");
			//讲模板中替换好的数据通过写入目录中去
			FileUtils.writeStringToFile(daoJava, result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * js
	 * 方法名：createJs
	 * 创建人：xuchengfei 
	 * 时间：2015年5月17日-上午12:20:53  void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createAdd(){
		try {
			//模板页面
			String daoTemplate = getPath("template\\edit.txt");
			String result = replaceModel(daoTemplate);
			//要生成的根目录
			String daoRoot =  getPath("WebRoot\\WEB-INF\\pages\\"+lowEntity);
			File rootPath  = new File(daoRoot);
			//如果不存在那么久创建
			if(!rootPath.exists())rootPath.mkdirs();
			//产生接口文件
			File daoJava = new File(rootPath, "edit.jsp");
			//讲模板中替换好的数据通过写入目录中去
			FileUtils.writeStringToFile(daoJava, result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String replaceModel(String path) throws IOException{
		String result = FileUtils.readFileToString(new File(path),"UTF-8");
		result = result.replaceAll("\\[entity\\]", entity)
				.replaceAll("\\[lowEntity\\]", lowEntity)
				.replaceAll("\\[author\\]", author)
				.replaceAll("\\[description\\]", description)
				.replaceAll("\\[date\\]", date);
		return result;
	}
	
	
	
	//不难很简单---javase学习的IO流+模板替换
	public static String getPath(String appendPath){
		String path = System.getProperty("user.dir");
		if(TzStringUtils.isEmpty(appendPath)){
			return path;
		}else{
			return path+"\\"+appendPath;
		}
	}
	
	
//	/**
//	 * 构建entity
//	 * @throws IOException
//	 */
//	public static void createEntity() throws IOException{
//		String newClassName = getHomeDir("src/com/tz/model")+"/"+entityClass+".java";
//		String actionTempContent = TmFileUtil.readFile(getHomeDir("src/template")+"entity.txt");
//		new File(newClassName).getParentFile().mkdirs();
//		if(!TmFileUtil.isExist(newClassName)){
//			bulidClass(actionTempContent,newClassName,entitypackage);
//			System.out.println("[TM构建类][Entity]===>  " +newClassName+"  [OK]");
//		}else{
//			System.out.println("[TM构建类][Entity]===>  " +entityClass+".java 该Dao类以及存在是否覆盖[y/n]!");
//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			String line = reader.readLine();
//			if(line!=null && line.equalsIgnoreCase("y")){
//				bulidClass(actionTempContent,newClassName,entitypackage);
//				System.out.println("[TM构建类][Entity]===>  " +newClassName+"  [覆盖OK]");
//			}
//		}
//	}
//	
	
	public static void main(String[] args) throws IOException {
//		Properties properties = System.getProperties();
//		for (Map.Entry<Object, Object> entry: properties.entrySet()) {
//			System.out.println(entry.getKey()+"==="+entry.getValue());
//		}
		createEntity();
		createDao();
		createDaoImpl();
		createService();
		createServiceImpl();
		createAction();
		createList();
		createListTemplate();
		createJs();
		createAdd();
	}
}
