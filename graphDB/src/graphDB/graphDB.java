package graphDB;

public class graphDB {
	public static void main(String[] args){
		System.out.println("hello world");
		MySQLAccess mysql = new MySQLAccess();
		Neo4jAccess neo4j = new Neo4jAccess();
		mysql.operate();
	}
}
